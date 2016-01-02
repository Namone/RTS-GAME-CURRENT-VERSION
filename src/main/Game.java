package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import camera.Camera;

public class Game {
	
	GameStateManager gameStateManager = new GameStateManager();
	Camera gameCamera;
	//*********** Variables *************	
	private final String GAMETITLE = "Real Time Strategy - V 0.0.10"; // Temporary title
	boolean isFullScreen;
	//*********** START GAME ************
	public Game() {
		isFullScreen = false;
		try {
			// Set display mode to a new display mode - taking width and height
			Display.setDisplayModeAndFullscreen(Display.getDesktopDisplayMode()); // Display.setDisplayMode(new DisplayMode(scrWidth, scrHeight));
			Display.setFullscreen(false); // For now - this is false
			Display.setVSyncEnabled(true);
			Display.setTitle(GAMETITLE);
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUpOpenGL();
		gameStateManager.setGameState(2); // Set to launch game by default ----- 0 -> MENU | 1 -> PAUSE | 2 -> PLAY_GAME
		gameLoop(); // Keep the game running		
	}
	
	//********** KEEP THE GAME ALIVE *********
	public void gameLoop() {
		// While we don't close the window... update it/draw it/etc.
		while (!Display.isCloseRequested()) {
			Display.update(); // Update the screen
			updateGame(); // Update game world
			drawGame();	// Draw game world 
			/*
			 * NOTE: In drawGame() gui.drawGUI() is called - which disables GL_TEXTURE_2D. 
			 * Eventually the GUI will be textured; but, for now, it isn't. I have to re-enable 
			 * 2D textures after the GUI is drawn. 
			 */
			GL11.glEnable(GL11.GL_TEXTURE_2D);      

		}
	}
	
	//******** SET UP OPENGL *******
	public void setUpOpenGL() {             
        // enable alpha blending
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		
	}
	
	//******** UPDATE GAME (GAME LOGIC GOES HERE) *********
	public void updateGame() {	
		if (Keyboard.isKeyDown(Keyboard.KEY_F11)) {	
			isFullScreen = !isFullScreen; // invert it
			try {
				Display.setFullscreen(isFullScreen);
			} catch (LWJGLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Update the game
		gameStateManager.updateGame();
	}
	
	//******** DRAW GAME *********
	public void drawGame() {
		// Clear so we can draw
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		// Draw game
		gameStateManager.drawGame();
	}

}
