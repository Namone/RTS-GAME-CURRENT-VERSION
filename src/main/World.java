package main;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.Texture;

import camera.Camera;
import gameplay.*;
import gui.GUI;
import input.Input;
import tiles.LoadTexture;
import tiles.Tile;
import tiles.Tile_Data;

public class World {
		
	private int[][] SMALL_MAP = new int[][] {
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0},
		{0, 0, 0}
	};
	
	private int[][] CURRENT_MAP;
	
	// *** VARIALBES TO HOLD DATA FOR THE GAME ***
	Tile tile; // TODO: Make random id generated as part of world generation
	ArrayList TILE_DATA = new ArrayList();
	ArrayList TILES = new ArrayList();
	ArrayList BUILDINGS = new ArrayList();
	ArrayList UNITS = new ArrayList();
	ArrayList SELECTED_UNITS = new ArrayList();
	private float futureX, futureY;
	Texture atlas;

	
	//***** GENERATE THE WORLD ******
	public World(int mapSize) {
		atlas = initResources();
		switch(mapSize) {
		case 0 :
			CURRENT_MAP = SMALL_MAP; // Set map size
		break;
		}		
		Random rand = new Random();
		Tile_Data tile_Data;
		// Loop through map size and generate colors for each tile... eventually will be generating tile IDs
		for (int currentTileX = 0; currentTileX < CURRENT_MAP.length; currentTileX++) {								
			for (int currentTileY = 0; currentTileY < CURRENT_MAP.length; currentTileY++) {		
				
				int tileID = rand.nextInt(4); // 0 -> 1 are possible id's currently
				tile_Data = new Tile_Data(tileID, currentTileX, currentTileY);
				TILE_DATA.add(tile_Data); // Store the data
			}
		}
		
		// Create all tile objects and store them
		for (int i = 0; i < TILE_DATA.size(); i++) {
			Tile_Data tempData = (Tile_Data) TILE_DATA.get(i); // Pull object out of list and use the data 
			tile = new Tile(tempData.tileID, atlas);
			TILES.add(tile);
		}
		
	}
	
	public Texture initResources() {
		LoadTexture loader = new LoadTexture("res/images/textureatlas/tilesheet.png", "PNG");
		Texture atlas = loader.getLoadedTexture();

		return atlas;
	}
	
	//******** UPDATE WORLD **********
	public void updateWorld() {	
		updateBuildings();
		updateUnits();
	}
	
	//******** DRAW WORLD *********
	public void renderWorld() {

		// DRAW TILES
		for (int i = 0; i < TILES.size(); i++) {	
			Tile_Data tempData = (Tile_Data) TILE_DATA.get(i);
			tile = (Tile) TILES.get(i);
			tile.drawTile(tempData.tileX, tempData.tileY);
		}				
		
		// DRAW BUILDINGS
		if (BUILDINGS != null) {
			for (int i = 0; i < BUILDINGS.size(); i++) {
				Buildings building = (Buildings) BUILDINGS.get(i);				
				building.drawBuilding();
			}
		}
		
		// DRAW UNITS
		if (UNITS != null) {
			for (int i = 0; i < UNITS.size(); i++) {
				Units units = (Units) UNITS.get(i);	
				units.drawUnit();
			}
		}			
	}
	
	//***** CHANGE SCREEN COORDINATES TO WORLD COORDINATES *****
	public FloatBuffer calculateWorldCoordinates(float mouseX, float mouseY) {
		FloatBuffer model = BufferUtils.createFloatBuffer(16);
		FloatBuffer projection = BufferUtils.createFloatBuffer(16);
		IntBuffer viewport = BufferUtils.createIntBuffer(16);

		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, model);
		GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projection);
		GL11.glGetInteger(GL11.GL_VIEWPORT, viewport);
		
		FloatBuffer pos = BufferUtils.createFloatBuffer(3);
		
		GLU.gluUnProject(mouseX, mouseY, 1f, model, projection, viewport, pos);
		
		return pos;
	}
	
	private int keyCount = 0; // prevents from holding down mouse and building a lot
	private int unitCount = 0;
	public void updateBuildings() {	
		if (Mouse.isButtonDown(3)) {	
			// BUILDING UPDATE LOGIC/ADDING
			Buildings building;
			float x = Mouse.getX();
			float y = Mouse.getY();
			FloatBuffer pos = calculateWorldCoordinates(x, y);	
			if (keyCount < 1) {
				building = new LumberTent(pos.get(0), pos.get(1));
				BUILDINGS.add(building);
			}
			keyCount += 5;
		} else { // reset 
			keyCount = 0;
		}
	}
	
	public void updateUnits() {		
		float x = Mouse.getX();
		float y = Mouse.getY();
		UnitManager unitManager;
		Units units;
		Input input = new Input();
		
		FloatBuffer pos = calculateWorldCoordinates(x, y);
		if (Mouse.isButtonDown(1)) {

			String unitType = "civilian"; // TODO: will grab from GUI soon
			if (unitCount < 1) {
				unitManager = new UnitManager(unitType, pos.get(0), pos.get(1));	
				System.out.println(unitManager.name + " created");
				units = unitManager.getUnit();
				System.out.println("Received object: " + units.toString());
				UNITS.add(units);			
				
			}

			unitCount += 5; // so we can't spawn a ton in one click
		} 
		
		else if(Mouse.isButtonDown(0)) { 

			if (UNITS.size() > 0) { // check to make sure there are units to check
				for (int i = 0; i < UNITS.size(); i++) {
					units = (Units) UNITS.get(i);				
					//System.out.println(pos.get(1) + " ---- " + units.posY + " | " + (units.posY + 50));
					if (input.unitIsClicked(units, pos)) {
						System.out.println("Unit clicked");
						units.isSelected = true;						
						
						// SET DEFAULT VALUES
						futureX = units.posX;
						futureY = units.posY; 
						
						// SET DEFAULT VALUES
						units.waypointX = futureX;
						units.waypointY = futureY;
						
						SELECTED_UNITS.add(units);
											
					} 					
				}
			}		
		
		} else { // reset 
			unitCount = 0;			
			boolean waypointCreated;
			for (int i = 0; i < SELECTED_UNITS.size(); i++) {

				units = (Units) SELECTED_UNITS.get(i);	
				
				// Create a click point
				if (Mouse.isButtonDown(2) && !(SELECTED_UNITS.isEmpty())) {
					
					// SET NEW WAYPOINT
					futureX = pos.get(0);
					futureY = pos.get(1);
					
					// SET NEW WAYPOINT
					units.waypointX = futureX;
					units.waypointY = futureY;
					
					waypointCreated = true;
					
				} else if (units.posX == units.waypointX && units.posY == units.waypointY) { //If the units position equals the way-point then we no longer need way-point
					waypointCreated = false;
				} else {
					waypointCreated = true; // default (takes over while unit moves)
				}
				
				// Un-select selected units...
				if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
					units.isSelected = false;
					SELECTED_UNITS.remove(units);
					
					// KEEP CURRENT UNIT WHERE THEY ARE
					futureX = units.posX;
					futureY = units.posY;
					
					// KEEP CURRENT UNIT WHERE THEY ARE
					units.waypointX = futureX;
					units.waypointY = futureY;
				}			
				
				// If no click point is set... then just stay put
				if (waypointCreated == false){
					futureX = units.posX;
					futureY = units.posY;
					
					units.waypointX = futureX;
					units.waypointY = futureY;
				}				

				if (units.posX < futureX) {
					units.posX += 0.5f;
				} 
				
				if (futureX < units.posX) {
					units.posX -= 0.5f;
				}
				
				if (units.posY < futureY) {
					units.posY += 0.5f;
				} 
				
				if (futureY < units.posY) {
					units.posY -= 0.5f;
				}				
				
			}
			
			
		}		
		
	}

	public void updateGUI() {
		
	}

}
