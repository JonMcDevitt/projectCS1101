import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PayFine extends JDialog implements ActionListener
{
	private JPanel panel;
	private JLabel fine;
   private JLabel welcome;
	private JTextField input;
	private JButton payFine;
	private JButton returnMain;
	
	public PayFine()
	{
		panel=new JPanel();
		welcome=new JLabel("Outstanding fine - $0");
		fine=new JLabel("Enter an amount to be paid:");
		input=new JTextField(10);
		input.setEditable(true);
		payFine=new JButton("Pay Fine");
		payFine.addActionListener(this);
		returnMain=new JButton("Return to Main");
		returnMain.setBackground(Color.RED);
		returnMain.setOpaque(true); //mac
		returnMain.setBorderPainted(false);//mac
		returnMain.addActionListener(this);

		panel.add(welcome);
		panel.add(fine);
		panel.add(input);
		panel.add(payFine);
		panel.add(returnMain);
		
		add(panel);			
		setTitle("Fine Payment");
		setSize(290,170);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== payFine)
		   {
		   	JOptionPane.showMessageDialog(this, "Thank you!"); //return to the main menu
		   	this.dispose(); //close window
		   	GeneralUserGUI usergui = new GeneralUserGUI(); //return them to the main menu
		   }
		if(e.getSource()== returnMain)
   		{
   			this.dispose(); //close this window
			GeneralUserGUI usergui = new GeneralUserGUI(); //return them to the main meny
	   	}
	}
	
	public static void main(String[] args)
	{
		PayFine gui=new PayFine();
	}
   
}
