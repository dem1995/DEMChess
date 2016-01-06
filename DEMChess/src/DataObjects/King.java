package DataObjects;
/**
 * The class of the King chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
public class King extends ChessPiece
{
	
	public King (int color)
	{
		super(color, 4, "King");
	}

	public char getChar ()
	{
		if (color==1)
			return('\u2654');
		else
			return('\u265a');
	}

	public int getValue()
	{
		return (100);
	}
}
