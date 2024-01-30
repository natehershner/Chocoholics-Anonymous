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
import java.sql.SQLException;

/**
 * The AddNewProvider class represents a GUI for adding a new provider.
 * It includes fields for provider information and provides functionality
 * to save the new provider to a file.
 */
public class AddNewProvider implements ActionListener, MouseListener{

    private JFrame AddNewProviderTerminalFrame;
    private JPanel AddNewProviderTerminalPanel;
	private JTextField ProviderNameField;
	private JTextField ProviderNumberField;
	private JTextField ProviderStreetAddressField;
	private JTextField ProviderCityField;
	private JTextField ProviderStateField;
	private JTextField ProviderZipField;
	
	/**
     * Constructs an instance of the AddNewProvider class.
     * Initializes the GUI components and sets up the frame.
     */

    public AddNewProvider() {
        AddNewProviderTerminalFrame = new JFrame("Add New Provider");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        AddNewProviderTerminalFrame.setIconImage(frameIcon.getImage());
        
        
        AddNewProviderTerminalPanel = new JPanel();
        AddNewProviderTerminalPanel.setLayout(new BoxLayout(AddNewProviderTerminalPanel, BoxLayout.Y_AXIS));
        AddNewProviderTerminalPanel.setBackground(new Color(0x996666));
        AddNewProviderTerminalPanel.setBorder(new LineBorder(Color.decode("#993366"),5));

        // Add your provider login components here
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Operator1.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"),5));

        JLabel headerLabel = new JLabel("Add New Provider");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        AddNewProviderTerminalPanel.add(imageLabel);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        AddNewProviderTerminalPanel.add(headerLabel);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

        AddNewProviderTerminalFrame.add(AddNewProviderTerminalPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(AddNewProviderTerminalFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        AddNewProviderTerminalFrame.setSize(windowWidth, windowHeight);
        AddNewProviderTerminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        AddNewProviderTerminalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AddNewProviderTerminalFrame.setLocationRelativeTo(null);
        AddNewProviderTerminalFrame.setVisible(true);
        
        JButton button = createButton("Go Back");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        
        JButton Newbutton = createButton("Save New Provider");
        Newbutton.addActionListener(this);
        Newbutton.setPreferredSize(new Dimension(350, 50));
        Newbutton.setMaximumSize(new Dimension(350, 50));
        Newbutton.setFont(buttonFont);
       
        ProviderNameField = new JTextField();
        ProviderNameField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        ProviderNameField.setMaximumSize(new Dimension(700, 50));
        ProviderNameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        ProviderNameField.setText("Provider Name");
        
        ProviderNumberField = new JTextField();
        ProviderNumberField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        ProviderNumberField.setMaximumSize(new Dimension(700, 50));
        ProviderNumberField.setAlignmentX(Component.CENTER_ALIGNMENT);
        ProviderNumberField.setText("Provider Number");
        
        ProviderStreetAddressField = new JTextField();
        ProviderStreetAddressField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        ProviderStreetAddressField.setMaximumSize(new Dimension(700, 50));
        ProviderStreetAddressField.setAlignmentX(Component.CENTER_ALIGNMENT);
        ProviderStreetAddressField.setText("Provider Street Address");
        
        ProviderCityField = new JTextField();
        ProviderCityField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        ProviderCityField.setMaximumSize(new Dimension(700, 50));
        ProviderCityField.setAlignmentX(Component.CENTER_ALIGNMENT);
        ProviderCityField.setText("Provider City");
        
        ProviderStateField = new JTextField();
        ProviderStateField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        ProviderStateField.setMaximumSize(new Dimension(700, 50));
        ProviderStateField.setAlignmentX(Component.CENTER_ALIGNMENT);
        ProviderStateField.setText("Provider State");
        
        ProviderZipField = new JTextField();
        ProviderZipField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        ProviderZipField.setMaximumSize(new Dimension(700, 50));
        ProviderZipField.setAlignmentX(Component.CENTER_ALIGNMENT);
        ProviderZipField.setText("Provider Zipcode");
        
        ProviderNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (ProviderNameField.getText().length() >= 25) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        ProviderNameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                ProviderNameField.setText("");
            }
        });
        
        ProviderNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (ProviderNumberField.getText().length() >= 9) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        ProviderNumberField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                ProviderNumberField.setText("");
            }
        });
        
        ProviderStreetAddressField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (ProviderStreetAddressField.getText().length() >= 25) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        ProviderStreetAddressField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                ProviderStreetAddressField.setText("");
            }
        });
        
        ProviderCityField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (ProviderCityField.getText().length() >= 14) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        ProviderCityField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                ProviderCityField.setText("");
            }
        });
        
        ProviderStateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (ProviderStateField.getText().length() >= 2) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        ProviderStateField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                ProviderStateField.setText("");
            }
        });
        
        ProviderZipField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (ProviderZipField.getText().length() >= 5) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        ProviderZipField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                ProviderZipField.setText("");
            }
        });
        
        
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(ProviderNameField);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(ProviderNumberField);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(ProviderStreetAddressField);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(ProviderCityField);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(ProviderStateField);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(ProviderZipField);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(Newbutton);
        AddNewProviderTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        AddNewProviderTerminalPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Newbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    

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
    
	@Override
	public void actionPerformed(ActionEvent e) {
	    JButton clickedButton = (JButton) e.getSource();

	    if (clickedButton.getText().equals("Go Back")) {
	        // Dispose of the current frame
	    	new EditProviders();
	        AddNewProviderTerminalFrame.dispose();
	    } else if (clickedButton.getText().equals("Save New Provider")) {
	        // Show custom dialog for "Yes" and "No" options
	        int result = showYesNoDialog("Do you want to save new provider");

	        // Handle the user's response
	        if (result == JOptionPane.YES_OPTION) {
	            // User clicked "Yes," handle accordingly
	            String Name = ProviderNameField.getText();
	            String Number = ProviderNumberField.getText();
	            String Address = ProviderStreetAddressField.getText();
	            String City = ProviderCityField.getText();
	            String State = ProviderStateField.getText();
	            String Zip = ProviderZipField.getText();
	            int errorProof = 0;

	            if (!Validators.isValidProviderCode(Number) && Number.length() == 9) {
	                // New member information
	            	try{
                    	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "providerinfo", "name", Name, "num", Number, "address", Address,
                    			"city", City, "state", State, "zipcode", Zip);
                    	CreateSQL.insertValue(CreateSQL.giveConnection(), "validproviders", "nums", Integer.parseInt(Number));
                    } catch (SQLException ex) {
                    	ex.printStackTrace();
                    }
	                showOkDialog("New Provider saved");
	               
	            }
	             else {
	                ProviderNumberField.setText("Invalid Provider Number");
	                errorProof = 1;
	            }

	            if (errorProof == 1) {
	                // User clicked "No" or closed the dialog, handle accordingly
	                showOkDialog("Member not saved.");
	            }
	        }
	    }
	}
    
    
    private int showOkDialog(String message) {
    	ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] option = {"Okay"};
        return JOptionPane.showOptionDialog(
                AddNewProviderTerminalFrame,
                message,
                "Confirmation",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                option,
                option[0]);
                
    }
    
    private int showYesNoDialog(String message) {
    	ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] options = {"Yes", "No"};
        return JOptionPane.showOptionDialog(
                AddNewProviderTerminalFrame,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                options,
                options[1]); // Default to "No"
    }
}
