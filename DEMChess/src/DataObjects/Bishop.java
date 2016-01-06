package DataObjects;

/**
 * The class of the Bishop chess piece
 * @author David McKnight
 * @version 12/22/2015
 */
public class Bishop extends ChessPiece
{

	/**
	 * Creates a ChessPiece Bishop. If the integer is 1, it will be white, if it is anything else, it will be black
	 * @param color
	 */
	public Bishop (int color)
	
	{
		super(color, 32);
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