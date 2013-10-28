public class Pawn extends ChessPiece implements PieceFace
{
final private int[][] attackRange={{1,1},{-1,1}};
public Pawn (int color)
{
super (color);
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