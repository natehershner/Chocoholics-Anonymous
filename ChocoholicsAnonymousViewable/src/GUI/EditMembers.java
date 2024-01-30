/**
 * 
 *
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */
/**
 * The EditMembers class provides a graphical user interface for managing member-related operations.
 * Users can choose to add a new member, edit an existing member, or delete a member.
 * It implements ActionListener and MouseListener interfaces to handle user interactions.
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditMembers implements ActionListener, MouseListener{

    private JFrame EditMembersTerminalFrame;
    private JPanel EditMembersTerminalPanel;

    /**
     * Constructs an instance of the EditMembers class, initializing the graphical user interface
     * for member-related operations. It includes buttons for adding, editing, and deleting members.
     */
    public EditMembers() {
        EditMembersTerminalFrame = new JFrame("Edit Members");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        EditMembersTerminalFrame.setIconImage(frameIcon.getImage());
        
        
        EditMembersTerminalPanel = new JPanel();
        EditMembersTerminalPanel.setLayout(new BoxLayout(EditMembersTerminalPanel, BoxLayout.Y_AXIS));
        EditMembersTerminalPanel.setBackground(new Color(0x996666));
        EditMembersTerminalPanel.setBorder(new LineBorder(Color.decode("#993366"),5));

        // Add your provider login components here
        EditMembersTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Operator1.png"));;
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"),5));

        JLabel headerLabel = new JLabel("Edit Members");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        EditMembersTerminalPanel.add(imageLabel);
        EditMembersTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        EditMembersTerminalPanel.add(headerLabel);
        EditMembersTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

        EditMembersTerminalFrame.add(EditMembersTerminalPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(EditMembersTerminalFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        EditMembersTerminalFrame.setSize(windowWidth, windowHeight);
        
        
        EditMembersTerminalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close only the providerFrame
        EditMembersTerminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        EditMembersTerminalFrame.setLocationRelativeTo(null); // Center on screen
        EditMembersTerminalFrame.setVisible(true);
        
        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
        
        JButton buttonMember = createButton("Edit Current Member");
        buttonMember.addActionListener(this);
        buttonMember.setPreferredSize(new Dimension(500, 100));
        buttonMember.setMaximumSize(new Dimension(450, 100));
        
        JButton buttonProvider = createButton("Add New Member");
        buttonProvider.addActionListener(this);
        buttonProvider.setPreferredSize(new Dimension(500, 100));
        buttonProvider.setMaximumSize(new Dimension(450, 100));
        
        JButton buttonReports = createButton("Delete Member");
        buttonReports.addActionListener(this);
        buttonReports.setPreferredSize(new Dimension(500, 100));
        buttonReports.setMaximumSize(new Dimension(450, 100));
        
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        buttonMember.setFont(buttonFont);
        buttonProvider.setFont(buttonFont);
        buttonReports.setFont(buttonFont);
        
        
        EditMembersTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        EditMembersTerminalPanel.add(buttonProvider);
        buttonReports.setAlignmentX(Component.CENTER_ALIGNMENT);
        EditMembersTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        EditMembersTerminalPanel.add(buttonMember);
        buttonMember.setAlignmentX(Component.CENTER_ALIGNMENT);
        EditMembersTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        EditMembersTerminalPanel.add(buttonReports);
        buttonProvider.setAlignmentX(Component.CENTER_ALIGNMENT);
        EditMembersTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        EditMembersTerminalPanel.add(button);
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

	/**
     * Handles the mouseEntered event for buttons, changing their background color when the mouse enters.
     *
     * @param e The MouseEvent object representing the mouse event.
     */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setBackground(Color.decode("#993366"));
		}	
		
	}

	/**
     * Handles the mouseExited event for buttons, resetting their background color when the mouse exits.
     *
     * @param e The MouseEvent object representing the mouse event.
     */
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setBackground(UIManager.getColor("Button.background")); // Reset to default background
        }
		
	}
    
	/**
     * Handles the actionPerformed event, determining which button was clicked and taking appropriate action.
     *
     * @param e The ActionEvent object representing the action event.
     */
    @Override
	public void actionPerformed(ActionEvent e) {
	     JButton clickedButton = (JButton) e.getSource();

         if (clickedButton.getText().equals("Return to Terminal")) {
             // Dispose of the current frame
        	 new OperatorTerminal();
             EditMembersTerminalFrame.dispose();
         }
         else if(clickedButton.getText().equals("Add New Member")) {
        	 new AddNewMember();
        	 EditMembersTerminalFrame.dispose();
       } else if(clickedButton.getText().equals("Edit Current Member")) {
    	     new EditCurrentMembers();
      	 	 EditMembersTerminalFrame.dispose();
   }
       else if(clickedButton.getText().equals("Delete Member")) {
    	     new DeleteMembers();
        	 EditMembersTerminalFrame.dispose();
     }
		
	}
}