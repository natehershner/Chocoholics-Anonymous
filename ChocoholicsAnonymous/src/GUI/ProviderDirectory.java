/**
 * The ProviderDirectory class manages the Provider Directory GUI, allowing users to
 * search and view information about providers. It includes methods for creating and
 * handling the directory frame, filtering the provider list, loading data from a file,
 * and responding to user actions.
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


public class ProviderDirectory implements ActionListener, MouseListener, ListSelectionListener {

    private JFrame providerDirectoryFrame;
    private JPanel providerDirectoryPanel;
    private JList<String> providerList;
    private DefaultListModel<String> listModel;
    private JTextField searchBar;

    /**
     * Constructs a new ProviderDirectory instance, initializing and displaying the GUI frame.
     */
    public ProviderDirectory() {
        providerDirectoryFrame = new JFrame("Provider Directory");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        providerDirectoryFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Return to Terminal");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        providerDirectoryPanel = new JPanel();
        providerDirectoryPanel.setLayout(new BoxLayout(providerDirectoryPanel, BoxLayout.Y_AXIS));
        providerDirectoryPanel.setBackground(new Color(0xFF9966));
        providerDirectoryPanel.setBorder(new LineBorder(Color.decode("#CC6600"), 5));

        ImageIcon imageIcon = new ImageIcon("resources/Provider.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#CC6600"), 5));

        JLabel headerLabel = new JLabel("Provider Directory");
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

        // Load elements from the file and add them to listModel
        listModel = ListModelLoaders.loadListModelProviderDirectory();

        Font listFont = new Font("Rockwell", Font.PLAIN, 30);

        providerList = new JList<>(listModel);
        providerList.setFont(listFont);

        JScrollPane scrollPane = new JScrollPane(providerList);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(200, 150));
        scrollPane.setMaximumSize(new Dimension(1000, 300));

        providerDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        providerDirectoryPanel.add(imageLabel);
        providerDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        providerDirectoryPanel.add(headerLabel);
        providerDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        providerDirectoryPanel.add(searchBar);
        providerDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        providerDirectoryPanel.add(scrollPane);

        providerDirectoryFrame.add(providerDirectoryPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(providerDirectoryFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        providerDirectoryFrame.setSize(windowWidth, windowHeight);

        providerDirectoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        providerDirectoryFrame.setLocationRelativeTo(null);
        providerDirectoryFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        providerDirectoryFrame.setVisible(true);

        providerDirectoryPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        providerDirectoryPanel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        providerList.addListSelectionListener(this);
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

        providerList.setModel(filteredModel);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("Return to Terminal")) {
            // Dispose of the current frame
        	new ProviderTerminal();
            providerDirectoryFrame.dispose();
            
        }
    }

    private int showConfirmationDialog(String selectedItem) {
        String message = "Is the information correct?\n" + selectedItem;
        int optionType = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;

        int response = JOptionPane.showConfirmDialog(providerDirectoryFrame, message, "Confirmation", optionType, messageType);

        // Request focus on the main frame to ensure it regains focus
        providerDirectoryFrame.requestFocus();

        return response;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedValue = providerList.getSelectedValue();
            if (selectedValue != null) {
                int response = showConfirmationDialog(selectedValue);

                if (response == JOptionPane.YES_OPTION) {
                    // Break down the selectedValue into its integer counterpart
                    try {
                       
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                        // Handle the case where parsing fails
                        ex.printStackTrace(); // Or log the exception
                    }
                } else {
                    // User clicked No, deselect the option
                    providerList.clearSelection();
                }

                // Set focus back to the main frame
                providerDirectoryFrame.requestFocus();
            }
        }
    }
}