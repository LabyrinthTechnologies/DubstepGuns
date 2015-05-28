package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.JFrame;*/

//import com.sun.corba.se.spi.orbutil.fsm.Action;

public class Listener implements KeyListener, ActionListener
{
	//public final HashMap<Character,Boolean> pressed = new HashMap<Character,Boolean>();
	
	private boolean w = false;
	private boolean a = false;
	private boolean s = false;
	private boolean d = false;
	
	public boolean getW()
	{
		return w;
	}
	
	public boolean getA()
	{
		return a;
	}
	
	public boolean getS()
	{
		return s;
	}
	
	public boolean getD()
	{
		return d;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		if(arg0.getKeyCode() == KeyEvent.VK_W)
		{
			w = true;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_A)
		{
			a = true;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_S)
		{
			s = true;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_D)
		{
			d = true;
		}
		
		System.out.println("press "+arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		if(arg0.getKeyCode() == KeyEvent.VK_W)
		{
			w = false;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_A)
		{
			a = false;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_S)
		{
			s = false;
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_D)
		{
			d = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	

	
}
