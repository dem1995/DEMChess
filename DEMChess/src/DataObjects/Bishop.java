package DataObjects;

/**
 * The class of the Bishop chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
public class Bishop extends ChessPiece
{

	public Bishop (int color)
	{
		super(color, 64, "Bishop");
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