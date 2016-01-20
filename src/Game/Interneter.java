package Game;

import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.sun.glass.events.WindowEvent;

public class Interneter 
{
	Socket s;
	PrintWriter out; 
	BufferedReader in; 
	
	public Interneter()
	{
		if(Main.internet)
		{
			Main.frame.addWindowListener(new WindowAdapter()
			{
			    @SuppressWarnings("unused")
				public void windowClosing(WindowEvent e)
			    {
			        try 
			        {
						s.close();
					} 
		        	catch (IOException e1) 
		        	{
						e1.printStackTrace();
					}
		    	}
			});
		}
	}
	
	public void connect()
	{
		if(Main.internet)
		{
			try 
			{
				s = new Socket("127.0.0.1", 20430);
				out = new PrintWriter(s.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			}
			catch(IOException e)
			{
			
			}
		}
	}
	
	public void sendEntityInfo(int entitynum)
	{
		if(Main.internet)
		{
			int[] tosend = new int[6];
			tosend[0] = entitynum;
			tosend[1] = Main.entity.get(entitynum).xPos;
			tosend[2] = Main.entity.get(entitynum).yPos;
			tosend[3] = (int) Main.entity.get(entitynum).xVel;
			tosend[4] = (int) Main.entity.get(entitynum).yVel;
			tosend[5] = Main.entity.get(entitynum).rotation;
			out.println(tosend);
		}
	}
	
	public void updateEntity(int entitynum)
	{
		if(Main.internet)
		{
			int[] tosend = new int[1];
			tosend[0] = entitynum;
			out.println(tosend);
		}
	}
}
