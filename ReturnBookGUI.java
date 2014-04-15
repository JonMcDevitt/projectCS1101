import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class ReturnBookGUI extends JDialog implements ActionListener
{
	private JPanel panel;
	private JLabel isbn;
	private JTextField input;
	private JButton returnBook;
	private JButton returnMain;
	private JLabel bookReturned;
	
	public ReturnBookGUI()
	{
		panel=new JPanel();
		isbn=new JLabel("ISBN Number:");
		input=new JTextField(20);
		input.setEditable(true);
		returnBook=new JButton("Return book");
		returnBook.addActionListener(this);
		returnMain=new JButton("Return to Main");
		returnMain.setBackground(Color.RED);
		returnMain.setOpaque(true); //mac
		returnMain.setBorderPainted(false);//mac
		returnMain.addActionListener(this);
		bookReturned=new JLabel("Book returned.");
		panel.add(isbn);
		panel.add(input);
		panel.add(returnBook);
		panel.add(bookReturned);
		panel.add(returnMain);
		add(panel);
		bookReturned.setVisible(false);
		
		setTitle("Return book");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== returnBook)
		{
			bookReturned.setVisible(true);
			//return book statements
		}
		if(e.getSource()== returnMain)
		{
			//GeneralUser gu= new GeneralUser;
			System.out.println("return to main"); //test
		}
	}
	
	public static void main(String[] args)
	{
		ReturnBookGUI gui=new ReturnBookGUI();
	}
}
