import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class AddBookGUI extends JDialog implements ActionListener{
	private JPanel panel, panel1, panel2, panel3, panel4;
	private JLabel ISBN, Author, Title, Genre, Language;
	private JButton AddBook, ReturnToMain;
	private JTextField ISBNInput, AuthorInput, TitleInput, GenreInput, LanguageInput;
	
	public AddBookGUI(){
		panel = new JPanel(new GridLayout(6, 2));
		ISBN = new JLabel("ISBN:");
		Author = new JLabel("Author:");
		Title = new JLabel("Title:");
		Genre = new JLabel("Genre:");
		Language = new JLabel("Language:");
		AddBook = new JButton("Add Book");
		ReturnToMain = new JButton("Return to Main");
		ISBNInput = new JTextField(50);
		AuthorInput = new JTextField(50);
		TitleInput = new JTextField(50);
		GenreInput = new JTextField(50);
		LanguageInput = new JTextField(50);
		
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
		setSize(300, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==AddBook){
			Book a = new Book(ISBNInput.getSelectedText(), AuthorInput.getSelectedText(), TitleInput.getSelectedText(), GenreInput.getSelectedText(), LanguageInput.getSelectedText());
			try {
				SystemManager.addBook(a);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Book added.");
			this.dispose();
			LibrarianGUI libgui = new LibrarianGUI();
		}
		if (e.getSource()==ReturnToMain){
			this.dispose();
			LibrarianGUI libgui = new LibrarianGUI();
		}
	}
	public static void main(String[] args){
		AddBookGUI addBook = new AddBookGUI();
	}
}
