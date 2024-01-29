/**
 * The PrintEFTReport class represents a graphical user interface (GUI) for printing EFT reports.
 * It allows the user to search for providers, filter the list, and print EFT reports for selected providers.
 * The class implements ActionListener, MouseListener, and ListSelectionListener interfaces to handle
 * button actions, mouse events, and list selection events, respectively.
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

public class PrintEFTReport implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame PrintEFTReportsFrame;
    private JPanel printEFTReportPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    /**
     * Constructs a PrintEFTReport object and initializes the GUI components.
     */
    public PrintEFTReport() {
        PrintEFTReportsFrame = new JFrame("View Providers");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        PrintEFTReportsFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        printEFTReportPanel = new JPanel();
        printEFTReportPanel.setLayout(new BoxLayout(printEFTReportPanel, BoxLayout.Y_AXIS));
        printEFTReportPanel.setBackground(new Color(0xADD8E6));
        printEFTReportPanel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

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

        printEFTReportPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        printEFTReportPanel.add(imageLabel);
        printEFTReportPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        printEFTReportPanel.add(headerLabel);
        printEFTReportPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printEFTReportPanel.add(searchBar);
        printEFTReportPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printEFTReportPanel.add(scrollPane);

        PrintEFTReportsFrame.add(printEFTReportPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(PrintEFTReportsFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        PrintEFTReportsFrame.setSize(windowWidth, windowHeight);
        PrintEFTReportsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
        PrintEFTReportsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PrintEFTReportsFrame.setLocationRelativeTo(null);
        PrintEFTReportsFrame.setVisible(true);

        printEFTReportPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        printEFTReportPanel.add(button);
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
     * Filters the list based on the text entered in the search bar.
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
     * 
     *Allows the user to return home
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Return to Terminal")) {
            // Dispose of the current frame
        	new ManagerTerminal();
            PrintEFTReportsFrame.dispose();
        }
    }

    /**
     * 
     *Option dialog for user to print EFT report
     * 
     */
    private int showConfirmationDialog(String selectedItem) {
        String message = "Do you want to print this EFT report?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(PrintEFTReportsFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        PrintEFTReportsFrame.requestFocus();

        return response;
    }

    /**
     * Asks user if they want to keep selected provider number
     *
     * .
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedProviderNumber = reportList.getSelectedValue();
            if (selectedProviderNumber != null) {
                int response = showConfirmationDialog(selectedProviderNumber);

                if (response == JOptionPane.YES_OPTION) {
                    // Extract information from "Member_Information.txt" for the selected member
                    new EFTReportViewer(selectedProviderNumber);
                    PrintEFTReportsFrame.dispose();
                    
                } else {
                    // User clicked No, deselect the option
                    reportList.clearSelection();
                }

                // Set focus back to the main frame
                PrintEFTReportsFrame.requestFocus();
            }
        }
    }	 
}