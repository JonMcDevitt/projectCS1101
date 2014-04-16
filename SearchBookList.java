import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


public class SearchBookList extends JPanel implements MouseListener{
	
	private JList booklist;
	private DefaultListModel listModel;
	private JScrollPane scrollpane;
	
	public SearchBookList(ArrayList <Book> book){
		setLayout(new BorderLayout());
		booklist = new JList(book.toArray());
		booklist.addMouseListener(this);
		booklist.setVisible(true);
		scrollpane = new JScrollPane();
		
		add(scrollpane, BorderLayout.NORTH);
		add(booklist, BorderLayout.NORTH);
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		SystemManager.reserveBook((Book)booklist.getSelectedValue());  
	}
}
