package Game;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Main 
{
	public static String Version = "0.0.05";
	public static JFrame frame = new JFrame("Dubstep Guns" + " " + Version);
	public static Game game;
	public static int blockSize = 50;
	public static Camera c = new Camera();
	public static TextureLoader tl = new TextureLoader();
	public static MusicLoader ml = new MusicLoader();
	public static MusicPlayer mp = new MusicPlayer();
	public static Tileset ts;
	public static ArrayList<Entity> entity = new ArrayList<Entity>();
	public static ArrayList<Entity> qued = new ArrayList<Entity>();
	public static int playerNum;
	//public static Interneter i;
	public static boolean internet = false;
	public static int gameState = 0;
	public static int toLoad = 0;
	public static int loaded = 0;
	//public static Socket s;
	
	//public static Player player = new Player();
	public static Listener listener = new Listener();
	public static MultiKeyPressListener multi =  new MultiKeyPressListener();
	public static Mouse mouse = new Mouse();
	public static Level level = new Level();
	//public static PhysicsObject physPlayer;
	
	public static void setupGraphics()
	{
		frame.add(game);
		frame.pack();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int desktopwidth = gd.getDisplayMode().getWidth();
		int desktopheight = gd.getDisplayMode().getHeight();
		frame.setLocation((desktopwidth/2)-500, (desktopheight/2)-350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void loadTextures()
	{
		tl.addMap("/Textures/Thing.png", "defaultPlayer");
		tl.addMap("/Textures/rhythmGun.png", "rhythmGun");
		tl.addMap("/Textures/rhythmGunShot.png", "rhythmGunShot");
	}
	
	public static void loadMusic() throws UnsupportedAudioFileException, IOException
	{
		ml.addMap(level.musicSrc, level.musicName);
	}
	
	/*public static void assignTextures()
	{
		player.texture = tl.textures[0];
	}*/

	public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException 
	{
		//assignTextures();
		game = new Game();
		game.addMouseListener(mouse);
		game.addMouseMotionListener(mouse);
		//frame.addMouseListener(mouse);
		setupGraphics();
		loadTextures();
		loadMusic();
		ml.loadMusic();
		tl.loadTextures();
		toLoad = toLoad + 64;
		ts = new Tileset(level.tileSrc);
		gameState = 1;
		frame.addKeyListener(listener);
		//i = new Interneter();
		//i.connect();
		entity.add(new Player());
		entity.add(new RhythmGun());
		entity.get(0).setPos(800, 400);
		entity.get(1).setPos(100, 100);
		//physPlayer = new PhysicsObject(entity.get(0));
		//physPlayer.setPhysics(true);
		mp.playMusic(level.musicName);
		
		while (true)
		{	
			if(listener.getRight())
			{
				c.cameraRight(2);
			}
			
			if(listener.getLeft())
			{
				c.cameraLeft(2);
			}

			//System.out.println(mouse.isOnscreen() + " " + mouse.GetAdjustedX() + " " + mouse.GetAdjustedY()+ " " + mouse.isClicked);
			
			//physPlayer.Update();
			//physPlayer.Update();
			//int inc = 0;
			//qued = entity;
			for (Entity e : entity)
			{
				e.Update();
				//i.sendEntityInfo(inc);
				//inc++;
			}
			
			for (Entity e : qued)
			{
				entity.add(e);
			}
			qued = new ArrayList<Entity>();
			
			game.repaint();
			Thread.sleep(10);
		}
	}

}
