package gameplay;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import tiles.LoadTexture;

public class LumberTent extends Buildings {
	
	float posX, posY;
	float texW, texH;
	private Texture buildingTexture;

	public LumberTent(float x, float y) {	
		textureLoader = new LoadTexture("res/images/buildings/tents/0.png", "PNG");
		buildingTexture = textureLoader.getLoadedTexture();
		this.texW = buildingTexture.getWidth();
		this.texH = buildingTexture.getHeight();
		this.posX = x;
		this.posY = y;
	}

	@Override
	public void destroyBuilding() {	
		
	}

	@Override
	public void drawBuilding() {
		// Draw the building
		buildingTexture.bind();
		GL11.glColor3f(255, 255, 255);	
		//System.out.println("draw at: " + posX + " - " + posY);
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2d(0f, 0f);
				GL11.glVertex2f(posX - offset, posY - offset);
			GL11.glTexCoord2d(0f, 1f);
				GL11.glVertex2f(posX - offset, (posY - offset) + 128);
			GL11.glTexCoord2d(1f, 1f);
				GL11.glVertex2f((posX - offset) + 128, (posY - offset) + 128);
			GL11.glTexCoord2d(1f, 0f);
				GL11.glVertex2f((posX - offset) + 128, posY - offset);
		}
		GL11.glEnd();
	}

	@Override
	public void updateBuildings() {
		
	}


}
