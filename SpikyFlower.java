import java.awt.event.*;
import javax.swing.*;
/**
 * <PRE> A type of Flower for the game Rainbow plants that if touched by the Player, will cause them to lose points.
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012 </PRE>
 */
public class SpikyFlower extends Flower
{
  public SpikyFlower (int x, int y, int col, int dir)
  {
    super (x, y, col, dir);
    if (col == 0)
      setIcon (new ImageIcon ("BlueSpikyFlower.png"));
    else if (col == 1)
      setIcon (new ImageIcon ("GreenSpikyFlower.png"));
    else if (col == 2)
      setIcon (new ImageIcon ("RedSpikyFlower.png"));
    else
    {
      if (col == 3)
        setIcon (new ImageIcon ("YellowSpikyFlower.png"));
    }
  }  
  /**
   * A defined actionPerformed method for the ActionListener interface that helps
   * animate the Flower properly and straightly. 
   * The first if structure determines if the direction is going from rig+ at to left and if the position of the Flower
   * isn't already at 750 on the x axis. If it is, the timer that animates stops the animation and the Flower is 
   * removed from play. A similar process occurs for the next two "else if" and last "else" structure. 
   */
  public void actionPerformed (ActionEvent e)
  {
    if (collDetect ())
    {
      Player.decrLives ();
      if (Player.score >= 50)
        Player.setScore (-50);
      removeSelf ();
    }
    if (getDirection () == 0)
    {
      if (getXPos () < 601)
      {
        incrXPos ();
      }
      else
      {
        removeSelf ();
      }
    }
    else if (getDirection () == 1)
    {
      if (getYPos () < 601)
        incrYPos ();
      else
      {
        removeSelf ();
      }
    }
    else if (getDirection () == 2)
    {
      if (getXPos () > -31)
        decrXPos ();
      else
      {
        removeSelf ();
      }
    }
    else
    {
      if (getDirection () == 3)
      {
        if (getYPos () > -31)
          decrYPos ();
        else
        {
          removeSelf ();
        }
      }
    }
  }
}