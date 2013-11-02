import javax.swing.JMenuItem;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
public class SaveMenuItem extends JMenuItem
{
    // instance variables - replace the example below with your own
    private int x;
    Board board;

    /**
     * Constructor for objects of class SaveMenu
     */
    public SaveMenuItem(Board board)
    {
        super("Save");
        this.board=board;
    }

    public void addSaveListener()
    {
        addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) 
                {
                    String fileName = JOptionPane.showInputDialog("What do you want to call your save file?");                   
                    try
                    {
                    printTo(fileName);
                }
                catch(IOException f){
                    System.out.println("File creation failed");
                }
               
            }
            }
        );

    }
//     public void addSaveListenerByte()
//     {
//         addActionListener(
//             new ActionListener(){
//                 public void actionPerformed(ActionEvent e) 
//                 {
//                     String fileName = JOptionPane.showInputDialog("What do you want to call your save file?");                   
//                     try
//                     {
//                     printBytesTo(fileName);
//                 }
//                 catch(IOException f){
//                     System.out.println("File creation failed");
//                 }
//                 board.changeBoardToThatWhichIsGivenByTheFollowingByteArray(board.toByteArray());
//                 System.out.println(board.toString());
//             }
//             }
//         );
// 
//     }
    public void printTo(String fileName) throws IOException
    {
      
  
  

        String path=new File(".").getAbsolutePath();
        path=path.substring(0, path.length()-1);
        File testFile=new File(path+"saves");
        if (!testFile.isDirectory())
            testFile.mkdir();
        System.out.println(testFile.getAbsolutePath());
        //File saveFile=new File(testFile.getAbsolutePath()+"saves\\"+fileName+".txt");
        File saveFile=new File("saves"+"\\"+fileName+".txt");
        try
        {
        byte[] out = UnicodeUtil.convert(board.toString().getBytes("UTF-16"), "UTF-8");

 
       //PrintWriter pw = new PrintWriter(saveFile);
        FileOutputStream fos = new FileOutputStream(saveFile);
            fos.write(out);
            //pw.print(board.toString());
          //  pw.close(); 
          fos.close();  
              }
    catch(Exception q)
    {
             }
            //return x + y;
        }
//     public void printBytesTo(String fileName) throws IOException
//     {
//         String path=new File(".").getAbsolutePath();
//         path=path.substring(0, path.length()-1);
//         File testFile=new File(path+"saves");
//         if (!testFile.isDirectory())
//             testFile.mkdir();
//         System.out.println(testFile.getAbsolutePath());
//         //File saveFile=new File(testFile.getAbsolutePath()+"saves\\"+fileName+".txt");
//         File saveFile=new File("saves");
//         
//             FileOutputStream fop = new FileOutputStream(saveFile);
//             fop.write(board.toByteArray());
//             fop.close(); 
//             //return x + y;
//     }
    }
