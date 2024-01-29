/**
 * This class is responsible for printing reports for members, including searching and filtering options.
 * It provides functionality for viewing and printing reports based on member information.
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

public class PrintMemberReport implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame printMemberReportFrame;
    private JPanel operatorDirectoryPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    /**
     * Constructor for the PrintMemberReport class. Initializes the GUI and sets up the necessary components.
     */
    public PrintMemberReport() {
        printMemberReportFrame = new JFrame("View Members");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        printMemberReportFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        operatorDirectoryPanel = new JPanel();
        operatorDirectoryPanel.setLayout(new BoxLayout(operatorDirectoryPanel, BoxLayout.Y_AXIS));
        operatorDirectoryPanel.setBackground(new Color(0xADD8E6));
        operatorDirectoryPanel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        ImageIcon imageIcon = new ImageIcon("resources/Manager.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        JLabel headerLabel = new JLabel("Search Members");
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

        operatorDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        operatorDirectoryPanel.add(imageLabel);
        operatorDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        operatorDirectoryPanel.add(headerLabel);
        operatorDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        operatorDirectoryPanel.add(searchBar);
        operatorDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        operatorDirectoryPanel.add(scrollPane);

        printMemberReportFrame.add(operatorDirectoryPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(printMemberReportFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        printMemberReportFrame.setSize(windowWidth, windowHeight);
        printMemberReportFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
        printMemberReportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printMemberReportFrame.setLocationRelativeTo(null);
        printMemberReportFrame.setVisible(true);

        operatorDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        operatorDirectoryPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportList.addListSelectionListener(this);
    }

    /**
     * Creates a JButton with the specified text and adds a mouse listener to it.
     * 
     * @param text The text to be displayed on the button.
     * @return The created JButton.
     */
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addMouseListener(this);
        return button;
    }

    /**
     * Filters the list of members based on the entered search text.
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Return to Terminal")) {
            // Dispose of the current frame
        	new ManagerTerminal();
            printMemberReportFrame.dispose();
        }
    }

    /**
     * Displays a confirmation dialog for printing a member report.
     * 
     * @param selectedItem The selected member number.
     * @return The user's response to the confirmation dialog.
     */
    private int showConfirmationDialog(String selectedItem) {
        String message = "Do you want to print this member report?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(printMemberReportFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        printMemberReportFrame.requestFocus();

        return response;
    }
    

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedMemberNumber = reportList.getSelectedValue();
            if (selectedMemberNumber != null) {
                int response = showConfirmationDialog(selectedMemberNumber);

                if (response == JOptionPane.YES_OPTION) {
                	new PrintMemberReportsView(selectedMemberNumber);
                	printMemberReportFrame.dispose();
                } else {
                    // User clicked No, deselect the option
                    reportList.clearSelection();
                }

                // Set focus back to the main frame
                printMemberReportFrame.requestFocus();
            }
        }
    }
}

    
