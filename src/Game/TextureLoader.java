package Game;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;


public class TextureLoader extends Loader
{
	public final int Player = 0;
	
	/*private ArrayList<String> textureSrc;
	private ArrayList<String> textureName;*/
	//@Override
	protected Map<String, Image> textureMap;

	public Image[] textures;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TextureLoader()
	{
		super();
		textureMap = new HashMap();
	}
	
	/*public void addTexture(String src, String name)
	{
		Src.add(src);
		Name.add(name);
	}*/
	
	public Image textureFromName(String src)
	{
		return textureMap.get(src);
	}
	
	public void loadTextures()
	{
		textures = new Image[Src.size()];
		int loadingTexture = 0;
		for (String src : Src)
		{
			textures[loadingTexture] = new ImageIcon(this.getClass().getResource(src)).getImage();
			textureMap.put(Name.get(loadingTexture), textures[loadingTexture]);
			new ImageIcon(textures[loadingTexture]);
			loadingTexture++;
			Main.loaded++;
			Main.game.repaint();
		}
	}
}
