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


import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
	public Image tile2;
	public Image tile2_1;
	public Image tile2_2;
	public Image tile2_3;
	public Image tile3;
	public Image tile4;
	public Image tile4_1;
	public Image tile4_2;
	public Image tile4_3;
	public Image tile5;
	public Image tile5_1;
	public Image tile5_2;
	public Image tile5_3;
	public Image tile6;
	public Image tile6_1;
	public Image tile6_2;
	public Image tile6_3;
	public Image tile7;
	public Image tile7_1;
	public Image tile8;
	public Image tile8_1;
	public Image tile9;
	public Image tile9_1;
	public Image tile9_2;
	public Image tile9_3;
	
	public Game()
	{
		super();
		player = new ImageIcon(this.getClass().getResource("/Textures/Thing.png")).getImage();
		tileset = new ImageIcon(this.getClass().getResource("/Textures/tiles.png")).getImage();
		tileblank = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(0, 0, 16, 16)));
		tile1 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(16, 0, 16, 16)));
		tile2 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(32, 0, 16, 16)));
		tile3 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(48, 0, 16, 16)));
		tile4 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(0, 16, 16, 16)));
		tile5 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(16, 16, 16, 16)));
		tile6 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(32, 16, 16, 16)));
		tile7 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(48, 16, 16, 16)));
		tile8 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(0, 32, 16, 16)));
		tile9 = createImage(new FilteredImageSource(tileset.getSource(),
		        new CropImageFilter(16, 32, 16, 16)));
		//tile2_1 = rotate(tile2, 90);
		//tile2_2 = rotate(tile2, 180);
		new ImageIcon(tileblank);
		new ImageIcon(tile2);
		new ImageIcon(tile3);
		new ImageIcon(tile4);
		new ImageIcon(tile5);
		new ImageIcon(tile6);
		new ImageIcon(tile7);
		new ImageIcon(tile8);
		new ImageIcon(tile9);
		//tile2
		double locationX = ToBuffImage(tile2).getWidth() / 2;
		double locationY = ToBuffImage(tile2).getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians (90), locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile2_1 = op.filter(ToBuffImage(tile2), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (180), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile2_2 = op.filter(ToBuffImage(tile2), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (270), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile2_3 = op.filter(ToBuffImage(tile2), null);
		//tile4
		locationX = ToBuffImage(tile4).getWidth() / 2;
		locationY = ToBuffImage(tile4).getHeight() / 2;
		tx = AffineTransform.getRotateInstance(Math.toRadians (90), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile4_1 = op.filter(ToBuffImage(tile4), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (180), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile4_2 = op.filter(ToBuffImage(tile4), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (270), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile4_3 = op.filter(ToBuffImage(tile4), null);
		//tile5
		locationX = ToBuffImage(tile5).getWidth() / 2;
		locationY = ToBuffImage(tile5).getHeight() / 2;
		tx = AffineTransform.getRotateInstance(Math.toRadians (90), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile5_1 = op.filter(ToBuffImage(tile5), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (180), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile5_2 = op.filter(ToBuffImage(tile5), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (270), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile5_3 = op.filter(ToBuffImage(tile5), null);
		//tile6
		locationX = ToBuffImage(tile6).getWidth() / 2;
		locationY = ToBuffImage(tile6).getHeight() / 2;
		tx = AffineTransform.getRotateInstance(Math.toRadians (90), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile6_1 = op.filter(ToBuffImage(tile6), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (180), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile6_2 = op.filter(ToBuffImage(tile6), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (270), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile6_3 = op.filter(ToBuffImage(tile6), null);
		//tile7
		locationX = ToBuffImage(tile7).getWidth() / 2;
		locationY = ToBuffImage(tile7).getHeight() / 2;
		tx = AffineTransform.getRotateInstance(Math.toRadians (90), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile7_1 = op.filter(ToBuffImage(tile7), null);
		//tile8
		locationX = ToBuffImage(tile8).getWidth() / 2;
		locationY = ToBuffImage(tile8).getHeight() / 2;
		tx = AffineTransform.getRotateInstance(Math.toRadians (90), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile8_1 = op.filter(ToBuffImage(tile8), null);
		//tile9
		locationX = ToBuffImage(tile9).getWidth() / 2;
		locationY = ToBuffImage(tile9).getHeight() / 2;
		tx = AffineTransform.getRotateInstance(Math.toRadians (90), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile9_1 = op.filter(ToBuffImage(tile9), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (180), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile9_2 = op.filter(ToBuffImage(tile9), null);
		tx = AffineTransform.getRotateInstance(Math.toRadians (270), locationX, locationY);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		tile9_3 = op.filter(ToBuffImage(tile9), null);
	}
	
	public BufferedImage rotate180( BufferedImage inputImage ) 
	{
			int width = inputImage.getWidth(); 
			int height = inputImage.getHeight();

			BufferedImage returnImage = new BufferedImage( width, height, inputImage.getType() );

			for( int x = 0; x < width; x++ ) 
			{
				for( int y = 0; y < height; y++ ) 
				{
					returnImage.setRGB(width - x - 1, height - y - 1, inputImage.getRGB(x, y));
				}
			}
			return returnImage;
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
			for (int y = 0; y < Main.level.renderLevel[0].length; y++)
			{
				if(Main.level.renderLevel[x][y] == 1)
				{
					//btemp = tile1;
					//g2d.setColor(Color.yellow);
					g2d.drawImage(tile1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
					//System.out.println("yellow");
				}
				else if(Main.level.renderLevel[x][y] == 2)
				{
					g2d.drawImage(tile2, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 3)
				{
					g2d.drawImage(tile2_1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 4)
				{
					g2d.drawImage(tile2_2, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 5)
				{
					g2d.drawImage(tile2_3, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 6)
				{
					g2d.drawImage(tile3, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 7)
				{
					g2d.drawImage(tile4, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 8)
				{
					g2d.drawImage(tile4_1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 9)
				{
					g2d.drawImage(tile4_2, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 10)
				{
					g2d.drawImage(tile4_3, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 11)
				{
					g2d.drawImage(tile5, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 12)
				{
					g2d.drawImage(tile5_1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 13)
				{
					g2d.drawImage(tile5_2, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 14)
				{
					g2d.drawImage(tile5_3, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 15)
				{
					g2d.drawImage(tile6, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 16)
				{
					g2d.drawImage(tile6_1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 17)
				{
					g2d.drawImage(tile6_2, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 18)
				{
					g2d.drawImage(tile6_3, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 19)
				{
					g2d.drawImage(tile7, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 20)
				{
					g2d.drawImage(tile7_1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 21)
				{
					g2d.drawImage(tile8, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 22)
				{
					g2d.drawImage(tile8_1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 23)
				{
					g2d.drawImage(tile9, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 24)
				{
					g2d.drawImage(tile9_1, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 25)
				{
					g2d.drawImage(tile9_2, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
				}
				else if(Main.level.renderLevel[x][y] == 26)
				{
					g2d.drawImage(tile9_3, (x * Main.blockSize) - (int)Main.c.xPos, (y * Main.blockSize) - (int)Main.c.yPos, Main.blockSize, Main.blockSize, this);
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
