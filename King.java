import java.util.*;
public class King extends ChessPiece implements PieceFace
{
private int q;
public King (int color)
{
super(color);
}

public char getChar ()
{
if (super.q==1)
return('\u2654');
else
return('\u265a');
}

public int getValue()
{
return (100);
}

public byte toByte()
{    
    if (q==1)
    return 1;
    return -1;
}
/*
public boolean isWhite()
{
if (q==0)
return true;
else 
return false; 
}
*/
}
