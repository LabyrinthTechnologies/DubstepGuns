package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class Game extends JPanel 
{
	
	public Image player;
	
	public Game()
	{
		super();
		//player = Main.tl.textures[0];//new ImageIcon(this.getClass().getResource("/Textures/Thing.png")).getImage();
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
		
		for (int x = 0; x < Main.level.level.length; x++)
		{
			for (int y = 0; y < Main.level.renderLevel[0].length; y++)
			{
				g2d.drawImage(Main.ts.tiles[Main.level.renderLevel[x][y]], (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);	
			}
		}
		g2d.drawImage(Main.tl.textureFromString(Main.player.textureName), Main.player.getPos().x - (int)Main.c.xPos, Main.player.getPos().y - (int)Main.c.yPos, Main.player.xSize, Main.player.ySize, this);
	}
	
}
