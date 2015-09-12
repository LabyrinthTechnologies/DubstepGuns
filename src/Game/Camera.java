package Game;

public class Camera 
{
	public float xPos = 0;
	public float yPos = 0;
	public int xSize = 1000;
	public int ySize = 700;
	
	public void cameraRight(int a)
	{
		if(Main.level.level.length * Main.blockSize  - xSize > xPos)
		xPos = xPos + a;
	}
	
	public void cameraLeft(int a)
	{
		if(xPos > 0)
		{
			xPos = xPos - a;
		}
	}
}
