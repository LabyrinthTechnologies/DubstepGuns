package Game;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Main 
{
	public static String Version = "0.0.03";
	public static JFrame frame = new JFrame("Dubstep Guns" + " " + Version);
	public static Game game = new Game();
	
	public static Player player = new Player();
	public static Listener listener = new Listener();
	public static MultiKeyPressListener multi =  new MultiKeyPressListener();
	public static Mouse mouse = new Mouse();
	public static Level level = new Level();
	public static PhysicsObject physPlayer = new PhysicsObject(player);

	public static void main(String[] args) throws InterruptedException 
	{
		//frame.getp
		frame.add(game);
		//frame.setSize(1000, 700);
		frame.pack();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int desktopwidth = gd.getDisplayMode().getWidth();
		int desktopheight = gd.getDisplayMode().getHeight();
		frame.setLocation((desktopwidth/2)-500, (desktopheight/2)-350);
		frame.addKeyListener(listener);
		frame.addMouseListener(mouse);
		//frame.addKeyListener(multi);
		player.setPos(80, 70);
		physPlayer.setPhysics(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true)
		{
			if(listener.getW())
			{
				if(player.state == "standing")
				{
					player.setYVel(-18);
				}
			}
			if(listener.getA())
			{
				player.setXVel(-5);
			}
			/*if(listener.getS())
			{
				player.setYVel(10);
			}*/
			if(listener.getD())
			{
				player.setXVel(5);
			}
			
			if(!listener.getA() && !listener.getD())
			{
				player.setXVel(0);
			}
			/*if(!listener.getW() && !listener.getS())
			{
				player.setYVel(0);
			}*/
			//System.out.println(mouse.isOnscreen() + " " + mouse.GetAdjustedX() + " " + mouse.GetAdjustedY()+ " " + mouse.isClicked);
			
			physPlayer.Update();
			
			game.repaint();
			Thread.sleep(10);
		}
	}

}
