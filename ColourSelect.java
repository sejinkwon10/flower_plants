import javax.swing.*;
import java.awt.event.*;

/**
 * This is the panel where the user choose the name of their Player and the colour of the basket of the Player.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class ColourSelect extends JPanel implements ActionListener{
  
  /**
   * Creates a ColourSelect panel with a set of colour buttons, a back button
   * and a JLabel that prompts the user to choose a colour.
   * The loop goes through all the buttons in the colChoices array of buttons, adds them to the panel,
   * adds an ActionListener to them and sets their attributes to look nicer.
   * Variable Dictionary:
   * colours       JLabel     prompts the user to choose a colour
   * colChoices [] JButton    an array of JButtons that hold each colour possibility.
   * colSrings []  String     an array of Strings that act as ActionCommands for the JButtons.
   * back          JButton    a JButton that sends the user back to the level select menu.
   */
  public ColourSelect(){
    setLayout (null);
    JLabel colours = new JLabel (new ImageIcon ("Colours.png"));
    colours.setBounds (400, 295, colours.getPreferredSize ().width, colours.getPreferredSize ().height);
    add (colours);
    JButton colChoices [] = {new JButton(new ImageIcon ("BluePlayer0.png")),new JButton(new ImageIcon ("GreenPlayer0.png")),new JButton(new ImageIcon ("RedPlayer0.png")),new JButton(new ImageIcon ("YellowPlayer0.png"))};
    String [] colStrings = {"Blue", "Green", "Red", "Yellow"};
    colChoices [0].setRolloverIcon (new ImageIcon ("BluePlayerRollover.png"));
    colChoices [1].setRolloverIcon (new ImageIcon ("GreenPlayerRollover.png"));
    colChoices [2].setRolloverIcon (new ImageIcon ("RedPlayerRollover.png"));
    colChoices [3].setRolloverIcon (new ImageIcon ("YellowPlayerRollover.png"));
    for( int i = 0 ; i < colChoices.length ; i++){
      colChoices[i].addActionListener(this);
      colChoices [i].setActionCommand (colStrings [i]);
      colChoices[i].setOpaque(false);
      colChoices[i].setContentAreaFilled(false);
      colChoices[i].setBorderPainted(false);
      colChoices[i].setFocusable(false);
      colChoices[i].setBounds(234,i*125 + 10,colChoices [i].getPreferredSize ().width,colChoices [i].getPreferredSize ().height );
      add(colChoices[i]);
    }
    JButton back = new JButton (new ImageIcon ("Back.png"));
    back.setOpaque (false);
    back.setContentAreaFilled (false);
    back.setBorderPainted (false);
    back.setFocusable (false);
    back.setRolloverIcon (new ImageIcon ("Backrollover.png"));
    back.setBounds (5, 10, back.getPreferredSize ().width, back.getPreferredSize ().height);
    add (back);
    back.addActionListener (this);
    updateUI ();
  }
  
  /**
   * A defined actionPerformed method from the ActionListener interface that 
   * sets the colour of the Player's basket, requests the user for input for
   * the name of the Player and then moves onto the game. 
   * The first if checks if the button pressed was a colour button.
   * The second if checks if the entered Player name is valid.
   * The third if checks if the button pressed was "Blue".
   * The first else if checks if the button pressed was "Green".
   * The second else if checks if the button pressed was "Red".
   * The else contains an if that checks if the button pressed was "Yellow". 
   * The third else if checks if the entered user name is above 15 characters long.
   * The second else checks if the entered user name is empty.
   * The last else accounts for if the button pressed was "Back".
   * The try-catch structure accounts for if the user presses cancel on the JOptionPane input dialog box. 
   * Variablie Dictionary:
   * playerName     String     stores the name of the Player as defined by the user. 
   * @param event - ActionEvent - passes in data on whichever action was performed or in this case, whichever button was pressed.
   */
  public void actionPerformed(ActionEvent event){
    if (event.getActionCommand ().equals ("Blue") || event.getActionCommand ().equals ("Green") || event.getActionCommand ().equals ("Red") ||event.getActionCommand ().equals ("Yellow"))
    {
      String playerName = JOptionPane.showInputDialog (this, "Please enter a name", "Player Name", JOptionPane.QUESTION_MESSAGE);
      try
      {
        if (!playerName.equals (null) && !playerName.trim ().equals ("") && playerName.length () <= 15)
        {
          if(event.getActionCommand().equals("Blue")){
            FrameApp.g.startGame (0, playerName);
          }
          else if(event.getActionCommand().equals("Green")){
            FrameApp.g.startGame (1, playerName);
          }
          else if(event.getActionCommand().equals("Red")){
            FrameApp.g.startGame (2, playerName);
          }
          else
          {
            if(event.getActionCommand().equals("Yellow"))
            {
              FrameApp.g.startGame (3, playerName);
            }
          }
          FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.GAME);
          FrameApp.frame.add(FrameApp.s);
          FrameApp.s.startGame ();
        }
        else if (playerName.length () > 15)
        {
          JOptionPane.showMessageDialog (this, "Your entered username was too long!", "Error",  JOptionPane.ERROR_MESSAGE);
        }
        else 
        {
          if (playerName.trim ().equals (""))
          {
            JOptionPane.showMessageDialog (this, "Your username cannot be empty!", "Error",  JOptionPane.ERROR_MESSAGE);
          }
        }
      }
      catch (NullPointerException e)
      {
      }
    }
    else
    {
      FrameApp.cardLayout.show (FrameApp.mainPanel, FrameApp.LEVELSELECT);
    }
  }
}