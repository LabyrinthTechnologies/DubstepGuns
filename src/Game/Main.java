package Game;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Main 
{
	public static String Version = "0.0.05";
	public static JFrame frame = new JFrame("Dubstep Guns" + " " + Version);
	public static Game game;
	public static int blockSize = 50;
	public static Camera c = new Camera();
	public static TextureLoader tl = new TextureLoader();
	public static Tileset ts;
	
	public static Player player = new Player();
	public static Listener listener = new Listener();
	public static MultiKeyPressListener multi =  new MultiKeyPressListener();
	public static Mouse mouse = new Mouse();
	public static Level level = new Level();
	public static PhysicsObject physPlayer = new PhysicsObject(player);
	
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
		tl.addTexture("/Textures/Thing.png");
		tl.loadTextures();
	}
	
	public static void assignTextures()
	{
		player.texture = tl.textures[0];
	}

	public static void main(String[] args) throws InterruptedException 
	{
		ts = new Tileset(level.tileSrc);
		loadTextures();
		assignTextures();
		game = new Game();
		setupGraphics();
		frame.addKeyListener(listener);
		frame.addMouseListener(mouse);
		player.setPos(800, 400);
		physPlayer.setPhysics(true);
		
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
			
			physPlayer.Update();
			
			game.repaint();
			Thread.sleep(10);
		}
	}

}
