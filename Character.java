import javax.swing.*;

/**
 * The basic abstract class that is used to outline every character in the game Rainbow plants.
 * Every character in the game (the Player, the Flowers, the Traps) will extend this class. A Character object will never be created. 
 * <PRE>
 * Variable Dictionary:
 * xPos     int     position of the Character on the x axis.
 * yPos     int     position of the Character on the y axis.
 * colour   int     number that helps identify the colour of the Character. 
 * </PRE>
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public abstract class Character extends JLabel
{
  private int xPos, yPos;
  private int colour;
  
  /**
   * <PRE> Constructs a Character with x as the position of the Character on the x axis, 
   * y as the position on the y axis and col as the number that helps identify the colour of the Character.
   * 
   * @param x     int     initial x axis position
   * @param y     int     initial y axis position
   * @param col   int     colour of the Character </PRE>
   */
  public Character (int x, int y, int col)
  {
    xPos = x;
    yPos = y;
    colour = col;
  }
  
  /**
   * Returns the position of the Character on the x axis of its container.
   * 
   * @return the position of the Character on the x axis of its container.
   */
  public int getXPos ()
  {
    return xPos;
  }
  
  /**
   * Returns the position of the Character on the y axis of its container.
   * 
   * @return the position of the Character on the y axis of its container.
   */
  public int getYPos ()
  {
    return yPos;
  }
  /**
   * Returns the color of the Character.
   * 
   * @return the color of the Character.
   */
  public int getColor ()
  {
    return colour;
  }
  
  /**
   * Sets the position of the Character on the x axis of its container.
   * 
   * @param x - int - The new x position of the Character.
   */
  public void setXPos (int x)
  {
    xPos =x;
    setBounds (getXPos (), getYPos (), getPreferredSize ().width, getPreferredSize ().height);
    updateUI ();
  }
  
  /**
   * Sets the position of the Character on the y axis of its container.
   * 
   * @param y - int - The new y position of the Character.
   */
  public void setYPos (int y)
  {
    yPos =y;
    setBounds (getXPos (), getYPos (), getPreferredSize ().width, getPreferredSize ().height);
    updateUI ();
  }
}