
//import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;

public class ChessPanel extends JPanel
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class ChessBoard
     */
    public ChessPanel()
    {
        super(new GridLayout(8,8));
        for (int row=0; row<((GridLayout)getLayout()).getRows(); row++)
        for (int column=0; column<((GridLayout)getLayout()).getColumns(); column++)
        add(new PiecePanel());
        
        for (int i=0; i<getComponentCount(); i++)
        {
        JPanel fred=(JPanel)(getComponent(i));
        if ((i+i/8)%2==0)
        fred.setBackground(Color.WHITE);
        else
        fred.setBackground(Color.DARK_GRAY);

    }
    
    }
    }

