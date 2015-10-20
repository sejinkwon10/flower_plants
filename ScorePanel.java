

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the ScorePanel class which is a JPanel. It contains the pause button as well as the score counter.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class ScorePanel extends JPanel implements ActionListener{
  /**
   * This is a displays the score.
   */
  static JTextField score = new JTextField (15);
  /**
   * The current level.
   */
  static JTextField level = new JTextField (10);
  /**
   * The name of the player.
   */
  static JTextField name = new JTextField (15);
  /**
   * The requirement until next level.
   */
  static JTextField levelReq = new JTextField (15);
  /**
   * The amount of lives left
   */
  static JTextField lives = new JTextField (15);
  /**
   * This is a displays the score.
   */
  /**
   * The pause Button
   */
  private JButton pause = new JButton("Pause");
  /**
   * This is the class constructor.
   * 
   * It adds and sets the attributes of the textfields and the buttons.
   */
  public ScorePanel(){
    add (new JLabel ("Name: "));
    name.setEditable (false);
    add (name);
    add (new JLabel ("Level: "));
    level.setEditable (false);
    add (level);
    add (new JLabel ("Score: "));
    score.setEditable (false);
    add (score);
    add (new JLabel ("Level Requirement: "));
    levelReq.setEditable (false);
    add (levelReq);
    add (new JLabel ("Lives Left: "));
    lives.setEditable(false);
    add(lives);
    pause.addActionListener(this);
    add(pause);
    
    setPreferredSize(new Dimension (200,600));
    updateUI();
    
  }
  /**
   * This sets the values of the textfields to default.
   */
  public void startGame ()
  {
    name.setText (Player.typeName ());
    score.setText (Integer.toString (Player.score));
    level.setText (Integer.toString (Game.level));
    levelReq.setText (Integer.toString (Game.levelReq));
    lives.setText (Integer.toString (Player.lives));
  }
  /**
   * This method helps change the game frame to a pause panel if the pause button is pressed. 
   * @param event     ActionEvent     helps act as a trigger for the pause button.
   */
  public void actionPerformed (ActionEvent event){
    if (event.getActionCommand ().equals ("Pause"))
    {
      FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.PAUSE);
      FrameApp.g.pauseGame ();
      FrameApp.frame.remove(this);
      FrameApp.frame.repaint();
      FrameApp.mm.repaint();
    }
  }
}