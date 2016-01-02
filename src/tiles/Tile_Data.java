package tiles;

public class Tile_Data {
	
	public int tileID;
	public int tileX, tileY; // X and Y coordination
	public float R, G, B; // colors of tile
	
	public Tile_Data(int id, int x, int y) {
		tileID = id;
		tileX = x;
		tileY = y;
	}
}
