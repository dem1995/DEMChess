
/**
 * The abstract class holding default implementations for methods for various Chess Pieces.
 * @author David McKnight
 * @version 12/22/2015
 */
abstract class ChessPiece
{
protected int color;
int identity;
public ChessPiece (int color)
{
this.color=color;
identity|=color;
}

public char getChar ()
{
return('0');
}

public int getValue()
{
return (0);
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