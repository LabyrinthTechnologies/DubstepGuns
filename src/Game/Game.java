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


import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;










//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class Game extends JPanel 
{
	
	public Image player;
	public Image tileset;
	public BufferedImage btileset;
	public Image tileblank;
	public Image tile1;
	
	public Game()
	{
		super();
		player = new ImageIcon(this.getClass().getResource("/Textures/Thing.png")).getImage();
		tileset = new ImageIcon(this.getClass().getResource("/Textures/tiles.png")).getImage();
		btileset = new BufferedImage(tileset.getWidth(null), tileset.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		tileblank = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(0, 0, 16, 16)));
		tile1 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(16, 0, 16, 16)));
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension (1000,700);
	}
	
	
	
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
		//Image btemp;
		
		for (int x = 0; x < Main.level.level.length; x++)
		{
			for (int y = 0; y < Main.level.level[0].length; y++)
			{
				if(Main.level.level[x][y] == 1)
				{
					//btemp = tile1;
					//g2d.setColor(Color.yellow);
					g2d.drawImage(tile1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
					//System.out.println("yellow");
				}
				else
				{
					//btemp = tileblank;
					g2d.drawImage(tileblank, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
					//g2d.setColor(Color.blue);
				}
				//g2d.fillRect(50 * x, 50 * y, 50 * (x + 1), 50 * (y + 1));
				//g2d.drawImage(btemp, (x * 50), (y * 50), 50, 50, this);
				
			}
		}
		//g2d.drawImage(tileset, 0, 0, 200, 200, this);
		g2d.drawImage(player, Main.player.getPos().x - (int)Main.c.xPos, Main.player.getPos().y - (int)Main.c.yPos, Main.player.xSize, Main.player.ySize, this);
		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
}
