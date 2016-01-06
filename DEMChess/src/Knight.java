/**
 * The class of the Knight chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
public class Knight extends ChessPiece
{
public Knight (int color)
{
super (color);
identity|=32;
}


public char getChar ()
{
if (color==1)
return('\u2658');
else
return('\u265e');
}

public int getValue()
{
return (3);
}

public String toString()
{
return "Knight";
}


}