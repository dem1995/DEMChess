import java.io.File;
import java.util.ArrayList;
import java.net.URI;
import java.net.URL;
import java.awt.Toolkit;
import java.awt.Image;
/**
 * Write a description of class PieceFileNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PieceFileNames
{
    Image whitePawn;
    Image whiteKnight;
    Image whiteBishop;
    Image whiteRook;
    Image whiteQueen;
    Image whiteKing;    
    Image blackPawn;
    Image blackKnight;
    Image blackBishop;
    Image blackRook;
    Image blackQueen;
    Image blackKing;
    public PieceFileNames()
    {
    }
    
    public void print()
    {
        //URL fred=new URL(
       // System.out.println(whitePawn.toString().replaceFirst("./", ""));
        System.out.println(whitePawn);
        System.out.println(whitePawn.toString().replaceFirst("\\./", ""));
    }
    

    
    public URL toURL(URI uri)
    {
        try
        {
        return (new URL(uri.toString().replaceFirst("\\./", "")));
    }
    catch (Exception e)
    {return null;}
    }
    
    public void set (String theme, String oppside)
    {
        File curDir=new File(".");
        ArrayList<File> pieceFiles=new ArrayList<File>();
        File[] filesList = curDir.listFiles();
        
        for(File f : filesList){
            if(f.isDirectory())
            if(f.getName().equals(theme))
            {
            for (File g: f.listFiles())
            {
                String fileName=g.getName().toLowerCase();
                if(!fileName.contains(oppside))
                {
                if (fileName.contains("white"))
                {
                    if (fileName.contains("pawn"))
                    whitePawn=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("knight"))
                    whiteKnight=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("bishop"))
                    whiteBishop=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("rook"))
                    whiteRook=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("queen"))
                    whiteQueen=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("king"))
                    whiteKing=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                }
                else if (fileName.contains("black"))
                {
                    if (fileName.contains("pawn"))
                    blackPawn=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("knight"))
                    blackKnight=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("bishop"))
                    blackBishop=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("rook"))
                    blackRook=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("queen"))
                    blackQueen=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                    else if (fileName.contains("king"))
                    blackKing=Toolkit.getDefaultToolkit().createImage(toURL(g.toURI()));
                }
            }
            }
            break;
        }
        }
        //System.out.println(blackQueen.getName());
    }
    
    public Image get(String pieceType)
    {
        if (pieceType.contains("white"))
                {
                    if (pieceType.equals("whitePawn"))
                    return whitePawn;
                    else if (pieceType.equals("whiteKnight"))
                    return whiteKnight;
                    else if (pieceType.equals("whiteBishop"))
                    return whiteBishop;
                    else if (pieceType.equals("whiteRook"))
                    return whiteRook;
                    else if (pieceType.equals("whiteQueen"))
                    return whiteQueen;
                    else if (pieceType.equals("whiteKing"))
                    return whiteKing;
                }
                else if (pieceType.contains("black"))
                {
                    if (pieceType.contains("blackPawn"))
                    return blackPawn;
                    else if (pieceType.equals("blackKnight"))
                    return blackKnight;
                    else if (pieceType.equals("blackBishop"))
                    return blackBishop;
                    else if (pieceType.equals("blackRook"))
                    return blackRook;
                    else if (pieceType.equals("blackQueen"))
                    return blackQueen;
                    else if (pieceType.equals("blackKing"))
                    return blackKing;
                   
                }
        return null;
    }

    
    }

