
/**
 * The interface that makes it so that all pieces will require these two methods.
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
