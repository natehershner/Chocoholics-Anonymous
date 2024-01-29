/**
 * The ProviderLogin class manages the Provider Login GUI, allowing providers to enter their
 * provider number for verification. It includes methods for creating and handling the login frame,
 * checking the validity of the entered provider number, and responding to user actions.
 *
 * @author Nathaniel_Hershner
 * @since 2024-01-27
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class ProviderLogin implements ActionListener, MouseListener{

    private JFrame providerFrame;
    private JPanel providerPanel;
    private JTextField codeField;
    private boolean isFirstKeyTyped = true;

    /**
     * Constructs a new ProviderLogin instance, initializing and displaying the login frame.
     */
    public ProviderLogin() {
        providerFrame = new JFrame("Provider Login");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        providerFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Return Home");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        providerPanel = new JPanel();
        providerPanel.setLayout(new BoxLayout(providerPanel, BoxLayout.Y_AXIS));
        providerPanel.setBackground(new Color(0xd2b48c));
        providerPanel.setBorder(new LineBorder(Color.decode("#964B00"),5));

        // Add your operator login components here
        providerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/ChocAnLogo2.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#964B00"),5));

        JLabel headerLabel = new JLabel("Provider Login");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        providerPanel.add(imageLabel);
        providerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        providerPanel.add(headerLabel);
        providerPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Add spacing

        providerFrame.add(providerPanel);
        
        
        codeField = new JTextField();
        codeField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        codeField.setMaximumSize(new Dimension(700, 50));
        codeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        codeField.setText("Enter Provider Number");
        
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

        providerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        providerPanel.add(codeField);
        providerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        providerPanel.add(checkCodeButton);

        providerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        providerPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(providerFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        providerFrame.setSize(windowWidth, windowHeight);
        
        providerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close only the operatorFrame
        providerFrame.setLocationRelativeTo(null); // Center on screen
        providerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        providerFrame.setVisible(true);
    }
    
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
            button.setBackground(Color.decode("#664229"));
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
		 if (e.getSource() instanceof JButton) {
             JButton clickedButton = (JButton) e.getSource();

             if (clickedButton.getText().equals("Return Home")) {
                 // Dispose of the current frame
            	 new GUI();
                 providerFrame.dispose();

                 
                 
             } else if (clickedButton.getText().equals("Verify Number")) {
                 // Check the entered code
            	 
                 String enteredCode = codeField.getText();

                 if (Validators.isValidProviderCode(enteredCode)) {
                	 new ProviderTerminal();
                	 providerFrame.dispose();
                     
                 } else {
                	 codeField.setText("Invalid Number");
                 }
             }
		
	    }
	}
}