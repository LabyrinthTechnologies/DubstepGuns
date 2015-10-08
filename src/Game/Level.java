package Game;

public class Level 
{
	public String tileSrc = "/Textures/tiles2.png";
	
	public int[][] level = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,1,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,1,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,1,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,1,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,1,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,1,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,1,0,0,0,0,0,0,0,0,1,0,1},
			{0,0,1,0,0,0,0,0,0,1,0,0,0,1},
			{0,0,0,1,0,0,0,0,1,0,0,0,0,1},
			{0,0,0,0,1,0,0,0,1,0,0,0,0,1},
			{0,0,0,0,0,0,0,1,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
	
	public int[][] renderLevel = {
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,04,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,04,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,39,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,37,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,19,20},
			{18,00,00,00,00,00,00,00,00,00,00,36, 9,21},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,04,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,04,00, 8},
			{10,00,00,00,00,00,00,00,00,00,04,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,04,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{10,00,39,00,00,00,00,00,00,00,00,00,00, 8},
			{17,00,33,00,00,00,00,00,00,00,00,04,00, 8},
			{00,00,37,00,00,00,00,00,00,04,00,00,00, 8},
			{00,00,00,04,00,00,00,00,39,00,00,00,00, 8},
			{00,00,00,00,04,00,00,00,37,00,00,00,00, 8},
			{00,00,00,00,00,00,00,04,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8},
			{00,00,00,00,00,00,00,00,00,00,00,00,00, 8}};
	
/*
 * 00-03 - Blank Space
 * 04-07 - All sides
 * 08-11 - Single side (top)
 * 12-15 - no sides
 * 16-19 - corner (top right)
 * 20-23 - corner piece (top left)
 * 24-27 - corner pieces (top)
 * 28-31 - corner pieces (top left bottom right)
 * 32-35 - sides (vertical)
 * 36-39 - open (down)
 */
	
	Level()
	{
		 
	}
}
