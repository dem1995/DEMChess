package DataObjects;

/**
 * The abstract class holding default implementations for methods for various Chess Pieces.
 * @author David McKnight
 * @version 12/22/2015
 */
public abstract class ChessPiece implements PieceFace
{
	/**
	 * The color of the piece
	 */
	protected int color;

	/**
	 * The bits of this byte express the piece's identity exactly (type of piece, color). To be used in the future for optimization.
	 */
	protected byte identity;


	/**
	 * @param color The color of the piece
	 * @param binProp The binary property of the piece (the identity byte lets you know what the piece is. So, for example the King has a binary property of 0100, so that is "or"-ed with the identity, meaning that any piece with a 1 in the 3rd bit from the right in the identity is a King)
	 */
	public ChessPiece (int color, int binProp)
	{
		this.color=color;
		identity|=color;
		identity|=binProp;
	}

	public boolean hasSameColorAs(ChessPiece c)
	{
		if (this.color==c.color)
			return true;
		else 
			return false;
	}

	public int getColor()
	{
		return identity&0b11;
	}

	public String getColorString()
	{
		if (getColor()==1)
			return "white";
		else
			if (getColor()==2)
				return "black";
		return null;
	}

	public String getName()
	{
		return this.getClass().getSimpleName();
	}
	
	public byte toByte()
	{
		return identity;
	}

	public PieceNames enumVal()
	{
		return PieceNames.valueOf(this.getClass().toString().substring(6).toUpperCase());

	}


}