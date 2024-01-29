/**
 * The PrintProviderReport class handles the functionality of viewing and printing
 * provider reports. It includes methods for loading and filtering a list of providers,
 * displaying a graphical user interface, and interacting with user actions.
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

public class PrintProviderReport implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame printProviderReportsFrame;
    private JPanel printProviderReportsPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    /**
     * Constructor for PrintProviderReport class.
     * Initializes the graphical user interface for viewing provider reports.
     */
    public PrintProviderReport() {
        printProviderReportsFrame = new JFrame("View Providers");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        printProviderReportsFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        printProviderReportsPanel = new JPanel();
        printProviderReportsPanel.setLayout(new BoxLayout(printProviderReportsPanel, BoxLayout.Y_AXIS));
        printProviderReportsPanel.setBackground(new Color(0xADD8E6));
        printProviderReportsPanel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        ImageIcon imageIcon = new ImageIcon("resources/Manager.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        JLabel headerLabel = new JLabel("Search Providers");
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
        printProviderReportsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        printProviderReportsPanel.add(imageLabel);
        printProviderReportsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        printProviderReportsPanel.add(headerLabel);
        printProviderReportsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printProviderReportsPanel.add(searchBar);
        printProviderReportsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printProviderReportsPanel.add(scrollPane);
        printProviderReportsFrame.add(printProviderReportsPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(printProviderReportsFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        printProviderReportsFrame.setSize(windowWidth, windowHeight);
        printProviderReportsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
        printProviderReportsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printProviderReportsFrame.setLocationRelativeTo(null);
        printProviderReportsFrame.setVisible(true);

        printProviderReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        printProviderReportsPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportList.addListSelectionListener(this);
    }

    /**
     * Creates a JButton with the specified text.
     *
     * @param text The text to be displayed on the button.
     * @return A JButton with the specified text.
     */
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addMouseListener(this);
        return button;
    }

    /**
     * Filters the provider list based on the input search text.
     */
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
            button.setBackground(Color.decode("#0047AB"));
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
     * Handles the action events triggered by user interactions.
     *
     * @param e The ActionEvent object representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Return to Terminal")) {
            // Dispose of the current frame
        	new ManagerTerminal();
            printProviderReportsFrame.dispose();
        }
    }

    /**
     * Displays a confirmation dialog with the selected provider report.
     *
     * @param selectedItem The selected provider report to be confirmed.
     * @return An integer representing the user's response to the confirmation dialog.
     */
    private int showConfirmationDialog(String selectedItem) {
        String message = "Do you want to print this provider report?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(printProviderReportsFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        printProviderReportsFrame.requestFocus();

        return response;
    }
   
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedMemberNumber = reportList.getSelectedValue();
            if (selectedMemberNumber != null) {
                int response = showConfirmationDialog(selectedMemberNumber);

                if (response == JOptionPane.YES_OPTION) {
                    // Extract information from "Member_Information.txt" for the selected member
                    new PrintProviderReportsView(selectedMemberNumber);
                    printProviderReportsFrame.dispose();
                    
                } else {
                    // User clicked No, deselect the option
                    reportList.clearSelection();
                }

                // Set focus back to the main frame
                printProviderReportsFrame.requestFocus();
            }
        }
    }  
}