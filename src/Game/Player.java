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
		

		
		//System.out.println(xVel);
	}
}
