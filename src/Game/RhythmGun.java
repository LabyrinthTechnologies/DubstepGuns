package Game;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RhythmGun extends Entity
{
	boolean mousetrigger = true;
	
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
		xPos = Main.entity.get(0).xPos + 25;
		yPos = Main.entity.get(0).yPos + 20;
		
		Point locpoint=new Point(xPos,yPos);
		float xDistance = (Main.mouse.GetAdjustedX()) - (xPos + rotCenterX - Main.c.xPos);
		float yDistance = (Main.mouse.GetAdjustedY()) - (yPos + rotCenterY - Main.c.yPos);
		//System.out.println(xDistance + " " + yDistance);
		double rotationAngle = Math.toDegrees(Math.atan2(yDistance, xDistance));
		rotation = (int) rotationAngle;
		//System.out.println(rotation);
		if(Main.mouse.isClicked && mousetrigger)
		{
			Main.qued.add(new RhythmGunShot(rotation, xPos, yPos));
		}
		
		if(Main.mouse.isClicked)
		{
			mousetrigger = false;
		}
		else
		{
			mousetrigger = true;
		}
	}
}
