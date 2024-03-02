/**
 * 
 *
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */
/**
 * The GUI class provides the main graphical user interface for the ChocAn system.
 * It includes buttons for Operator Login, Manager Login, Provider Login, and running the Main Accounting Procedure.
 * The class implements ActionListener and MouseListener to handle button clicks and mouse events.
 * It creates a JFrame with a background image, a logo, and multiple buttons for user interactions.
 * When a button is clicked, it disposes of the current frame and opens the corresponding login or procedure window.
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

 public class GUI implements ActionListener, MouseListener {

     private JFrame frame;
     private JPanel panel;

     /**
      * Constructs a new GUI object.
      */
     public GUI() {
         frame = new JFrame();
          
         ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        
         frame.setIconImage(frameIcon.getImage());

         JButton button = createButton("Provider Login");
         button.addActionListener(this);
         button.setPreferredSize(new Dimension(400, 100));
         button.setMaximumSize(new Dimension(600, 150));

         Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
         button.setFont(buttonFont);
         


         panel = new JPanel();
         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

         // Set the background to a hex color
         panel.setBackground(Color.decode("#d2b48c"));
         panel.setBorder(new LineBorder(Color.decode("#964B00"),5));
         panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
         ImageIcon imageIcon = new ImageIcon(getClass().getResource("/ChocAnLogo2.jpg"));
        
         JLabel imageLabel = new JLabel(imageIcon);
         imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         imageLabel.setBorder(new LineBorder(Color.decode("#964B00"),5));

         JLabel headerLabel = new JLabel("Welcome to Chocoholics Anonymous");
         headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

         panel.add(imageLabel);
         panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
         panel.add(headerLabel);
         panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

         
         panel.add(button);

         panel.add(Box.createRigidArea(new Dimension(0, 15))); // Add spacing

         JButton button2 = createButton("Operator Login");
         button2.addActionListener(this);
         button2.setPreferredSize(new Dimension(400, 100));
         button2.setMaximumSize(new Dimension(600, 150));
         panel.add(button2);
         button2.setFont(buttonFont);

         panel.add(Box.createRigidArea(new Dimension(0, 15))); // Add spacing

         JButton button3 = createButton("Manager Login");
         button3.addActionListener(this);
         button3.setPreferredSize(new Dimension(400, 100));
         button3.setMaximumSize(new Dimension(600, 150));
         panel.add(button3);
         button3.setFont(buttonFont);
         
         panel.add(Box.createRigidArea(new Dimension(0, 15))); // Add spacing 
         JButton button4 = createButton("Run Main Accounting Procedure");
         button4.addActionListener(this);
         button4.setPreferredSize(new Dimension(400, 100));
         button4.setMaximumSize(new Dimension(600, 150));
         panel.add(button4);
         button4.setFont(buttonFont);
         
         JButton button5 = createButton("Edit SQL Info");
         button5.addActionListener(this);
         button5.setPreferredSize(new Dimension(400, 100));
         button5.setMaximumSize(new Dimension(600, 150));
         panel.add(Box.createRigidArea(new Dimension(0, 15)));
         button5.setFont(buttonFont);
         panel.add(button5);
         button.setAlignmentX(Component.CENTER_ALIGNMENT);
         button2.setAlignmentX(Component.CENTER_ALIGNMENT);
         button3.setAlignmentX(Component.CENTER_ALIGNMENT);
         button4.setAlignmentX(Component.CENTER_ALIGNMENT);
         button5.setAlignmentX(Component.CENTER_ALIGNMENT);

         frame.add(panel);

         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setTitle("ChocAn System");

         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
         int windowWidth = screenSize.width - (insets.left + insets.right);
         int windowHeight = screenSize.height - (insets.top + insets.bottom);
         frame.setSize(windowWidth, windowHeight);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLocationRelativeTo(null);
         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         frame.setVisible(true);
     }

     /**
      * Creates a JButton with specified text and adds a mouse listener to it.
      *
      * @param text The text to be displayed on the button.
      * @return The created JButton.
      */
     private JButton createButton(String text) {
         JButton button = new JButton(text);
         button.addMouseListener(this); // Add mouse listener to the button
         button.setFocusPainted(false);
         
         return button;
     }

     /**
      * The main method to start the GUI.
      *
      * @param args The command-line arguments.
      */
     public static void main(String[] args) {
         new CreateSQL();
     }

     /**
      * Handles the actionPerformed event when a button is clicked.
      *
      * @param e The ActionEvent object.
      */
     @Override
     public void actionPerformed(ActionEvent e) {
        
    	// Check which button is clicked
         if (e.getSource() instanceof JButton) {
             JButton clickedButton = (JButton) e.getSource();

             if (clickedButton.getText().equals("Operator Login")) {
                 // Dispose of the current frame
            	 new OperatorLogin();
                 frame.dispose();

                 // Open OperatorLogin when Operator Login button is clicked
                 
             }
             else if (clickedButton.getText().equals("Manager Login")) {
                 // Dispose of the current frame
            	 new ManagerLogin();
                 frame.dispose();

                 // Open ManagerLogin when Manager Login button is clicked
                 
             }
             else if (clickedButton.getText().equals("Provider Login")) {
                 // Dispose of the current frame
            	 new ProviderLogin();
                 frame.dispose();

                 // Open ProviderLogin when Provider Login button is clicked
                 
             }
             else if(clickedButton.getText().equals("Run Main Accounting Procedure"))
             {
            	 int result = JOptionPane.showConfirmDialog(frame, "Do you want to run Main Accounting Procedure?", "Confirmation", JOptionPane.YES_NO_OPTION);

         	    if (result == JOptionPane.YES_OPTION) {
         	    	new RunMainAccountingProcedure();
         	    	frame.dispose();
         	    }
             } else if(clickedButton.getText().equals("Edit SQL Info"))
               {
            	 int result = JOptionPane.showConfirmDialog(frame, "Do you want to Edit SQL Info?", "Confirmation", JOptionPane.YES_NO_OPTION);

         	    if (result == JOptionPane.YES_OPTION) {
         	    	new SetSqlInfo();
         	    	frame.dispose();
         	    }
             }
         }
     }

     /**
      * Handles the mouseClicked event.
      *
      * @param e The MouseEvent object.
      */
     // MouseListener methods
     @Override
     public void mouseClicked(MouseEvent e) {
    	 
     }

     /**
      * Handles the mousePressed event.
      *
      * @param e The MouseEvent object.
      */
     @Override
     public void mousePressed(MouseEvent e) {
    	 
     }

     /**
      * Handles the mouseReleased event.
      *
      * @param e The MouseEvent object.
      */
     @Override
     public void mouseReleased(MouseEvent e) {
    	
     }

     /**
      * Handles the mouseEntered event by changing the background color of the button.
      *
      * @param e The MouseEvent object.
      */
     @Override
     public void mouseEntered(MouseEvent e) {
         if (e.getSource() instanceof JButton) {
             JButton button = (JButton) e.getSource();
             button.setBackground(Color.decode("#664229"));
         }
     }

     /**
      * Handles the mouseExited event by resetting the background color of the button.
      *
      * @param e The MouseEvent object.
      */
     @Override
     public void mouseExited(MouseEvent e) {
         if (e.getSource() instanceof JButton) {
             JButton button = (JButton) e.getSource();
             button.setBackground(UIManager.getColor("Button.background")); // Reset to default background
         }
     }
 }