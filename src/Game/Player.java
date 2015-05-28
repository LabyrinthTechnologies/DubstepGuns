package Game;

//import javax.swing.JFrame;

public class Player 
{
	public Player()
	{
		
	}
	public int xPos = 0;
	public int yPos = 0;
	public int xVel = 0;
	public int yVel = 0;
	
	public void moveRight()
	{
		if(this.xPos < Game.frame.getWidth()-120)
		{
			this.xPos = this.xPos + 10;
		}
	}
	
	public void moveLeft()
	{
		if(this.xPos > 0)
		{
			this.xPos = this.xPos - 10;
		}
	}
	
	public void moveUp()
	{
		if(this.yPos > 0)
		{
			this.yPos = this.yPos - 10;
		}
	}
	
	public void moveDown()
	{
		if(this.yPos < Game.frame.getHeight()-130)
		{
			this.yPos = this.yPos + 10;
		}
	}
}
