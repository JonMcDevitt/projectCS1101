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
	private JButton loginGeneralUser, loginLibrarian;
	
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
		loginGeneralUser= new JButton("Log In");
		loginGeneralUser.setBackground(Color.GREEN);
		loginGeneralUser.setOpaque(true); //for mac
		loginGeneralUser.setBorderPainted(false);//for mac
		loginLibrarian= new JButton("Log In");
		loginLibrarian.setBackground(Color.GREEN);
		loginLibrarian.setOpaque(true); //for mac
		loginLibrarian.setBorderPainted(false);//for mac
		panel.add(areyou);
		panel.add(lib);
		panel.add(user);
		panel.add(username);
		panel.add(userinput);
		panel.add(password);
		panel.add(pwinput);
		panel.add(loginGeneralUser);
		panel.add(loginLibrarian);
		add(panel);
		username.setVisible(false);
		password.setVisible(false);
		userinput.setVisible(false);
		pwinput.setVisible(false);
		loginGeneralUser.setVisible(false);
		loginLibrarian.setVisible(false);
		user.addActionListener(this);
		lib.addActionListener(this);
		loginGeneralUser.addActionListener(this);
		loginLibrarian.addActionListener(this);
		setTitle("Login");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			loginGeneralUser.setVisible(false);
			loginLibrarian.setVisible(true);
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
			loginGeneralUser.setVisible(true);
			loginLibrarian.setVisible(false);
		}
		if(e.getSource() == loginGeneralUser)
		{
			int result = SystemManager.loginGeneralUser(userinput.getText(), pwinput.getText());
			if(result == -2)
				JOptionPane.showMessageDialog(this, "User aadoes not exist", "Error", JOptionPane.ERROR_MESSAGE);
			else if(result == -3)
				JOptionPane.showMessageDialog(this, "Invalid password", "Error", JOptionPane.ERROR_MESSAGE);
			else if(result == 0)
			{
				JOptionPane.showMessageDialog(this, "User logged in successfully");
				this.setVisible(false);
				GeneralUserGUI usergui = new GeneralUserGUI();
				
			}
		}
		if(e.getSource() == loginLibrarian)
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
				LibrarianGUI libgui = new LibrarianGUI();
				
			}
		}
	}
	//to test
	public static void main(String[] args)
	{
		LoginGUI gui = new LoginGUI();
	}
}
