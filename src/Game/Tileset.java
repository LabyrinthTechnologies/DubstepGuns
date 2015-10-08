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


//import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tileset extends JPanel
{
	public Image tileset;
	
	public Image[] tiles;
	public int tilesLoaded = 0;
	
	public Tileset(String src)
	{
		tiles = new Image[64];
		tileset = new ImageIcon(this.getClass().getResource(src)).getImage();
		//System.out.println(tilesLoaded);
		for(int q = 0; q != 64; q = q + 16)
		{
			System.out.println(q);
			for(int w = 0; w != 64; w = w + 16)
			{
				for(int o = 0; o != 4; o++)
				{
					tiles[tilesLoaded] = createImage(new FilteredImageSource(tileset.getSource(),
							new CropImageFilter(w, q, 16, 16)));
					new ImageIcon(tiles[tilesLoaded]);
					double locationX = ToBuffImage(tiles[tilesLoaded]).getWidth() / 2;
					double locationY = ToBuffImage(tiles[tilesLoaded]).getHeight() / 2;
					AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians (o * 90), locationX, locationY);
					AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
					tiles[tilesLoaded] = op.filter(ToBuffImage(tiles[tilesLoaded]), null);
					tilesLoaded++;
					System.out.println(tilesLoaded);
				}	
			}
		}
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
}
