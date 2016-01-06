/**
 * The class of the Rook chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
public class Rook extends ChessPiece implements PieceFace
{
public Rook (int color)
{
super(color);
identity|=16;
}

public char getChar ()
{
if (color==1)
return('\u2656');
else
return('\u265c');
}

public int getValue()
{
return (5);
}

}