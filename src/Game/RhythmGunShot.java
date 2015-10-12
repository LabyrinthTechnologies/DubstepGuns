package Game;

public class RhythmGunShot extends Entity
{
	public RhythmGunShot() 
	{
		collides = false;
		xSize = 10;
		ySize = 10;
		textureName = "rhythmGunShot";
		rotCenterY = 5;
		rotCenterX = 5;
		physics = false;
	}
	
	public RhythmGunShot(int rot, int xPostemp, int yPostemp) 
	{
		collides = false;
		xSize = 10;
		ySize = 10;
		textureName = "rhythmGunShot";
		rotCenterY = 5;
		rotCenterX = 5;
		physics = false;
		rotation = rot;
		yPos = yPostemp;
		xPos = xPostemp;
	}
	
	public void Update()
	{
		super.Update();
		
		int speed = 10;
		float directionx = (float) Math.cos(Math.toRadians(rotation));
		float directiony = (float) Math.sin(Math.toRadians(rotation));
		
		xVel = directionx * speed;
		yVel = directiony * speed;
	}
}
