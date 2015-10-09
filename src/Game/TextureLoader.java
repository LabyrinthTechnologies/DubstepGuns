package Game;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class TextureLoader 
{
	public final int Player = 0;
	
	private ArrayList<String> textureSrc;
	public Image[] textures;
	
	public TextureLoader()
	{
		textureSrc = new ArrayList<String>();
	}
	
	public void addTexture(String src)
	{
		textureSrc.add(src);
	}
	
	public void loadTextures()
	{
		textures = new Image[textureSrc.size()];
		int loadingTexture = 0;
		for (String src : textureSrc)
		{
			textures[loadingTexture] = new ImageIcon(this.getClass().getResource(textureSrc.get(loadingTexture))).getImage();
			loadingTexture++;
		}
	}
}
