package main;
//****** BLUEPRINT FOR ALL GAME STATE CLASSES ******
public abstract class GameStates {
	
	public enum GAME_STATES {
		MENU,
		PAUSE,
		PLAY_GAME
	}
	
	public abstract void updateGame();
	public abstract void drawGame();

}
