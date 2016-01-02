package tiles;

import java.io.IOException;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureAtlas {
	
	private float tilePixelWidth, 
				tilePixelHeight,
				gridW,
				gridH,
				tPWidth,
				tPHeight;
	
	//******* CREATE TEXTURE ATLAS IMAGE ******
	public TextureAtlas(float gridWidth, float gridHeight, float tilePixelWidth,
			float tilePixelHeight, float totalPixelW, float totalPixelH) { // tile pixel width is 64; height is 32
		// Set parameters of the image
		this.tilePixelHeight = tilePixelHeight;
		this.tilePixelWidth = tilePixelWidth;
		this.gridW = gridWidth;
		this.gridH = gridHeight;
		this.tPWidth = totalPixelW;
		this. tPHeight = totalPixelH;
		
		
	}
	
	//**** GET ID SPECIFIC TEXTURE CELL ******
	public Rectangle getTexture(int id) {
		
		int columnNumber = (int)(id % gridW); // Column of texture (using MOD so I can get textures beyond next column [next row])
		int rowNumber = (int)(id / gridH); // Row number for texture			
		// TODO: Get texture selection working!
		// Create bounding box
		float tilePercentOfWidth = this.tilePixelWidth / this.tPWidth;
		float tilePercentOfHeight = this.tilePixelHeight / this.tPHeight;
	
		float boxX = (columnNumber * (tilePixelWidth / tPWidth));
		float boxY = (rowNumber * (tilePixelHeight / tPHeight));
		float boxWidth = tilePercentOfWidth;
		float boxHeight = tilePercentOfHeight;		
		// End bounding box creation
		
		Rectangle textureBounds = new Rectangle (boxX, boxY, boxWidth, boxHeight);
		
		return textureBounds;
	} 

}
