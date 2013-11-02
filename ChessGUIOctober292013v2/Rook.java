import java.util.*;
public class Rook extends ChessPiece implements PieceFace
{
private int q;
public Rook (int color)
{
super(color);
identity|=16;
}

public char getChar ()
{
if (super.q==1)
return('\u2656');
else
return('\u265c');
}

public int getValue()
{
return (5);
}

}