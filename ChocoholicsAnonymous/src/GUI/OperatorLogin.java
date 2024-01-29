/**
 * The OperatorLogin class represents a graphical user interface (GUI) for operator login.
 * It allows operators to enter their codes for verification and provides access to the OperatorTerminal upon successful verification.
 *
 * The GUI includes a header, an image logo, a text field for entering the operator code, and buttons for verification and returning home.
 * The class implements ActionListener and MouseListener interfaces to handle button actions and mouse events.
 *
 * @author Nathaniel_Hershner
 * @since 2024-01-27
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class OperatorLogin implements ActionListener, MouseListener{

    private JFrame operatorFrame;
    private JPanel operatorPanel;
    private JTextField codeField;
    private boolean isFirstKeyTyped = true;


    /**
     * Constructs an OperatorLogin object and initializes the GUI components.
     */
    public OperatorLogin() {
    	
        operatorFrame = new JFrame("Operator Login");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        operatorFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Return Home");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        operatorPanel = new JPanel();
        operatorPanel.setLayout(new BoxLayout(operatorPanel, BoxLayout.Y_AXIS));
        operatorPanel.setBackground(new Color(0xd2b48c));
        operatorPanel.setBorder(new LineBorder(Color.decode("#964B00"),5));

        // Add your operator login components here
        operatorPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon("resources/ChocAnLogo2.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#964B00"),5));

        JLabel headerLabel = new JLabel("Operator Login");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        operatorPanel.add(imageLabel);
        operatorPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        operatorPanel.add(headerLabel);
        operatorPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Add spacing

        operatorFrame.add(operatorPanel);
        
        
        codeField = new JTextField();
        codeField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        codeField.setMaximumSize(new Dimension(700, 50));
        codeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        codeField.setText("Enter Operator Number");
        
        codeField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                codeField.setText("");
            }
        });
        
        codeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Clear the text only on the first key typed
                if (isFirstKeyTyped) {
                    codeField.setText("");
                    isFirstKeyTyped = false;
                }
            }
        });

        JButton checkCodeButton = createButton("Verify Number");
        checkCodeButton.addActionListener(this);
        checkCodeButton.setPreferredSize(new Dimension(500, 100));
        checkCodeButton.setMaximumSize(new Dimension(350, 75));
        checkCodeButton.setFont(new Font("Rockwell", Font.BOLD, 30));
        checkCodeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkCodeButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        operatorPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        operatorPanel.add(codeField);
        operatorPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        operatorPanel.add(checkCodeButton);

        operatorPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        operatorPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(operatorFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        operatorFrame.setSize(windowWidth, windowHeight);
        operatorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        operatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close only the operatorFrame
        operatorFrame.setLocationRelativeTo(null); // Center on screen
        operatorFrame.setVisible(true);
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

    /**
     * Handles mouse-click events.
     *
     * @param e The MouseEvent to be handled.
     */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles mouse-press events.
     *
     * @param e The MouseEvent to be handled.
     */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles mouse-release events.
     *
     * @param e The MouseEvent to be handled.
     */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles mouse-enter events.
     *
     * @param e The MouseEvent to be handled.
     */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setBackground(Color.decode("#664229"));
		}		
	}

	/**
     * Handles mouse-exit events.
     *
     * @param e The MouseEvent to be handled.
     */
	@Override
	public void mouseExited(MouseEvent e) {
		 if (e.getSource() instanceof JButton) {
             JButton button = (JButton) e.getSource();
             button.setBackground(UIManager.getColor("Button.background")); // Reset to default background
         }
		
	}
	
	 /**
     * Handles action events triggered by buttons.
     *
     * @param e The ActionEvent to be handled.
     */
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();

            if (clickedButton.getText().equals("Return Home")) {
                // Dispose of the current frame
            	new GUI();
                operatorFrame.dispose();

                

            } else if (clickedButton.getText().equals("Verify Number")) {
                // Check the entered code
           	 
                String enteredCode = codeField.getText();

                if (Validators.isValidOperatorCode(enteredCode)) {
                	
                    new OperatorTerminal();
                    operatorFrame.dispose();
                } else {
               	 codeField.setText("Invalid Number");
                }
            }
		
	 }
	}
}