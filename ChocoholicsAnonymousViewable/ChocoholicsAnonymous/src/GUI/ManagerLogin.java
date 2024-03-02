/**
 * 
 *
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */
/**
 * The ManagerLogin class provides the graphical user interface for Manager login in the ChocAn system.
 * It includes components such as a text field to enter the manager number, a button to verify the number,
 * and a button to return to the home screen. The class implements ActionListener and MouseListener to handle
 * button clicks and mouse events. It also performs validation of the entered manager number.
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class ManagerLogin implements ActionListener, MouseListener{

    private JFrame managerFrame;
    private JPanel managerPanel;
    private JTextField codeField;
    private boolean isFirstKeyTyped = true;


    /**
     * Constructs a new ManagerLogin object, creating the Manager Login GUI.
     */
    public ManagerLogin() {
        managerFrame = new JFrame("Manager Login");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        managerFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Return Home");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        managerPanel = new JPanel();
        managerPanel.setLayout(new BoxLayout(managerPanel, BoxLayout.Y_AXIS));
        managerPanel.setBackground(new Color(0xd2b48c));
        managerPanel.setBorder(new LineBorder(Color.decode("#964B00"),5));

        // Add your manager login components here
        managerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/ChocAnLogo2.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#964B00"),5));

        JLabel headerLabel = new JLabel("Manager Login");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        managerPanel.add(imageLabel);
        managerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        managerPanel.add(headerLabel);
        managerPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Add spacing

        managerFrame.add(managerPanel);
        
        
        codeField = new JTextField();
        codeField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        codeField.setMaximumSize(new Dimension(700, 50));
        codeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        codeField.setText("Enter Manager Number");
        
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

        managerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        managerPanel.add(codeField);
        managerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        managerPanel.add(checkCodeButton);

        managerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        managerPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(managerFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        managerFrame.setSize(windowWidth, windowHeight);
        managerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
        managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managerFrame.setLocationRelativeTo(null); // Center on screen
        managerFrame.setVisible(true);
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
     * Handles the mouseClicked event.
     *
     * @param e The MouseEvent object.
     */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles the mousePressed event.
     *
     * @param e The MouseEvent object.
     */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles the mouseReleased event.
     *
     * @param e The MouseEvent object.
     */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	/**
     * Handles the actionPerformed event.
     *
     * @param e The ActionEvent object.
     */
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();

            if (clickedButton.getText().equals("Return Home")) {
                // Dispose of the current frame
            	new GUI();
                managerFrame.dispose();
            }else if (clickedButton.getText().equals("Verify Number")) {
                // Check the entered code
           	 
                String enteredCode = codeField.getText();

                if (Validators.isValidManagerCode(enteredCode)) {
                	new ManagerTerminal();
               	 	managerFrame.dispose();
                } else {
               	 codeField.setText("Invalid Number");
                }
            }
		
	 }
	}
}
