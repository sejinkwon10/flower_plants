import javax.swing.*;
import java.awt.event.*;

/**
 * This is the TrapGen class that generates Trap Objects.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class TrapGen extends Thread implements ActionListener
{
  /**
   * The timer object
   */
  private Timer t;
  /**
   * The difficulty
   */
  private int difficulty; 
  /**
   * The max difficulty
   */
  private int maxDiff; 
  /**
   * The minimum delay
   */
  private int minDelay;
  /**
   * The frequency
   */
  private double freq; 
  /**
   * The max frequency
   */
  private double maxFreq;
  
  /**
   * The class constructor.
   * 
   * It creates the timers and sets the delays.
   * @param delay The delay time
   * @param diff The difficulty
   * @param freq The frequency
   */
  public TrapGen (int delay, int diff, double freq)
  {
    this.freq = freq; 
    maxFreq = this.freq + 0.5;
    difficulty = diff; 
    maxDiff = diff + 3000;
    minDelay = delay - 3000;
    t = new Timer (delay, this);
  }
  
  /**
   * Returns random Traps and sets their bounds on their container. 
   */
  public Trap randomizeTrap()
  {
    Trap trap = new Trap ((int) (Math.random () * 550), (int) (Math.random () * 550), difficulty);
    trap.setBounds (trap.getXPos (), trap.getYPos (), trap.getPreferredSize ().width, trap.getPreferredSize ().height);
    return trap;
  }
  
  /**
   * Returns random RedTraps and sets their bounds on their container. 
   */
  public RedTrap randomizeRedTrap()
  {
    RedTrap redTrap = new RedTrap ((int) (int) (Math.random () * 550), (int) (Math.random () * 550), difficulty);
    redTrap.setBounds (redTrap.getXPos (), redTrap.getYPos (), redTrap.getPreferredSize ().width, redTrap.getPreferredSize ().height);
    return redTrap;
  }
  
  /**
   * Generates and draws out random Traps/RedTraps on the screen. 
   * The first if checks if k (Math.random ()) is greater than freq. If this is true,
   * it draws a randomly generated Trap.
   * The else checks if k (Math.random ()) is less than freq. If this is true
   * it draws a randomly generated RedTrap.
   * @param e     ActionEvent     passes in the Action that triggers this method. 
   */
  public void actionPerformed (ActionEvent e)
  { 
    double k = Math.random ();
    if (k > freq)
      FrameApp.g.add (randomizeTrap ());
    else
      FrameApp.g.add (randomizeRedTrap ());
    FrameApp.g.updateUI();
  }
  
  
  /**
   * Changes the difficulty of the game. 
   * The first if checks if the current delay for the timer is greater or equal to the minimum
   * possible delay for the timer. If this is true, the delay is decreased.
   * The second if checks if the lifespan of the Traps/RedTraps is less than or equal to
   * maximum possible lifespan of the Traps/RedTraps. If this is true, the life span is increased.
   * The third if checks if the frequency of RedTraps is less than or equal to the maximum
   * frequency of RedTraps. If this is true, the frequency of RedTraps increases by 5%. 
   */
  public void changeDifficulty ()
  {
    if (t.getDelay () >= minDelay)
    {
      t.setDelay (t.getDelay () - 300);
    }
    if (difficulty <= maxDiff)
    {
      difficulty += 300;
    }
    if (freq <= maxFreq)
    {
      freq += 0.05;
    }
  }
  
  /**
   * Pauses the TrapGen.
   */
  public void pause ()
  {
    t.stop ();
  }
  
  /**
   * Resumes the TrapGen.
   */
  public void resumeGame ()
  {
    t.start ();
  }
  
  /**
   * Starts the generation of random Traps/RedTraps.
   */
  public void run ()
  {
    resumeGame ();
  }
}