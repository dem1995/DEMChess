package DataObjects;

/**
 * The class of the Queen chess piece
 * @author David McKnight
 * @version 12/22/2015
 */

public class Queen extends ChessPiece
{
	public Queen (int color)
	{
		super(color, 8, "Queen");
	}


	public char getChar ()
	{
		if (color==1)
			return('\u2655');
		else
			return('\u265b');
	}

	public int getValue()
	{
		return (9);
	}


}
