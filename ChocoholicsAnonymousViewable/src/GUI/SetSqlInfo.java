package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.prefs.Preferences;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SetSqlInfo implements ActionListener, MouseListener {
	private JFrame preferencesFrame;
	private JPanel preferencesPanel;
	private Preferences prefs;
    private boolean isFirstKeyTyped = true;
    private JLabel panelLabel; 
    private JTextField serverNameField;
    private JTextField portNumberField;
    private JTextField databaseNameField;
    private JTextField passwordField;
    private JTextField usernameField;
    
    public SetSqlInfo() {
    	prefs = Preferences.userNodeForPackage(GUI.class);
  	    preferencesFrame = new JFrame("Set SQL Preferences");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        preferencesFrame.setIconImage(frameIcon.getImage());
        
        JButton button = createButton("Save Info");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));
        
        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);
        
        preferencesPanel = new JPanel();
        preferencesPanel.setLayout(new BoxLayout(preferencesPanel, BoxLayout.Y_AXIS));
        preferencesPanel.setBackground(new Color(0x89CFF0));
        preferencesPanel.setBorder(new LineBorder(Color.decode("#000000"),5));

        // Add your provider login components here
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/ChocAnLogo2.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#CC6600"),5));

        JLabel headerLabel = new JLabel("Set SQL Preferences");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        preferencesPanel.add(imageLabel);
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(headerLabel);
        //preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        preferencesFrame.add(preferencesPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        preferencesFrame.setSize(screenSize);
        preferencesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        preferencesFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        preferencesFrame.setLocationRelativeTo(null);
        
        serverNameField = new JTextField();
        serverNameField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        serverNameField.setMaximumSize(new Dimension(700, 50));
        serverNameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        serverNameField.setText("MM–DD–YYYY HH:MM:SS");
        
        panelLabel = new JLabel("SQL Server Information:");
        panelLabel.setFont(new Font("Rockwell", Font.PLAIN, 20));
        panelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        serverNameField.setText("Server Name");
        
        
        portNumberField = new JTextField();
        portNumberField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        portNumberField.setMaximumSize(new Dimension(700, 50));
        portNumberField.setAlignmentX(Component.CENTER_ALIGNMENT);
        portNumberField.setText("Port Number");
        
        databaseNameField = new JTextField();
        databaseNameField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        databaseNameField.setMaximumSize(new Dimension(700, 50));
        databaseNameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        databaseNameField.setText("Database Name");
        
       
        usernameField = new JTextField();
        usernameField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        usernameField.setMaximumSize(new Dimension(700, 50));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField.setText("SQL Authentication Username");
        
        
        passwordField = new JTextField();
        passwordField.setFont(new Font("Rockwell", Font.PLAIN, 20));
        passwordField.setMaximumSize(new Dimension(700, 50));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setText("SQL Authentication Password");

        // Restrict the length of the text to be no longer than 100 characters
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (passwordField.getText().length() >= 100) {
                    e.consume(); // Ignore the key input if the length is already 100 or more
                }
            }
        });

        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextArea is clicked
                passwordField.setText("");
            }
        });
       
        // Restrict the length of the text to be no longer than 9 characters
        portNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (portNumberField.getText().length() >= 9) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        portNumberField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                portNumberField.setText("");
            }
        });
        
        // Restrict the length of the text to be no longer than 9 characters
        
        
     // Restrict the length of the text to be no longer than 9 characters
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (usernameField.getText().length() >= 6) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        usernameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                usernameField.setText("");
            }
        });
        
        // Restrict the length of the text to be no longer than 9 characters
        databaseNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (databaseNameField.getText().length() >= 9) {
                    e.consume(); // Ignore the key input if the length is already 9 or more
                }
            }
        });

        databaseNameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                databaseNameField.setText("");
            }
        });
                
        serverNameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Clear the text when the JTextField is clicked
                serverNameField.setText("");
            }
        });
        
        serverNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Clear the text only on the first key typed
                if (isFirstKeyTyped) {
                    serverNameField.setText("");
                    isFirstKeyTyped = false;
                }
            }
        });
        
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(panelLabel);
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(serverNameField);
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(portNumberField);
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(databaseNameField);
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(usernameField);
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(passwordField);
        preferencesPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        preferencesPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        preferencesFrame.setVisible(true);
    }
    private int showYesNoDialog(String message) {
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] options = {"Yes", "No"};
        return JOptionPane.showOptionDialog(
                preferencesFrame,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                options,
                options[1]); // Default to "No"
    }
    private int showOkDialog(String message) {
		ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] option = {"Okay"};
        return JOptionPane.showOptionDialog(
                preferencesFrame,
                message,
                "Confirmation",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                option,
                option[0]);
                
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
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton.getText().equals("Save Info")) {
            // Show custom dialog for "Yes" and "No" options
            int result = showYesNoDialog("Are you sure you want to save SQL info and proceed to the application?");

            // Handle the user's response
            if (result == JOptionPane.YES_OPTION) {
                // User clicked "Yes," handle accordingly
            	String serverName = serverNameField.getText();
                String portNumber = portNumberField.getText();
                String databaseName = databaseNameField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();
                String tmp = "";
                for (int i = 0; i < serverName.length(); i++) {
                	char c = serverName.charAt(i);
                	if (c == '\\') tmp += c;
                	tmp += c;
                }
                serverName = tmp;
                prefs.put("serverName", serverName);
                prefs.put("portNumber", portNumber);
                prefs.put("databaseName", databaseName);
                prefs.put("username", username);
                prefs.put("password", password);
                runSqlPopulation();
                new GUI();
                preferencesFrame.dispose();
                
            } else {
                    // User clicked "No" or closed the dialog, handle accordingly
                showOkDialog("SQL info not saved. ");
            }      
        }
    }

     /**
      * Handles the mouseClicked event.
      *
      * @param e The MouseEvent object.
      */
     // MouseListener methods
     @Override
     public void mouseClicked(MouseEvent e) {
    	 
     }

     /**
      * Handles the mousePressed event.
      *
      * @param e The MouseEvent object.
      */
     @Override
     public void mousePressed(MouseEvent e) {
    	 
     }

     /**
      * Handles the mouseReleased event.
      *
      * @param e The MouseEvent object.
      */
     @Override
     public void mouseReleased(MouseEvent e) {
    	
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
     private void runSqlPopulation() {
    	 try (Connection connection = CreateSQL.giveConnection()) {
             // create and populate validproviders table if it does not exist
         	if (!CreateSQL.tableExists(connection, "validproviders")) {
         		CreateSQL.createTable(connection, "validproviders");
         		if (!CreateSQL.columnExistsInTable(connection, "validproviders", "nums")) {
         			CreateSQL.addColumnToTable(connection, "validproviders", "nums", "INT");
         			int[] list = {999999999, 121212121, 123456789, 987654321, 385393502, 834592176, 609384215, 725109384, 481236790, 573892614};
         			for (int i = 0; i < 10; i++) {
         				if (!CreateSQL.valueExists(connection, "validproviders", "nums", list[i])) {
         					CreateSQL.insertValue(connection, "validproviders", "nums", list[i]);
         				}
         			}
         		}
         	}
         	// create and populate validoperators table if it does not exist
         	if (!CreateSQL.tableExists(connection, "validoperators")) {
         		CreateSQL.createTable(connection, "validoperators");
         		if (!CreateSQL.columnExistsInTable(connection, "validoperators", "nums")) {
         			CreateSQL.addColumnToTable(connection, "validoperators", "nums", "INT");
         			int[] list = {999999999, 232323232, 876876876, 343412121, 248975361, 697813254, 530964187, 814326509, 672148935, 395210846};
         			for (int i = 0; i < 10; i++) {
         				if (!CreateSQL.valueExists(connection, "validoperators", "nums", list[i])) {
         					CreateSQL.insertValue(connection, "validoperators", "nums", list[i]);
         				}
         			}
         		}
         	}
         	// create and populate validmanagers table if it does not exist
         	if (!CreateSQL.tableExists(connection, "validmanagers")) {
         		CreateSQL.createTable(connection, "validmanagers");
         		if (!CreateSQL.columnExistsInTable(connection, "validmanagers", "nums")) {
         			CreateSQL.addColumnToTable(connection, "validmanagers", "nums", "INT");
         			int[] list = {999999999, 323232323, 454454454, 155155155, 729183465, 604512837, 851937624, 463298571, 318746952, 975624183};
         			for (int i = 0; i < 10; i++) {
         				if (!CreateSQL.valueExists(connection, "validmanagers", "nums", list[i])) {
         					CreateSQL.insertValue(connection, "validmanagers", "nums", list[i]);
         				}
         			}
         		}
         	}
         	// create and populate members table if it does not exist
         	if (!CreateSQL.tableExists(connection, "members")) {
         		CreateSQL.createTable(connection, "members");
         		if (!CreateSQL.columnExistsInTable(connection, "members", "valid")) {
         			CreateSQL.addColumnToTable(connection, "members", "valid", "INT");
         			
         			int[] list = {999999999, 555555555, 666666666, 777777777, 572943618, 689175432, 427356189, 836914257, 514287963, 293861745};
         			
         			for (int i = 0; i < 10; i++) {
         				CreateSQL.insertValue(connection, "members", "valid", list[i]);
         			}
         			
         		}
         	}
         	// create and populate suspendedmembers table if it does not exist
         	if (!CreateSQL.tableExists(connection, "suspendedmembers")) {
         		CreateSQL.createTable(connection, "suspendedmembers");
         		if (!CreateSQL.columnExistsInTable(connection, "suspendedmembers", "nums")) {
         			CreateSQL.addColumnToTable(connection, "suspendedmembers", "nums", "INT");
         			
         			int[] list = {999999998, 555555554, 455555555, 899999999, 476819325, 825634197, 391547682, 648273519, 752198364, 913462875};
         			for (int i = 0; i < 10; i++) {
         				CreateSQL.insertValue(connection, "suspendedmembers", "nums", list[i]);
         			}
         			
         		}
         	}
         	// create and populate providerdirectory table if it does not exist
         	if (!CreateSQL.tableExists(connection, "providerdirectory")) {
         		CreateSQL.createTable(connection, "providerdirectory");
         		if (!CreateSQL.columnExistsInTable(connection, "providerdirectory", "codes")) {
         			CreateSQL.addColumnToTable(connection, "providerdirectory", "codes", "INT");
         			CreateSQL.addColumnToTable(connection, "providerdirectory", "descriptions", "VARCHAR(255)");
         			int[] list = {999999, 555555, 666666, 777777, 718245, 392857, 564213, 987634, 126489, 573916};
         			String[] list2 = {"Workout and Meal Plans", "Yoga and Stretching", "Common Illness Treatment", "Alternative Medicine", "Juice Cleanse"
         							  , "Group Therapy", "Chocolate Detox", "Shock Therapy", "Aerobics Class", "Spin Cycle Class"};
         			for (int i = 0; i < 10; i++) {
         				if (!CreateSQL.valueExists(connection, "providerdirectory", "codes", list[i]) && !CreateSQL.valueExists(connection, "providerdirectory", "descriptions", list2[i])) {
         					CreateSQL.insertValues(connection, "providerdirectory", "codes", "descriptions", list[i], list2[i]);
         				}
         			}
         		}
         	}
         	//create and populate bill table if it does not exist
         	if (!CreateSQL.tableExists(connection, "bill")) {
         		CreateSQL.createTable(connection, "bill");
         		if (!CreateSQL.columnExistsInTable(connection, "bill", "billdate")) {
         			CreateSQL.addColumnToTable(connection, "bill", "billdate", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "bill", "servicedate", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "bill", "servicecode", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "bill", "providercode", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "bill", "membercode", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "bill", "comments", "VARCHAR(255)");
         			String[] serviceCodes = {"392857", "987634", "573916", "777777", "573916", "666666", "392857", "126489", "718245", "564213"};
         			String[] billDates = {"07-30-2023 12:02:31", "12-21-2022 14:22:34", "12-01-2023 15:21:54", "08-19-2020 14:22:32", "01-02-2018 11:01:01"
         			                      , "03-29-2020 16:03:46", "05-20-2023 12:34:43", "09-23-2017 16:19:19", "02-27-2023 15:55:45", "04-01-2023 11:34:43"};
         			String[] serviceDates = {"07-19-2023", "12-01-2022", "11-21-2023", "08-14-2020", "12-19-2017", "03-13-2020", "05-01-2023", "09-01-2017", "02-02-2023", "03-18-2023"};
         			String[] providerCodes = {"121212121", "385393502", "609384215", "123456789", "999999999", "481236790", "609384215", "385393502", "609384215", "121212121"};
         			String[] memberCodes = {"572943618", "689175432", "666666666", "514287963", "293861745", "572943618", "999999999", "572943618", "666666666", "572943618"};
         			String[] comments = {"Interacted well with others during session", "Responded well to treatment", "Burnt the most calories of class"
         								 , "Did not benefit from treatment", "Burnt the least calories of class", "Illness is gone", "Did not interact with group"
         								 , "Flexibility increased since last visit", "Enjoyed juice", "Chocolate detox seems effective"};
         			for (int i = 0; i < 10; i++) {
         				try{
                         	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "bill", "billdate", billDates[i], "servicedate", serviceDates[i], "servicecode", serviceCodes[i],
                         			"providercode", providerCodes[i], "membercode", memberCodes[i], "comments", comments[i]);
                         } catch (SQLException ex) {
                         	ex.printStackTrace();
                         }
         			}
         		}
         	}
         	// create and populate memberinfo table if it does not exist
         	if (!CreateSQL.tableExists(connection, "memberinfo")) {
         		CreateSQL.createTable(connection, "memberinfo");
         		if (!CreateSQL.columnExistsInTable(connection, "memberinfo", "name")) {
         			CreateSQL.addColumnToTable(connection, "memberinfo", "name", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "memberinfo", "num", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "memberinfo", "address", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "memberinfo", "city", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "memberinfo", "state", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "memberinfo", "zipcode", "VARCHAR(255)");
         			String[] names = {"Matthew King", "Trina Smith", "Kelly Allbody", "John Smart", "Demarcus Keen", "Sheila Baker", "Rose King", "Emily Vanderbilt", "Lance Wood", "Allison Baird"};
         			String[] nums = {"999999999", "555555555", "666666666", "777777777", "572943618", "689175432", "427356189", "836914257", "514287963", "293861745"};
         			String[] addresses = {"234 Right Way", "9356 Pleasant St", "733 Brick St", "223 American Rd", "123 Main Street", "456 Oak Avenue", "789 Elm Lane", "321 Pine Drive", "567 Birch Road", "890 Cedar Court"};
         			String[] cities = {"Fairfield", "Hamilton", "Colerain", "Middletown", "Seattle", "Miami", "Denver", "Atlanta", "Boston", "Dallas"};
         			String[] states = {"OH", "KY", "AL", "NY", "AL", "MI", "MS", "CO", "MA", "FL"};
         			String[] zipcodes = {"24524", "99832", "45014", "34432", "89234", "65781", "43829", "12657", "54902", "78453"};
         			for (int i = 0; i < 10; i++) {
         				try{
                         	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "memberinfo", "name", names[i], "num", nums[i], "address", addresses[i],
                         			"city", cities[i], "state", states[i], "zipcode", zipcodes[i]);
                         } catch (SQLException ex) {
                         	ex.printStackTrace();
                         }
         			}
         		}
         	}
         	// create and populate providerinfo table if it does not exist
         	if (!CreateSQL.tableExists(connection, "providerinfo")) {
         		CreateSQL.createTable(connection, "providerinfo");
         		if (!CreateSQL.columnExistsInTable(connection, "providerinfo", "name")) {
         			CreateSQL.addColumnToTable(connection, "providerinfo", "name", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "providerinfo", "num", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "providerinfo", "address", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "providerinfo", "city", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "providerinfo", "state", "VARCHAR(255)");
         			CreateSQL.addColumnToTable(connection, "providerinfo", "zipcode", "VARCHAR(255)");
         			String[] names = {"Dex Martin", "Christie Wahoff", "Joban Singh", "Marla Richards", "Henry Gonzalez", "Tank Frank", "Sydney Sweet", "Victoria Lane", "Lindsey Mailer", "Javier Johnston"};
         			String[] nums = {"999999999", "121212121", "123456789", "987654321", "385393502", "834592176", "609384215", "725109384", "481236790", "573892614"};
         			String[] addresses = {"34 Madid Ave", "9265 Saga St", "7323 Cobble St", "423 Dixie Rd", "234 Maple Avenue", "567 Pine Street", "890 Elm Road", "432 Oak Drive", "765 Cedar Lane", "109 Birch Court"};
         			String[] cities = {"West Chester", "Mason", "Indian Hill", "Cincinnati", "Los Angeles", "Chicago", "Houston", "Philadelphia", "Phoenix", "San Antonio"};
         			String[] states = {"PA", "LA", "NH", "FL", "OH", "NY", "CA", "WA", "NJ", "OH"};
         			String[] zipcodes = {"63524", "99222", "11014", "36322", "89124", "65732", "43895", "12678", "54903", "78456"};
         			for (int i = 0; i < 10; i++) {
         				try{
                         	CreateSQL.insertSixStringValues(CreateSQL.giveConnection(), "providerinfo", "name", names[i], "num", nums[i], "address", addresses[i],
                         			"city", cities[i], "state", states[i], "zipcode", zipcodes[i]);
                         } catch (SQLException ex) {
                         	ex.printStackTrace();
                         }
         			}
         		}
         	}

             
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}
