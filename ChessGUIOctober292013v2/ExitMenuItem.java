import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
