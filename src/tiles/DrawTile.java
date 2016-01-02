package tiles;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.Texture;


public class DrawTile extends Tiles {

	public DrawTile(float r, float g, float b) {
		Red = r;
		Green = g;
		Blue = b;
	}
	
	public DrawTile(int id) {
		ID = id;
	}

	@Override
	public int getTileId() {
		return tileID;
	}	
	
	@Override
	public void drawTile(int tileX,  int tileY, Texture atlas) {
		
		int tileXcoord, tileYcoord;

		tileXcoord = (tileX - tileY) * (TILE_XHALF); // TILE_WIDTH = 128
		tileYcoord = (tileX + tileY) * (TILE_YHALF); // TILE_HEIGHT = 64
			
		
		//tileXcoord = tileX * TILE_WIDTH;
		//tileYcoord = tileY * TILE_HEIGHT;
		
		atlas.bind();		
		
		GL11.glColor3f(255, 255, 255);	
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			setTextureCoordinates(1);
			GL11.glVertex2f(tileXcoord, tileYcoord);
			//GL11.glVertex2f(tileXcoord, tileYcoord);
			setTextureCoordinates(2);
			GL11.glVertex2f(tileXcoord + TILE_XHALF, tileYcoord + TILE_YHALF);
			//GL11.glVertex2f(tileXcoord, tileYcoord + TILE_HEIGHT);
			setTextureCoordinates(3);
			GL11.glVertex2f(tileXcoord + (TILE_XHALF * 2), tileYcoord);
			//GL11.glVertex2f(tileXcoord + TILE_WIDTH, tileYcoord + TILE_HEIGHT);
			setTextureCoordinates(4);
			GL11.glVertex2f(tileXcoord + TILE_XHALF, tileYcoord - TILE_YHALF);
			//GL11.glVertex2f(tileXcoord + TILE_WIDTH, tileYcoord);
		}
		GL11.glEnd();
		
	}
	
	//***** SET TEXTURE COORDINATES *****
	public void setTextureCoordinates(int pos) {
			Rectangle rect = textureAtlas.getTexture(ID);
			
			float x = rect.getX(), y = rect.getY();
			float height = rect.getHeight(), width = rect.getWidth();
			
			switch (pos) {
			case 1 :
				GL11.glTexCoord2f(x, y + (height / 2)); 
				//GL11.glTexCoord2f(0.0f, 0.03125f);
				//GL11.glTexCoord2f(0.0f, 0.0f);
				break;
				
			case 2:
				GL11.glTexCoord2f(x + (width / 2), y + height);
				//GL11.glTexCoord2f(0.03125f, 0.0625f);
				//GL11.glTexCoord2f(0.0f, 1f);
				break;
				
			case 3:
				GL11.glTexCoord2f(x + width, y + (height / 2));
				//GL11.glTexCoord2f(0.0625f, 0.03125f);
				//GL11.glTexCoord2f(1f, 1f);
				break;
				
			case 4:
				GL11.glTexCoord2f(x + (width / 2), y);
				//GL11.glTexCoord2f(0.03125f, 0.0f);
			    //GL11.glTexCoord2f(1f, 0.0f);
				break;
			}

	}
	

	@Override
	public void drawTile(int tileX, int tileY) {
		// TODO Auto-generated method stub
		
	}
	

}
