package gameplay;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.opengl.Texture;

import tiles.LoadTexture;
import tiles.TextureAtlas;

public abstract class Units {
	
	public int healthPoints;
	public int staminaPoints;
	public int armorPoints;
	public float posX, posY;
	public float waypointX;
	public float waypointY;	
	public String name;
	public boolean isSelected = false;
	TextureAtlas atlas = new TextureAtlas (17, 13, 61, 40, 1024, 512);
	LoadTexture textureLoader = new LoadTexture("res/images/textureatlas/units2.gif", "GIF");
	Texture texture = textureLoader.getLoadedTexture();
	Rectangle rect;
	public enum UNITS 
	{
		CIVILIAN,
		SOLDIER,
		PRIEST,
		ARCHITECT,
	}
	
	public abstract void drawUnit();
	public abstract void moveUnit();
	public abstract void createUnit();
	public abstract void killUnit();
	public abstract void healUnit(int hpPointsToHeal);
	public abstract Units getUnit();

}
