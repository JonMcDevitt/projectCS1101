import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UserStatus extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel curRes;
	private JLabel remRes;
	private JLabel curFine;
	private JButton returnMain;
	
	public UserStatus()
	{
      int reser = SystemManager.getGeneralUser().getTotalOfReservations();
		panel=new JPanel();
		curRes=new JLabel("Current Reservations: "+reser);
		remRes=new JLabel("Reservations Remaining: "+(reser - 8));
		curFine=new JLabel("Current Fine: $0");
		returnMain=new JButton("Return to Main");
		returnMain.setBackground(Color.RED);
		returnMain.setOpaque(true); //mac
		returnMain.setBorderPainted(false);//mac
		returnMain.addActionListener(this);
      panel.add(curRes);
		panel.add(remRes);
		panel.add(curFine);
		panel.add(returnMain);
		add(panel);
		
		setTitle("User Status");
		setSize(230,170);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== returnMain)
   		{
   			this.dispose();
   			GeneralUserGUI gui = new GeneralUserGUI();
	   	}
	}
   
	public static void main(String[] args)
	{
		UserStatus gui=new UserStatus();
	}
   
}
