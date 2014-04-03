import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Frame extends JFrame {
   int windowWidth = 600;
   int windowHeight = 400;
   public Frame() {
      setSize(windowWidth, windowHeight);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Set layout for the whole dialog
      JPanel contentPane = (JPanel)this.getContentPane();
      contentPane.setLayout(new BorderLayout());
      
      // Set layout for contactListPane
      JPanel contactListPanel = new JPanel();
      contactListPanel.setLayout(new GridLayout(15, 1)); // 15 rows, 1 column
      contactListPanel.setMinimumSize(new Dimension(windowWidth, windowHeight));
      contactListPanel.setPreferredSize(new Dimension(windowWidth, windowHeight));
      contactListPanel.setMaximumSize(new Dimension(windowWidth, windowHeight));
      
      //(...)
      
      //Add a button for each contact in the address book (from a LinkedList)
      for (int i=0; i<15; i++)
      {
         JButton button = new JButton();
         button.setText(" Jones, Jim " + i); //contactList.get(i).getSurname() + ", " + contactList.get(i).getGivenName());
         contactListPanel.add(button);
      }
      
      //(...)
      
      JScrollPane scrollPane = new JScrollPane(contactListPanel);
      // Add the contactListPane to the main content area (inside scrollPane)
      contentPane.add(scrollPane, BorderLayout.CENTER);
      setVisible(true);
   
   }
}