import java.util.*;
public class Bishop extends ChessPiece implements PieceFace
{
// private int[][] q=new int[32][];
// int a=0;
// {
// for(int x=1; x<=8; x++)
// for(int y=1; y<=8; y++)
// {
// q[a++]=({x, y});
// q[a++]=({x, y});
// }
// }
public Bishop (int color)
{
super(color);
}

public char getChar ()
{
if (super.q==1)
return('\u2657');
else
return('\u265d');
}

public byte toByte()
{    
    if (q==1)
    return 1;
    return -1;
}

public int getValue()
{
return (3);
}
}