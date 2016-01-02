package tiles;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class LoadTexture {
	
	Texture textureAtlas;
	
	public LoadTexture(String path, String filetype) {
		try {
			// Load texture atlas image
			textureAtlas = TextureLoader.getTexture (filetype, ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Texture getLoadedTexture() {
		return textureAtlas;
	}

}
