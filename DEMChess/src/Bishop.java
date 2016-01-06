
/**
 * The class of the Bishop chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
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
identity|=64;
}

public char getChar ()
{
if (color==1)
return('\u2657');
else
return('\u265d');
}

public int getValue()
{
return (3);
}
}