import javax.swing.*;
import java.awt.event.*;

/**
 * <PRE> The basic Flower that the Player collects to get points in the game Rainbow plants. 
 * It traverses the screen so that the Player can "collect" it with their basket. 
 * The direction that the Flower is going on the screen must match the direction of the basket of the
 * Player. When a Flower of a colour matching the colour of the user's basket is collected, the user gains points. 
 * Otherwise, they lose points. If a Flower is collected or traverses the whole game screen without being collected.
 * it is then removed from play. 
 * Variable Dictionary:
 * t     Timer     helps the animation of the Flower across the screen.
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class Flower extends Moveable implements ActionListener
{
  private Timer t;
  
  /**
   * <PRE>Constructs a Flower object that starts at x on the x axis and y on the y axis, 
   * comes in from direction dir, is of the colour col and is represented by an image that 
   * depends on the parameter int col. 
   * Ths first if detects if the colour of the Flower is blue.
   * The first else if detects if the colour of the Flower is green.
   * The second else if detects if the colour of the Flower is red.
   * The else detects if the colour of the Flower is yellow. 
   * @param x     int     initial x axis position
   * @param y     int     initial y axis position
   * @param dir   int     direction that the Flower comes in on the screen
   * @param col   int     colour of the Flower </PRE>
   */
  public Flower (int x, int y, int col , int dir)
  {
    super (x, y, col, dir);
    if (col == 0)
      setIcon (new ImageIcon ("BlueFlower.png"));
    else if (col == 1)
      setIcon (new ImageIcon ("GreenFlower.png"));
    else if (col == 2)
      setIcon (new ImageIcon ("RedFlower.png"));
    else
      setIcon (new ImageIcon ("YellowFlower.png"));
    t = new Timer (1, this);
    t.start ();
  }
  
  /**
   * (Re)Starts the movement of the Flower (for when the game is started or paused and then resumed).
   */
  public void resume ()
  {
    t.start ();
  }
  
  /**
   * Stops the movement of the Flower (for when the game is paused). 
   */
  public void pause ()
  {
    t.stop ();
  }
  
  /**
   * Removes the Flower from the screen after it has been collected or has moved off the screen.
   * Precondition: this Flower is out of play. 
   * Postcondition: this Flower has been removed.
   */
  public void removeSelf ()
  {
    pause ();
    FrameApp.g.remove(this);
  }
  
  /**
   * A defined actionPerformed method for the ActionListener interface that helps
   * animate the Flower and deal with if the Flower has hit a Player. 
   * The first if checks if the Flower has hit a Player. 
   * The second if checks if the colour of the Flower matches that of the Player and adds 50 to the Player's score.
   * The first else is for when the colour of the Flower does not match that of the Player and it subtracts 10 from the Player's score.
   * The third if structure determines if the direction of the Flower is going from left to right.
   * The fourth if structure checks if the Flower is still on the screen and if this is true, it moves the Flower one pixel to the right. 
   * The second else is for when the Flower isn't on the screen. If this is true, the Flower is removed from play.
   * The fifth if structure determines if the direction of the Flower is going from up to down.
   * The sixth if structure checks if the Flower is still on the screen and if this is true, it moves the Flower one pixel down. 
   * The third else is for when the Flower isn't on the screen. If this is true, the Flower is removed from play.
   * The seventh if structure determines if the direction of the Flower is going from right to left.
   * The eigth if structure checks if the Flower is still on the screen and if this is true, it moves the Flower one pixel left. 
   * The fourth else is for when the Flower isn't on the screen. If this is true, the Flower is removed from play.
   * The ninth if structure determines if the direction of the Flower is going from down to up.
   * The tenth if structure checks if the Flower is still on the screen and if this is true, it moves the Flower one pixel up. 
   * The fifth else is for when the Flower isn't on the screen. If this is true, the Flower is removed from play.
   * @param e     ActionEvent     passes in data of the Action that was performed to trigger the method. 
   */
  public void actionPerformed (ActionEvent e)
  {
    if (collDetect ())
    {
      if (getColor () == FrameApp.g.pl.getColor ())
      {
        Player.setScore(50);
      }
      else
      {
        Player.setScore (10);
      }
      removeSelf ();
    }
    if (getDirection () == 0)
    {
      if (getXPos () < 601)
      {
        incrXPos ();
      }
      else
        removeSelf ();
    }
    else if (getDirection () == 1)
    {
      if (getYPos () < 601)
      {
        incrYPos ();
      }
      else
        removeSelf ();
    }
    else if (getDirection () == 2)
    {
      if (getXPos () > -31)
      {
        decrXPos ();
      }
      else
        removeSelf ();
    }
    else
    {
      if (getDirection () == 3)
      {
        if (getYPos () > -31)
        {
          decrYPos ();
        }
        else
          removeSelf ();
      }
    }
  }
  /**
   * Detects if the Flower hits a Player.
   * The Flower is only validly caught if the direction of the Flower is opposite to that of the Player it hit and
   * if the Flower hits only the Player's basket. 
   * The if structures are used to check if the Flower has hit a Player at given points on the Flower. 
   * If the Flower hits a player validly, this method returns true. Otherwise, it returns false.
   * This method is called every time the Flower moves.
   * Variable Dictionary:
   * pl         Player     variable used to store the Player that the Flower has hit. 
   * isThere    boolean    stores if the Flower has hit just the Player's basket. 
   */
  public boolean collDetect ()
  {
    Player pl = null; 
    try
    {
      if (getDirection () == 0)
      {
        if (FrameApp.g.getComponentAt (getXPos () + 31, getYPos ()) instanceof Player || FrameApp.g.getComponentAt (getXPos () + 31, getYPos () - 15) instanceof Player || FrameApp.g.getComponentAt (getXPos () + 31, getYPos () - 30) instanceof Player )
        {
          if (FrameApp.g.getComponentAt (getXPos () + 31, getYPos ()) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () + 31, getYPos ()));
          else if (FrameApp.g.getComponentAt (getXPos () + 31, getYPos () - 15) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () + 31, getYPos () - 15));
          else
            if (FrameApp.g.getComponentAt (getXPos () + 31, getYPos () - 30) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () + 31, getYPos () - 30));
          for (int x = 0; x < 112; x += 4)
          {
            if (FrameApp.g.getComponentAt (pl.getXPos () - 1, pl.getYPos () + x) instanceof Flower)
            {
              if (pl.getDirection () == 2)
              {
                return true;
              }
            }
          }
        }
      }
      else if (getDirection () == 1)
      {
        if (FrameApp.g.getComponentAt (getXPos (), getYPos () + 31) instanceof Player || FrameApp.g.getComponentAt (getXPos () + 15, getYPos () + 31) instanceof Player || FrameApp.g.getComponentAt (getXPos () + 30, getYPos () + 31) instanceof Player)
        {
          if (FrameApp.g.getComponentAt (getXPos (), getYPos () + 31) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos (), getYPos ()+ 31));
          else if (FrameApp.g.getComponentAt (getXPos () + 15, getYPos () + 31) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () + 15, getYPos () + 31));
          else
            if (FrameApp.g.getComponentAt (getXPos () + 30, getYPos () + 31) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () + 30, getYPos () + 31));
          for (int x = 0; x < 112; x += 4)
          {
            if (FrameApp.g.getComponentAt (pl.getXPos () + x, pl.getYPos () - 1) instanceof Flower)
            {
              if (pl.getDirection () == 3)
              {
                return true;
              }
            }
          }
        }
      }
      else if (getDirection () == 2)
      {
        if (FrameApp.g.getComponentAt (getXPos () - 1, getYPos ()) instanceof Player || FrameApp.g.getComponentAt (getXPos () - 1, getYPos () + 15) instanceof Player || FrameApp.g.getComponentAt (getXPos () - 1, getYPos () + 30) instanceof Player)
        {
          if (FrameApp.g.getComponentAt (getXPos () - 1, getYPos ()) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () - 1, getYPos ()));
          else if (FrameApp.g.getComponentAt (getXPos () - 1, getYPos () + 15) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () - 1, getYPos () + 15));
          else
            if (FrameApp.g.getComponentAt (getXPos () - 1, getYPos () + 30) instanceof Player)
            pl = (Player) (FrameApp.g.getComponentAt (getXPos () - 1, getYPos () + 30));
          for (int x = 0; x < 112; x += 4)
          {
            if (FrameApp.g.getComponentAt (pl.getXPos () + 113, pl.getYPos () + x) instanceof Flower)
            {
              if (pl.getDirection () == 0)
              {
                return true;
              }
            }
          }
        }
      }
      else
      {
        if (getDirection () == 3)
        {
          if (FrameApp.g.getComponentAt (getXPos (), getYPos () - 1) instanceof Player || FrameApp.g.getComponentAt (getXPos () + 15, getYPos () - 1) instanceof Player || FrameApp.g.getComponentAt (getXPos () + 30, getYPos () - 1) instanceof Player)
          {
            if (FrameApp.g.getComponentAt (getXPos (), getYPos () - 1) instanceof Player)
              pl = (Player) (FrameApp.g.getComponentAt (getXPos (), getYPos () - 1));
            else if (FrameApp.g.getComponentAt (getXPos () + 15, getYPos () - 3) instanceof Player)
              pl = (Player) (FrameApp.g.getComponentAt (getXPos () + 15, getYPos () - 3));
            else
              if (FrameApp.g.getComponentAt (getXPos () + 30, getYPos () - 1) instanceof Player)
              pl = (Player) (FrameApp.g.getComponentAt (getXPos () + 30, getYPos () - 1));
            for (int x = 0; x < 112; x += 4)
            {
              if (FrameApp.g.getComponentAt (pl.getXPos () + x, pl.getYPos () + 113) instanceof Flower)
              {
                if (pl.getDirection () == 1)
                {
                  return true;
                }
              }
            }
          }
        }
      }
    }
    catch (NullPointerException e)
    {
    }
    return false; 
  }
}
