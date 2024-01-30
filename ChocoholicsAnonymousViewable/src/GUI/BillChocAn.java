/**
 * The BillChocAn class represents the graphical user interface for processing and sending bills in the ChocAn system.
 * It includes components for entering information about the service, member, and provider, as well as handling user
 * interactions such as button clicks and mouse events.
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
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Constructs an instance of the BillChocAn class, initializing the GUI components.
 */
public class BillChocAn implements ActionListener, MouseListener {

    private JFrame billChocAnFrame;
    private JPanel billChocAnPanel;
    private JTextField codeField;
    private boolean isFirstKeyTyped = true;
    private JLabel dateLabel; 
    private JLabel performedLabel; 
    private JTextField performedField;
    private JTextField providerTextField;
    private JTextField memberTextField;
    private JTextArea commentsTextArea;
    private JTextField selectedValueTextField;
    

    public BillChocAn() {
    	
    	
        
        billChocAnFrame = new JFrame("Bill ChocAn");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        billChocAnFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
        
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        
        billChocAnPanel = new JPanel();
        billChocAnPanel.setLayout(new BoxLayout(billChocAnPanel, BoxLayout.Y_AXIS));
        billChocAnPanel.setBackground(new Color(0xFF9966));
        billChocAnPanel.setBorder(new LineBorder(Color.decode("#CC6600"),5));

        // Add your provider login components here
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Provider.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#CC6600"),5));

        JLabel headerLabel = new JLabel("Bill ChocAn");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        billChocAnPanel.add(imageLabel);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(headerLabel);
        //billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        billChocAnFrame.add(billChocAnPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        billChocAnFrame.setSize(screenSize);
        billChocAnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billChocAnFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        billChocAnFrame.setLocationRelativeTo(null);
        billChocAnFrame.setVisible(true);
        
        codeField = new JTextField();
        codeField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        codeField.setMaximumSize(new Dimension(700, 50));
        codeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        codeField.setText("MM–DD–YYYY HH:MM:SS");
        
        dateLabel = new JLabel("Current Date and Time:");
        dateLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        performedField = new JTextField();
        performedField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        performedField.setMaximumSize(new Dimension(700, 50));
        performedField.setAlignmentX(Component.CENTER_ALIGNMENT);
        performedField.setText("MM–DD–YYYY HH:MM:SS");
        
        performedLabel = new JLabel("Date service was provided:");
        performedLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
        performedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        performedField.setText("MM–DD–YYYY");
        
        
        providerTextField = new JTextField();
        providerTextField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        providerTextField.setMaximumSize(new Dimension(700, 50));
        providerTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        providerTextField.setText("Provider Number");
        
        memberTextField = new JTextField();
        memberTextField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        memberTextField.setMaximumSize(new Dimension(700, 50));
        memberTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        memberTextField.setText("Member Number");
        
       
        selectedValueTextField = new JTextField();
        selectedValueTextField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        selectedValueTextField.setMaximumSize(new Dimension(700, 50));
        selectedValueTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectedValueTextField.setText("Service Code");
        
        
        commentsTextArea = new JTextArea();
        commentsTextArea.setFont(new Font("Rockwell", Font.PLAIN, 20));
        commentsTextArea.setLineWrap(true); // Enable text wrapping
        commentsTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        commentsTextArea.setMaximumSize(new Dimension(700, 100));
        commentsTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        commentsTextArea.setText("Additional Comments");

        // Restrict the length of the text to be no longer than 100 characters
        commentsTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (commentsTextArea.getText().length() >= 100) {
                    e.consume(); // Ignore the key input if the length is already 100 or more
                }
            }
        });

        commentsTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextArea is clicked
                commentsTextArea.setText("");
            }
        });
       
        // Restrict the length of the text to be no longer than 9 characters
        providerTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (providerTextField.getText().length() >= 9) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        providerTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                providerTextField.setText("");
            }
        });
        
        // Restrict the length of the text to be no longer than 9 characters
        
        
     // Restrict the length of the text to be no longer than 9 characters
        selectedValueTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (selectedValueTextField.getText().length() >= 6) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        selectedValueTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                selectedValueTextField.setText("");
            }
        });
        
        // Restrict the length of the text to be no longer than 9 characters
        memberTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (memberTextField.getText().length() >= 9) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        memberTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                memberTextField.setText("");
            }
        });
        
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
        
        performedField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                performedField.setText("");
            }
        });
        
        performedField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Clear the text only on the first key typed
                if (isFirstKeyTyped) {
                    performedField.setText("");
                    isFirstKeyTyped = false;
                }
            }
        });
        
        JButton sendBillButton = createButton("Send Bill");
        sendBillButton.addActionListener(this);
        sendBillButton.setPreferredSize(new Dimension(250, 50));
        sendBillButton.setMaximumSize(new Dimension(250, 50));
        sendBillButton.setFont(buttonFont);
        sendBillButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(dateLabel);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(codeField);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(performedLabel);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(performedField);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(providerTextField);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(memberTextField);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(selectedValueTextField);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(commentsTextArea);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(sendBillButton);
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        billChocAnPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        codeField.setText(dateFormat.format(new Date()));

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

	 /**
	     * Reads acceptable values from a file based on the specified category.
	     *
	     * @param filePath The path to the file containing acceptable values.
	     * @param category The category of acceptable values to read.
	     * @return A list of acceptable values for the specified category.
	     * @throws IOException If an I/O error occurs while reading the file.
	     */
	@Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton.getText().equals("Return to Terminal")) {
            // Dispose of the current frame
        	new ProviderTerminal();
            billChocAnFrame.dispose();
        } else if (clickedButton.getText().equals("Send Bill")) {
            // Show custom dialog for "Yes" and "No" options
            int result = showYesNoDialog("Do you want to send the bill?");

            // Handle the user's response
            if (result == JOptionPane.YES_OPTION) {
                // User clicked "Yes," handle accordingly
            	String enteredDateCode = codeField.getText();
                String enteredServiceCode = selectedValueTextField.getText();
                String enteredMemberCode = memberTextField.getText();
                String enteredProviderCode = providerTextField.getText();
                String enteredPerformedCode = performedField.getText();
                String enteredComments = commentsTextArea.getText();
                int errorProof = 0;
                
                if (Validators.isValidServiceCode(enteredServiceCode)) {
                	//Do nothing
                } else {
                    selectedValueTextField.setText("Invalid Service Code");
                    errorProof =1;
                    		
                }
                if (Validators.isValidMemberCode(enteredMemberCode)) {
                    //Do nothing
                }else if(Validators.isSuspendedMemberCode(enteredMemberCode)) {
                	memberTextField.setText("Suspended Membership Number");
                    errorProof =1;
                }else {
                    memberTextField.setText("Invalid Membership Number");
                    errorProof =1;
                }
                if (Validators.isValidProviderCode(enteredProviderCode)) {
                    //Do Nothing
                } else {
                    providerTextField.setText("Invalid Provider Number");
                    errorProof =1;
                }
                if (performedField.getText().matches("\\d{2}-\\d{2}-\\d{4}")) {
                    //Do Nothing
                } else {
                    performedField.setText("Invalid Date input. Please enter in form of MM-DD-YYYY");
                    errorProof =1;
                }
                if (errorProof == 0) {
                    String payment = enteredServiceCode.substring(Math.max(0, enteredServiceCode.length() - 3));
                    showOkDialog("Bill sending...");
                    showOkDialog("Bill sent");
                    showOkDialog("ChocAn will Reimburse provider:\n" + "$" + payment + " for service " + enteredServiceCode);
                    try{
                    	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "bill", "billdate", enteredDateCode, "servicedate", enteredPerformedCode, "servicecode", enteredServiceCode,
                    			"providercode", enteredProviderCode, "membercode", enteredMemberCode, "comments", enteredComments);
                    } catch (SQLException ex) {
                    	ex.printStackTrace();
                    }
                    								

                } else {
                    // User clicked "No" or closed the dialog, handle accordingly
                    showOkDialog("Bill not sent.");
                }
            }
        }
    }
	
	

	/**
     * Shows a dialog with "Yes" and "No" options and returns the user's choice.
     *
     * @param message The message to be displayed in the dialog.
     * @return JOptionPane.YES_OPTION if the user clicks "Yes," JOptionPane.NO_OPTION otherwise.
     */
	private int showYesNoDialog(String message) {
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] options = {"Yes", "No"};
        return JOptionPane.showOptionDialog(
                billChocAnFrame,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                options,
                options[1]); // Default to "No"
    }
	
	/**
     * Shows a dialog with an "Okay" option and returns the user's choice.
     *
     * @param message The message to be displayed in the dialog.
     * @return JOptionPane.OK_OPTION.
     */
	private int showOkDialog(String message) {
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] option = {"Okay"};
        return JOptionPane.showOptionDialog(
                billChocAnFrame,
                message,
                "Confirmation",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                option,
                option[0]);
                
    }
}
