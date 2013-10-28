import java.awt.Color;
import javax.swing.JFrame;

public class ChessContainer extends JFrame
{
    // instance variables - replace the example below with your own
    private int x;

    public ChessContainer()
    {
      setBackground(Color.GRAY);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("David Estes McKnight's Chess");
      setResizable(true);
      setLayout(null);    
      setJMenuBar(new MenuBar());
      setContentPane(new ChessPanel());
      setVisible(true);
        
    }
}
