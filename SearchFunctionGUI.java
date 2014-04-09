import javax.swing.*;
import java.awt.event.*;
public class SearchFunctionGUI extends JFrame implements ActionListener
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==search)
		{
			if(select.getSelectedItem().equals("Books") && searchBy.getSelectedItem().equals("Author"))
				System.out.println("Books and Author selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Books") && searchBy.getSelectedItem().equals("Title"))
				System.out.println("Books and Title selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Books") && searchBy.getSelectedItem().equals("Genre"))
				System.out.println("Books and Genre selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Magazines") && searchBy.getSelectedItem().equals("Author"))
				System.out.println("Magazines and Author selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Magazines") && searchBy.getSelectedItem().equals("Title"))
				System.out.println("Magazines and Title selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Magazines") && searchBy.getSelectedItem().equals("Genre"))
				System.out.println("Magazines and Genre selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("NewsPapers") && searchBy.getSelectedItem().equals("Author"))
				System.out.println("Newspapers and Author selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("NewsPapers") && searchBy.getSelectedItem().equals("Title"))
				System.out.println("Newspapers and Title selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("NewsPapers") && searchBy.getSelectedItem().equals("Genre"))
				System.out.println("Newspapers and Genre selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Journals") && searchBy.getSelectedItem().equals("Author"))
				System.out.println("Journals and Author selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Journals") && searchBy.getSelectedItem().equals("Title"))
				System.out.println("Journals and Title selected"); //test, actually go to another GUI/class
			if(select.getSelectedItem().equals("Journals") && searchBy.getSelectedItem().equals("Genre"))
				System.out.println("Journals and Genre selected"); //test, actually go to another GUI/class
		}
	}
	//to test
	public static void main(String[] args) 
	{
		SearchFunctionGUI gui = new SearchFunctionGUI();
	}
	
}