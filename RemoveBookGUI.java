import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class RemoveBookGUI extends JFrame{
	private JPanel panel;
	private JLabel ISBN;
	private JTextField ISBNInput;
	private JButton RemoveBook;
	
	public RemoveBookGUI(){
		panel = new JPanel();
		ISBN = new JLabel("ISBN:");
		ISBNInput = new JTextField(30);
		RemoveBook = new JButton("Remove Book");
		
		add(panel, BorderLayout.CENTER);
		panel.add(ISBN);
		panel.add(ISBNInput);
		panel.add(RemoveBook);
		setTitle("Remove Book Menu");
		setSize(400, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void ActionPerformer(ActionEvent e){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveBookGUI removeBook = new RemoveBookGUI();
	}

}
