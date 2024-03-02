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
 * The AddNewMember class represents a graphical user interface for adding new members to a system.
 */
public class AddNewMember implements ActionListener, MouseListener {

  private JFrame addNewMemberTerminalFrame;
  private JPanel addNewMemberTerminalPanel;
  private JTextField memberNameField;
  private JTextField memberNumberField;
  private JTextField memberStreetAddressField;
  private JTextField memberCityField;
  private JTextField memberStateField;
  private JTextField memberZipField;
  
  /**
   * Constructs a new AddNewMember object, initializing the GUI components and displaying the frame.
   */

  public AddNewMember() {
    addNewMemberTerminalFrame = new JFrame("Add New Member");
    ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
    addNewMemberTerminalFrame.setIconImage(frameIcon.getImage());
        
        
    addNewMemberTerminalPanel = new JPanel();
    addNewMemberTerminalPanel.setLayout(new BoxLayout(addNewMemberTerminalPanel, BoxLayout.Y_AXIS));
    addNewMemberTerminalPanel.setBackground(new Color(0x996666));
    addNewMemberTerminalPanel.setBorder(new LineBorder(Color.decode("#993366"), 5));

    // Add your provider login components here
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
    ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Operator1.png"));
    JLabel imageLabel = new JLabel(imageIcon);
    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    imageLabel.setBorder(new LineBorder(Color.decode("#993366"), 5));

    JLabel headerLabel = new JLabel("Add New Member");
    headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

    addNewMemberTerminalPanel.add(imageLabel);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
    addNewMemberTerminalPanel.add(headerLabel);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

    addNewMemberTerminalFrame.add(addNewMemberTerminalPanel);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(addNewMemberTerminalFrame.getGraphicsConfiguration());
    int windowWidth = screenSize.width - (insets.left + insets.right);
    int windowHeight = screenSize.height - (insets.top + insets.bottom);
    addNewMemberTerminalFrame.setSize(windowWidth, windowHeight);
    addNewMemberTerminalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addNewMemberTerminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    addNewMemberTerminalFrame.setLocationRelativeTo(null);
    addNewMemberTerminalFrame.setVisible(true);
        
    JButton button = createButton("Go Back");
    button.addActionListener(this);
    button.setPreferredSize(new Dimension(500, 100));
    button.setMaximumSize(new Dimension(450, 100));
    Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
    button.setFont(buttonFont);
        
    JButton newbutton = createButton("Save New Member");
    newbutton.addActionListener(this);
    newbutton.setPreferredSize(new Dimension(350, 50));
    newbutton.setMaximumSize(new Dimension(350, 50));
    newbutton.setFont(buttonFont);
       
    memberNameField = new JTextField();
    memberNameField.setFont(new Font("Rockwell", Font.PLAIN, 20));
    memberNameField.setMaximumSize(new Dimension(700, 50));
    memberNameField.setAlignmentX(Component.CENTER_ALIGNMENT);
    memberNameField.setText("Member Name");
        
    memberNumberField = new JTextField();
    memberNumberField.setFont(new Font("Rockwell", Font.PLAIN, 20));
    memberNumberField.setMaximumSize(new Dimension(700, 50));
    memberNumberField.setAlignmentX(Component.CENTER_ALIGNMENT);
    memberNumberField.setText("Member Number");
        
    memberStreetAddressField = new JTextField();
    memberStreetAddressField.setFont(new Font("Rockwell", Font.PLAIN, 20));
    memberStreetAddressField.setMaximumSize(new Dimension(700, 50));
    memberStreetAddressField.setAlignmentX(Component.CENTER_ALIGNMENT);
    memberStreetAddressField.setText("Member Street Address");
        
    memberCityField = new JTextField();
    memberCityField.setFont(new Font("Rockwell", Font.PLAIN, 20));
    memberCityField.setMaximumSize(new Dimension(700, 50));
    memberCityField.setAlignmentX(Component.CENTER_ALIGNMENT);
    memberCityField.setText("Member City");
        
    memberStateField = new JTextField();
    memberStateField.setFont(new Font("Rockwell", Font.PLAIN, 20));
    memberStateField.setMaximumSize(new Dimension(700, 50));
    memberStateField.setAlignmentX(Component.CENTER_ALIGNMENT);
    memberStateField.setText("Member State");
        
    memberZipField = new JTextField();
    memberZipField.setFont(new Font("Rockwell", Font.PLAIN, 20));
    memberZipField.setMaximumSize(new Dimension(700, 50));
    memberZipField.setAlignmentX(Component.CENTER_ALIGNMENT);
    memberZipField.setText("Member Zipcode");
        
    memberNameField.addKeyListener(new KeyAdapter() {
      @Override
            public void keyTyped(KeyEvent e) {
            if (memberNameField.getText().length() >= 25) {
              e.consume(); // Ignore the key input if the length is already 9 or more
            }
          }
        });

    memberNameField.addMouseListener(new MouseAdapter() {
      @Override
            public void mouseClicked(MouseEvent e) {
            // Clear the text when the JTextField is clicked
            memberNameField.setText("");
          }
        });
        
    memberNumberField.addKeyListener(new KeyAdapter() {
      @Override
            public void keyTyped(KeyEvent e) {
            if (memberNumberField.getText().length() >= 9) {
              e.consume(); // Ignore the key input if the length is already 9 or more
            }
          }
        });

    memberNumberField.addMouseListener(new MouseAdapter() {
      @Override
            public void mouseClicked(MouseEvent e) {
            // Clear the text when the JTextField is clicked
            memberNumberField.setText("");
          }
        });
        
    memberStreetAddressField.addKeyListener(new KeyAdapter() {
      @Override
            public void keyTyped(KeyEvent e) {
            if (memberStreetAddressField.getText().length() >= 25) {
              e.consume(); // Ignore the key input if the length is already 9 or more
            }
          }
        });

    memberStreetAddressField.addMouseListener(new MouseAdapter() {
      @Override
            public void mouseClicked(MouseEvent e) {
            // Clear the text when the JTextField is clicked
            memberStreetAddressField.setText("");
          }
        });
        
    memberCityField.addKeyListener(new KeyAdapter() {
      @Override
            public void keyTyped(KeyEvent e) {
            if (memberCityField.getText().length() >= 14) {
              e.consume(); // Ignore the key input if the length is already 9 or more
            }
          }
        });

    memberCityField.addMouseListener(new MouseAdapter() {
      @Override
            public void mouseClicked(MouseEvent e) {
            // Clear the text when the JTextField is clicked
            memberCityField.setText("");
          }
        });
        
    memberStateField.addKeyListener(new KeyAdapter() {
        @Override
            public void keyTyped(KeyEvent e) {
            if (memberStateField.getText().length() >= 2) {
            e.consume(); // Ignore the key input if the length is already 9 or more
            }
          }
        });

    memberStateField.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            // Clear the text when the JTextField is clicked
            memberStateField.setText("");
          }
        });
        
    memberZipField.addKeyListener(new KeyAdapter() {
        @Override
            public void keyTyped(KeyEvent e) {
            if (memberZipField.getText().length() >= 5) {
            e.consume(); // Ignore the key input if the length is already 9 or more
            }
          }
        });

    memberZipField.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            // Clear the text when the JTextField is clicked
            memberZipField.setText("");
          }
        });
        
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(memberNameField);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(memberNumberField);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(memberStreetAddressField);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(memberCityField);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(memberStateField);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(memberZipField);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(newbutton);
    addNewMemberTerminalPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
    addNewMemberTerminalPanel.add(button);
    button.setAlignmentX(Component.CENTER_ALIGNMENT);
    newbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
 }
    
    /**
     * Creates a JButton with the specified text and adds a mouse listener.
     *
     * @param text The text to be displayed on the button.
     * @return The configured JButton.
     */

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addMouseListener(this); // Add mouse listener to the button
        button.setFocusPainted(false);
        return button;
    }
    
    /**
     * Handles the mouse click event for buttons.
     *
     * @param e The MouseEvent.
     */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles the mouse press event.
     *
     * @param e The MouseEvent.
     */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles the mouse release event.
     *
     * @param e The MouseEvent.
     */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Handles the mouse enter event for buttons, changing the background color.
     *
     * @param e The MouseEvent.
     */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setBackground(Color.decode("#993366"));
		}	
		
	}

	/**
     * Handles the mouse exit event for buttons, resetting the background color.
     *
     * @param e The MouseEvent.
     */
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setBackground(UIManager.getColor("Button.background")); // Reset to default background
        }
		
	}
    
	/**
     * Handles action events for buttons, such as "Go Back" and "Save New Member."
     *
     * @param e The ActionEvent.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
	    JButton clickedButton = (JButton) e.getSource();

	    if (clickedButton.getText().equals("Go Back")) {
	        // Dispose of the current frame
	    	new EditMembers();
	        addNewMemberTerminalFrame.dispose();
	        
	    } else if (clickedButton.getText().equals("Save New Member")) {
	        // Show custom dialog for "Yes" and "No" options
	        int result = showYesNoDialog("Do you want to save new member?");

	        // Handle the user's response
	        if (result == JOptionPane.YES_OPTION) {
	            // User clicked "Yes," handle accordingly
	            String Name = memberNameField.getText();
	            String Number = memberNumberField.getText();
	            String Address = memberStreetAddressField.getText();
	            String City = memberCityField.getText();
	            String State = memberStateField.getText();
	            String Zip = memberZipField.getText();
	            int errorProof = 0;

	            if (!Validators.isValidMemberCode(Number) && Number.length() == 9) {
	                // New member information
	            	try{
                    	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "memberinfo", "name", Name, "num", Number, "address", Address,
                    			"city", City, "state", State, "zipcode", Zip);
                    	CreateSQL.insertValue(CreateSQL.giveConnection(), "members", "valid", Integer.parseInt(Number));
                    	showOkDialog("Member saved");
                    } catch (SQLException ex) {
                    	ex.printStackTrace();
                    }
	            } else {
	                memberNumberField.setText("Invalid Member Code");
	                errorProof = 1;
	            }

	            if (errorProof == 1) {
	                // User clicked "No" or closed the dialog, handle accordingly
	                showOkDialog("Member not saved.");
	            }
	        }
	    }
	}	
    
    /**
     * Displays a dialog with an "OK" button and a custom icon.
     *
     * @param message The message to be displayed in the dialog.
     * @return The result of the dialog.
     */
  private int showOkDialog(String message) {
    ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
    Object[] option = {"Okay"};
    return JOptionPane.showOptionDialog(
                addNewMemberTerminalFrame,
                message,
                "Confirmation",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                option,
                option[0]);
                
  }
    
  /**
     * Displays a dialog with "Yes" and "No" options and a custom icon.
     *
     * @param message The message to be displayed in the dialog.
     * @return The result of the dialog.
     */
  private int showYesNoDialog(String message) {
    ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
    Object[] options = {"Yes", "No"};
    return JOptionPane.showOptionDialog(
                addNewMemberTerminalFrame,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                options,
                options[1]); // Default to "No"
  }
}
