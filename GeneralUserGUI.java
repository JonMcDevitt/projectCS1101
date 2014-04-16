import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class GeneralUserGUI extends JDialog implements ActionListener{
	private JPanel panel;
	private JButton searchBook, payFine, returnBook, checkStatus, logOut;
	
	public GeneralUserGUI(){
		panel = new JPanel(new GridLayout(9, 2));
		searchBook = new JButton("Search for Book");
		payFine = new JButton("Pay Fine");
		returnBook = new JButton("Return Book");
		checkStatus = new JButton("Check Status");
		logOut = new JButton("Log Out");
		panel.add(searchBook);
		panel.add(payFine);
		panel.add(returnBook);
		panel.add(checkStatus);
		panel.add(logOut);
		
		add(panel);
		searchBook.addActionListener(this);
		payFine.addActionListener(this);
		returnBook.addActionListener(this);
		checkStatus.addActionListener(this);
		logOut.addActionListener(this);
		setTitle("Main Menu");
		setSize(400, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==logOut){
			SystemManager.logout(); //log the user out
			JOptionPane.showMessageDialog(this, "User logged out successfully"); //display message			
			this.dispose(); //close window
			LoginGUI login = new LoginGUI(); //create new Login window
		}
		if (e.getSource()==returnBook){
			this.dispose(); //dispose of this window
			ReturnBookGUI returnbook = new ReturnBookGUI(); //open the Return Book GUI
		}
		if (e.getSource()==searchBook){
			this.dispose(); //dispose
			SearchFunctionGUI searchbook = new SearchFunctionGUI(); //open Search function
		}
		if (e.getSource()==payFine){
			this.dispose(); //dispose
			PayFine fine = new PayFine(); //open Search function
		}
		if (e.getSource()==checkStatus){
			this.dispose(); //dispose
			UserStatus check = new UserStatus(); //open Search function
		}
	}
	
	public static void main(String[] args){
		GeneralUserGUI user = new GeneralUserGUI();
	}
}