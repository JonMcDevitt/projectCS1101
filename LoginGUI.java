import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginGUI extends JFrame implements ActionListener
{
	private JPanel panel;
	private JRadioButton lib, user;
	private JLabel areyou, username, password;
	private JTextField userinput;
	private JPasswordField pwinput;
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
		//userinput.setEditable(true);
		pwinput= new JPasswordField(30);
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
		login.addActionListener(this);
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
		if(e.getSource() == login)
		{
			System.out.println(userinput.getText() + "\t" + pwinput.getText());
			int result = SystemManager.loginLibrarian(userinput.getText(), pwinput.getText());
			if(result == -2)
				JOptionPane.showMessageDialog(this, "User does not exist", "Error", JOptionPane.ERROR_MESSAGE);
			else if(result == -3)
				JOptionPane.showMessageDialog(this, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
			else if(result == 0)
			{
				JOptionPane.showMessageDialog(this, "User logged in successfully");
				// set LoginGUI to invisible and open Librarian GUI 
				
			}
		}
	}
	//to test
	public static void main(String[] args)
	{
		LoginGUI gui = new LoginGUI();
	}
}
