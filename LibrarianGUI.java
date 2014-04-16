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
		addMag.addActionListener(this);
		removeMag.addActionListener(this);
		addNews.addActionListener(this);
		removeNews.addActionListener(this);
		addJournal.addActionListener(this);
		removeJournal.addActionListener(this);
		logOut.addActionListener(this);
		
		add(panel);
		setTitle("Main Menu");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==addBook){ //if they are adding a book
			this.dispose(); //close the window
			AddBookGUI AddBook = new AddBookGUI(); //open relevant GUI
		}
		if (e.getSource()==removeBook){
			this.dispose();
			RemoveBookGUI RemoveBook = new RemoveBookGUI(); //open removeBook GUI
		}
		if (e.getSource()==logOut){
			SystemManager.logout(); //log the librarian out
			JOptionPane.showMessageDialog(this, "Successfully logged out."); //show message
			this.dispose();
			LoginGUI login = new LoginGUI();
		}
	}
	
	public static void main(String[] args){
		LibrarianGUI librarian = new LibrarianGUI();
	}
}
