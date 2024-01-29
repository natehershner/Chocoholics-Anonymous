/**
 * The EditCurrentProviders class provides functionality for editing provider records in the system.
 * It includes a graphical user interface with a list of available provider records and a search bar
 * for filtering the displayed records. Users can select a provider record and choose to edit it.
 * The class also interacts with the system files to open the AlterProvider class for further editing.
 * It implements the ActionListener, MouseListener, and ListSelectionListener interfaces to handle
 * user actions.
 * 
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Constructs an instance of the EditCurrentProviders class, initializing the graphical user interface
 * for editing provider records. It includes buttons, labels, and a search bar to facilitate the process.
 */
public class EditCurrentProviders implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame editCurrentFrame;
    private JPanel editCurrentPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    public EditCurrentProviders() {
        editCurrentFrame = new JFrame("Edit Provider");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        editCurrentFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        editCurrentPanel = new JPanel();
        editCurrentPanel.setLayout(new BoxLayout(editCurrentPanel, BoxLayout.Y_AXIS));
        editCurrentPanel.setBackground(new Color(0x996666));
        editCurrentPanel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        ImageIcon imageIcon = new ImageIcon("resources/Operator1.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        JLabel headerLabel = new JLabel("Edit Provider");
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setFont(new Font("Rockwell", Font.BOLD, 60));

        searchBar = new JTextField();
        searchBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchBar.setMaximumSize(new Dimension(500, 30));
        searchBar.setFont(new Font("Rockwell", Font.PLAIN, 20));
        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterList();
            }
        });

        // Load elements from the folder and add them to listModel
        listModel = ListModelLoaders.loadListModelProviderNumbers();

        Font listFont = new Font("Rockwell", Font.PLAIN, 30);

        reportList = new JList<>(listModel);
        reportList.setFont(listFont);

        JScrollPane scrollPane = new JScrollPane(reportList);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(200, 150));
        scrollPane.setMaximumSize(new Dimension(1000, 300));

        editCurrentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        editCurrentPanel.add(imageLabel);
        editCurrentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        editCurrentPanel.add(headerLabel);
        editCurrentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        editCurrentPanel.add(searchBar);
        editCurrentPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        editCurrentPanel.add(scrollPane);

        editCurrentFrame.add(editCurrentPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(editCurrentFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        editCurrentFrame.setSize(windowWidth, windowHeight);
        editCurrentFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        editCurrentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editCurrentFrame.setLocationRelativeTo(null);
        editCurrentFrame.setVisible(true);

        editCurrentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        editCurrentPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportList.addListSelectionListener(this);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addMouseListener(this);
        return button;
    }

    private void filterList() {
        String searchText = searchBar.getText().trim().toLowerCase();
        DefaultListModel<String> filteredModel = new DefaultListModel<>();

        for (int i = 0; i < listModel.getSize(); i++) {
            String listItem = listModel.getElementAt(i).toLowerCase();
            if (listItem.contains(searchText)) {
                filteredModel.addElement(listModel.getElementAt(i));
            }
        }

        reportList.setModel(filteredModel);
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
     * Handles the action events triggered by buttons in the graphical user interface.
     * Currently, it listens for the "Return to Terminal" button click and navigates back to the OperatorTerminal class.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Return to Terminal")) {
            // Dispose of the current frame
        	new EditProviders();
            editCurrentFrame.dispose();
        }
    }

    /**
     * Displays a confirmation dialog with a specified message.
     *
     * @param selectedItem The selected item to be included in the confirmation message.
     * @return An integer representing the user's response (YES_OPTION or NO_OPTION).
     */
    private int showConfirmationDialog(String selectedItem) {
        String message = "Do you want to edit this provider?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(editCurrentFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        editCurrentFrame.requestFocus();

        return response;
    }

    /**
     * Handles the valueChanged events triggered by the list selection in the graphical user interface.
     * It prompts the user to confirm the editing of the selected provider record and opens the AlterProvider class
     * for further editing if the user confirms. It interacts with system files to update the records.
     *
     * @param e The ListSelectionEvent object representing the change in list selection.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedValue = reportList.getSelectedValue();
            if (selectedValue != null) {
                int response = showConfirmationDialog(selectedValue);

                if (response == JOptionPane.YES_OPTION) {
                    // Open EditReports with the selected file name
                    new AlterProvider(selectedValue);
                    editCurrentFrame.dispose();
                } else {
                    // User clicked No, deselect the option
                    reportList.clearSelection();
                }

                // Set focus back to the main frame
                editCurrentFrame.requestFocus();
            }
        }
    }
    
 

	
    
}

