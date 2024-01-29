/**
 * 
 *
 * @author Nathaniel_Hershner
 * @since 2024-01-27
 */
/**
 * The DeleteProviders class provides functionality for deleting provider records from the system.
 * It includes a graphical user interface with a list of available provider records and a search bar
 * for filtering the displayed records. Users can select a provider record and choose to delete it.
 * The class also interacts with the system files to remove the selected provider's information.
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

public class DeleteProviders implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame deleteProviderFrame;
    private JPanel deleteProviderPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    /**
     * Constructs an instance of the DeleteProviders class, initializing the graphical user interface
     * for deleting provider records. It includes buttons, labels, and a search bar to facilitate the process.
     */
    public DeleteProviders() {
        deleteProviderFrame = new JFrame("Delete Providers");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        deleteProviderFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Go Back");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        deleteProviderPanel = new JPanel();
        deleteProviderPanel.setLayout(new BoxLayout(deleteProviderPanel, BoxLayout.Y_AXIS));
        deleteProviderPanel.setBackground(new Color(0x996666));
        deleteProviderPanel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        ImageIcon imageIcon = new ImageIcon("resources/Operator1.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        JLabel headerLabel = new JLabel("Delete Providers");
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

        deleteProviderPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        deleteProviderPanel.add(imageLabel);
        deleteProviderPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        deleteProviderPanel.add(headerLabel);
        deleteProviderPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        deleteProviderPanel.add(searchBar);
        deleteProviderPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        deleteProviderPanel.add(scrollPane);

        deleteProviderFrame.add(deleteProviderPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(deleteProviderFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        deleteProviderFrame.setSize(windowWidth, windowHeight);
        deleteProviderFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
        deleteProviderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteProviderFrame.setLocationRelativeTo(null);
        deleteProviderFrame.setVisible(true);

        deleteProviderPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        deleteProviderPanel.add(button);
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
     * Currently, it listens for the "Go Back" button click and navigates back to the EditProviders class.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Go Back")) {
            // Dispose of the current frame
        	new EditProviders();
            deleteProviderFrame.dispose();
        }
    }

    private int showConfirmationDialog(String selectedItem) {
        String message = "Do you want to delete this provider?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(deleteProviderFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        deleteProviderFrame.requestFocus();

        return response;
    }


    /**
     * Handles the valueChanged events triggered by the list selection in the graphical user interface.
     * It prompts the user to confirm the deletion of the selected provider record and performs the deletion
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
                	CreateSQL.deleteRow(CreateSQL.giveConnection(), "validproviders", "nums", Integer.parseInt(selectedValue));
                    CreateSQL.deleteRow(CreateSQL.giveConnection(), "providerinfo", "num", selectedValue);
                    CreateSQL.deleteRow(CreateSQL.giveConnection(), "bill", "providercode", selectedValue);
                    showOkDialog("Provider deleted");
                    listModel = ListModelLoaders.loadListModelProviderNumbers();
                    reportList.setModel(listModel);

                    // Deselect the option
                    reportList.clearSelection();
                } else {
                    // User clicked No, deselect the option
                    reportList.clearSelection();
                }

                // Set focus back to the main frame
                deleteProviderFrame.requestFocus();
            }
        }
    }
    
    private int showOkDialog(String message) {
        ImageIcon customIcon = new ImageIcon(getClass().getResource("/ChocolateIcon1.jpg"));
        Object[] option = {"Okay"};
        return JOptionPane.showOptionDialog(
        			deleteProviderFrame,
                    message,
                    "Confirmation",
                    JOptionPane.OK_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    customIcon,
                    option,
                    option[0]);
                    
      }

}
