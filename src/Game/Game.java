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
	AffineTransform tx;
	AffineTransformOp op;
	
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
		
		for(Entity e : Main.entity)
		{
			Image tempImage = Main.tl.textureFromName(e.textureName);
			new ImageIcon(tempImage);
			tx = AffineTransform.getRotateInstance(Math.toRadians (e.rotation), e.rotCenterX, e.rotCenterY);
			op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			tempImage = op.filter(ToBuffImage(tempImage), null);
		//System.out.println(Main.player.textureName);
			g2d.drawImage(tempImage, e.getPos().x - (int)Main.c.xPos, e.getPos().y - (int)Main.c.yPos, e.xSize, e.ySize, this);
		}
	}
	
	public static BufferedImage ToBuffImage(Image im)
	{
		BufferedImage bi = new BufferedImage
				(im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
		Graphics bg = bi.getGraphics();
		bg.drawImage(im, 0, 0, null);
		bg.dispose();
		return bi;
	}
	
}
