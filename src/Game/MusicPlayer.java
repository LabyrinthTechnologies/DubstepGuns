package Game;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class MusicPlayer 
{
	public void playMusic(String name) throws LineUnavailableException, IOException
	{
		AudioInputStream audioIn = Main.ml.clipFromName(name);
		Clip clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.start();
	}
}
