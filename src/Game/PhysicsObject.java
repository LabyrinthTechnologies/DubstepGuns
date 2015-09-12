package Game;

public class PhysicsObject 
{
	private static boolean physics = false;
	
	private static Entity p;
	
	PhysicsObject(Entity player)
	{
		p = player;
	}
	
	public void setPhysics(boolean onoff)
	{
		physics = onoff;
	}
	
	public void Update()
	{
		p.Update();
		if(physics)
		{
			if(p.getYVel() < 20)
			{
				if(p.state == "falling")
				{
					p.addYVel(0.5F);
				}
				/*else
				{
					p.setYVel(0);
				}*/
			}
			
			
		}
	}
}
