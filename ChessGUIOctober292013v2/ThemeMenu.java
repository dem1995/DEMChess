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

    }


    private static ArrayList<String> getFolders(File curDir)
    {            
        ArrayList<String> strings=new ArrayList<String>();
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory())
                for (File g : f.listFiles())
                if (g.getName().toLowerCase().contains("jpeg")||g.getName().toLowerCase().contains("png")||g.getName().toLowerCase().contains("gif"))
                    if (g.getName().toLowerCase().contains("white")||g.getName().toLowerCase().contains("black"))
                    {
                     
                        strings.add(f.getName());
                        break;
            }
        }

        return strings;
    }

    
}