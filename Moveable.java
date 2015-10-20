import javax.swing.*;
/**
 * <PRE> The basic abstract class that extends the abstract Character class and
 * provides an outline for every moving character in the game Rainbow plants. Every 
 * moving character in the game (the Player, the Flowers) will extend this class since it contains
 * variables and methods such as direction and incrXPos () that are useful for moving objects in the game. 
 * Variable Dictionary:
 * direction    int     direction that the Moveable is facing/coming in from (depends on subclass).
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 * </PRE>
 */
public abstract class Moveable extends Character
{
  private int direction;
 
  /**
   * <PRE>Constructs a Moveable object with x as the position of the Moveable on the x axis,
   * y as the position on the y axis, col as the name of the colour of the Moveable and dir as the
   * direction that the Moveable is facing/coming in from.(depends on subclass). 
   * 
   * @param x     int     initial x axis position
   * @param y     int     initial y axis position
   * @param col   int     colour of the Moveable
   * @param dir   int     initial direction </PRE>
   */
  public Moveable (int x, int y, int col , int dir)
  {
    super (x,y,col);
    direction = dir;
  }
  
  /**
   * Adds one to the x axis position of the Moveable. 
   */
  public void incrXPos ()
  {
    setXPos (getXPos () + 1);
  }
  
  /**
   * Adds one to the y axis position of the Moveable. 
   */
  public void incrYPos ()
  {
    setYPos (getYPos () + 1);
  }
  
  /**
   * Subtracts one from the x axis position of the Moveable. 
   */
  public void decrXPos ()
  {
    setXPos (getXPos () - 1);
  }
  
  /**
   * Subtracts one from the y axis position of the Moveable. 
   */
  public void decrYPos ()
  {
    setYPos (getYPos ()  - 1);
  }
  
  /**
   * Returns the direction that the Moveable is facing/coming in from (depends on subclass). 
   * @return the direction that the Moveable is facing/coming in from (depends on subclass). 
   */
  public int getDirection ()
  {
    return direction;
  }
  
  /**
   * <PRE> The int parameter pos becomes the new direction. </PRE>
   * @param pos the new direction of the Moveable.
   */ 
  public void setDirection (int pos)
  {
    direction= pos;
  }
}