import java.util.*;
abstract class ChessPiece
{
protected int q;
//PieceNames identity;
public ChessPiece (int color)
{
q=color;
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
if (this.q==c.q)
return true;
else 
return false;
}

public int getColor()
{
    return q;
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
if (q==1)
return true;
else 
return false; 
}

public PieceNames enumVal()
{
    return PieceNames.valueOf(this.getClass().toString().substring(6).toUpperCase());

}
}