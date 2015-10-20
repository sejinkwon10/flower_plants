import javax.swing.*;
import java.awt.event.*;

/**
 * This is the FlowerGen class which generates Flower/SpikyFlower objects and places them in the game panel.
 * Variable Dictionary:
 * t        private Timer     the Timer that triggers the generation of Flowers/SpikyFlowers. 
 * freq     private double    the chance of the FlowerGen creating a SpikyFlower.
 * maxFreq  private double    the maximum value that freq can hold. 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class FlowerGen extends Thread implements ActionListener
{
  private Timer t;
  private double freq, maxFreq;
  
  /**
   * Creates a FlowerGen object that generates one Flower/SpikyFlower per second
   * with double parameter freq chance of creating SpikyFlowers.
   */
  public FlowerGen (double freq)
  {
    t = new Timer (1000, this);
    this.freq = freq; 
    maxFreq = this.freq + 0.5;
  }
  
  /**
   * Creates a Flower object with a random initial location, direction and colours. 
   * Each of the ifs (if, else if, else) are used to determine random initial locations to help create Flowers given 
   * a certain direction. Once a Flower has been created, it is added to the JPanel. 
   * Variable Dictionary:
   * flow  Flower  Stores the flower to be returned.
   * k     int     stores the randomly generated direction of the Flower.
   */
  private Flower randomizeFlower ()
  {
    Flower flow = null;
    int  k = (int) (Math.random () * 4), x = (int) (Math.random () * 2);
    if (k== 0 && x == 0)
      flow = new Flower (-31, (int) (Math.random ()*570), FrameApp.g.pl.getColor (), k);
    else if (k== 0 && x == 1)
      flow = new Flower (-31, (int) (Math.random ()*570), (int)(Math.random () * 4), k);
    else if (k==1 && x == 0)
      flow = new Flower ((int) (Math.random () * 570), -31,FrameApp.g.pl.getColor (),k);
    else if (k== 1 && x == 1)
      flow = new Flower ((int) (Math.random () * 570), -31, (int)(Math.random () * 4), k);
    else if (k== 2 && x == 0)
      flow = new Flower (601, (int) (Math.random () * 570),FrameApp.g.pl.getColor (),k);
    else if (k== 2 && x == 1)
      flow = new Flower (601, (int) (Math.random () * 570),(int)(Math.random () * 4),k);
    else if (k== 3 && x == 0)
      flow = new Flower ((int) (Math.random () * 570), 601,FrameApp.g.pl.getColor (),k);
    else
      if (k== 3 && x == 1)
      flow = new Flower ((int) (Math.random () * 570), 601,(int) (Math.random () * 4), k);
    flow.setBounds (flow.getXPos (), flow.getYPos (), flow.getPreferredSize ().width, flow.getPreferredSize ().height);
    return flow;
  }  
 
  /**
   * Creates a SpikyFlower object with a random initial location, direction and colours. 
   * Each of the ifs (if, else if, else) are used to determine random initial locations to help create 
   * SpikFlowers given a certain direction. Once a SpikyFlower has been created, it is added to the JPanel. 
   * Variable Dictionary:
   * sflow  SpikyFlower  Stores the flower to be returned.
   * k      int     stores the randomly generated direction of the Flower.
   */
  private Flower randomizeSpikyFlower ()
  {
    SpikyFlower sflow = null;
    int  k = (int) (Math.random () * 4);
    if (k== 0)
      sflow = new SpikyFlower (-200, (int) (Math.random ()*550), (int) (Math.random () * 4), k);
    else if (k==1)
      sflow = new SpikyFlower ((int) (Math.random () * 400), -200,(int) (Math.random () * 4),k);
    else if (k== 2)
      sflow = new SpikyFlower (800, (int) (Math.random () * 550),(int) (Math.random () * 4),k);
    else
      if (k== 3)
      sflow = new SpikyFlower ((int) (Math.random () * 400), 800,(int) (Math.random () * 4), k);
    sflow.setBounds (sflow.getXPos (), sflow.getYPos (), sflow.getPreferredSize ().width, sflow.getPreferredSize ().height);
    return sflow;
  }
  
  /**
   * Pauses the generation of Flowers/SpikyFlowers.
   */
  public void pause ()
  {
    t.stop ();
  }
  
  /**
   * (Re)Starts the generation of Flowers/SpikyFlowers. 
   */
  public void resumeGame ()
  {
    t.start ();
  }
  
  /**
   * Increases the frequency of SpikyFlowers in the game. 
   * The first if checks if the current chance of creating a SpikyFlower is less than or equal to that maximum possible chance.
   * If this is true, the chance of creating a SpikyFlower is increased by 5%. 
   */
  public void changeDifficulty ()
  {
    if (freq <= maxFreq)
    {
      freq += 0.05;
    }
  }
  
  /**
   * Generates and draws out random Flowers and SpikyFlowers on the screen.
   * The first if determines if a Flower should be created depending on if k is greater than freq.
   * The else determines if a SpikyFlower should be created depending on if k is less than or equal to freq.
   * Variable Dictionary:
   * k     double     a variable that stores a random real number between 0 and .99 (inclusive) that is used to determine if a Flower of SpikyFlower should be made.
   * @param e     ActionEvent     passes in data about the Action that was performed to trigger this method. 
   */
  public void actionPerformed (ActionEvent e)
  {
    double k = Math.random ();
    if (k > freq)
      FrameApp.g.add (randomizeFlower ());
    else
      FrameApp.g.add (randomizeSpikyFlower ());
    FrameApp.g.updateUI();
  }
  
  /**
   * Starts the random adding of Flowers. 
   */
  public void run ()
  {
    resumeGame ();
  }
}