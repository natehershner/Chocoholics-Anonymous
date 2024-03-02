/**
 * The ManagerTerminal class represents a graphical user interface (GUI) for the manager's terminal.
 * It provides options to print various reports and navigate back to the home screen.
 *
 * @author Nathaniel_Hershner
 * @since 2024-01-27
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The ManagerTerminal class implements ActionListener and MouseListener interfaces
 * to handle button actions and mouse events. It contains a GUI with buttons for printing
 * different reports and returning to the home screen.
 */
public class ManagerTerminal implements ActionListener, MouseListener {

  private JFrame managerTerminalFrame;
  private JPanel managerTerminalPanel;

  /**
   * Constructs a ManagerTerminal object and initializes the GUI components.
   */
  public ManagerTerminal() {
	    managerTerminalFrame = new JFrame("Manager Terminal");
	    ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
	    managerTerminalFrame.setIconImage(frameIcon.getImage());
	        
	        
	    managerTerminalPanel = new JPanel();
	    managerTerminalPanel.setLayout(new BoxLayout(managerTerminalPanel, BoxLayout.Y_AXIS));
	    managerTerminalPanel.setBackground(new Color(0xADD8E6));
	    managerTerminalPanel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

	    // Add your manager login components here
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
	    ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Manager.png"));
	    JLabel imageLabel = new JLabel(imageIcon);
	    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    imageLabel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

	    JLabel headerLabel = new JLabel("Manager Terminal");
	    headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

	    managerTerminalPanel.add(imageLabel);
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
	    managerTerminalPanel.add(headerLabel);
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

	    managerTerminalFrame.add(managerTerminalPanel);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    managerTerminalFrame.setSize(screenSize);
	    managerTerminalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    managerTerminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    managerTerminalFrame.setLocationRelativeTo(null);
	    managerTerminalFrame.setVisible(true);
	        
	        
	    JButton button = createButton("Return Home");
	    button.addActionListener(this);
	    button.setPreferredSize(new Dimension(500, 100));
	    button.setMaximumSize(new Dimension(450, 100));
	        
	    JButton buttonMember = createButton("Print Member Report");
	    buttonMember.addActionListener(this);
	    buttonMember.setPreferredSize(new Dimension(500, 100));
	    buttonMember.setMaximumSize(new Dimension(450, 100));
	        
	    JButton buttonReports = createButton("Print Provider Report");
	    buttonReports.addActionListener(this);
	    buttonReports.setPreferredSize(new Dimension(500, 100));
	    buttonReports.setMaximumSize(new Dimension(450, 100));
	        
	    JButton buttonEFT = createButton("Print EFT Report");
	    buttonEFT.addActionListener(this);
	    buttonEFT.setPreferredSize(new Dimension(500, 100));
	    buttonEFT.setMaximumSize(new Dimension(450, 100));
	        
	    JButton buttonSummary = createButton("Print Summary Report");
	    buttonSummary.addActionListener(this);
	    buttonSummary.setPreferredSize(new Dimension(500, 100));
	    buttonSummary.setMaximumSize(new Dimension(450, 100));
	        
	    Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
	    button.setFont(buttonFont);
	    buttonMember.setFont(buttonFont);
	    buttonReports.setFont(buttonFont);
	    buttonEFT.setFont(buttonFont);
	    buttonSummary.setFont(buttonFont);
	        
	        
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
	    managerTerminalPanel.add(buttonReports);
	    buttonReports.setAlignmentX(Component.CENTER_ALIGNMENT);
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
	    managerTerminalPanel.add(buttonMember);
	    buttonMember.setAlignmentX(Component.CENTER_ALIGNMENT);
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
	    managerTerminalPanel.add(buttonEFT);
	    buttonEFT.setAlignmentX(Component.CENTER_ALIGNMENT);
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
	    managerTerminalPanel.add(buttonSummary);
	    buttonSummary.setAlignmentX(Component.CENTER_ALIGNMENT);
	    managerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
	        
	    managerTerminalPanel.add(button);
	    button.setAlignmentX(Component.CENTER_ALIGNMENT);
	  }
    /**
     * Creates a JButton with the specified text and adds a mouse listener to it.
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
    
  @Override
  public void mouseClicked(MouseEvent e) {
  // TODO Auto-generated method stub
	
  }

  @Override
  public void mousePressed(MouseEvent e) {
  // TODO Auto-generated method stub
	
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  // TODO Auto-generated method stub
	
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    if (e.getSource() instanceof JButton) {
      JButton button = (JButton) e.getSource();
      button.setBackground(Color.decode("#0047AB"));
    }	
	
  }

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setBackground(UIManager.getColor("Button.background")); // Reset to default background
        }
		
	}
    
    @Override
	public void actionPerformed(ActionEvent e) {
	     JButton clickedButton = (JButton) e.getSource();

         if (clickedButton.getText().equals("Return Home")) {
             // Dispose of the current frame
             new GUI();
             managerTerminalFrame.dispose();
         }
         else if(clickedButton.getText().equals("Print Member Report")) {
             new PrintMemberReport();
             managerTerminalFrame.dispose();
       } 
       else if(clickedButton.getText().equals("Print EFT Report")) {;
           new PrintEFTReport();
           managerTerminalFrame.dispose();
     }
       else if(clickedButton.getText().equals("Print Provider Report")) {
    	   new PrintProviderReport();
           managerTerminalFrame.dispose();
   }
       else if(clickedButton.getText().equals("Print Summary Report")) {
      	 
    	   int result = JOptionPane.showConfirmDialog(managerTerminalFrame, "Do you want to print a Summary Report?", "Confirmation", JOptionPane.YES_NO_OPTION);

    	    if (result == JOptionPane.YES_OPTION) {
    	    	new PrintSummaryReport();
    	        managerTerminalFrame.dispose();
    	    } else {
    	        // User clicked No, handle accordingly or do nothing
    	    }
   }
		
	}
}