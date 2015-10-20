
/**
 * This is the Score data class. It contains the score of the player
 * 
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012
 */
public class Score{
  /**
   * The name of the player.
   */
  private String name;
  /**
   * The number of points.
   */
  private int score;
  /**
   * The class constructor.
   * 
   * @param name The nameof the player.
   * @param score The score of the player.
   */
  public Score(String name, int score){
    this.name = name;
    this.score = score;
  }
  
  /**
   * This is a return method that returns the score
   */
  public int getScore(){
    return score;
  }
  /**
   * This is a return method that returns the name.
   */
  public String getName(){
    return name;
  }
  
}