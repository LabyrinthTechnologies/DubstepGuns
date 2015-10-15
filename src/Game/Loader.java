package Game;

import java.util.ArrayList;


public class Loader 
{
	protected ArrayList<String> Src;
	protected ArrayList<String> Name;
	
	public Loader()
	{
		Src = new ArrayList<String>();
		Name = new ArrayList<String>();
	}
	
	public void addMap(String src, String name)
	{
		Src.add(src);
		Name.add(name);
		Main.toLoad++;
	}
	
}
