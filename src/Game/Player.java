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
	public float xVel = 0;
	public float yVel = 0;
	public int xSize = 50;
	public int ySize = 50;
	public int collideLeft;
	public int collideRight;
	public int collideUp;
	public int collideDown;
	public String state = "falling";
		
	public void addYVel(float vel)
	{
		yVel = yVel + vel;
	}
	
	public void addXVel(float vel)
	{
		xVel = xVel + vel;
	}
	
	public void setYVel(float vel)
	{
		yVel = vel;
	}
	
	public void setXVel(float vel)
	{
		xVel = vel;
	}
	
	public float getYVel()
	{
		return yVel;
	}
	
	public float getXVel()
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
				//if(xPos)
				if(xPos%50 != 0)
				{
					if(Main.level.level[toblock(xPos, yPos).x + 1][toblock(xPos, yPos).y + counter] == 1)
					{
						collideDown = ((toblock(xPos, yPos).y + counter) * 50);
						//System.out.println("1: " + collideDown);
						out = false;
					}
				}
			}	
			
			if(Main.level.level[toblock(xPos, yPos).x][toblock(xPos, yPos).y + counter] == 1)
			{
				collideDown = ((toblock(xPos, yPos).y + counter) * 50);
				//System.out.println("1: " + collideDown);
				out = false;
			}
			counter++;
		}	
		out = true;
		counter = 1;
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
					//System.out.println("2: " + collideUp);
					out = false;
				}
			}	
			
			if(Main.level.level[toblock(xPos, yPos).x][toblock(xPos, yPos).y - counter] == 1)
			{
				collideUp = ((toblock(xPos, yPos).y - counter) * 50);
				//System.out.println("2: " + collideUp);
				out = false;
			}
			counter++;
		}
		
		out = true;
		counter = 0;
		while (out)
		{
			if(toblock(xPos, yPos).x + counter == 20)
			{
				collideRight = 1000;
				break;
			}
			if(!(yPos == (Main.level.level[0].length * 50) - 50))
			{
				if(Main.level.level[toblock(xPos, yPos).x + counter][toblock(xPos, yPos).y + 1] == 1)
				{
					if(state != "standing")
					{
						collideRight = ((toblock(xPos, yPos).x + counter) * 50);
						//System.out.println("1: " + collideDown);
						out = false;
					}
				}
			}	
			
			if(Main.level.level[toblock(xPos, yPos).x + counter][toblock(xPos, yPos).y] == 1)
			{
				collideRight = ((toblock(xPos, yPos).x + counter) * 50);
				//System.out.println("1: " + collideDown);
				out = false;
			}
			counter++;
		}
		/*while(out)
		{
			if(toblock(xPos, yPos).x + counter == 20)
			{
				collideRight = 1000;
				break;
			}
			if(!(yPos == (Main.level.level.length * 50) - 50))
			{
				if(state != "standing")
				{
					if(Main.level.level[toblock(xPos, yPos).x + counter][toblock(xPos, yPos).y + 1] == 1)
					{
						collideRight = (((toblock(xPos, yPos).x + counter) * 50));
						//System.out.println("4: " + collideRight);
						out = false;
					}
				}	
			}	
			
			if(Main.level.level[toblock(xPos, yPos).x + counter][toblock(xPos, yPos).y] == 1)
			{
				collideRight = (((toblock(xPos, yPos).x + counter) * 50));
				//System.out.println("4: " + collideRight);
				out = false;
			}
			counter++;
		}*/
		
		out = true;
		counter = 0;
		while(out)
		{
			if(toblock(xPos, yPos).x - counter == 0)
			{
				collideLeft = 0;
				break;
			}
			if(!(yPos == (Main.level.level.length * 50) - 50))
			{
				if(state != "standing")
				{
					if(Main.level.level[toblock(xPos, yPos).x - counter][toblock(xPos, yPos).y + 1] == 1)
					{
						collideLeft = (((toblock(xPos, yPos).x - counter) * 50) + xSize);
						//System.out.println("3: " + collideLeft);
						out = false;
					}
				}	
			}	
			
			if(Main.level.level[toblock(xPos, yPos).x - counter][toblock(xPos, yPos).y] == 1)
			{
				collideLeft = (((toblock(xPos, yPos).x - counter) * 50) + xSize);
				//System.out.println("3: " + collideLeft);
				out = false;
			}
			counter++;
		}
		

		/*if(Main.level.level[toblock(xPos, yPos).x][toblock(xPos, yPos + 1).y] == 1)
		{
			collideDown = ((toblock(xPos, yPos).y + 1) * 50);
			System.out.println("2: " + collideDown);
		}*/
		

		
		if((yPos < collideDown - ySize && yVel > 0) || (yPos > collideUp && yVel < 0))
		{
			System.out.println("collidey");
			if((yPos > collideUp) && (collideDown - (yPos + ySize) < yVel))
			{
				//System.out.println("hit");
				yPos = collideDown - ySize;
				System.out.println("down");
				yVel = 0;
				//state = "standing";
			}
			else if ((yPos < collideDown) && (yPos - (collideUp + 50) < -yVel))//((yVel < 0) && (-yVel > yPos))
			{
				//System.out.println("hit2");
				yPos = collideUp + 50;
				System.out.println("up");
				yVel = 0;
				//state = "standing";
			}
			else
			{
				//System.out.println("no hit");
				yPos = (int) (yPos + yVel);
				System.out.println("ynorm");
				//state = "falling";
			}
			
		}
		
		if((xPos < collideRight - xSize && xVel > 0) || (xPos > collideLeft && xVel < 0))
		{
			System.out.println("collidex");
			if((xPos > collideLeft) && (collideRight - (xPos + xSize) < xVel))
			{
				System.out.println("hit");
				xPos = collideRight - xSize;
				xVel = 0;
			}
			else if ((xPos < collideRight) && (xPos - (collideLeft) < -xVel))
			{
				System.out.println("hit2");
				xPos = collideLeft + 50;
				xVel = 0;
			}
			else
			{
				System.out.println("norm");
				xPos = (int) (xPos + xVel);
			}
			//this.xPos = this.xPos + xVel;
		}
		

		System.out.println(state + " " + collideDown + " " + yPos + " " + yVel + " " + xPos);
		
		if(yPos == collideDown - ySize)
		{
			state = "standing";
			//System.out.println("stand");
			yVel = 0;
		}
		else
		{
			state = "falling";
		}
		
	}
}
