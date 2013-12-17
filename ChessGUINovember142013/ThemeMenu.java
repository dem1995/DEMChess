import java.io.File;
import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ThemeMenu extends JMenu
{
    ArrayList<String> themeNames;
    public ThemeMenu()
    {
        super("Piece Themes");
        setMnemonic('P');
        themeNames=getFolders(new File ("."));
        if (themeNames.size()==0)
        themeNames.add("There are no themes available");
        
    }


    private static ArrayList<String> getFolders(File curDir)
    {            
        ArrayList<String> strings=new ArrayList<String>();
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
            {
                int pieces=0;
                for (File g : f.listFiles())
                if (g.getName().toLowerCase().contains("jpeg")||g.getName().toLowerCase().contains("png")||g.getName().toLowerCase().contains("gif"))
                    pieces|=filePieceArrayVal(g.getName());
                if (pieces==4095)
                strings.add(f.getName());
                    }                    
                }
            return strings;
           
        }
        
        public static int filePieceArrayVal(String fileName)
        {
            fileName=fileName.toLowerCase();
            int colorShift=0;
            if (fileName.contains("black"))
            colorShift=6;
            if (fileName.contains("pawn"))
            return 1<<colorShift;
            if (fileName.contains("knight"))
            return 2<<colorShift;
            if (fileName.contains("bishop"))
            return 4<<colorShift;
            if (fileName.contains("rook"))
            return 8<<colorShift;
            if (fileName.contains("queen"))
            return 16<<colorShift;
            if (fileName.contains("king"))
            return 32<<colorShift;
            return 0;
        }
        

    }

    
