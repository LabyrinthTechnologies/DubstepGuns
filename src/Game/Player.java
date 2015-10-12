package Game;

public class Player extends Entity
{
	public Player()
	{
		textureName = "defaultPlayer";
		physics = true;
	}
	
	@Override
	public void Update()
	{
		if(Main.listener.getW())
		{
			if(this.state == "standing")
			{
				this.setYVel(-14);
			}
		}
		if(Main.listener.getA())
		{
			this.setXVel(-3);
		}
		
		if(Main.listener.getD())
		{
			this.setXVel(3);
		}
		
		if(!Main.listener.getA() && !Main.listener.getD())
		{
			this.setXVel(0);
		}
		
		super.Update();
		
		if(Main.c.xPos + (Main.c.xSize / 2) > xPos + (xSize / 2) + 1)
		{
			Main.c.cameraLeft(3);
		}
		else if(Main.c.xPos + (Main.c.xSize / 2) < xPos + (xSize / 2) - 1)
		{
			Main.c.cameraRight(3);
		}
		//Main.c.xPos = xPos + (xSize / 2);
		

		
		//System.out.println(xVel);
	}
}
