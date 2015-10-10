package Game;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;


public class TextureLoader 
{
	public final int Player = 0;
	
	private ArrayList<String> textureSrc;
	private ArrayList<String> textureName;
	private Map<String, Image> textureMap;
	public Image[] textures;
	
	public TextureLoader()
	{
		textureSrc = new ArrayList<String>();
		textureName = new ArrayList<String>();
		textureMap = new HashMap();
	}
	
	public void addTexture(String src, String name)
	{
		textureSrc.add(src);
		textureName.add(name);
	}
	
	public Image textureFromString(String src)
	{
		return textureMap.get(src);
	}
	
	public void loadTextures()
	{
		textures = new Image[textureSrc.size()];
		int loadingTexture = 0;
		for (String src : textureSrc)
		{
			textures[loadingTexture] = new ImageIcon(this.getClass().getResource(textureSrc.get(loadingTexture))).getImage();
			textureMap.put(textureName.get(loadingTexture), textures[loadingTexture]);
			loadingTexture++;
		}
	}
}
