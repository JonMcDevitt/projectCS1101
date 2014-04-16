import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
public class ReturnBookGUI extends JDialog implements ActionListener
{
	private JPanel panel;
	private JLabel isbn;
	private JTextField input;
	private JButton returnBook;
	private JButton returnMain;
	
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
		panel.add(isbn);
		panel.add(input);
		panel.add(returnBook);
		panel.add(returnMain);
		add(panel);
		
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
			try {
				if (SystemManager.returnBook(input.getText())==0){
					JOptionPane.showMessageDialog(this, "Book returned.");
					GeneralUserGUI usergui = new GeneralUserGUI();
					this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(this, "Error, enter the correct ISBN.");
					GeneralUserGUI usergui = new GeneralUserGUI();
					this.dispose();
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== returnMain)
		{
			GeneralUserGUI usergui = new GeneralUserGUI();
			this.dispose();
		}
	}
	
	public static void main(String[] args)
	{
		ReturnBookGUI gui=new ReturnBookGUI();
	}
}
