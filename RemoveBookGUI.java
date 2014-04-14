import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class RemoveBookGUI extends JDialog implements ActionListener{
	private JPanel panel;
	private JLabel ISBN;
	private JTextField ISBNInput;
	private JButton RemoveBook;
	
	public RemoveBookGUI(){
		panel = new JPanel();
		ISBN = new JLabel("ISBN:");
		ISBNInput = new JTextField(30);
		RemoveBook = new JButton("Remove Book");
		
		panel.add(ISBN);
		panel.add(ISBNInput);
		panel.add(RemoveBook);
		add(panel, BorderLayout.CENTER);
		setTitle("Remove Book Menu");
		setSize(400, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveBookGUI removeBook = new RemoveBookGUI();
	}


}
