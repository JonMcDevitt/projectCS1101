import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class LibrarianGUI extends JDialog implements ActionListener{
	private JPanel panel;
	private JButton addBook, addMag, addNews, addJournal;
	private JButton removeBook, removeMag, removeNews, removeJournal, logOut;
	
	public LibrarianGUI(){
		panel = new JPanel(new GridLayout(5, 2));
		addBook = new JButton("Add Book");
		addMag = new JButton("Add Magazine");
		addNews = new JButton("Add Newspaper");
		addJournal = new JButton("Add Journal or Anthology");
		removeBook = new JButton("Remove Book");
		removeMag = new JButton("Remove Magazine");
		removeNews = new JButton("Remove Newspaper");
		removeJournal = new JButton("Remove Journal/Anthology");
		logOut = new JButton("Log Out");
		panel.add(addBook);
		panel.add(removeBook);
		panel.add(addMag);
		panel.add(removeMag);
		panel.add(addNews);
		panel.add(removeNews);
		panel.add(addJournal);
		panel.add(removeJournal);
		panel.add(logOut);
		addBook.addActionListener(this);
		removeBook.addActionListener(this);
		logOut.addActionListener(this);
		
		add(panel);
		setTitle("Main Menu");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==addBook){
			this.setVisible(false);
			AddBookGUI AddBook = new AddBookGUI();
		}
		if (e.getSource()==removeBook){
			RemoveBookGUI RemoveBook = new RemoveBookGUI();
		}
		if (e.getSource()==logOut){
			SystemManager.logout();
			JOptionPane.showMessageDialog(this, "Successfully logged out.");
			LoginGUI login = new LoginGUI();
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args){
		LibrarianGUI librarian = new LibrarianGUI();
	}
}
