package Game;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Loader 
{
	protected ArrayList<String> Src;
	protected ArrayList<String> Name;
	protected Map<String, String> Map;
	
	public Loader()
	{
		Src = new ArrayList<String>();
		Name = new ArrayList<String>();
		Map = new HashMap();
	}
	
	public void addMap(String src, String name)
	{
		Src.add(src);
		Name.add(name);
	}
	
}
