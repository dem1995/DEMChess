import java.util.*;
public class Rook extends ChessPiece implements PieceFace
{
private int q;
public Rook (int color)
{
super(color);
}

public char getChar ()
{
if (super.q==1)
return('\u2656');
else
return('\u265c');
}
public byte toByte()
{    
    if (q==1)
    return 1;
    return -1;
}

public int getValue()
{
return (5);
}

}