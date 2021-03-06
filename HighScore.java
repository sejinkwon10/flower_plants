import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.print.*;

/**
 * This is the HighScore class that extends JPanel.
 * 
 * It shows all the highscores in textfields.
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class HighScore extends JPanel  {
  
  /**
   * File header
   */
  static private String header = "Trololol";
  /**
   * TextFields for names
   */
  static public  JTextField namesDisplay [] = new JTextField [10];
  /**
   * TextFields for scores
   */
  static public JTextField scoresDisplay [] = new JTextField [10];
  /**
   * The game difficulty.
   */
  private  JLabel difficulty;
  /**
   * A list of scores.
   */
  static ArrayList<Score> scores = new ArrayList<Score>();
  
  
  /**
   * This is the class constructor.
   * 
   * The JLabel array for the numbers are made. The attributes of the panel are set.
   * A JLabel is made with the logo on it. Its attributes are set then added to the panel.
   * A back JButton is made and its attributes are set. It is added to the panel.
   * An ActionListener is also added to the back button. When clicked, it will switch panels.
   * The array of name textfields and scores textfields are instantiated.
   * The attributes of these textfields are set then added onto the panel, using a for loop.
   * A print button is made and its attributes are set. An ActionListener is also added on,
   * so that whenever its clicked, it will print the highscores.
   * It is then added to the panel.
   * <PRE>
   * VAR DICTIONARY
   * Name         Type           Desc.
   * 
   * places       JLabel         Shows the places of each score.
   * logo         JLabel         The logo of the game.
   * back         JButton        The button to go back.
   * print        JButton        The button to print.
   * i            int            Used to traverse forloops.
   * 
   * </PRE>
   */
  public HighScore(){
    JLabel places [] = new JLabel [10];
    setLayout (null);
    setOpaque(false);
    JLabel logo = new JLabel (new ImageIcon ("Logohs.png"));
    logo.setBounds (205, 1, logo.getPreferredSize ().width, logo.getPreferredSize ().height);
    add (logo);
    JButton back = new JButton(new ImageIcon ("Back.png"));
    back.setOpaque (false);
    back.setContentAreaFilled (false);
    back.setBorderPainted (false);
    back.setFocusable (false);
    back.setRolloverIcon (new ImageIcon ("Backrollover.png"));
    back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        FrameApp.cardLayout.show(FrameApp.mainPanel, FrameApp.MAINMENU);
      }
    });
    for(int i = 0 ; i < 10 ; i ++){
      namesDisplay [i] = new JTextField (20);
      scoresDisplay[i] = new JTextField(20);
      namesDisplay [i].setEditable (false);
      scoresDisplay [i].setEditable (false);
      places [i] = new JLabel (Integer.toString (i + 1) + ".");
      places [i].setBounds (50, 75 + i * 40, places [i].getPreferredSize ().width, places [i].getPreferredSize ().height);
      add (places [i]);
      namesDisplay [i].setBounds (75, 75 + i * 40, namesDisplay [i].getPreferredSize ().width,  namesDisplay [i].getPreferredSize ().height);
      add (namesDisplay [i]);
      scoresDisplay [i].setBounds (350, 75 + i* 40, scoresDisplay [i].getPreferredSize ().width, scoresDisplay [i].getPreferredSize ().height);
      add(scoresDisplay[i]);
    }
    JButton print = new JButton(new ImageIcon ("print.png"));
    print.setRolloverIcon (new ImageIcon ("printrollover.png"));
    print.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        Printer p = new Printer();
        p.print();
      }
    });
    print.setBounds (300,455, print.getPreferredSize ().width, print.getPreferredSize ().height);
    print.setOpaque (false);
    print.setContentAreaFilled (false);
    print.setBorderPainted (false);
    print.setFocusable (false);
    back.setBounds (450,455, back.getPreferredSize ().width, back.getPreferredSize ().height);
    add(print);
    add(back);
  }
  
  /**
   * This method initializes the arraylist.
   * 
   * The for loop runs 10 times to instantiate 10 instances of Score.
   * 
   * <PRE>
   * VAR DICTIONARY
   * Name         Type           Desc.
   * 
   * i            int            Used to traverse a forloop.   
   * 
   * </PRE>
   */
  public static void loadFile()  {
    for(int i = 0 ; i < 10 ; i++){
      scores.add(new Score("",0));
    }
  }
  
  
  /**
   * This method wries to the files and to the textfields.
   * 
   * A PrintWriter object is made and depending on what level it is at, that file will be loaded.
   * The for each loop will go through the arraylist and save it onto the textfile. The file
   * is then closed.
   * <PRE>
   * VAR DICTIONARY
   * Name         Type           Desc.
   * 
   * out          PrintWriter    The output stream to the file.     
   * 
   * </PRE>
   */
  public static void writeScore()  {
    try{
      PrintWriter out = null;
      if(Game.difficulty == 1){
        out = new PrintWriter(new FileWriter("Easy.txt"));
      }
      else if (Game.difficulty == 2){
        out = new PrintWriter(new FileWriter("Med.txt"));
      }
      else{
        out = new PrintWriter(new FileWriter("Hard.txt"));
      }
      out.println("Trololol");
      for(Score s : scores){
        out.printf("%s\n%d\n",s.getName(),s.getScore());
      }
      out.close();
    }
    catch(IOException e){e.printStackTrace();};
  }
  /**
   * This method allows scores to be inserted into highscore list.
   * 
   * It if it is 1st place, not a highscore, or anywhere in between.
   * if it is anywhere inbetween, a for loop will run and see if it is greater than i but less than i-1.
   * If so, then it is added into the position, effectively shifting everything down. The last object is removed
   * and then writeScore is called.
   * 
   * <PRE>
   * VAR DICTIONARY
   * Name         Type           Desc.
   * 
   * i            int            Used to traverse forloops.     
   * 
   * </PRE>
   * @param s This is the score being checked.
   */
  public static void insertScore(Score s){
    if (s.getScore()<= scores.get(9).getScore()){        
      
      return;}
    else if(s.getScore() > scores.get(0).getScore()){
      scores.add(0,s);    writeScore();
      return;}
    else{
      for(int i = 9 ; i >= 1 ; i--){
        int score = s.getScore();
        if(score > scores.get(i).getScore() && score <= scores.get(i-1).getScore()){
          scores.add(i, s);
          scores.remove(10);
        }
      }
    }
    writeScore();
  }
  
  /**
   * This method sets the top label.
   * 
   * This method removes existing labels if any then instantiates the difficulty label. The image loaded
   * is dependant on the difficulty you are on. Its attributes are set then added to the panel.
   */
  public void levelDisting ()
  {
    try
    {
      remove (difficulty);
    }
    catch (NullPointerException e)
    {
      
    }
    if(Game.difficulty == 1){
      difficulty = new JLabel (new ImageIcon ("Easyhs.png"));
    }
    else if (Game.difficulty == 2){
      difficulty = new JLabel (new ImageIcon ("Mediumhs.png"));
    }
    else{
      difficulty = new JLabel (new ImageIcon ("Hardhs.png"));
    }
    difficulty.setBounds (350, 1, difficulty.getPreferredSize ().width, difficulty.getPreferredSize ().height);
    add (difficulty); 
  }
  
  
  /**
   * This method reads the scores from the textfiles and adds them to the arraylist and to the textfields.
   * 
   * A BufferedReader is made. It is initiallized depending what difficulty the user is on.
   * The header is checked. If it is invalid a JOptionPane will appear and exit. If valid,
   * The arraylist elements are set and the textfields are set.
   * 
   * <PRE>
   * VAR DICTIONARY
   * Name      Type              Desc.
   * 
   * in        BufferedReader    The input stream to the file.     
   * 
   * </PRE>
   */
  static public void readScore (){
    try{
      BufferedReader in = null;
      if(Game.difficulty == 1){
        in = new BufferedReader(new FileReader("Easy.txt"));
      }
      else if (Game.difficulty == 2){
        in = new BufferedReader(new FileReader("Med.txt"));
      }
      else{
        in = new BufferedReader(new FileReader("Hard.txt"));
      }
      if(!in.readLine().equals("Trololol"))
        JOptionPane.showMessageDialog(null,"FILE ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
      else{
        for(int i = 0 ; i < 10 ; i++){
          scores.set(i, new Score (in.readLine(),Integer.parseInt(in.readLine())));
          namesDisplay [i].setText (scores.get (i).getName ());
          scoresDisplay[i].setText(Integer.toString (scores.get(i).getScore()));
        }
      }
    }
    catch(IOException exception){exception.printStackTrace();}
  }
}

/**
 * This is the printer class that allows the user to print things.
 */
class Printer implements Printable{
  /**
   * This prints the score.
   * 
   * A PrinterJob object is made and its attributes are set.
   * It then prints the scores.
   * <PRE>
   * VAR DICTIONARY
   * Name     Type          Desc.
   * 
   * j        PrinterJob    The PrinterJob object.     
   * 
   * </PRE>
   */
  public int print(Graphics g, PageFormat fmt, int pageIndex){
    if( pageIndex > 0 ) {
      return Printable.NO_SUCH_PAGE;
    }
    
    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(fmt.getImageableX(), fmt.getImageableY());
    if (Game.difficulty == 1)
    {
      g.drawString ("Rainbow Plants: Easy Difficulty High Scores", 100, 30);
    }
    else if (Game.difficulty == 1)
    {
      g.drawString ("Rainbow Plants: Medium Difficulty High Scores", 100, 30);
    }
    else
    {
      g.drawString ("Rainbow Plants: Hard Difficulty High Scores", 100, 30);
    }
    for(int i = 0 ; i < 10 ; i++){
      if(HighScore.namesDisplay[i].getText().length() != 0)
        g.drawString("Name: " + HighScore.namesDisplay[i].getText() + " Score: " + HighScore.scoresDisplay[i].getText(),100,30*i+60 );
    }
    return Printable.PAGE_EXISTS;
    
  }
  
  public void print(){
    PrinterJob j = PrinterJob.getPrinterJob();
    j.setPrintable(this);
    if(j.printDialog()){
      try{
        j.print();
      }
      catch(Exception exception){}
    }
  }
  
}


