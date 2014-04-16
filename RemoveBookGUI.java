import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
public class RemoveBookGUI extends JDialog implements ActionListener{
	private JPanel panel;
	private JLabel ISBN;
	private JTextField ISBNInput;
	private JButton RemoveBook, ReturnToMain;
	
	public RemoveBookGUI(){
		panel = new JPanel();
		ISBN = new JLabel("ISBN:");
		ISBNInput = new JTextField(30);
		RemoveBook = new JButton("Remove Book");
		ReturnToMain = new JButton("Return to Main");
		
		panel.add(ISBN);
		panel.add(ISBNInput);
		panel.add(RemoveBook);
		panel.add(ReturnToMain);
		add(panel, BorderLayout.CENTER);
		RemoveBook.addActionListener(this);
		ReturnToMain.addActionListener(this);
		setTitle("Remove Book Menu");
		setSize(400, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==ReturnToMain){
			this.dispose();
			LibrarianGUI libgui = new LibrarianGUI();
		}
		if (e.getSource()==RemoveBook){
			try {
				if (SystemManager.removeBook(ISBNInput.getText())==true){
					JOptionPane.showMessageDialog(this, "Book returned.");
					LibrarianGUI libgui = new LibrarianGUI(); //open new main meny
					this.dispose(); //close the window
				}
				else{
					JOptionPane.showMessageDialog(this, "Error, enter the correct ISBN.");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveBookGUI removeBook = new RemoveBookGUI();
	}


}
