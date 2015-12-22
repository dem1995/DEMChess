/**
 * The class of the Pawn chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
public class Pawn extends ChessPiece implements PieceFace
{
final private int[][] attackRange={{1,1},{-1,1}};
public Pawn (int color)
{
super (color);
identity|=128;
}

public char getChar ()
{
if (super.q==1)
return('\u2659');
else
return('\u265f');
}


public int getValue()
{
return (1);
}

public int[][] getAttackRange()
{
return attackRange;
}
}