import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class SearchFunctionGUI extends JDialog implements ActionListener
{
	private JPanel panel;
	private JTextField searchinput;
	private JButton search, main;
	private JComboBox select, searchBy;
	private String[] choicesSelect= {"Select","Books", "Magazines", "NewsPapers", "Journals"};
	private String[] choicesSearchBy= {"Search by", "Author", "Title", "Genre"};
	
	public SearchFunctionGUI()
	{
		panel= new JPanel();
		searchinput= new JTextField(20);
		search= new JButton("Search");
		search.addActionListener(this);
		main= new JButton("Return to Main");
		main.addActionListener(this);
		select= new JComboBox(choicesSelect);
		searchBy= new JComboBox(choicesSearchBy);
		panel.add(searchinput);
		panel.add(search);
		panel.add(select);
		panel.add(searchBy);
		panel.add(main);
		add(panel);
		setTitle("Search");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==search)
		{
			String userInput, option;
			
			userInput = searchinput.getText();
			option = searchBy.getSelectedItem().toString();
			if(select.getSelectedItem().equals("Books"))
			{
				ArrayList<Book> books = SystemManager.searchBook(userInput, option);
				if(books == null)
					System.out.println("error");
				else
				{
					SearchBookList sbl = new SearchBookList(books);
				}
				
			}
		}
	}
	//to test
	public static void main(String[] args) 
	{
		SearchFunctionGUI gui = new SearchFunctionGUI();
	}
	
}