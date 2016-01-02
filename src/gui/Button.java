package gui;

import input.Input;

public class Button extends GUI{

	Input input = new Input();
	public Button(float w, float h, String buttonImagePath) {
		super(w, h, buttonImagePath);
	}
	
	public Button(float w, float h, String buttonImagePath, float posX, float posY) {
		super(w, h, buttonImagePath, posX, posY);
	}
	
	public Button(float w, float h, float r, float g, float b) {
		super(w, h, r, g, b);
	}
	
	public void drawGUI() {
		super.drawGUI();
	}
	
	public boolean isClicked(float mouseX, float mouseY) {
		boolean isClicked = false;
		
		// CLICK LOGIC
		isClicked = input.isButtonClicked(this);
		
		if (isClicked) {
			System.out.println("buttonclick");
		}
		
		
		return isClicked;
		
	}

}
