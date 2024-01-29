/**
 * 
 *
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */
/**
 * The DeleteMembers class provides functionality for deleting member records from the system.
 * It includes a graphical user interface with a list of available member records and a search bar
 * for filtering the displayed records. Users can select a member record and choose to delete it.
 * The class also interacts with the system files to remove the selected member's information.
 * It implements the ActionListener, MouseListener, and ListSelectionListener interfaces to handle
 * user actions.
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

public class DeleteMembers implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame DeleteMemberDirectoryFrame;
    private JPanel DeleteMemberDirectoryPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    
    /**
     * Constructs an instance of the DeleteMembers class, initializing the graphical user interface
     * for deleting member records. It includes buttons, labels, and a search bar to facilitate the process.
     */
    public DeleteMembers() {
        DeleteMemberDirectoryFrame = new JFrame("Delete Members");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        DeleteMemberDirectoryFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Go Back");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        DeleteMemberDirectoryPanel = new JPanel();
        DeleteMemberDirectoryPanel.setLayout(new BoxLayout(DeleteMemberDirectoryPanel, BoxLayout.Y_AXIS));
        DeleteMemberDirectoryPanel.setBackground(new Color(0x996666));
        DeleteMemberDirectoryPanel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        ImageIcon imageIcon = new ImageIcon("resources/Operator1.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        JLabel headerLabel = new JLabel("Delete Members");
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
        listModel = ListModelLoaders.loadListModelMemberNumbers();

        Font listFont = new Font("Rockwell", Font.PLAIN, 30);

        reportList = new JList<>(listModel);
        reportList.setFont(listFont);

        JScrollPane scrollPane = new JScrollPane(reportList);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(200, 150));
        scrollPane.setMaximumSize(new Dimension(1000, 300));

        DeleteMemberDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        DeleteMemberDirectoryPanel.add(imageLabel);
        DeleteMemberDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        DeleteMemberDirectoryPanel.add(headerLabel);
        DeleteMemberDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        DeleteMemberDirectoryPanel.add(searchBar);
        DeleteMemberDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        DeleteMemberDirectoryPanel.add(scrollPane);

        DeleteMemberDirectoryFrame.add(DeleteMemberDirectoryPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(DeleteMemberDirectoryFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        DeleteMemberDirectoryFrame.setSize(windowWidth, windowHeight);
        DeleteMemberDirectoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DeleteMemberDirectoryFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        DeleteMemberDirectoryFrame.setLocationRelativeTo(null);
        DeleteMemberDirectoryFrame.setVisible(true);

        DeleteMemberDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        DeleteMemberDirectoryPanel.add(button);
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
     * Currently, it listens for the "Go Back" button click and navigates back to the EditMembers class.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Go Back")) {
            // Dispose of the current frame
        	new EditMembers();
            DeleteMemberDirectoryFrame.dispose();

        }
    }

    private int showConfirmationDialog(String selectedItem) {
        String message = "Do you want to delete this member?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(DeleteMemberDirectoryFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        DeleteMemberDirectoryFrame.requestFocus();

        return response;
    }

    /**
     * Handles the valueChanged events triggered by the list selection in the graphical user interface.
     * It prompts the user to confirm the deletion of the selected member record and performs the deletion
     * if the user confirms. It interacts with system files to update the records.
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
                    // Assuming EditReports has a method to delete member information
                    CreateSQL.deleteRow(CreateSQL.giveConnection(), "members", "valid", Integer.parseInt(selectedValue));
                    CreateSQL.deleteRow(CreateSQL.giveConnection(), "memberinfo", "num", selectedValue);
                    CreateSQL.deleteRow(CreateSQL.giveConnection(), "bill", "membercode", selectedValue);
                    showOkDialog("Member information deleted successfully.");
                    listModel = ListModelLoaders.loadListModelMemberNumbers();
                    reportList.setModel(listModel);

                    // Deselect the option
                    reportList.clearSelection();
                } else {
                    // User clicked No, deselect the option
                    reportList.clearSelection();
                }

                // Set focus back to the main frame
                DeleteMemberDirectoryFrame.requestFocus();
            }
        }
    }
    
    /**
     * Displays an information dialog with a specified message.
     *
     * @param message The message to be displayed in the dialog.
     * @return An integer representing the user's response (always JOptionPane.OK_OPTION).
     */
    private int showOkDialog(String message) {
    	ImageIcon customIcon = new ImageIcon("resources/ChocolateIcon1.jpg");
        Object[] option = {"Okay"};
        return JOptionPane.showOptionDialog(
                DeleteMemberDirectoryFrame,
                message,
                "Confirmation",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                customIcon,
                option,
                option[0]);
                
    }

	
    
}