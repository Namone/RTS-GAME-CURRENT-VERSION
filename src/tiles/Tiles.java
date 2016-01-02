package tiles;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import camera.Camera;
//******* BLUEPRINT FOR ALL TILES ******
public abstract class Tiles {
	
	public final int TILE_WIDTH = 128, TILE_HEIGHT = 64;
	public final int TILE_XHALF = TILE_WIDTH / 2, TILE_YHALF = TILE_HEIGHT / 2;
	public int tileID;
	public float Red, Green, Blue;
	public int ID;
	public TextureAtlas textureAtlas = new TextureAtlas(9, 9, 128, 64, 2048, 1024); // TEXTURE WIDTH AND HEIGHT IS TO NEXT POWER OF TWO
	//****** ENUM LIST OF TILE TYPES *****
	public enum TILE_TYPES {
		GRASS,
		DIRT,
		WATER,
		SNOW,
	}
	
	public abstract int getTileId();	
	public abstract void drawTile(int tileX,  int tileY, Texture atlas);
	public abstract void drawTile(int tileX, int tileY);

}
