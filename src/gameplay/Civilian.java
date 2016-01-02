package gameplay;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.Texture;

import tiles.LoadTexture;

public class Civilian extends Units {
	
	public Civilian(float x, float y) {
		posX = x;
		posY = y;;
	}
	
	public Civilian() {

	}
	
	@Override
	public void drawUnit() {

		texture.bind();
		rect = atlas.getTexture(1);
		GL11.glColor3f(1f, 1f, 1f);	
		
		GL11.glBegin(GL11.GL_QUADS);
		{		
			GL11.glTexCoord2f(rect.getX(), rect.getY());
			GL11.glVertex2f(posX, posY);
			GL11.glTexCoord2f(rect.getX(), rect.getY() + rect.getHeight());
			GL11.glVertex2f(posX, posY + 50);
			GL11.glTexCoord2f(rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight());
			GL11.glVertex2f(posX + 50, posY + 50);
			GL11.glTexCoord2f(rect.getX() + rect.getWidth(), rect.getY());
			GL11.glVertex2f(posX + 50, posY);
		}
		GL11.glEnd();	

		
	}
	
	public void updateUnit() {
		
	}

	public void moveUnit() {
		
	}

	public void createUnit() {
		
	}

	public void killUnit() {
		
	}

	public void healUnit(int hpPointsToHeal) {
		
	}

	public Units getUnit() {
		return this;
	}

}
