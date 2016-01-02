package input;

import java.nio.FloatBuffer;

import org.lwjgl.input.Mouse;

import gameplay.Units;
import gui.Button;
import gui.GUI;

public class Input {
	
	public Input() {
		
	}
	
	public boolean unitIsClicked(Units units, FloatBuffer pos) {
		
		boolean isClicked;
		
		if (pos.get(0) > units.posX && pos.get(0) < units.posX + 50
				&& pos.get(1) > units.posY && pos.get(1) < units.posY + 50) {
			isClicked = true;
		} else {
			isClicked = false;
		}
		
		return isClicked;
	
	}
	
	public boolean isButtonClicked(Button button) {
		boolean isClicked = false;
		
		if (Mouse.getX() > button.posX && Mouse.getX() < button.posX + button.width
				&& Mouse.getY() > button.posY && Mouse.getY() < button.posY + button.height) {
			isClicked = true;
		} else {
			isClicked = false;
		}
		
		return isClicked;
	}

}
