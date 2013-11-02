
public class Board
{
    private ChessPiece[][] bl;
    public Board (ChessPiece[][] b)
    {
        bl=b;
    }

    public void movePiece (String start, String finish)
    {
        if (this.getPiece(start).getValue()!=0&&!(this.getPiece(start).equals(this.getPiece(finish))||
            this.getPiece(start).equals(this.getPiece(finish))))
        {
            this.bl[(finish.charAt(0)-97)][finish.charAt(1)-49]=this.getPiece(start);
            try{
                this.bl[(start.charAt(0)-97)][start.charAt(1)-49]=new Space(0);
            }
            catch (Exception e){}
        }
    }

    public ChessPiece getPiece (String a)
    {
        if (a.charAt(0)=='m'||a.charAt(0)=='M')
            return makePiece(a);
        else
            return this.bl[(a.charAt(0)-97)][a.charAt(1)-49];
    }

    public ChessPiece getPiece (int x, int y)
    {
        return this.bl[x][y];
    }

    public ChessPiece makePiece (String a)
    {
        ChessPiece q=new Space(0);
        switch (a.charAt(1))
        {
            case 'P':
            case 'p': q=new Pawn  ((int)a.charAt(2)-48);
            break;
            case 'N':
            case 'n': q=new Knight((int)a.charAt(2)-48);
            break;
            case 'B':
            case 'b': q=new Bishop((int)a.charAt(2)-48);
            break;
            case 'R':
            case 'r': q=new Rook  ((int)a.charAt(2)-48);
            break;
            case 'Q':
            case 'q': q=new Queen ((int)a.charAt(2)-48);
            break;
            case 'K':
            case 'k': q=new King  ((int)a.charAt(2)-48);
            break;
        }
        return q;
    }

    public String toString()
    {
        return ("\u2003\u2003a\u2003b\u2003c\u2003d\u2003e\u2003f\u2003g\u2003h")+"\n"+
        ("8 |"+this.getPiece("a8").getChar()+"|"+this.getPiece("b8").getChar()+"|"+this.getPiece("c8").getChar()+"|"+this.getPiece("d8").getChar()+"|"+this.getPiece("e8").getChar()+"|"+this.getPiece("f8").getChar()+"|"+this.getPiece("g8").getChar()+"|"+this.getPiece("h8").getChar()+"| 8")+"\n"+
        ("7 |"+this.getPiece("a7").getChar()+"|"+this.getPiece("b7").getChar()+"|"+this.getPiece("c7").getChar()+"|"+this.getPiece("d7").getChar()+"|"+this.getPiece("e7").getChar()+"|"+this.getPiece("f7").getChar()+"|"+this.getPiece("g7").getChar()+"|"+this.getPiece("h7").getChar()+"| 7")+"\n"+
        ("6 |"+this.getPiece("a6").getChar()+"|"+this.getPiece("b6").getChar()+"|"+this.getPiece("c6").getChar()+"|"+this.getPiece("d6").getChar()+"|"+this.getPiece("e6").getChar()+"|"+this.getPiece("f6").getChar()+"|"+this.getPiece("g6").getChar()+"|"+this.getPiece("h6").getChar()+"| 6")+"\n"+
        ("5 |"+this.getPiece("a5").getChar()+"|"+this.getPiece("b5").getChar()+"|"+this.getPiece("c5").getChar()+"|"+this.getPiece("d5").getChar()+"|"+this.getPiece("e5").getChar()+"|"+this.getPiece("f5").getChar()+"|"+this.getPiece("g5").getChar()+"|"+this.getPiece("h5").getChar()+"| 5")+"\n"+
        ("4 |"+this.getPiece("a4").getChar()+"|"+this.getPiece("b4").getChar()+"|"+this.getPiece("c4").getChar()+"|"+this.getPiece("d4").getChar()+"|"+this.getPiece("e4").getChar()+"|"+this.getPiece("f4").getChar()+"|"+this.getPiece("g4").getChar()+"|"+this.getPiece("h4").getChar()+"| 4")+"\n"+
        ("3 |"+this.getPiece("a3").getChar()+"|"+this.getPiece("b3").getChar()+"|"+this.getPiece("c3").getChar()+"|"+this.getPiece("d3").getChar()+"|"+this.getPiece("e3").getChar()+"|"+this.getPiece("f3").getChar()+"|"+this.getPiece("g3").getChar()+"|"+this.getPiece("h3").getChar()+"| 3")+"\n"+
        ("2 |"+this.getPiece("a2").getChar()+"|"+this.getPiece("b2").getChar()+"|"+this.getPiece("c2").getChar()+"|"+this.getPiece("d2").getChar()+"|"+this.getPiece("e2").getChar()+"|"+this.getPiece("f2").getChar()+"|"+this.getPiece("g2").getChar()+"|"+this.getPiece("h2").getChar()+"| 2")+"\n"+
        ("1 |"+this.getPiece("a1").getChar()+"|"+this.getPiece("b1").getChar()+"|"+this.getPiece("c1").getChar()+"|"+this.getPiece("d1").getChar()+"|"+this.getPiece("e1").getChar()+"|"+this.getPiece("f1").getChar()+"|"+this.getPiece("g1").getChar()+"|"+this.getPiece("h1").getChar()+"| 1")+"\n"+
        ("\u2003\u2003a\u2003b\u2003c\u2003d\u2003e\u2003f\u2003g\u2003h");
    }

    public String toString2()
    {
        String cheese=new String ("\u2003\u2003a\u2003b\u2003c\u2003d\u2003e\u2003f\u2003g\u2003h");
        for (int y=0; y<8; y++)
        {
            cheese+="\n"+((y+1)+" ");
            for (int x=0; x<8; x++)
                cheese+="|"+this.getPiece(x, y).getChar();    
            cheese+="|";
        }
        cheese+=("\n"+"\u2003\u2003a\u2003b\u2003c\u2003d\u2003e\u2003f\u2003g\u2003h");
        return cheese;
    }
    
    public byte[] toBits()
    {
        byte[] board=new byte[64];
        for (int x=0; x<bl.length; x++)
        {     
            return bl[x].toByte();
        }
    }
    
    public String toString(int a)
    {
        if (a%2==0)
        return toString();
        else
        return toString2();
    }

    public Board fillBoard()
    {
        ChessPiece[][] q=new ChessPiece [8][8];
        q[0][7]=new Rook(2);
        q[1][7]=new Knight(2);
        q[2][7]=new Bishop(2);
        q[3][7]=new Queen(2);
        q[4][7]=new King(2);
        q[5][7]=new Bishop(2);
        q[6][7]=new Knight(2);
        q[7][7]=new Rook(2);
        q[0][0]=new Rook(1);
        q[1][0]=new Knight(1);
        q[2][0]=new Bishop(1);
        q[3][0]=new Queen(1);
        q[4][0]=new King(1);
        q[5][0]=new Bishop(1);
        q[6][0]=new Knight(1);
        q[7][0]=new Rook(1);
        for (int number=1; number<q.length-6; number++)
            for (int letter=0; letter<q[number].length; letter++)
                q[letter][number]=new Pawn(1);
        for (int number=2; number<q.length-2; number++)
            for (int letter=0; letter<q[number].length; letter++)
                q[letter][number]=new Space(0);
        for (int number=6; number<q.length-1; number++)
            for (int letter=0; letter<q[number].length; letter++)
                q[letter][number]=new Pawn(2);
        return new Board(q);
    }

}
