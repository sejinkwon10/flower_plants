import javax.swing.*;
import java.awt.event.*;
/**
 * <PRE> The basic Rock class for the game Rainbow plants. This acts as an obstacle that blocks the
 * Player from moving on the screen.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 * </PRE>
 */
public class Trap extends Character implements ActionListener
{  
  /**
   * The timer object.
   */
  private Timer timer;
  
  /**
   * Creates a new Rock object that lasts t (long) seconds and
   * is at point (x,y) on its JPanel container. 
   * 
   * @param x The x location
   * @param y The y location
   * @param t The time
   */
  public Trap (int x, int y, long t)
  {
    super (x, y, 0);
    setIcon (new ImageIcon ("Trap.png"));
    setVisible (true);
    timer = new Timer ((int)t,this);
    timer.start ();
  }
  
  public void pause ()
  {
    timer.stop ();
  }
  public void resume ()
  {
    timer.start ();
  }
  
  public void removeSelf ()
  {
      timer.stop ();
      FrameApp.g.remove (this);
      FrameApp.g.updateUI ();
  }
  /**
   * Adds 1 to time every time the Timer invokes an Action until
   * limit is equal to time. When limit is equal to time, the Rock
   * removes itself from the grid. 
   */
  public void actionPerformed (ActionEvent e)
  {
    removeSelf ();
  }
}