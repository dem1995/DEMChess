import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Write a description of class InputMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InputMenu extends JMenu
{
    String inputMethod="dnd";
    public InputMenu()
    {
        super("Input Method");
        setMnemonic('I');
        JMenuItem DnDItem  = new JMenuItem("Drag and Drop");
        add(DnDItem);
        JMenuItem clickItem = new JMenuItem("Click Twice");
        add(clickItem);
           DnDItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    inputMethod="dnd";
                }
            }
        );   
        clickItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    inputMethod="click";
                }
            }
        );
    }
    
}
