import javax.swing.*;
import javax.swing.event.*;;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * <PRE> The Game panel class that runs the game and contains all the game characters/sprites.
 * It manages parts of the game logic such as moving the player, turning the player and 
 * increasing the game level.
 * Variable Dictionary:
 * pl          Player           holds the Player of the game of your main game panel screen 
 * level       int              holds the level of the game.
 * levelReq    int              holds the amount of points required to get to the next level. 
 * difficulty  int              holds whether or not the Game is easy, medium or hard.
 * f           FlowerGen        holds the FlowerGen object that generates flowers.
 * t           TrapGen          holds the TrapGen object that generates traps.
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 * <PRE>
 */
class Game extends JPanel implements MouseInputListener {
  static Player pl;
  static int level, levelReq, difficulty;
  private FlowerGen f;
  private TrapGen t;
  private BufferedImage backg; 
  
  /**
   *Has no purpose in this class.
   */
  public void mouseClicked (MouseEvent e){}
  /**
   *Has no purpose in this class.
   */
  public void mouseReleased (MouseEvent e){}
  /**
   *Has no purpose in this class.
   */
  public void mouseEntered (MouseEvent e){}
  /**
   *Has no purpose in this class.
   */
  public void mouseExited (MouseEvent e){}
  /**
   *Has no purpose in this class.
   */
  public void mouseDragged (MouseEvent e){}
  
  /**
   * This method is triggered when the mouse is moved.
   * 
   * The position of the Player is set to the location of the mouse.
   * The if checks if the Player can indeed move (isn't trapped or
   * paused).
   * @param e The event triggered
   */
  public void mouseMoved (MouseEvent e)
  {
    if (pl.canMove (e.getX (), e.getY ()))
    {
      pl.setXPos (e.getX());
      pl.setYPos (e.getY());
    }
  }
  
  /**
   * This method is triggered when the mouse is pressed.
   * 
   * The character is rotated (depending on the mouse button clicked).
   * The first if accounts for if the Player can indeed move (isn't trapped or paused).
   * The inner if-else (if) checks for which mouse button was pressed (left or right).
   * @param e The event triggered
   */
  public void mousePressed (MouseEvent e) 
  {
    if (pl.canMove (pl.getXPos (), pl.getYPos ()))
    {
      if (e.getButton () == MouseEvent.BUTTON1)
      {
        pl.turn (1);
      }
      else 
      {
        if (e.getButton () == MouseEvent.BUTTON3)
        {
          pl.turn (2);
        }
      }
    }
  }
  
  /**
   * Pauses the game (Stops all FLowers, Traps and the player).
   * The fo loop goes throogh every component on the panel.
   * The first if checks if the component at the given array list index
   * is a Flower.
   * The else if checks if the component at the given array list index
   * is a Trap.
   * The else checks if the component at the given array list index is a 
   * Player.
   */
  public void pauseGame ()
  {
    Component [] components = getComponents ();
    for (int x = 0; x< components.length; x++)
    {
      if (components [x] instanceof Flower)
      {
        ((Flower) (components [x])).pause ();
      }
      else if (components [x] instanceof Trap)
      {
        ((Trap) (components [x])).pause ();
      }
      else
      {
        if (components [x] instanceof Player)
        {
          pl.setPaused ();
        }
      }
    }
    t.pause ();
    f.pause ();
  }
  
  public void resumeGame ()
  {
    Component [] components = getComponents ();
    for (int x = 0; x< components.length; x++)
    {
      if (components [x] instanceof Flower)
      {
        ((Flower) (components [x])).resume ();
      }
      else if (components [x] instanceof Trap)
      {
        ((Trap) (components [x])).resume ();
      }
      else
      {
        if (components [x] instanceof Player)
        {
          pl.setPaused ();
        }
      }
    }
    t.resumeGame ();
    f.resumeGame ();
  }
  /**
   * Creates an object of the GamePanel panel class with a null layout, a Player in the center of the frame, 
   * and randomly generated Flowers all over the place. 
   * 
   * Var Dictionary:
   * FlowerGen f This is the flower generator
   * RockGen r This is the rock generator
   */
  public Game(){
    setPreferredSize(new Dimension (600,600));
    setLayout(null);
    addMouseListener (this);
    addMouseMotionListener (this);
  }
  
  public void startGame (int col, String name)
  {
    removeAll (); 
    if (difficulty == 1)
    {
      f= new FlowerGen (0.1);
      t = new TrapGen (6000, 1000, 0.1);
      pl = new Player (300, 300, col, 0, 5, name);
    }
    else if (difficulty == 2)
    {
      f= new FlowerGen (0.25);
      t = new TrapGen (5000, 4000, 0.3);
      pl = new Player (300, 300, col, 0, 3,name);
    }
    else
    {
      if (difficulty == 3)
      {
        f= new FlowerGen (0.4);
        t = new TrapGen (4000, 7000, 0.5);
        pl = new Player (300, 300, col, 0, 1,name);
      }
    }
    f.start ();
    t.start ();
    pl.setBounds (pl.getXPos (), pl.getYPos (), pl.getPreferredSize ().width, pl.getPreferredSize ().height);
    add (pl);
    level = 1;
    levelReq = level * 500;
    updateUI ();
  }
  public void incrLevel ()
  { 
    level++;
    levelReq = level * 500 + (level - 1) * 100;
    ScorePanel.level.setText(Integer.toString(level));
    ScorePanel.levelReq.setText (Integer.toString (levelReq));
    Component [] components = FrameApp.g.getComponents ();
    for (int x = 0; x< components.length; x++)
    {
      if (components [x] instanceof Flower)
      {
        ((Flower) (components [x])).removeSelf ();
      }
      else
      {
        if (components [x] instanceof Trap)
        {
          ((Trap) (components [x])).removeSelf ();
        }
      }
    }
    t.changeDifficulty ();
    f.changeDifficulty ();
  }
  /**
   * This paints the screen black.
   * 
   * @param f The graphics object being passed
   */
  public void paintComponent(Graphics f){
    Graphics2D g = (Graphics2D) f;
    try
    {
      File image = new File ("Grass.png");
      backg = ImageIO.read (image);
    }
    catch (IOException e)
    { 
    }
    int width = backg.getWidth (null);
    int height = backg.getHeight (null);
    g.drawImage (backg, 0, 0, null);
  }
}