package Game;

import java.awt.Point;

//import javax.swing.JFrame;

public class Player 
{
	public Player()
	{
		collideDown = 700;
		collideRight = 1000;
		collideLeft = 0;
		collideUp = 0;
	}
	
	private int xPos = 0;
	private int yPos = 0;
	public int xVel = 0;
	public int yVel = 0;
	public int xSize = 50;
	public int ySize = 50;
	public int collideLeft;
	public int collideRight;
	public int collideUp;
	public int collideDown;
	public String state = "falling";
		
	public void addYVel(int vel)
	{
		yVel = yVel + vel;
	}
	
	public void addXVel(int vel)
	{
		xVel = xVel + vel;
	}
	
	public void setYVel(int vel)
	{
		yVel = vel;
	}
	
	public void setXVel(int vel)
	{
		xVel = vel;
	}
	
	public int getYVel()
	{
		return yVel;
	}
	
	public int getXVel()
	{
		return xVel;
	}
	
	public void setPos(int x, int y)
	{
		xPos = x;
		yPos = y;
	}
	
	public Point getPos()
	{
		return new Point(xPos, yPos); 
	}
	
	private Point toblock(int x, int y)
	{
		return new Point(x / 50, (y / 50));
	}
	
	public void Update()
	{
		collideDown = 700;
		collideRight = 1000;
		collideLeft = 0;
		collideUp = 0;
		boolean out = true;
		int counter = 1;
		while (out)
		{
			if(!(xPos == (Main.level.level.length * 50) - 50))
			{
				if(Main.level.level[toblock(xPos, yPos).x + 1][toblock(xPos, yPos).y + counter] == 1)
				{
					collideDown = ((toblock(xPos, yPos).y + counter) * 50);
					System.out.println("1: " + collideDown);
					out = false;
				}
			}	
			
			if(Main.level.level[toblock(xPos, yPos).x][toblock(xPos, yPos).y + counter] == 1)
			{
				collideDown = ((toblock(xPos, yPos).y + counter) * 50);
				System.out.println("1: " + collideDown);
				out = false;
			}
			counter++;
		}	
		out = true;
		counter = 0;
		while(out)
		{
			if(toblock(xPos, yPos).y - counter == 0)
			{
				collideUp = 0;
				break;
			}
			if(!(xPos == (Main.level.level.length * 50) - 50))
			{
				if(Main.level.level[toblock(xPos, yPos).x + 1][toblock(xPos, yPos).y - counter] == 1)
				{
					collideUp = ((toblock(xPos, yPos).y - counter) * 50);
					System.out.println("2: " + collideUp);
					out = false;
				}
			}	
			
			if(Main.level.level[toblock(xPos, yPos).x][toblock(xPos, yPos).y - counter] == 1)
			{
				collideUp = ((toblock(xPos, yPos).y - counter) * 50);
				System.out.println("2: " + collideUp);
				out = false;
			}
			counter++;
		}
		

		/*if(Main.level.level[toblock(xPos, yPos).x][toblock(xPos, yPos + 1).y] == 1)
		{
			collideDown = ((toblock(xPos, yPos).y + 1) * 50);
			System.out.println("2: " + collideDown);
		}*/
		
		if((xPos < collideRight - xSize && xVel > 0) || (xPos > collideLeft && xVel < 0))
		{
			if((xPos > collideLeft) && (collideRight - (xPos + xSize) < xVel))
			{
				xPos = collideRight - xSize;
			}
			else if ((xVel < 0) && (-xVel > xPos))
			{
				xPos = collideLeft;
			}
			else
			{
				this.xPos = this.xPos + xVel;
			}
			//this.xPos = this.xPos + xVel;
		}
		
		if((yPos < collideDown - ySize && yVel > 0) || (yPos > collideUp && yVel < 0))
		{
			if((yPos > collideUp) && (collideDown - (yPos + ySize) < yVel))
			{
				System.out.println("hit");
				yPos = collideDown - ySize;
				yVel = 0;
				//state = "standing";
			}
			else if ((yPos < collideDown) && (yPos - (collideUp + 50) < -yVel))//((yVel < 0) && (-yVel > yPos))
			{
				System.out.println("hit2");
				yPos = collideUp + 50;
				yVel = 0;
				//state = "standing";
			}
			else
			{
				System.out.println("no hit");
				this.yPos = this.yPos + yVel;
				//state = "falling";
			}
			
		}
		


		
		if(yPos == collideDown - ySize)
		{
			state = "standing";
		}
		else
		{
			state = "falling";
		}
		System.out.println(state + " " + collideDown + " " + yPos + " " + yVel);
	}
}
