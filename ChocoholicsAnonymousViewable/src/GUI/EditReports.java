/**
 * 
 *
 * @author Tyler Gazzam
 * @author August_Connors
 * 
 * @since 2023-04-12
 */
/**
 * The EditReports class provides a graphical user interface for editing and saving reports.
 * Users can modify details such as date, performed date, provider information, member information,
 * service code, and comments. It implements ActionListener and MouseListener interfaces to handle user interactions.
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditReports implements ActionListener, MouseListener{

	    private JFrame editReportsFrame;
	    private JPanel editReportsPanel;
	    private JTextField codeField;
	    private JLabel dateLabel; 
	    private JLabel performedLabel; 
	    private JTextField performedField;
	    private JTextField providerTextField;
	    private JTextField memberTextField;
	    private JTextArea commentsTextArea;
	    private JTextField selectedValueTextField;

	    /**
	     * Constructs an instance of the EditReports class with the specified selectedValue.
	     *
	     * @param selectedValue The report identifier to be edited.
	     */
    public EditReports(String selectedValue) {
    	editReportsFrame = new JFrame("Edit Report");
    	ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        editReportsFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Go Back");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
        
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        
        editReportsPanel = new JPanel();
        editReportsPanel.setLayout(new BoxLayout(editReportsPanel, BoxLayout.Y_AXIS));
        editReportsPanel.setBackground(new Color(0x996666));
        editReportsPanel.setBorder(new LineBorder(Color.decode("#993366"),5));

        // Add your provider login components here
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Operator1.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"),5));

        JLabel headerLabel = new JLabel("Edit Report");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        editReportsPanel.add(imageLabel);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(headerLabel);
        //billChocAnPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        editReportsFrame.add(editReportsPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        editReportsFrame.setSize(screenSize);
        editReportsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        editReportsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editReportsFrame.setLocationRelativeTo(null);
        editReportsFrame.setVisible(true);
        
        codeField = new JTextField();
        codeField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        codeField.setMaximumSize(new Dimension(700, 50));
        codeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        dateLabel = new JLabel("Current Date and Time:");
        dateLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        performedField = new JTextField();
        performedField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        performedField.setMaximumSize(new Dimension(700, 50));
        performedField.setAlignmentX(Component.CENTER_ALIGNMENT);
        performedField.setEditable(false);
        
        
        performedLabel = new JLabel("Date service was provided:");
        performedLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
        performedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        providerTextField = new JTextField();
        providerTextField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        providerTextField.setMaximumSize(new Dimension(700, 50));
        providerTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        memberTextField = new JTextField();
        memberTextField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        memberTextField.setMaximumSize(new Dimension(700, 50));
        memberTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
       
        selectedValueTextField = new JTextField();
        selectedValueTextField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        selectedValueTextField.setMaximumSize(new Dimension(700, 50));
        selectedValueTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        
        commentsTextArea = new JTextArea();
        commentsTextArea.setFont(new Font("Rockwell", Font.PLAIN, 20));
        commentsTextArea.setLineWrap(true); // Enable text wrapping
        commentsTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        commentsTextArea.setMaximumSize(new Dimension(700, 100));
        commentsTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        // Restrict the length of the text to be no longer than 100 characters
        
        
        JButton sendBillButton = createButton("Save Report");
        sendBillButton.addActionListener(this);
        sendBillButton.setPreferredSize(new Dimension(250, 50));
        sendBillButton.setMaximumSize(new Dimension(250, 50));
        sendBillButton.setFont(buttonFont);
        sendBillButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
       
        
        codeField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "bill", "billdate", "servicedate", selectedValue.substring(12)));
    	commentsTextArea.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "bill", "comments", "servicedate", selectedValue.substring(12)));
    	selectedValueTextField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "bill", "servicecode", "servicedate", selectedValue.substring(12)));
    	providerTextField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "bill", "providercode", "servicedate", selectedValue.substring(12)));
    	memberTextField.setText(CreateSQL.getStringByStringValue(CreateSQL.giveConnection(), "bill", "membercode", "servicedate", selectedValue.substring(12)));
    	performedField.setText(selectedValue.substring(12));
    	
    	
        
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(dateLabel);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(codeField);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(performedLabel);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(performedField);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(providerTextField);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(memberTextField);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(selectedValueTextField);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(commentsTextArea);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(sendBillButton);
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
       
        editReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editReportsPanel.add(button);
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
	     * Handles the actionPerformed event, determining which button was clicked and taking appropriate action.
	     *
	     * @param e The ActionEvent object representing the action event.
	     */
	@Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton.getText().equals("Go Back")) {
            // Dispose of the current frame
        	new ViewReports();
            editReportsFrame.dispose();
        } else if (clickedButton.getText().equals("Save Report")) {
            // Show custom dialog for "Yes" and "No" options
            int result = showYesNoDialog("Do you want to save the report?");

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
                    
                    showOkDialog("Report saving...");
                    try {
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "bill", "servicecode", enteredServiceCode, "servicedate", enteredPerformedCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "bill", "providercode", enteredProviderCode, "servicedate", enteredPerformedCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "bill", "membercode", enteredMemberCode, "servicedate", enteredPerformedCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "bill", "comments", enteredComments, "servicedate", enteredPerformedCode);
	                	CreateSQL.updateValue(CreateSQL.giveConnection(), "bill", "billdate", enteredDateCode, "servicedate", enteredPerformedCode);
	                } catch (Exception exc){
	                	exc.printStackTrace();
	                }
                    showOkDialog("Report saved");
                    

                    
                } else {
                    // User clicked "No" or closed the dialog, handle accordingly
                    showOkDialog("Bill not sent.");
                }
        }
        }
    }
	

	 /**
     * Displays a confirmation dialog with "Yes" and "No" options.
     *
     * @param message The message to be displayed in the dialog.
     * @return The user's choice (YES_OPTION or NO_OPTION).
     */
	private int showYesNoDialog(String message) {
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] options = {"Yes", "No"};
        return JOptionPane.showOptionDialog(
                editReportsFrame,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                options,
                options[1]); // Default to "No"
    }
	/**
     * Displays an OK dialog with a single "Okay" option.
     *
     * @param message The message to be displayed in the dialog.
     * @return The user's choice (OK_OPTION).
     */
	private int showOkDialog(String message) {
		 ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] option = {"Okay"};
        return JOptionPane.showOptionDialog(
                editReportsFrame,
                message,
                "Confirmation",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                option,
                option[0]);
                
    }
}