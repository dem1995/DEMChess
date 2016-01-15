import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import DataObjects.Board;


public class LoadMenu extends JMenu {
	//Board board;
	final JFileChooser fileChooser= new JFileChooser();
	public LoadMenu(Board board)
	{
		super("Open");
		//this.board=board;
		JMenuItem loadHumanReadable= new JMenuItem("Open a Human-Readable board");
		add(loadHumanReadable);
		JMenuItem loadBytes= new JMenuItem("Open a 64-byte .demChess file");
		add(loadBytes);
		
		loadBytes.addActionListener(
				new ActionListener()
				{
			public void actionPerformed(ActionEvent s)
			{			
				int returnValue=fileChooser.showOpenDialog(null);
				if (returnValue==JFileChooser.APPROVE_OPTION);
				{
					File file = fileChooser.getSelectedFile();
					try{
					byte[] byteArray=Files.readAllBytes(file.toPath());
					Board board2= Board.fromByteArray(byteArray);
					System.out.println(board2);
					//board.setPieceArray(Board.fromByteArray(byteArray).getPieceArray());
					}catch(Exception e){System.out.println("loading failed");};
					
				}
				
			}
		});
	}
	

}
