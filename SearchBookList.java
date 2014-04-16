import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;
import java.io.*;

public class SearchBookList extends JDialog implements ActionListener{

	private JList list;
    private DefaultListModel listModel;
    private JButton reserveButton;
    private JPanel panel;
    ArrayList<Book> books;
    
	public SearchBookList(ArrayList<Book> books) 
	{
		this.books = books;
		panel= new JPanel();
		listModel = new DefaultListModel();
		for(int i = 0; i < books.size(); i++)
		{
			Book temp = books.get(i);
			String str = temp.getTitle() + "; " + temp.getAuthor() + "; " + temp.getISBN();
			listModel.addElement(str);
		}
        
        
      //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        
        reserveButton = new JButton("reserve");
        
        panel.add(listScrollPane);
        panel.add(reserveButton);
        panel.add(reserveButton);
        add(panel);
        reserveButton.setActionCommand("Reserve");
        reserveButton.addActionListener(this);
        
        setTitle("Login");
		setSize(1000, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == reserveButton)
		{
			System.out.println(SystemManager.getGeneralUser().getOutstandingFine());
			int index = list.getSelectedIndex();
			
			System.out.println(books.get(index).toString());
			int result = SystemManager.reserveBook(books.get(index));
			
			if(result == -1)
				JOptionPane.showMessageDialog(this, "User already has reserved 8 books", "Error", JOptionPane.ERROR_MESSAGE);
			else if(result == -3)
				JOptionPane.showMessageDialog(this, "User has outstanding fines", "Error", JOptionPane.ERROR_MESSAGE);
			else if(result == 0)
			{
				JOptionPane.showMessageDialog(this, "Book reserved successfully");
				this.dispose();
			}
			System.out.println(books.get(index).toString());

		}
	}
	public static void main(String[] args)throws IOException
	{
		SearchBookList gui = new SearchBookList(Factory.createBooks());
	}
}


