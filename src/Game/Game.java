package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
//import java.awt.MouseInfo;
//ort java.awt.Point;
//import java.awt.PointerInfo;
//import java.awt.TextArea;
//import java.awt.Toolkit;
//import java.awt.geom.Ellipse2D;
//import java.awt.image.BufferedImage;
//import java.io.IOException;


//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class Game extends JPanel 
{
	public static String Version = "0.0.03";
	public static JFrame frame = new JFrame("Dubstep Guns" + " " + Version);
	public static Game game = new Game();
	
	public static Player player = new Player();
	public static Listener listener = new Listener();
	public static MultiKeyPressListener multi =  new MultiKeyPressListener();
	public static Mouse mouse = new Mouse();

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension (1000,700);
	}
	
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
		player.xPos = 80;
		player.yPos = 80;
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true)
		{
			if(listener.getW())
			{
				player.moveUp();
			}
			if(listener.getA())
			{
				player.moveLeft();
			}
			if(listener.getS())
			{
				player.moveDown();
			}
			if(listener.getD())
			{
				player.moveRight();
			}
			
			System.out.println(mouse.isOnscreen() + " " + mouse.GetAdjustedX() + " " + mouse.GetAdjustedY()+ " " + mouse.isClicked);
			
			game.repaint();
			Thread.sleep(10);
		}
	}
	public Image img1 = new ImageIcon(this.getClass().getResource("/Textures/Thing.png")).getImage();
	
	@Override
	public void paint(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.fillRect(0,0, 1000, 700);
		g2d.setColor(Color.BLACK);
		//g2d.drawString("Hi", 50, 50);
		//ClassLoader cldr = this.getClass().getClassLoader();

	    //java.net.URL imageURL   = cldr.getResource("/Textures/Thing.png");
	    //BufferedImage Thing = null;
		//Thing = ImageIO.read(imageURL);
		//Image img1 = Toolkit.getDefaultToolkit().getImage("/Textures/Thing.png");
		
		g2d.drawImage(img1, player.xPos, player.yPos, this);

		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
}
