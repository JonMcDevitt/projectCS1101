import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class AddBookGUI extends JDialog implements ActionListener{
	private JPanel panel;
	private JLabel ISBN, Author, Title, Genre, Language;
	private JButton AddBook, ReturnToMain;
	private JTextField ISBNInput, AuthorInput, TitleInput, GenreInput, LanguageInput;
	
	public AddBookGUI(){
		panel = new JPanel();
		ISBN = new JLabel("ISBN:");
		Author = new JLabel("Author:");
		Title = new JLabel("Title:");
		Genre = new JLabel("Genre:");
		Language = new JLabel("Language:");
		AddBook = new JButton("Add Book");
		ReturnToMain = new JButton("Return to Main");
		ISBNInput = new JTextField(30);
		AuthorInput = new JTextField(30);
		TitleInput = new JTextField(30);
		GenreInput = new JTextField(30);
		LanguageInput = new JTextField(30);
		
		panel.add(ISBN);
		panel.add(ISBNInput);
		panel.add(Author);
		panel.add(AuthorInput);
		panel.add(Title);
		panel.add(TitleInput);
		panel.add(Genre);
		panel.add(GenreInput);
		panel.add(Language);
		panel.add(LanguageInput);
		panel.add(AddBook);
		panel.add(ReturnToMain);
		AddBook.addActionListener(this);
		ReturnToMain.addActionListener(this);
		
		add(panel);
		setTitle("Add Book Menu");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==AddBook){
			Book a = new Book(ISBNInput.getSelectedText(), AuthorInput.getSelectedText(), TitleInput.getSelectedText(), GenreInput.getSelectedText(), LanguageInput.getSelectedText());
			JOptionPane.showMessageDialog(this, "Book added.");
		}
		if (e.getSource()==ReturnToMain){
			LibrarianGUI libgui = new LibrarianGUI();
		}
	}
	public static void main(String[] args){
		AddBookGUI addBook = new AddBookGUI();
	}
}
