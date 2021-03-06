
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This is the LevelSelect panel where the user chooses a level.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class HighScoreLevelSelect extends JPanel  {
  
  /**
   * This is an array of JButtons for the selections.
   */
  JButton levelChoices [] = {new JButton(new ImageIcon ("Easy.png")), new JButton(new ImageIcon ("Medium.png")), new JButton(new ImageIcon ("Hard.png"))};
  
  /**
   * The class constructor.
   * 
   * The loop does through all the buttons in the levelChoices array and adds them to the panel
   * and adds a listener to them.
   */
  public HighScoreLevelSelect(){
    setLayout (null);
    JLabel level = new JLabel (new ImageIcon ("Difficulty.png"));
    level.setBounds (5, 295, level.getPreferredSize ().width, level.getPreferredSize ().height);
    add (level);
    levelChoices [0].setRolloverIcon (new ImageIcon ("Easyrollover.png"));
    levelChoices [1].setRolloverIcon (new ImageIcon ("Mediumrollover.png"));
    levelChoices [2].setRolloverIcon (new ImageIcon ("Hardrollover.png"));
    String [] levels = {"Easy", "Medium", "Hard"};
    for(int i = 0 ; i < levelChoices.length ; i++){
      add(levelChoices[i]);
      levelChoices[i].addActionListener(new HighScoreLevelListener());
      levelChoices [i].setActionCommand(levels[i]);
      levelChoices[i].setOpaque(false);
      levelChoices[i].setContentAreaFilled(false);
      levelChoices[i].setBorderPainted(false);
      levelChoices[i].setFocusable(false);
      levelChoices[i].setBounds(275,i*185 + 10,100,75);
    }
    JButton back = new JButton (new ImageIcon ("Back.png"));
    back.setOpaque (false);
    back.setContentAreaFilled (false);
    back.setBorderPainted (false);
    back.setFocusable (false);
    back.setRolloverIcon (new ImageIcon ("Backrollover.png"));
    back.setBounds (480, 10, back.getPreferredSize ().width, back.getPreferredSize ().height);
    add (back);
    back.addActionListener (new HighScoreLevelListener ());
    updateUI ();
  }
  
  /**
   * This is an inner class that implements ActionListener. 
   */
  class HighScoreLevelListener implements ActionListener{
    /**
     * This method is triggered when a button is pressed. 
     *
     * Depending on what level the user chooses, the string for the level will be changed
     * and so will the panel.
     * If the user clicks back, it will go back to the main menu.
     * 
     * @param event The event that is triggered.
     */
    public void actionPerformed(ActionEvent event){
      if (event.getActionCommand().equals("Easy") || event.getActionCommand().equals("Medium") || event.getActionCommand().equals("Hard"))
      {
        if(event.getActionCommand().equals("Easy")){
          Game.difficulty = 1;
        }
        else if(event.getActionCommand().equals("Medium")){
          Game.difficulty = 2;
        }
        else 
        {
          if(event.getActionCommand().equals("Hard")){
            Game.difficulty = 3;
          }
        }
        FrameApp.hs.levelDisting ();
        FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.HIGHSCORE);
        HighScore.readScore ();
      }
      else{
        FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.MAINMENU);
      }
    }
  }
}