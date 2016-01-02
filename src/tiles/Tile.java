package tiles;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.Texture;

import camera.Camera;

//****** MANAGES TILES *******
public class Tile extends Tiles {

	TILE_TYPES CURRENT_TILE;
	//****** CREATES TILES *****
	Tiles drawTile;
	Texture texture;
	//***** CREATE A TILE *****
	public Tile (int ID, Texture atlas) {
		tileID = ID; // So we can select the ID to draw
		this.texture = atlas;
		switch(ID) {
		case 0 :			
			CURRENT_TILE = TILE_TYPES.GRASS;
		break;
		case 1 :			
			CURRENT_TILE = TILE_TYPES.DIRT;
		break;
		case 2 :			
			CURRENT_TILE = TILE_TYPES.WATER;
		break;
		case 3 :			
			CURRENT_TILE = TILE_TYPES.SNOW;
		break;
		}	
		
	}	
	
	//***** DRAW TILE *****
	@Override
	public void drawTile(int tileX, int tileY) { // TODO: Make these have textures
		switch (CURRENT_TILE) {
		case GRASS: 
			drawTile = new DrawTile(0); // Draws tile object
			drawTile.drawTile(tileX, tileY, texture); // Draws tile object
		break;
		case DIRT: 
			drawTile = new DrawTile(1);
			drawTile.drawTile(tileX, tileY, texture);
		break;
		case WATER: 
			drawTile = new DrawTile(2);
			drawTile.drawTile(tileX, tileY, texture);
		break;
		case SNOW: 
			drawTile = new DrawTile(3);
			drawTile.drawTile(tileX, tileY, texture);
		break;
		}

	}	
	
	//***** GET TILE ID (FOR USE WITH WORLD GEN) *****
	public int getTileId() {
		// TODO: get functioning...
		
		return 0;
	}

	@Override
	public void drawTile(int tileX, int tileY, Texture atlas) {
		// does nothing in this class
		
	}

}
