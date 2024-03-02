/**
 * The ViewReports class represents a graphical user interface for viewing and searching reports.
 * It allows the user to search for specific reports, filter the displayed list, and open selected reports.
 * 
 * @author Tyler Gazzam
 * @since 2023-04-12
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

public class ViewReports implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame viewReportsFrame;
    private JPanel viewReportsPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    /**
     * Constructs a ViewReports object, initializing the graphical user interface.
     */
    public ViewReports() {
        viewReportsFrame = new JFrame("View Reports");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        viewReportsFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        viewReportsPanel = new JPanel();
        viewReportsPanel.setLayout(new BoxLayout(viewReportsPanel, BoxLayout.Y_AXIS));
        viewReportsPanel.setBackground(new Color(0x996666));
        viewReportsPanel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Operator1.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#993366"), 5));

        JLabel headerLabel = new JLabel("Search Reports");
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
        listModel = new DefaultListModel<>();
        loadListModelFromFolder("Member_Reports");

        Font listFont = new Font("Rockwell", Font.PLAIN, 30);

        reportList = new JList<>(listModel);
        reportList.setFont(listFont);

        JScrollPane scrollPane = new JScrollPane(reportList);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(200, 150));
        scrollPane.setMaximumSize(new Dimension(1000, 300));

        viewReportsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        viewReportsPanel.add(imageLabel);
        viewReportsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        viewReportsPanel.add(headerLabel);
        viewReportsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        viewReportsPanel.add(searchBar);
        viewReportsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        viewReportsPanel.add(scrollPane);

        viewReportsFrame.add(viewReportsPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        viewReportsFrame.setSize(screenSize);
        viewReportsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewReportsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        viewReportsFrame.setLocationRelativeTo(null);
        viewReportsFrame.setVisible(true);

        viewReportsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        viewReportsPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportList.addListSelectionListener(this);
    }
    
    /**
     * Creates a JButton with the specified text.
     * 
     * @param text The text to be displayed on the button.
     * @return The created JButton.
     */

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addMouseListener(this);
        button.setFocusPainted(false);
        return button;
    }

    /**
     * Filters the displayed list based on the text entered in the search bar.
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
    
    /**
     * Loads the list model with file names from the specified folder.
     * 
     * @param folderPath The path of the folder containing the files.
     */

    private void loadListModelFromFolder(String folderPath) {
    	String line;
        int numCodes = CreateSQL.getColumnItemCount(CreateSQL.giveConnection(), "bill", "providercode");
        String[] arr = CreateSQL.getColumnValuesString(CreateSQL.giveConnection(), "bill", "providercode");
        String[] arr2 = CreateSQL.getColumnValuesString(CreateSQL.giveConnection(), "bill", "servicedate");
        for (int i = 0; i < numCodes; i++) {
        	line = arr[i] + " - " + arr2[i];
        	listModel.addElement(line);
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Return to Terminal")) {
            // Dispose of the current frame
        	new OperatorTerminal();
            viewReportsFrame.dispose();
        }
    }

    private int showConfirmationDialog(String selectedItem) {
        String message = "Do you want to open this file?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(viewReportsFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        viewReportsFrame.requestFocus();

        return response;
    }
    
    /**
     * Handles the value changed event in the report list.
     * If a file is selected and the user confirms, opens EditReports with the selected file name.
     * If the user clicks No, deselects the option.
     * 
     * @param e The ListSelectionEvent.
     */

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedValue = reportList.getSelectedValue();
            if (selectedValue != null) {
                int response = showConfirmationDialog(selectedValue);

                if (response == JOptionPane.YES_OPTION) {
                    // Open EditReports with the selected file name
                    new EditReports(selectedValue);
                    viewReportsFrame.dispose();
                } else {
                    // User clicked No, deselect the option
                    reportList.clearSelection();
                }

                // Set focus back to the main frame
                viewReportsFrame.requestFocus();
            }
        }
    }
}