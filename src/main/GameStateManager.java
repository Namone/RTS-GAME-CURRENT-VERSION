package main;

import main.GameStates.GAME_STATES;

public class GameStateManager {

	private GAME_STATES CURRENT_STATE; // 0 -> MENU | 1 -> PAUSE | 2 -> PLAY_GAME
	
	private GameStates play_game;
	private GameStates pause_game;
	private GameStates menu;
		
	//****** MANAGES GAME STATES ******
	public GameStateManager() {
		CURRENT_STATE = GAME_STATES.PLAY_GAME; // Default value - eventually will be MENU
	}
	
	public void setGameState(int gameState) {
		switch (gameState) {
		case 0 : 
			// MENU
			CURRENT_STATE = GAME_STATES.MENU;	
		break;
		case 1 : 
			// PAUSE
			CURRENT_STATE = GAME_STATES.PAUSE;	
			pause_game = new PauseGame();
		break;
		case 2 : 
			// PLAY GAME
			CURRENT_STATE = GAME_STATES.PLAY_GAME;			
			play_game = new LaunchGame();
		break;
		}
	}
	
	//****** UPDATE CURRENT GAME STATE ******
	public void updateGame() {
		switch (CURRENT_STATE) {
		case MENU :
			
		break;
		case PAUSE :
			
		break;
		case PLAY_GAME :
			play_game.updateGame();
		break;
		}
	}
	
	//****** DRAW CURRENT GAME STATE *******
	public void drawGame() {
		switch (CURRENT_STATE) {
		case MENU :
			
		break;
		case PAUSE :
				
		break;
		case PLAY_GAME :
			play_game.drawGame();
		break;
		}
	}
	

}
