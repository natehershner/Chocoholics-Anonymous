/**
 * 
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The `AlterProvider` class provides functionality to edit and save provider information.
 * It includes a graphical user interface with text fields for various provider details.
 * The class implements ActionListener and MouseListener interfaces to handle user interactions.
 */
public class AlterProvider implements ActionListener, MouseListener{

	    private JFrame alterProviderFrame;
	    private JPanel alterProviderPanel;
	    private JTextField NameField;
	    private JTextField NumberField;
	    private JTextField AddressField;
	    private JTextField CityTextField;
	    private JTextField StateTextArea;
	    private JTextField ZipField;

	    /**
	     * Constructs an instance of the AlterProvider class.
	     *
	     * @param selectedValue The selected value used to identify the provider for editing.
	     */
    public AlterProvider(String selectedValue) {
    	alterProviderFrame = new JFrame("Edit Provider");
    	ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        alterProviderFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Go Back");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
        
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        alterProviderPanel = new JPanel();
        alterProviderPanel.setLayout(new BoxLayout(alterProviderPanel, BoxLayout.Y_AXIS));
        alterProviderPanel.setBackground(new Color(0x996666));
        alterProviderPanel.setBorder(new LineBorder(Color.decode("#993366"),5));

        // Add your provider login components here
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Operator1.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"),5));

        JLabel headerLabel = new JLabel("Edit Provider");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        alterProviderPanel.add(imageLabel);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(headerLabel);
        //billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        alterProviderFrame.add(alterProviderPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(alterProviderFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        alterProviderFrame.setSize(windowWidth, windowHeight);
        alterProviderFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        alterProviderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        alterProviderFrame.setLocationRelativeTo(null);
        alterProviderFrame.setVisible(true);
        
        NameField = new JTextField();
        NameField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        NameField.setMaximumSize(new Dimension(700, 50));
        NameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        
        NumberField = new JTextField();
        NumberField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        NumberField.setMaximumSize(new Dimension(700, 50));
        NumberField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        
        AddressField = new JTextField();
        AddressField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        AddressField.setMaximumSize(new Dimension(700, 50));
        AddressField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        CityTextField = new JTextField();
        CityTextField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        CityTextField.setMaximumSize(new Dimension(700, 50));
        CityTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
       
        ZipField = new JTextField();
        ZipField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        ZipField.setMaximumSize(new Dimension(700, 50));
        ZipField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        StateTextArea = new JTextField();
        StateTextArea.setFont(new Font("Rockwell", Font.PLAIN, 20));
        StateTextArea.setMaximumSize(new Dimension(700, 50));
        StateTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        // Restrict the length of the text to be no longer than 100 characters
        
        
        JButton sendBillButton = createButton("Save Provider");
        sendBillButton.addActionListener(this);
        sendBillButton.setPreferredSize(new Dimension(250, 50));
        sendBillButton.setMaximumSize(new Dimension(250, 50));
        sendBillButton.setFont(buttonFont);
        sendBillButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        /**
         * Adds key and mouse listeners to the provided text field to limit text length and handle mouse clicks.
         *
         * @param textField The text field to which listeners are added.
         * @param maxLength The maximum length allowed for the text in the text field.
         */
        NameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (NameField.getText().length() >= 25) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        NameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                NameField.setText("");
            }
        });
        
        NumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (NumberField.getText().length() >= 9) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        NumberField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                
            }
        });
        
        AddressField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (AddressField.getText().length() >= 25) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        AddressField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                AddressField.setText("");
            }
        });
        
        CityTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (CityTextField.getText().length() >= 14) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        CityTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                CityTextField.setText("");
            }
        });
        
        StateTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (StateTextArea.getText().length() >= 2) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        StateTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                StateTextArea.setText("");
            }
        });
        
        ZipField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (ZipField.getText().length() >= 5) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        ZipField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                ZipField.setText("");
            }
        });
        
        NameField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "name", "num", selectedValue));
    	StateTextArea.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "state", "num", selectedValue));
    	ZipField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "zipcode", "num", selectedValue));
    	AddressField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "address", "num", selectedValue));
    	CityTextField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "city", "num", selectedValue));
    	NumberField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "providerinfo", "num", "num", selectedValue));
    	NumberField.setEditable(false);
    	
    	
        
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(NameField);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(NumberField);
        NumberField.setEditable(false);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(AddressField);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(CityTextField);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(StateTextArea);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(ZipField);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(sendBillButton);
        alterProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        alterProviderPanel.add(button);
       
        
        

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
     * Handles action events, such as button clicks.
     *
     * @param e The ActionEvent representing the action event.
     */

	@Override
	public void actionPerformed(ActionEvent e) {
	    JButton clickedButton = (JButton) e.getSource();

	    
	     if (clickedButton.getText().equals("Save Provider")) {
	        // Show custom dialog for "Yes" and "No" options
	        int result = showYesNoDialog("Do you want to save the provider?");

	        // Handle the user's response
	        if (result == JOptionPane.YES_OPTION) {
	            // User clicked "Yes," handle accordingly
	            String enteredNameCode = NameField.getText();
	            String enteredZipCode = ZipField.getText();
	            String enteredCityCode = CityTextField.getText();
	            String enteredAddressCode = AddressField.getText();
	            String enteredNumberCode = NumberField.getText();
	            String enteredState = StateTextArea.getText();
	            int errorProof = 0;

	            if (errorProof == 0) {
	                
	                showOkDialog("Provider saving...");
	                
	                // Save the provider information to the file
	                try {
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "providerinfo", "name", enteredNameCode, "num", enteredNumberCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "providerinfo", "zipcode", enteredZipCode, "num", enteredNumberCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "providerinfo", "city", enteredCityCode, "num", enteredNumberCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "providerinfo", "address", enteredAddressCode, "num", enteredNumberCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "providerinfo", "state", enteredState, "num", enteredNumberCode);
	                } catch (Exception exc){
	                	exc.printStackTrace();
	                }
	                showOkDialog("Provider saved");
	                new EditCurrentProviders();
	                alterProviderFrame.dispose();
	            } else {
	                // User clicked "No" or closed the dialog, handle accordingly
	                showOkDialog("Provider not saved.");
	            }
	        }
	    } else if (clickedButton.getText().equals("Go Back")) {
	    	new EditCurrentProviders();
	    	alterProviderFrame.dispose();
	    }
	}

	
	 /**
     * Shows a dialog with "Yes" and "No" options.
     *
     * @param message The message to be displayed in the dialog.
     * @return The option chosen by the user (YES_OPTION or NO_OPTION).
     */
	private int showYesNoDialog(String message) {
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] options = {"Yes", "No"};
        return JOptionPane.showOptionDialog(
                alterProviderFrame,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                options,
                options[1]); // Default to "No"
    }
	 /**
     * Shows a dialog with OK option.
     *
     * @param message The message to be displayed in the dialog.
     * @return The option chosen by the user (OK_OPTION).
     */
	private int showOkDialog(String message) {
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] option = {"Okay"};
        return JOptionPane.showOptionDialog(
                alterProviderFrame,
                message,
                "Confirmation",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                option,
                option[0]);
                
    }
}