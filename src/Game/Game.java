package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
//import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class Game extends JPanel 
{
	AffineTransform tx;
	AffineTransformOp op;
	AffineTransform oldtx;
	
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
	
	public void paintGame(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		for (int x = 0; x < Main.level.level.length; x++)
		{
			for (int y = 0; y < Main.level.renderLevel[0].length; y++)
			{
				g2d.drawImage(Main.ts.tiles[Main.level.renderLevel[x][y]], (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);	
			}
		}
		oldtx = g2d.getTransform();
		for(Entity e : Main.entity)
		{
			Image tempImage = Main.tl.textureFromName(e.textureName);
			//new ImageIcon(tempImage);
			tx = new AffineTransform();
			
			tx.rotate(Math.toRadians(e.rotation), (e.rotCenterX + e.xPos) - Main.c.xPos, (e.rotCenterY + e.yPos) - Main.c.yPos);
			//op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			//tempImage = op.filter(ToBuffImage(tempImage), null);
		//System.out.println(Main.player.textureName);
			g2d.setTransform(tx);
			
			g2d.drawImage(tempImage, e.getPos().x - (int)Main.c.xPos, e.getPos().y - (int)Main.c.yPos, e.xSize, e.ySize, this);
			g2d.setTransform(oldtx);
		}
		
		g2d.drawOval((int)(Main.mouse.GetAdjustedX() - 2.5), (int)(Main.mouse.GetAdjustedY() - 2.5), 5, 5);
	}
	
	public void paintLoading(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, Main.c.xSize, Main.c.ySize);
		float size = 600.0F * ((float) Main.loaded) / Main.toLoad;
		g2d.setColor(Color.yellow);
		g2d.fillRect(200, 500, 600, 20);
		g2d.setColor(Color.green);
		g2d.fillRect(200, 500, (int) size, 20);
		System.out.println(Main.loaded + " " + size);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		if (Main.gameState == 0)
		{
			paintLoading(g);
		}
		else if	(Main.gameState == 1)
		{
			paintGame(g);
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
