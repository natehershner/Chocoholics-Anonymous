/**
 * The OperatorTerminal class represents a graphical user interface (GUI) for the operator terminal.
 * It provides access to various functionalities such as editing members, editing providers, and viewing reports.
 * The class implements ActionListener and MouseListener interfaces to handle button actions and mouse events.
 *
 * @author Nathaniel_Hershner
 * 
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

public class OperatorTerminal implements ActionListener, MouseListener{

    private JFrame operatorTerminalFrame;
    private JPanel operatorTerminalPanel;

    /**
     * Constructs an OperatorTerminal object and initializes the GUI components.
     */
    public OperatorTerminal() {
        operatorTerminalFrame = new JFrame("Operator Terminal");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        operatorTerminalFrame.setIconImage(frameIcon.getImage());
        
        
        operatorTerminalPanel = new JPanel();
        operatorTerminalPanel.setLayout(new BoxLayout(operatorTerminalPanel, BoxLayout.Y_AXIS));
        operatorTerminalPanel.setBackground(new Color(0x996666));
        operatorTerminalPanel.setBorder(new LineBorder(Color.decode("#993366"),5));

        // Add operator terminal components to the panel
        operatorTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon("resources/Operator1.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"),5));

        JLabel headerLabel = new JLabel("Operator Terminal");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));
        // Add components to the panel
        operatorTerminalPanel.add(imageLabel);
        operatorTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        operatorTerminalPanel.add(headerLabel);
        operatorTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

        operatorTerminalFrame.add(operatorTerminalPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(operatorTerminalFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        operatorTerminalFrame.setSize(windowWidth, windowHeight);
        operatorTerminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
     // Configure the main frame
        operatorTerminalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close only the providerFrame
        operatorTerminalFrame.setLocationRelativeTo(null); // Center on screen
        operatorTerminalFrame.setVisible(true);
     // Create and configure buttons
        JButton button = createButton("Return Home");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
     // Create and configure buttons
        JButton buttonMember = createButton("Edit Members");
        buttonMember.addActionListener(this);
        buttonMember.setPreferredSize(new Dimension(500, 100));
        buttonMember.setMaximumSize(new Dimension(450, 100));
     // Create and configure buttons
        JButton buttonProvider = createButton("Edit Providers");
        buttonProvider.addActionListener(this);
        buttonProvider.setPreferredSize(new Dimension(500, 100));
        buttonProvider.setMaximumSize(new Dimension(450, 100));
     // Create and configure buttons
        JButton buttonReports = createButton("View Reports");
        buttonReports.addActionListener(this);
        buttonReports.setPreferredSize(new Dimension(500, 100));
        buttonReports.setMaximumSize(new Dimension(450, 100));
     // Create and configure buttons
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        buttonMember.setFont(buttonFont);
        buttonProvider.setFont(buttonFont);
        buttonReports.setFont(buttonFont);
        
     // Add buttons to the panel
        operatorTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        operatorTerminalPanel.add(buttonReports);
        buttonReports.setAlignmentX(Component.CENTER_ALIGNMENT);
        operatorTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        operatorTerminalPanel.add(buttonMember);
        buttonMember.setAlignmentX(Component.CENTER_ALIGNMENT);
        operatorTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        operatorTerminalPanel.add(buttonProvider);
        buttonProvider.setAlignmentX(Component.CENTER_ALIGNMENT);
        operatorTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        operatorTerminalPanel.add(button);
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
            button.setBackground(Color.decode("#993366"));
		}	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setBackground(UIManager.getColor("Button.background")); // Reset to default background
        }
		
	}
    
	/**
     * Allows user to select from one of four button options
     *
     * 
     */
    @Override
	public void actionPerformed(ActionEvent e) {
	     JButton clickedButton = (JButton) e.getSource();

         if (clickedButton.getText().equals("Return Home")) {
             // Dispose of the current frame
        	 new GUI();
             operatorTerminalFrame.dispose();
         }
         else if(clickedButton.getText().equals("Edit Members")) {
        	 new EditMembers();
        	 operatorTerminalFrame.dispose();
       } else if(clickedButton.getText().equals("Edit Providers")) {
    	    new EditProviders();
      	 	operatorTerminalFrame.dispose();

   }
       else if(clickedButton.getText().equals("View Reports")) {
    	     new ViewReports();
        	 operatorTerminalFrame.dispose();
     }
		
	}
}