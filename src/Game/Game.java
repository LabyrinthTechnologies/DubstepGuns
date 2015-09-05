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
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension (1000,700);
	}
	
	public Image img1 = new ImageIcon(this.getClass().getResource("/Textures/Thing.png")).getImage();
	
	@Override
	public void paint(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;
		//g2d.setColor(Color.BLUE);
		//g2d.fillRect(0,0, 1000, 700);
		//g2d.setColor(Color.BLACK);
		//g2d.drawString("Hi", 50, 50);
		//ClassLoader cldr = this.getClass().getClassLoader();

	    //java.net.URL imageURL   = cldr.getResource("/Textures/Thing.png");
	    //BufferedImage Thing = null;
		//Thing = ImageIO.read(imageURL);
		//Image img1 = Toolkit.getDefaultToolkit().getImage("/Textures/Thing.png");
		
		
		for (int x = 0; x < Main.level.level.length; x++)
		{
			for (int y = 0; y < Main.level.level[0].length; y++)
			{
				if(Main.level.level[x][y] == 1)
				{
					g2d.setColor(Color.YELLOW);
					//System.out.println("yellow");
				}
				else
				{
					g2d.setColor(Color.blue);
				}
				g2d.fillRect(50 * x, 50 * y, 50 * (x + 1), 50 * (y + 1));
			}
		}
		
		g2d.drawImage(img1, Main.player.getPos().x, Main.player.getPos().y, 50, 50, this);
		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
}
