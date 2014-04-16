import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class SearchJList extends JPanel implements ActionListener{
	private JList booklist;
	private DefaultListModel listModel;
	private JScrollPane scrollpane;
	private JButton ReserveBook;
	private JButton ReturnToMain;
	private int counter;
	
	public SearchJList(ArrayList <Book> books){
		
		listModel = new DefaultListModel();
		booklist = new JList(listModel);
		scrollpane = new JScrollPane(booklist);
		ReserveBook = new JButton("Reserve");
		ReturnToMain = new JButton("Return to Main");
		for (int i=0; i<books.size(); i++){
			listModel.add(i, books.get(i));
		}
		ReserveBook.addActionListener(this);
		ReturnToMain.addActionListener(this);
		
		add(scrollpane, BorderLayout.NORTH);
		add(ReserveBook);
		add(ReturnToMain);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args, ArrayList <Book> book){
		JFrame dialog = new JFrame("Book Search");
		dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog.setContentPane(new SearchJList(book));
		dialog.setSize(500, 300);
		dialog.setVisible(true);
	}
}
