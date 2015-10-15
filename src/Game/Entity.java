package Game;

import java.awt.Point;

//import javax.swing.JFrame;

public class Entity 
{
	public Entity()
	{
		collides = true;
	}
	
	public String textureName = "default";
	protected int xPos = 0;
	protected int yPos = 0;
	public float xVel = 0;
	public float yVel = 0;
	public int xSize = 30;
	public int ySize = 50;
	public String state = "falling";
	public boolean collides;
	protected boolean physics = false;
	protected int rotation = 0;
	protected int rotCenterX = 0;
	protected int rotCenterY = 0;
		
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
	
	public void setPhysics(boolean onoff)
	{
		physics = onoff;
	}
	
	public void Update()
	{		
		if(physics)
		{
			if(this.getYVel() < 20)
			{
				if(this.state == "falling")
				{
					this.addYVel(0.5F);
				}
				/*else
				{
					p.setYVel(0);
				}*/
			}
			
			
		}
		if(collides)
		{
			if(xPos%Main.blockSize == 0 || (xPos+xSize)%Main.blockSize == 0)
			{
				if(Main.level.level[xPos / Main.blockSize][((yPos + ySize) / Main.blockSize)] == 1 && yVel > 0)
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
				if(xPos + xSize < Main.level.level.length * Main.blockSize)
				{
					if((Main.level.level[xPos / Main.blockSize][(yPos / Main.blockSize) + 1] == 1 || Main.level.level[(xPos + xSize) / Main.blockSize][(yPos / Main.blockSize) + 1] == 1) && yVel > 0)
					{
						////system.out.println("stand");
						state = "standing";
						yVel = 0;
					}
					else
					{
						state = "falling";
					}
				}	
			}
	
			if (/*yVel == 0 &&*/ xVel > 0)
			{
				//system.out.println("pos non" + " (" + xPos + " " + yPos + ") (" + xVel + " " + yVel + ")");
				//yPos = yPos + (int)yVel;
				int tempx = xPos + xSize + (int)xVel;
				//int tempy = yPos;
				if(Main.level.level.length * Main.blockSize > tempx)
				{
					if(yPos%Main.blockSize == 0 || (yPos+ySize)%Main.blockSize == 0)
					{
						if(Main.level.level[tempx / Main.blockSize][yPos / Main.blockSize] == 1)
						{
							//system.out.println("yesx");
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
							//system.out.println("hitx");
							xPos = ((xPos / Main.blockSize) + 1) * Main.blockSize - (xSize);
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
				//system.out.println("neg non" + " " + xVel + " " + yVel);
				//yPos = yPos + (int)yVel;
				int tempx = xPos + (int)xVel;
				//int tempy = yPos;
				if(0 < tempx)
				{
					if(yPos%Main.blockSize == 0 || (yPos+ySize)%Main.blockSize == 0)
					{
						if(Main.level.level[tempx / Main.blockSize][yPos / Main.blockSize] == 1)
						{
							//system.out.println("yesx");
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
							//system.out.println("hitx");
							xPos = ((xPos / Main.blockSize)) * Main.blockSize;
							xVel = 0;
						}
						else
						{
							xPos = xPos + (int)xVel;
						}
					}
				}
				else
				{
					xPos = 0;
				}
			}
			
			if (yVel > 0 /*&& xVel == 0*/)
			{
				//system.out.println("non pos" + " " + xVel + " " + yVel);
				//yPos = yPos + (int)yVel;
				//int tempx = xPos;
				int tempy = yPos + (int)yVel;
				if(Main.level.level[0].length * Main.blockSize > tempy)
				{
					//system.out.println("left");
					if(xPos%Main.blockSize == 0)
					{
						if(Main.level.level[xPos / Main.blockSize][((tempy + ySize) / Main.blockSize)] == 1)
						{
							//system.out.println("yes");
							yPos = (((yPos) / Main.blockSize) + 1) * Main.blockSize;
							yVel = 0;
						}
						else
						{
							state = "falling";
							yPos = yPos + (int)yVel;
						}
					}
					else if((xPos+xSize)%Main.blockSize == 0)
					{
						//system.out.println("right");
						if(Main.level.level[xPos / Main.blockSize][((tempy + ySize) / Main.blockSize)] == 1)
						{
							//system.out.println("yes2");
							yPos = (((yPos) / Main.blockSize) + 1) * Main.blockSize;
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
						//system.out.println("norm");
						if(xPos + xSize < Main.level.level.length * Main.blockSize)
						{
							if(Main.level.level[xPos / Main.blockSize][((tempy + ySize) / Main.blockSize)] == 1 || Main.level.level[(xPos + xSize) / Main.blockSize][((tempy + ySize) / Main.blockSize)] == 1)
							{	
								//system.out.println("hit+ " + xPos + " " + tempy);
								yPos = (((yPos) / Main.blockSize) + 1) * Main.blockSize;
								//system.out.println(xPos + " " + (yPos));
								state = "standing";
							}
							else
							{
								state = "falling";
								yPos = yPos + (int)yVel;
							}
						}
					}
				}
				else
				{
					yPos = (Main.level.level[0].length * Main.blockSize);
				}
			}
			else if (yVel < 0 /*&& xVel == 0*/)
			{
				//system.out.println("non neg" + " " + xVel + " " + yVel);
				//yPos = yPos + (int)yVel;
				//int tempx = xPos;
				int tempy = yPos + (int)yVel;
				if(0 < tempy)
				{
					if(xPos%Main.blockSize == 0 || (xPos+xSize)%Main.blockSize == 0)
					{
						if(Main.level.level[(xPos / Main.blockSize)][tempy / Main.blockSize] == 1)
						{
							//system.out.println("yes");
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
						if(xPos + xSize < Main.level.level.length * Main.blockSize)
						{
							if(Main.level.level[(xPos / Main.blockSize)][(tempy / Main.blockSize)] == 1 || 
								Main.level.level[((xPos + xSize) / Main.blockSize)][(tempy / Main.blockSize)] == 1)
							{
								//system.out.println("hi-t");
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
				else
				{
					yPos = 0;
					yVel = 0;
				}
			}

		}
		else
		{
			yPos = (int) (yPos + yVel);
			xPos = (int) (xPos + xVel);
		}
	}
}
