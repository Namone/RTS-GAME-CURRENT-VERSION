package gui;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import tiles.LoadTexture;

public class GUI {
	
	public float 
	width, height,
	RED, GREEN, BLUE, 
	posX, posY;
	protected String imagePath;	
	Texture image;
	
	public GUI(float w, float h, String path) {
		LoadTexture textureLoader = new LoadTexture(path, "PNG");
		image = textureLoader.getLoadedTexture(); // load texture input
		width = w;
		height = h;		
		imagePath = path;
	}
	
	public GUI(float w, float h, String path, float posX, float posY) {
		LoadTexture textureLoader = new LoadTexture(path, "PNG");
		this.posX = posX;
		this.posY = posY;
		image = textureLoader.getLoadedTexture(); // load texture input
		width = w;
		height = h;		
		imagePath = path;
	}
	
	public GUI(float w, float h, float posX, float posY, float r, float g, float b) {
		this.posX = posX;
		this.posY = posY;
		RED  = r;
		GREEN = g;
		BLUE = b;
		width = w;
		height = h;		
	}
	
	public GUI(float w, float h, 
			float red, float green, float blue) {
		RED  = red;
		GREEN = green;
		BLUE = blue;
		width = w;
		height = h;
	}
	
	public GUI(float w, float h) {
		width = w;
		height = h;
	}
	
	public void updateGUI() {
		// TODO: get user input, update statistics, etc.
	}
	
	public void drawGUI() {
		
		// If the GUI object has an image...
		if (image != null) {
			
			GL11.glColor3f(1f, 1f, 1f);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 800, 600, 0, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
			image.bind();
			GL11.glBegin(GL11.GL_QUADS); 
					GL11.glTexCoord2f(0f, 0f);
				GL11.glVertex2f(posX, posY); 
					GL11.glTexCoord2f(0f, 1f);
				GL11.glVertex2f(posX, posY + height);
					GL11.glTexCoord2f(1f, 1f);
				GL11.glVertex2f(posX + width, posY + height); 
					GL11.glTexCoord2f(1f, 0f);
				GL11.glVertex2f(posX + width, posY); 
			GL11.glEnd();
			GL11.glPopMatrix();
			
		// If the GUI object does not have an image...
		} else if (RED != 0 && GREEN != 0 && BLUE != 0) {
			
			GL11.glColor3f(RED, GREEN, BLUE);
			
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
			GL11.glOrtho(0, 800, 600, 0, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glPushMatrix();
			GL11.glLoadIdentity();
			GL11.glBegin(GL11.GL_QUADS); 
				GL11.glVertex2f(posX, posY); 
				GL11.glVertex2f(posX, posY + height); 
				GL11.glVertex2f(posX + width, posY + height); 
				GL11.glVertex2f(posX + width, posY); 
			GL11.glEnd();
			GL11.glPopMatrix();
		}		
		
	}

}
