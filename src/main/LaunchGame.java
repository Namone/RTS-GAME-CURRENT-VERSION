package main;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import camera.Camera;
import gui.*;

public class LaunchGame extends GameStates{
	
	World worldGen;
	Camera gameCam;
	
	// GUI OBJECTS
	GUI topBarGUI;
	GUI bottomBarGUI;
	GUI buttonGUI;
	
	//******* LAUNCH PLAY_GAME *******
	public LaunchGame() {
		System.out.println("+++++++ GAME LAUNCHED V0.0.10 +++++++");
		worldGen = new World(0); // TODO: Add interface to allow use to select world size (0, 1, 2)
		gameCam = new Camera();
		bottomBarGUI = new BottomBar(Display.getWidth(), 100, 0, Display.getHeight() - 500, 0.5f, 0.5f, 0.2f);
		topBarGUI = new TopBar(Display.getWidth(), 30, 0.5f, 0.5f, 0.2f);
		buttonGUI = new Button(30, 30, "res/images/buildings/tents/0.png", 10, 0);
		/*
		 * TODO: Add an 'add' function to the GUI code to automatically calculate position of the buttons, items, etc.	 * 
		 * 
		 */
	}
	
	//****** UPDATE GAME *******
	@Override 
	public void updateGame() {
		gameCam.updateCamera();
		worldGen.updateWorld();
	}
	
	//****** DRAW GAME ********
	@Override 
	public void drawGame() {
		worldGen.renderWorld();
		bottomBarGUI.drawGUI();
		topBarGUI.drawGUI();
		buttonGUI.drawGUI();
	}

}
