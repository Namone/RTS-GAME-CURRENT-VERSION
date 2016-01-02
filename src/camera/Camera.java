package camera;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class Camera {
	
	private float xAxis = 0;
	private float yAxis = 0;
	
	//***** CREATE A NEW CAMERA OBJECT ******
	public Camera() {

	}
	
	//****** UPDATES ANY CAMERA POSITION CHANGES TO GAME SCREEN *******
	public void updateCamera() {
		
		// KEYBOARD CAMERA CONTROL
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xAxis += 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			xAxis = 0; // reset so we don't fly everywhere
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xAxis -= 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			xAxis = 0;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yAxis += 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			yAxis = 0;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yAxis -= 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			yAxis = 0;
		}
		
		// MOUSE CAMERA CONTROL
		if (Mouse.isInsideWindow() && Mouse.getX() <= Display.getWidth() - Display.getWidth() + 20) {
			xAxis += 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			xAxis = 0; // reset so we don't fly everywhere
		} else if (Mouse.isInsideWindow() && Mouse.getX() >= Display.getWidth() - 20) {
			xAxis -= 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			xAxis = 0;
		}
		
		if (Mouse.isInsideWindow() && Mouse.getY() <= Display.getHeight() - Display.getHeight() + 20) {
			yAxis -= 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			yAxis = 0;
		} else if (Mouse.isInsideWindow() && Mouse.getY() >= Display.getHeight() - 20) {
			yAxis += 5f;
			GL11.glTranslatef(xAxis, yAxis, 0);
			yAxis = 0;
		} 
	}

}
