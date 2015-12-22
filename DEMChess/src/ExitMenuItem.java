import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * The menu for exiting the game. A seperate class just to make editing things easier.
 * @author David McKnight
 * @version 12/22/2015
 */
public class ExitMenuItem extends JMenuItem
{
    public ExitMenuItem()
    {
            super("Exit");
            setMnemonic('x');
            addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            }
        );  
    }
}
