package Game;

//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class Mouse implements MouseListener, MouseMotionListener
{
	public boolean isClicked = false;
	
	public float GetRawPosX()
	{
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		return x;
	}
	
	public float GetRawPosY()
	{
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int y = (int) b.getY();
		return y;
	}
	
	public boolean isOnscreen()
	{
		Point p = Main.frame.getLocation();
		if (GetRawPosY() > p.getY() && GetRawPosY() < 700+p.getY() && GetRawPosX() > p.getX() && GetRawPosX() < 1000+p.getX())
		{
			return true;
		}
		return false;
	}
	
	public float GetAdjustedX()
	{
		return adjX;
		/*Point p = Main.frame.getLocation();
		if(isOnscreen())
		{
			return (float) (GetRawPosX() - p.getX());
		}
		else
		{
			return -10;
		}*/
	}
	
	public float GetAdjustedY()
	{
		return adjY;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		isClicked = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		isClicked = false;
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int adjX;
	public int adjY;

	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
		adjX = arg0.getX();
		adjY = arg0.getY();
		System.out.println("greg");
	}
}