package Game;

public class RhythmGun extends Entity
{
	public RhythmGun() 
	{
		collides = false;
		xSize = 16;
		ySize = 10;
		textureName = "rhythmGun";
		rotCenterY = 5;
		rotCenterX = 0;
		physics = false;
	}
	
	public void Update()
	{
		super.Update();
		int angle = (int) Math.atan2(Main.mouse.GetAdjustedY() - (yPos-Main.c.yPos), Main.mouse.GetAdjustedX() - (xPos-Main.c.xPos));
		angle = (int) (angle * (180/Math.PI));
		rotation = angle;
		System.out.println(rotation);
	}
}
