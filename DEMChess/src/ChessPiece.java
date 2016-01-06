
/**
 * The abstract class holding default implementations for methods for various Chess Pieces.
 * @author David McKnight
 * @version 12/22/2015
 */
abstract class ChessPiece implements PieceFace
{
	

/**
 * The color of the piece
 */
protected int color;

/**
 * The bits of this byte express the piece's identity exactly (type of piece, color). To be used in the future for optimization.
 */
byte identity;


public ChessPiece (int color)
{
this.color=color;
identity|=color;
}

public boolean equals(ChessPiece c)
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


public boolean isWhite()
{
if ((identity&0b11)==1)
return true;
else 
return false; 
}



public PieceNames enumVal()
{
    return PieceNames.valueOf(this.getClass().toString().substring(6).toUpperCase());

}


}