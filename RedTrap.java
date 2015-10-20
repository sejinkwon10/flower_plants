import javax.swing.*;
/**
 * <PRE> A type of Rock in Rainbow Plants that both blocks the Player from moving,
 * and causes them to lose points.
 * @author Eric Tu and Sejin Kwon
 * @version 6
 * @since June 13, 2012 </PRE>
 */
public class RedTrap extends Trap
{
  public RedTrap (int x, int y, long t)
  {
    super (x, y, t);
    setIcon (new ImageIcon ("RedTrap.png"));
  }
}