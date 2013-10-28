import java.util.*;
public class Knight extends ChessPiece implements PieceFace
{
private int q;
public Knight (int color)
{
super (color);
}


public char getChar ()
{
if (super.q==1)
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