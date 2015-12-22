/**
 * The class of the Space chess piece (for the sake of avoiding having separate move/take methods, as well as to simplify the structure of Board, space is considered a piece as well)
 * @author David McKnight
 * @version 12/22/2015
 */
public class Space extends ChessPiece implements PieceFace
{
private int q;
public Space (int color)
{
super(color);
}

public char getChar ()
{
return('\u2003');
}

public int getValue()
{
return (0);
}

}