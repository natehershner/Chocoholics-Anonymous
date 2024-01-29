/**
 * The ProviderTerminal class manages the Provider Terminal GUI, allowing providers to perform
 * various actions such as verifying member numbers, accessing the provider directory, and billing ChocAn.
 * It includes methods for creating and handling the terminal frame, checking the validity of member numbers,
 * identifying suspended members, and responding to user actions.
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ProviderTerminal implements ActionListener, MouseListener {

    private JFrame providerTerminalFrame;
    private JPanel providerTerminalPanel;
    private JTextField codeField;
    private boolean isFirstKeyTyped = true;

    /**
     * Constructs a new ProviderTerminal instance, initializing and displaying the terminal frame.
     */
    public ProviderTerminal() {
        providerTerminalFrame = new JFrame("Provider Terminal");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        providerTerminalFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Return Home");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
        
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        
        providerTerminalPanel = new JPanel();
        providerTerminalPanel.setLayout(new BoxLayout(providerTerminalPanel, BoxLayout.Y_AXIS));
        providerTerminalPanel.setBackground(new Color(0xFF9966));
        providerTerminalPanel.setBorder(new LineBorder(Color.decode("#CC6600"),5));

        // Add your provider login components here
        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon("resources/Provider.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#CC6600"),5));

        JLabel headerLabel = new JLabel("Provider Terminal");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        providerTerminalPanel.add(imageLabel);
        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        providerTerminalPanel.add(headerLabel);
        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

        providerTerminalFrame.add(providerTerminalPanel);
        
       
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(providerTerminalFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        providerTerminalFrame.setSize(windowWidth, windowHeight);
        providerTerminalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close only the providerFrame
        providerTerminalFrame.setLocationRelativeTo(null); // Center on screen
        providerTerminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        providerTerminalFrame.setVisible(true);
        
        
        codeField = new JTextField();
        codeField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        codeField.setMaximumSize(new Dimension(700, 50));
        codeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        codeField.setText("Enter Member Number");
        
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
        
        JButton checkCodeButton = createButton("Verify Member");
        checkCodeButton.addActionListener(this);
        checkCodeButton.setPreferredSize(new Dimension(500, 100));
        checkCodeButton.setMaximumSize(new Dimension(350, 75));
        checkCodeButton.setFont(new Font("Rockwell", Font.BOLD, 30));
        checkCodeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        providerTerminalPanel.add(codeField);
        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        providerTerminalPanel.add(checkCodeButton);
        
        JButton directory = createButton("Provider Directory");
        directory.addActionListener(this);
        directory.setPreferredSize(new Dimension(500, 100));
        directory.setMaximumSize(new Dimension(450, 100));
        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        directory.setFont(new Font("Rockwell", Font.BOLD, 30));
        directory.setAlignmentX(Component.CENTER_ALIGNMENT);
        providerTerminalPanel.add(directory);
        directory.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        JButton billChocAn = createButton("Bill ChocAn");
        billChocAn.addActionListener(this);
        billChocAn.setPreferredSize(new Dimension(500, 100));
        billChocAn.setMaximumSize(new Dimension(450, 100));
        billChocAn.setFont(new Font("Rockwell", Font.BOLD, 30));
        billChocAn.setAlignmentX(Component.CENTER_ALIGNMENT);
        providerTerminalPanel.add(billChocAn);

        providerTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        providerTerminalPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
       
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
            button.setBackground(Color.decode("#CC6600"));
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
             providerTerminalFrame.dispose();
             
         }else if (clickedButton.getText().equals("Verify Member")) {
             // Check the entered code
             String enteredCode = codeField.getText();

             if (Validators.isValidMemberCode(enteredCode)) {
            	codeField.setText("Validated");
             }else if(Validators.isSuspendedMemberCode(enteredCode)) {
             	codeField.setText("Suspended Membership Number");
                 
             }else {
                codeField.setText("Invalid Membership Number");
                 
             }
         }
         else if(clickedButton.getText().equals("Provider Directory")) {
        	 new ProviderDirectory();
        	 providerTerminalFrame.dispose();
             
       } else if(clickedButton.getText().equals("Bill ChocAn")) {
    	   new BillChocAn();
      	 providerTerminalFrame.dispose();
         
   }
		
	}
}
