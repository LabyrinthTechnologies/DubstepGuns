package Game;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class MusicLoader extends Loader
{
	public final int Player = 0;
	
	/*private ArrayList<String> textureSrc;
	private ArrayList<String> textureName;*/
	//@Override
	protected Map<String, AudioInputStream> musicMap;

	public AudioInputStream[] music;
	
	public MusicLoader()
	{
		super();
		musicMap = new HashMap();
	}
	
	/*public void addTexture(String src, String name)
	{
		Src.add(src);
		Name.add(name);
	}*/
	
	public AudioInputStream clipFromName(String src)
	{
		return musicMap.get(src);
	}
	
	public void loadMusic() throws UnsupportedAudioFileException, IOException
	{
		music = new AudioInputStream[Src.size()];
		int loadingmusic = 0;
		for (String src : Src)
		{
			music[loadingmusic] = (AudioSystem.getAudioInputStream(this.getClass().getResource(Src.get(loadingmusic))));
			musicMap.put(Name.get(loadingmusic), music[loadingmusic]);
			loadingmusic++;
		}
	}

}
