
/**
 * An interface that describes all methods that are unique to each piece, but that each require.
 * @author David McKnight
 * @version 12/22/2015
 */
public interface PieceFace
{
    
    /**
     * @return The default Unicode character for the ChessPiece using this PieceFace
     */
    public char getChar();
    
    /**
     * @return The default point value for the ChessPiece using this PieceFace
     */
    public int getValue();
    

    }
