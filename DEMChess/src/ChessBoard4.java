import java.awt.*;
import java.net.*;

import javax.swing.*;

import java.awt.event.*;

import DataObjects.*;
/**
 * The ChessBoard4 Class (so named because it is the fourth version of the ChessBoard class) is the class that handles all user inputs, as well as the class that handles rendering all graphical components to the screen. 
 * @author David McKnight
 * @version 12/22/2015
 */
public class ChessBoard4 extends JFrame implements MouseListener, MouseMotionListener

{    

    private JPanel[][] pnlChessCells = new JPanel[8][8];
    private int intX;
    private int intY;
    private boolean moveFromisDone=false;
    private boolean showIconDragging=false;
    private JPanel pnlMain = new JPanel(new GridLayout(8,8));
    public static Board board=Board.makeAndFillABoard();
    public String theme;
    /**
     * Filenames for the images representing the pieces
     */
    public PieceFileNames farPieceFiles=new PieceFileNames();
    /**
     * Filenames for the images representing the pieces
     */
    public PieceFileNames nearPieceFiles=new PieceFileNames();
    /**
     * A boolean value letting the program know whether white is at the bottom of the screen or not.
     */
    boolean whiteFront=true;
    private Point pntMoveFrom, pntMoveTo;
    private Container c;
    NewMenu newMenu=new NewMenu();
    InputMenu inputMenu=new InputMenu();
    /**
     * The menu for selecting the piece theme currently being used.
     */
    ThemeMenu themeMenu=new ThemeMenu();
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    int winXPos=0;
    int winYPos=0;
    // private JTextField text=new JTextField("HELLO");
    // private JScrollPane scroller = new JScrollPane(text);

    public static void main(String[] args)
    {
        ChessBoard4 itsaBoard=new ChessBoard4();

        //System.out.println(ChessBoard4.board.toString());
    }

    /**
     * Converts a point representation of a chess board location (e.g., the king starts at (4,0)) to a string representation (e.g., the white king starts at e1)
     * @param a The integer value of the column of the square on the chess board being converted
     * @param b The integer value of the row of the square on the chess board being converted
     * @return A The string representation of the point on the chess board
     */
    public String pointtoString(int a, int b)
    {
        return ""+(char)(b+97)+(char)((7-a)+49);
    }

    /**
     * The GUI representation of the board, along with the needed menus
     */
    public ChessBoard4() 

    {
        super("Menu example");

        JMenu file = new JMenu("File");
        file.setMnemonic('F');
        JMenu view = new JMenu("View");        
        view.setMnemonic('V');

        SaveMenu saveMenu=new SaveMenu(board);
        file.add(saveMenu);
        
        ////////////////
        file.add(newMenu);
        ////////////////
        file.add(inputMenu);
        ///////////////
        view.add(themeMenu);
        try{
        theme=themeMenu.themeNames.get(0);
        farPieceFiles.set(theme, "back");
        nearPieceFiles.set(theme, "front");
    }
    catch (Exception error){};

        
        JMenuItem reverseItem=new JMenuItem("Reverse Board");
        view.add(reverseItem);
        JMenuItem decToggleItem=new JMenuItem("Toggle Decoration");
        view.add (decToggleItem);

        ExitMenuItem exitItem= new ExitMenuItem();
        file.add(exitItem);

        //adding Action Listeners to menu items

        newMenu.NewBoardItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    board=Board.makeAndFillABoard();
                    refreshChessPieces();
                }
            }
        );      

        reverseItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    whiteFront=!whiteFront;
                    refreshChessPieces();
                }
            }
        );

        decToggleItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    toggleWinDecoration();
                }
            }
        );

        for (int i=0; i<themeMenu.themeNames.size(); i++)
        {
            JMenuItem george=new JMenuItem(themeMenu.themeNames.get(i));
            themeMenu.add(george);
            george.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        theme=e.getActionCommand();
                        farPieceFiles.set(theme, "back");
                        nearPieceFiles.set(theme, "front");
                        refreshChessPieces();
                    }
                });
        }
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(file);
        bar.add(view);

        bar.addMouseListener(new MouseAdapter()

            {
                public void mousePressed(MouseEvent e)
                {
                    winXPos=e.getX();
                    winYPos=e.getY();
                }
            });
        bar.addMouseMotionListener(new MouseAdapter()
            {
                public void mouseDragged(MouseEvent mouseEvent)
                {
                    //sets frame position when mouse dragged			
                    setLocation (mouseEvent.getXOnScreen()-winXPos,mouseEvent.getYOnScreen()-winYPos);

                }
            });

        setUndecorated(true);             

        c = getContentPane();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        //int taskBarSize = scnMax.bottom;
        //taskBarSize=bar.
        Dimension barSize=new Dimension(screenSize.width,screenSize.height/33);
        bar.setPreferredSize(barSize);
        double barHeight=barSize.getHeight();
        //setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
        if(screenSize.height<screenSize.width)
        {
            setBounds((int)(screenSize.width/2.0-(screenSize.height-barHeight)/2.0), 0, (int)(screenSize.height-barHeight), screenSize.height);
            pnlMain.setBounds(0, 0, (int)(screenSize.height-barHeight), (int)(screenSize.height-barHeight));
        }
        else
        {
            setBounds((int)(screenSize.width/2.0-(screenSize.height-barHeight)/2.0), 0,(int)(screenSize.width-barHeight), screenSize.width);
            pnlMain.setBounds(0, 0, (int)(screenSize.width-barHeight), (int)(screenSize.width-barHeight));
        }

        
        //setBounds(100, 100, 740, 760);
        setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("David Estes McKnight's Chess");
        setResizable(true);
        setLayout(null);    

        
        pnlMain.setBackground(Color.WHITE);
        add(pnlMain);
        this.firstDraw();
        this.refreshChessPieces();
        setVisible(true);
        //show();
    }

    public Image getImagee(String fileName) { 
        URL imageURL = getClass().getClassLoader().getResource(fileName);
        if(imageURL == null) 
            return null; 
        return new ImageIcon(imageURL).getImage();
    }

    public void mouseClicked(MouseEvent e)

    {
        Object source = e.getSource();

        JPanel pnlTemp = (JPanel)source; 
        System.out.println(pnlTemp.getWidth());
        //int intX = (int)(pnlTemp.getX()/pnlTemp.getWidth());
       // int intY = (int)(pnlTemp.getY()/pnlTemp.getHeight());
        if (newMenu.apple)
        {
            String fin=pointtoString(intY, intX);
            this.board.movePiece(newMenu.tempPiece, fin);
            newMenu.apple=false;
            this.refreshChessPieces();
            //             System.out.println(tempPiece);
            //             System.out.println(fin);
            //             System.out.println(this.board.toString());
        }
        //         else
        //         {
        //             if (!moveFromisDone)
        //                 this.pntMoveFrom = new Point(intX, intY);       
        //             else
        //                 this.pntMoveTo = new Point(intX, intY);
        //             moveFromisDone=true;
        //             if (this.pntMoveFrom.equals(this.pntMoveTo))
        //                 moveFromisDone=false;
        //             else if (moveFromisDone&&!(this.pntMoveTo==null))
        //             {
        //                 String start=pointtoString(pntMoveFrom.y, pntMoveFrom.x);
        //                 String fin=pointtoString(pntMoveTo.y, pntMoveTo.x);
        //                 this.board.movePiece(start, fin);
        //                 this.refreshChessPieces();
        //                 moveFromisDone=false;
        //                 this.pntMoveTo=null;
        //             }
        //         }

    }

    private JLabel getPieceObject(ChessPiece piece)
    {
        JLabel PieceLabel;
        try{
        if (whiteFront)
        {
            if (piece.getColor()==1)          
                return new JLabel (new ImageIcon(nearPieceFiles.get(piece.getColorString()+piece.getName())));         
            else if (piece.getColor()==2)
                return new JLabel (new ImageIcon(farPieceFiles.get(piece.getColorString()+piece.getName())));
        }
        else
        {
            if (piece.getColor()==1)          
                return new JLabel (new ImageIcon(farPieceFiles.get(piece.getColorString()+piece.getName())));         
            else if (piece.getColor()==2)
                return new JLabel (new ImageIcon(nearPieceFiles.get(piece.getColorString()+piece.getName())));
        }
    }catch (Exception e){};
        return new JLabel ("");

    }

    private String getPieceObjectName(ChessPiece piece)

    {
        return piece.enumVal().toString();
    }

    private void refreshChessPieces()
    {            

        for(int y = 0; y <8; y++)       

            for(int x = 0; x <8; x++) 

            {                
                this.pnlChessCells[y][x].removeAll();
                if (whiteFront)
                    this.pnlChessCells[y][x].add(this.getPieceObject(this.board.getPiece(pointtoString((y),(x)))), BorderLayout.CENTER);
                else
                    this.pnlChessCells[y][x].add(this.getPieceObject(this.board.getPiece(pointtoString((7-y),(7-x)))), BorderLayout.CENTER);
                this.pnlChessCells[y][x].validate();
        }          
        System.out.println(board.toString());

    }

    private void firstDraw()
    {

        for (int i=0; i<64; i++)
        {
            pnlChessCells[i/8][i%8]=new JPanel(new BorderLayout());
            pnlChessCells[i/8][i%8].addMouseListener(this);
            pnlMain.add(pnlChessCells[i/8][i%8]);
            if ((i+i/8)%2==0)
                pnlChessCells[i/8][i%8].setBackground(Color.WHITE);
            else
                pnlChessCells[i/8][i%8].setBackground(Color.DARK_GRAY);
        }

    }


    public void mouseEntered(MouseEvent e){
        Object source = e.getSource();
        JPanel pnlTemp = (JPanel)source;
        if (whiteFront)
        {
            intX = (int)(pnlTemp.getX()/pnlTemp.getWidth());
            intY = (int)(pnlTemp.getY()/pnlTemp.getHeight());
        }
        else
        {
            intX = 7-(int)(pnlTemp.getX()/pnlTemp.getWidth());
            intY = 7-(int)(pnlTemp.getY()/pnlTemp.getHeight());
        }
    }

    public void mouseExited(MouseEvent e){}  

    public void mousePressed(MouseEvent e){
        //System.out.println(this.board.toString());
        //System.out.println(intX);
        //System.out.println(intY);
        if(!newMenu.apple)
            if (inputMenu.inputMethod.equals("dnd"))
            {
                showIconDragging=true;

                this.pntMoveFrom = new Point (intX, intY);
                System.out.println(this.board.getPiece(intX, 7-intY).getColorString()+this.board.getPiece(intX, 7-intY).getName());
                try{
                    Image image = nearPieceFiles.get(this.board.getPiece(intX, 7-intY).getColorString()+this.board.getPiece(intX, 7-intY).getName());
                    //Image image = toolkit.getImage(nearPieceFiles.get(this.board.getPiece(intX, intY).getColorString()+this.board.getPiece(intX, intY).getClass().toString().substring(6)));
                    Cursor c = toolkit.createCustomCursor(image, new Point(10, 10), "img");                
                    this.setCursor (c);
                }
                catch (Exception f)
                {};
                moveFromisDone=true;
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        if(this.getCursor().getName().equals("img"))
        {
            this.setCursor(Cursor.DEFAULT_CURSOR);
        }
        if(!newMenu.apple)
            if (inputMenu.inputMethod.equals("dnd"))
            {
                showIconDragging=false;
                Object source = e.getSource();
                JPanel pnlTemp = (JPanel)source;
                this.pntMoveTo=new Point (intX, intY);
                if(this.pntMoveFrom!=null)
                    if (this.pntMoveFrom.equals(this.pntMoveTo))
                    {
                        this.pntMoveFrom=null;
                        moveFromisDone=false;
                    }
                    else if(moveFromisDone&&pntMoveTo!=null)
                    {
                        String start=pointtoString(pntMoveFrom.y, pntMoveFrom.x);
                        String fin=pointtoString(pntMoveTo.y, pntMoveTo.x);
                        this.board.movePiece(start, fin);          
                        this.refreshChessPieces();
                        moveFromisDone=false;
                        this.pntMoveTo=null;
                }

            }
            else
            {
                if (moveFromisDone)
                {
                    if (whiteFront)
                    pnlChessCells[pntMoveFrom.y][pntMoveFrom.x].setBorder(BorderFactory.createEmptyBorder());
                    else
                    pnlChessCells[7-pntMoveFrom.y][7-pntMoveFrom.x].setBorder(BorderFactory.createEmptyBorder());
                    this.pntMoveTo=new Point (intX, intY);                    
                    String start=pointtoString(pntMoveFrom.y, pntMoveFrom.x);
                    String fin=pointtoString(pntMoveTo.y, pntMoveTo.x);
                    this.board.movePiece(start, fin);
                    this.refreshChessPieces();
                    moveFromisDone=false;
                }
                else
                {
                    this.pntMoveFrom=new Point (intX, intY);
                    if (whiteFront)
                    pnlChessCells[intY][intX].setBorder(BorderFactory.createLineBorder(Color.green));
                    else
                    pnlChessCells[7-intY][7-intX].setBorder(BorderFactory.createLineBorder(Color.green));
                    moveFromisDone=true;
                }
        }

    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void toggleWinDecoration(){
        dispose();
        setUndecorated(!isUndecorated());
        setVisible(true);
    }
}
