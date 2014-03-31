import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class LoginGUI extends JFrame implements ActionListener
{
	private JPanel panel;
	private JRadioButton lib, user;
	private JLabel areyou, username, password;
	private JTextField userinput, pwinput;
	private JButton login;
	
	public LoginGUI()
	{
		panel= new JPanel();
		areyou= new JLabel("Who are you?");
		lib=new JRadioButton("Librarian");
		user= new JRadioButton("User");
		username= new JLabel("Username");
		password= new JLabel("Password");
		userinput= new JTextField(30);
		userinput.setEditable(true);
		pwinput= new JTextField(30);
		pwinput.setEditable(true);
		login= new JButton("Log In");
		login.setBackground(Color.GREEN);
		login.setOpaque(true); //for mac
		login.setBorderPainted(false);//for mac
		panel.add(areyou);
		panel.add(lib);
		panel.add(user);
		panel.add(username);
		panel.add(userinput);
		panel.add(password);
		panel.add(pwinput);
		panel.add(login);
		add(panel);
		username.setVisible(false);
		password.setVisible(false);
		userinput.setVisible(false);
		pwinput.setVisible(false);
		login.setVisible(false);
		user.addActionListener(this);
		lib.addActionListener(this);
		setTitle("Login");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==lib)
		{
			areyou.setVisible(false);
			lib.setVisible(false);
			user.setVisible(false);
			username.setVisible(true);
			userinput.setVisible(true);
			password.setVisible(true);
			pwinput.setVisible(true);
			login.setVisible(true);
		}
		if(e.getSource()==user)
		{
			areyou.setVisible(false);
			lib.setVisible(false);
			user.setVisible(false);
			username.setVisible(true);
			userinput.setVisible(true);
			password.setVisible(true);
			pwinput.setVisible(true);
			login.setVisible(true);
		}
	}
	//to test
	public static void main(String[] args)
	{
		LoginGUI gui = new LoginGUI();
	}
}
