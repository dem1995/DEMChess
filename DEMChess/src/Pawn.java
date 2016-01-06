/**
 * The class of the Pawn chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
public class Pawn extends ChessPiece implements PieceFace
{
public Pawn (int color)
{
super (color);
identity|=128;
}

public char getChar ()
{
if (color==1)
return('\u2659');
else
return('\u265f');
}


public int getValue()
{
return (1);
}

}