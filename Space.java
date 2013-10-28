import java.util.*;
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