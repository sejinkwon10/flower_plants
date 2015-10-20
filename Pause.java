
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
 * This is the Pause panel where the user chooses from a list of options.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class Pause extends JPanel{
  
  /**
   * A list of buttons in the pause menu.
   */
  private JButton pauseChoices [] = {new JButton("Resume"),new JButton("Restart"),new JButton("Quit")};
  
  /**
   * The class constructor.
   * 
   * The loop does through all the buttons in the levelChoices array and adds them to the panel
   * and adds a listener to them.
   */
  public Pause(){
    setFocusable (true);
    setLayout (null);
    pauseChoices [0].setMnemonic (KeyEvent.VK_F5);
    pauseChoices [1].setMnemonic (KeyEvent.VK_F6);
    pauseChoices [2].setMnemonic (KeyEvent.VK_F7);
    for( int i = 0 ; i < pauseChoices.length ; i++){
      pauseChoices [i].setBounds (270 + i*100, 25, pauseChoices [0].getPreferredSize ().width, pauseChoices [0].getPreferredSize ().height);
      add(pauseChoices[i]);
      pauseChoices[i].addActionListener(new PauseListener());
    }
    JLabel pause = new JLabel (new ImageIcon ("pause.png"));
    pause.setBounds (0, 0, pause.getPreferredSize ().width, pause.getPreferredSize ().height);
    add (pause);
    updateUI();
  }
  /**
   * This is the inner class that implements ActionListener.
   */
  class PauseListener implements ActionListener{
    /**
     * This triggers when a button is pressed.
     * 
     * If the user clicks Resume, the game resumes.
     * If the user clicks Quit, the game goes back to the main menu.
     * 
     * @param event This is the event triggered.
     */
    public void actionPerformed(ActionEvent event){
      if(event.getActionCommand().equals("Resume")){
        FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.GAME);
        FrameApp.frame.add(FrameApp.s);
        FrameApp.g.resumeGame ();
      }
      else if(event.getActionCommand().equals("Quit")){
        FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.MAINMENU);
        FrameApp.g.pauseGame ();
      }
      else
      {
        FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.LEVELSELECT);
      }
      FrameApp.frame.repaint();
      FrameApp.mm.repaint();
    }
  }
  
}