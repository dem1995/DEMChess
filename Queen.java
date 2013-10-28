import java.util.*;
public class Queen extends ChessPiece implements PieceFace
{
private int q;
public Queen (int color)
{
super(color);
}


public char getChar ()
{
if (super.q==1)
                return('\u2655');
            else
                return('\u265b');
}

public int getValue()
{
return (9);
}


}
