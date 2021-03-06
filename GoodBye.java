
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * The is the GoodBye panel that is the outro screen.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class GoodBye extends JPanel implements ActionListener {
  
  private Timer animator;
  private JLabel flower1 = new JLabel (new ImageIcon ("RedFlower.png"));
  private JLabel flower2 = new JLabel (new ImageIcon ("BlueFlower.png"));
  private JLabel flower3 = new JLabel (new ImageIcon ("YellowFlower.png"));
  private JLabel flower4 = new JLabel (new ImageIcon ("GreenFlower.png"));
  private JLabel flower5 = new JLabel (new ImageIcon ("RedSpikyFlower.png"));
  private JLabel flower6 = new JLabel (new ImageIcon ("BlueSpikyFlower.png"));
  private JLabel flower7 = new JLabel (new ImageIcon ("YellowSpikyFlower.png"));
  private JLabel flower8 = new JLabel (new ImageIcon ("GreenSpikyFlower.png"));
  private JLabel logo = new JLabel (new ImageIcon ("munderdifflin.png"));
  /**
   * This starts the timer to call it's event methods after 4 seconds.
   */
  public void start(){
    animator = new Timer (1, this);
    animator.start ();
  }
  
  /**
   * The class constructor.
   * 
   * Adds and creates a message saying bye.
   */
  public GoodBye(){
    setLayout (null);
    setPreferredSize(new Dimension (840,600));
    logo.setBounds (158, 196, logo.getPreferredSize ().width, logo.getPreferredSize ().height);
    flower1.setBounds (5, 260, flower1 .getPreferredSize ().width, flower1.getPreferredSize ().height);
    flower2.setBounds (5, 5, flower2.getPreferredSize ().width, flower2.getPreferredSize ().height);
    flower3.setBounds (285, 5, flower3.getPreferredSize ().width, flower3.getPreferredSize ().height);
    flower4.setBounds (565, 5, flower4.getPreferredSize ().width, flower4.getPreferredSize ().height);
    flower5.setBounds (565, 260, flower5.getPreferredSize ().width, flower5.getPreferredSize ().height);
    flower6.setBounds (565, 535, flower6.getPreferredSize ().width, flower6.getPreferredSize ().height);
    flower7.setBounds (285, 535, flower7.getPreferredSize ().width, flower7.getPreferredSize ().height);
    flower8.setBounds (5, 535 , flower8.getPreferredSize ().width, flower8.getPreferredSize ().height);
    add (flower1);
    add (flower2);
    add (flower3);
    add (flower4);
    add (flower5);
    add (flower6);
    add (flower7);
    add (flower8);
    add (logo);
  }
  
  public void actionPerformed (ActionEvent e)
  {
    if (flower1.getLocation ().getX() <= 128)
    {
      flower1.setBounds ((int) (flower1.getLocation ().getX()+ 1), 260, flower1.getPreferredSize ().width,flower1.getPreferredSize ().height);
    }
    else if (flower2.getLocation ().getX () <= 166)
    {
      flower2.setBounds ((int) (flower2.getLocation ().getX()+ 1), (int) (flower2.getLocation ().getY() + 1), flower2.getPreferredSize ().width,flower2.getPreferredSize ().height);
    }
    else if (flower3.getLocation ().getY () <= 166)
    {
      flower3.setBounds (285, (int) (flower3.getLocation ().getY() + 1), flower3.getPreferredSize ().width,flower3.getPreferredSize ().height);
    }
    else if (flower4.getLocation ().getX () >= 404)
    {
      flower4.setBounds ((int) (flower4.getLocation ().getX()- 1), (int) (flower4.getLocation ().getY() + 1), flower4.getPreferredSize ().width,flower4.getPreferredSize ().height);
    }
    else if (flower5.getLocation ().getX () >= 442)
    {
      flower5.setBounds ((int) (flower5.getLocation ().getX()- 1), 260, flower5.getPreferredSize ().width,flower5.getPreferredSize ().height);
    }
    else if (flower6.getLocation ().getX () >= 404)
    {
      flower6.setBounds ((int) (flower6.getLocation ().getX()- 1), (int) (flower6.getLocation ().getY() - 1), flower6.getPreferredSize ().width,flower6.getPreferredSize ().height);
    }
    else if (flower7.getLocation ().getY () >= 375)
    {
      flower7.setBounds (285, (int) (flower7.getLocation ().getY() - 1), flower7.getPreferredSize ().width,flower7.getPreferredSize ().height);
    }
    else if (flower8.getLocation ().getX () <= 166)
    {
      flower8.setBounds ((int) (flower8.getLocation ().getX()+ 1), (int) (flower8.getLocation ().getY() - 1), flower8.getPreferredSize ().width,flower8.getPreferredSize ().height);
    }
    else if (animator.getDelay () == 1)
    {
      animator.setDelay (3000);
      removeAll ();
      JLabel message = new JLabel (new ImageIcon ("Goodbyemessage.png"));
      message.setBounds (100, 150,message.getPreferredSize ().width, message.getPreferredSize ().height);
      add (message); 
    }
    else
    {
      if (animator.getDelay () == 3000)
      {
        System.exit (0);
      }
    }
    updateUI ();
  }
}