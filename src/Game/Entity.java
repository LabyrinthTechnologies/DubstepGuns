package Game;

import java.awt.Point;

//import javax.swing.JFrame;

public class Entity 
{
	public Entity()
	{
		collideDown = Main.c.ySize;
		collideRight = Main.c.xSize;
		collideLeft = 0;
		collideUp = 0;
	}
	
	private int xPos = 0;
	private int yPos = 0;
	public float xVel = 0;
	public float yVel = 0;
	public int xSize = 30;
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
		return new Point(x / Main.blockSize, (y / Main.blockSize));
	}
	
	public void Update()
	{		
		if(xPos%Main.blockSize == 0)
		{
			if(Main.level.level[xPos / Main.blockSize][(yPos / Main.blockSize) + 1] == 1 && yVel > 0)
			{
				state = "standing";
				yVel = 0;
			}
			else
			{
				state = "falling";
			}
		}
		else
		{
			if((Main.level.level[xPos / Main.blockSize][(yPos / Main.blockSize) + 1] == 1 || Main.level.level[(xPos + xSize) / Main.blockSize][(yPos / Main.blockSize) + 1] == 1) && yVel > 0)
			{
				state = "standing";
				yVel = 0;
			}
			else
			{
				state = "falling";
			}
		}

		if (/*yVel == 0 &&*/ xVel > 0)
		{
			System.out.println("pos non" + " (" + xPos + " " + yPos + ") (" + xVel + " " + yVel + ")");
			//yPos = yPos + (int)yVel;
			int tempx = xPos + xSize + (int)xVel;
			int tempy = yPos;
			if(Main.level.level.length > (tempx / Main.blockSize))
			{
				if(yPos%Main.blockSize == 0)
				{
					if(Main.level.level[tempx / Main.blockSize][yPos / Main.blockSize] == 1)
					{
						System.out.println("yesx");
						xPos = ((xPos / Main.blockSize) + 1) * Main.blockSize - xSize;
						xVel = 0;
					}
					else
					{
						xPos = xPos + (int)xVel;
					}
				}
				else
				{
					if(Main.level.level[(tempx / Main.blockSize)][(yPos / Main.blockSize)] == 1 || Main.level.level[(tempx / Main.blockSize)][((yPos + ySize) / Main.blockSize)] == 1)
					{
						System.out.println("hitx");
						xPos = ((xPos / Main.blockSize) + 1) * Main.blockSize - (xSize + 1);
					}
					else
					{
						xPos = xPos + (int)xVel;
					}
				}
			}
			else
			{
				xPos = (Main.level.level.length * Main.blockSize) - xSize;
				xVel = 0;
			}
		}
		else if (/*yVel == 0 &&0*/ xVel < 0)
		{
			System.out.println("neg non" + " " + xVel + " " + yVel);
			//yPos = yPos + (int)yVel;
			int tempx = xPos + (int)xVel;
			int tempy = yPos;
			if(0 < (tempx / Main.blockSize) + 1)
			{
				if(yPos%Main.blockSize == 0)
				{
					if(Main.level.level[tempx / Main.blockSize][yPos / Main.blockSize] == 1)
					{
						System.out.println("yesx");
						xPos = ((xPos / Main.blockSize)) * Main.blockSize;
						xVel = 0;
					}
					else
					{
						xPos = xPos + (int)xVel;
					}
				}
				else
				{
					if(Main.level.level[(tempx / Main.blockSize)][(yPos / Main.blockSize)] == 1 || Main.level.level[(tempx / Main.blockSize)][(yPos + ySize) / Main.blockSize] == 1)
					{
						System.out.println("hitx");
						xPos = ((xPos / Main.blockSize)) * Main.blockSize;
						xVel = 0;
					}
					else
					{
						xPos = xPos + (int)xVel;
					}
				}
			}
		}
		
		if (yVel > 0 /*&& xVel == 0*/)
		{
			System.out.println("non pos" + " " + xVel + " " + yVel);
			//yPos = yPos + (int)yVel;
			int tempx = xPos;
			int tempy = yPos + ySize + (int)yVel;
			if(Main.level.level[0].length > (tempy / Main.blockSize))
			{
				if(xPos%Main.blockSize == 0)
				{
					if(Main.level.level[xPos / Main.blockSize][(tempy / Main.blockSize)] == 1)
					{
						System.out.println("yes");
						yPos = ((yPos / Main.blockSize) + 1) * Main.blockSize;
						yVel = 0;
					}
					else
					{
						state = "falling";
						yPos = yPos + (int)yVel;
					}
				}
				else
				{
					if(Main.level.level[xPos / Main.blockSize][(tempy / Main.blockSize)] == 1 || Main.level.level[(xPos + xSize) / Main.blockSize][(tempy / Main.blockSize)] == 1)
					{
						System.out.println("hit");
						yPos = ((yPos / Main.blockSize) + 1) * Main.blockSize;
						state = "standing";
						yVel = 0;
					}
					else
					{
						state = "falling";
						yPos = yPos + (int)yVel;
					}
				}
			}
		}
		else if (yVel < 0 /*&& xVel == 0*/)
		{
			System.out.println("non neg" + " " + xVel + " " + yVel);
			//yPos = yPos + (int)yVel;
			int tempx = xPos;
			int tempy = yPos + (int)yVel;
			if(0 < (tempy / Main.blockSize) + 1)
			{
				if(xPos%Main.blockSize == 0)
				{
					if(Main.level.level[(xPos / Main.blockSize)][tempy / Main.blockSize] == 1)
					{
						System.out.println("yes");
						yPos = ((yPos / Main.blockSize)) * Main.blockSize;
						yVel = 0;
					}
					else
					{
						state = "falling";
						yPos = yPos + (int)yVel;
					}
				}
				else
				{
					if(Main.level.level[(xPos / Main.blockSize)][(tempy / Main.blockSize)] == 1 || Main.level.level[((xPos + xSize) / Main.blockSize)][(tempy / Main.blockSize)] == 1)
					{
						System.out.println("hit");
						yPos = ((yPos / Main.blockSize)) * Main.blockSize;
						yVel = 0;
					}
					else
					{
						state = "falling";
						yPos = yPos + (int)yVel;
					}
				}
			}
		}
	}
}
