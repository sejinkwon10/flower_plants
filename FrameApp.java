
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 * This class is frame class of the program.
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class FrameApp{
  /**
   * This is the JFrame of the program.
   */
  static JFrame frame = new JFrame();
  /**
   * The layout for the mainPanel
   */
  static CardLayout cardLayout = new CardLayout(); 
  /**
   * The mainPanel, which is used to contain the cards.
   */
  static JPanel mainPanel;
  /**
   * String for the INTRO card.
   */
  static final String INTRO = "INTRO";
  /**
   * String for the MAINMENU card.
   */
  static final String MAINMENU = "MAINMENU";
  /**
   * String for the GOODBYE card.
   */
  static final String GOODBYE = "GOODBYE";
  /**
   * String for the LEVELSELECT card.
   */
  static final String LEVELSELECT = "LEVELSELECT";
  /**
   * String for the GAME card.
   */
  static final String GAME = "GAME";
  /**
   * String for the HIGHSCORE card.
   */
  static final String HIGHSCORE = "HIGHSCORE";
  /**
   * String for the HIGHSCORELS card.
   */
  static final String HIGHSCORELS = "HIGHSCORELS";
  /**
   * String for the INSTRUCTIONS1 card.
   */
  static final String INSTRUCTIONS1 = "INSTRUCTIONS1";
  /**
   * String for the INSTRUCTIONS2 card.
   */
  static final String INSTRUCTIONS2 = "INSTRUCTIONS2";
  /**
   * String for the PAUSE card.
   */
  static final String PAUSE = "PAUSE";
  /**
   * String for the COLOURSELECT card.
   */
  static final String COLOURSELECT = "COLOURSELECT";
  /**
   * String for the INTRODUCTION card.
   */
  static final String INTRODUCTION = "INTRODUCTION";
  /**
   * A Game Object.
   */
  public static  Game g = new Game();
  /**
   * A ColourSelect Object.
   */
  public static  ColourSelect cs = new ColourSelect();
  /**
   * A MainMenu Object.
   */
  public static  MainMenu mm = new MainMenu();
  /**
   * A LevelSelect Object.
   */
  public static  LevelSelect ls = new LevelSelect();
  /**
   * A Introduction Object.
   */
  public static  Introduction i = new Introduction();
  /**
   * A GoodBye Object.
   */
  public static  GoodBye gb = new GoodBye();
  /**
   * A Pause Object.
   */
  public static  Pause p = new Pause();
  /**
   * An Instruction1 Object.
   */
  public static Instruction1 in = new Instruction1 ();
  /**
   * An Instruction2 object.
   */
  public static Instruction2 in2 = new Instruction2 ();
  /**
   * A ScorePanel object.
   */
  public static ScorePanel s = new ScorePanel ();
  /**
   * A HighScore object.
   */
  public static HighScore hs = new HighScore();
  /**
   * A HighScoreLevelSelect object.
   */
  public static HighScoreLevelSelect hsls = new HighScoreLevelSelect ();
  
  /**
   * The class constructor.
   * 
   * The mainPanel is initialized and the cards are added onto the panel.
   * The mainPanel has a shortcut key "H" that opens the help file.
   * The mainPanel cards are set to be transparent. 
   * The mainPanel is added onto the JFrame frame and frame's attributes are set.
   */
  public FrameApp(){
    frame.setContentPane ( new JLabel (new ImageIcon ("Background.png")));
    mainPanel = new JPanel (cardLayout);
    Action help = new AbstractAction () {
      /**
       * An actionPerformed method that deals with the "H" key.
       * It opens the help file.
       * The try catch structure accounts for any potential IOExceptions.
       * @param e ActionEvent passes in the Action that triggered the method.
       */
      public void actionPerformed (ActionEvent e)
      {
        try
        {
          Runtime.getRuntime ( ).exec ("hh.exe Rainbow Plants.chm");
        }
        catch (IOException easasads)
        {
        }
      }
    };
    mainPanel.getInputMap ().put (KeyStroke.getKeyStroke ("H"), "Help");
    mainPanel.getActionMap ().put ("Help", help);
    mainPanel.add (i, INTRODUCTION);
    mainPanel.add ( mm,MAINMENU);
    mainPanel.add ( ls,LEVELSELECT);
    mainPanel.add ( gb,GOODBYE);
    mainPanel.add (cs, COLOURSELECT);
    mainPanel.add(g,GAME);
    mainPanel.add( p, PAUSE);
    mainPanel.add(hs,HIGHSCORE);
    mainPanel.add (in, INSTRUCTIONS1);
    mainPanel.add (in2, INSTRUCTIONS2);
    mainPanel.add(hsls,HIGHSCORELS);
    mainPanel.setPreferredSize(new Dimension (600,600));
    mainPanel.updateUI();
    mainPanel.setOpaque(false);
    i.setOpaque (false);
    mm.setOpaque (false);
    ls.setOpaque (false);
    cs.setOpaque (false);
    p.setOpaque (false);
    s.setOpaque (false);
    gb.setOpaque (false);
    in.setOpaque (false);
    in2.setOpaque (false);
    hsls.setOpaque (false);
    frame.setLayout(new FlowLayout());
    frame.add(mainPanel);
    frame.setTitle("Rainbow Plants");
    frame.setSize(840,600);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
    frame.setResizable (false);
    i.start ();
  }
  
  /**
   * The main method that runs the whole game.
   * 
   * An instance of FrameApp is created.
   * The HighScores load. 
   * 
   * @param argv Arguments for the main method.
   */
  public static void main (String argv []){
    new FrameApp(); 
    HighScore.loadFile();
  }
}
