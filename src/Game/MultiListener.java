package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class MultiKeyPressListener implements KeyListener {

    // Set of currently pressed keys
    public final Set<Character> pressed = new HashSet<Character>();

    @Override
    public synchronized void keyPressed(KeyEvent e) 
    {
        pressed.add(e.getKeyChar());
        if (pressed.size() > 1) 
        {
            Iterator<Character> it = pressed.iterator();
            while(it.hasNext())
            {
               if(it.next() == 'w')
               {
            	   //Game.game.movePlayerUp();
               }
            }
            // More than one key is currently pressed.
            // Iterate over pressed to get the keys.
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent e) {/* Not used */ }
}