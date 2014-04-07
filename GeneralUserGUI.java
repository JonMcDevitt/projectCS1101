import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class GeneralUserGUI extends JFrame implements ActionListener{
	private JPanel panel;
	private JButton searchBook, reserveBook, payFine, returnBook, checkStatus, logOut;
	
	public GeneralUserGUI(){
		panel = new JPanel(new GridLayout(9, 2));
		searchBook = new JButton("Search for Book");
		reserveBook = new JButton("Reserve Book");
		payFine = new JButton("Pay Fine");
		returnBook = new JButton("Return Book");
		checkStatus = new JButton("Check Status");
		logOut = new JButton("Log Out");
		panel.add(searchBook);
		panel.add(reserveBook);
		panel.add(payFine);
		panel.add(returnBook);
		panel.add(checkStatus);
		panel.add(logOut);
		
		add(panel);
		setTitle("Main Menu");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public static void main(String[] args){
		GeneralUserGUI user = new GeneralUserGUI();
	}
}