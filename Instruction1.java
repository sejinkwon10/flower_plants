
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
public class Instruction1 extends JPanel implements ActionListener {
  
  
  /**
   * The class constructor.
   * 
   * Adds and creates a message saying bye.
   */
  public Instruction1(){
    setLayout (null);
    JButton back = new JButton (new ImageIcon ("Back.png"));
    back.setOpaque (false);
    back.setContentAreaFilled (false);
    back.setBorderPainted (false);
    back.setFocusable (false);
    back.setRolloverIcon (new ImageIcon ("Backrollover.png"));
    back.setActionCommand ("Back");
    JButton next = new JButton (new ImageIcon ("next.png"));
    next.setOpaque (false);
    next.setContentAreaFilled (false);
    next.setBorderPainted (false);
    next.setFocusable (false);
    next.setRolloverIcon (new ImageIcon ("nextrollover.png"));
    next.setActionCommand ("Next");
    back.addActionListener (this);
    next.addActionListener (this);
    JLabel pic = new JLabel(new ImageIcon ("Instructions1.png"));
    pic.setBounds (0, 0, pic.getPreferredSize ().width, pic.getPreferredSize ().height);
    back.setBounds (5, 200, back.getPreferredSize ().width, back.getPreferredSize ().height);
    next.setBounds (450, 200, next.getPreferredSize ().width, next.getPreferredSize ().height);
    add (pic);
    add (back);
    add (next);
  }
  public void actionPerformed (ActionEvent e)
  {
    if (e.getActionCommand ().equals ("Back"))
      FrameApp.cardLayout.show (FrameApp.mainPanel, FrameApp.MAINMENU);
    else
      FrameApp.cardLayout.show (FrameApp.mainPanel, FrameApp.INSTRUCTIONS2);
  }
}