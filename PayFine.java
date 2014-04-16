import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PayFine extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel fine;
   private JLabel welcome;
	private JTextField input;
	private JButton payFine;
	private JButton returnMain;
	private JLabel finePaid;
	
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
		finePaid=new JLabel("Fine Paid.");
      panel.add(welcome);
		panel.add(fine);
		panel.add(input);
      panel.add(payFine);
		panel.add(returnMain);
		add(panel);
		finePaid.setVisible(false);
		
		setTitle("Fine Payment");
		setSize(290,170);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== payFine)
		   {
            //if (input  0)
		   	finePaid.setVisible(true);
		   	JOptionPane.showMessageDialog(this, "Thank you!");
		   }
		if(e.getSource()== returnMain)
   		{
   			System.out.println("return to main"); //test
	   	}
	}
	
	public static void main(String[] args)
	{
		PayFine gui=new PayFine();
	}
   
}
