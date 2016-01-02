package gameplay;

import tiles.LoadTexture;

public abstract class Buildings {
	
	public int integrity; // health, basically
	public int posX, posY;
	public int isShop;
	public LoadTexture textureLoader;
	public float offset = 100;

	public abstract void drawBuilding();
	public abstract void updateBuildings();
	public abstract void destroyBuilding();
}
