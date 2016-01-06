
/**
 * The class of the Queen chess piece
 * @author David McKnight
 * @version 12/22/2015
 */

public class Queen extends ChessPiece implements PieceFace
{
public Queen (int color)
{
super(color);
identity|=8;
}


public char getChar ()
{
if (color==1)
                return('\u2655');
            else
                return('\u265b');
}

public int getValue()
{
return (9);
}


}
