import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The menu for adding new chess pieces to the game.
 * @author David McKnight
 * @version 12/22/2015
 */
public class NewMenu extends JMenu
{
    public String tempPiece;        
    public boolean apple=false;
    JMenuItem NewBoardItem  = new JMenuItem("New Board");
    public NewMenu()
    {
        super("New");
        setMnemonic('N');
        
        
        add(NewBoardItem);
        
        
        JMenuItem EraseItem  = new JMenuItem("Erase a Piece");
        add(EraseItem);

                
        JMenuItem Pawn1Item  = new JMenuItem("White Pawn");
        add(Pawn1Item);
        JMenuItem Knight1Item = new JMenuItem("White Knight");
        add(Knight1Item);
        JMenuItem Bishop1Item = new JMenuItem("White Bishop");
        add(Bishop1Item);
        JMenuItem Rook1Item = new JMenuItem("White Rook");
        add(Rook1Item);
        JMenuItem Queen1Item = new JMenuItem("White Queen");
        add(Queen1Item);
        JMenuItem King1Item = new JMenuItem("White King");
        add(King1Item);

        JMenuItem Pawn2Item  = new JMenuItem("Black Pawn");
        add(Pawn2Item);
        JMenuItem Knight2Item = new JMenuItem("Black Knight");
        add(Knight2Item);
        JMenuItem Bishop2Item = new JMenuItem("Black Bishop");
        add(Bishop2Item);
        JMenuItem Rook2Item = new JMenuItem("Black Rook");
        add(Rook2Item);
        JMenuItem Queen2Item = new JMenuItem("Black Queen");
        add(Queen2Item);
        JMenuItem King2Item = new JMenuItem("Black King");
        add(King2Item);
        
        addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    System.out.println("New is pressed");
                }
            }
        );

        EraseItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mp0";
                    apple=true;
                }
            }
        );
        Pawn1Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mp1";
                    apple=true;
                }
            }
        );
        Knight1Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mn1";
                    apple=true;
                }
            }
        );
        Bishop1Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mb1";
                    apple=true;
                }
            }
        );
        Rook1Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mr1";
                    apple=true;
                }
            }
        );
        Queen1Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mq1";
                    apple=true;
                }
            }
        );
        King1Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mk1";
                    apple=true;
                }
            }
        );
        Pawn2Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mp2";
                    apple=true;
                }
            }
        );
        Knight2Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mn2";
                    apple=true;
                }
            }
        );
        Bishop2Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mb2";
                    apple=true;
                }
            }
        );
        Rook2Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mr2";
                    apple=true;
                }
            }
        );
        Queen2Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mq2";
                    apple=true;
                }
            }
        );
        King2Item.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    tempPiece="mk2";
                    apple=true;
                   
                }
            }
        );
}
}
