/*
 * Prints summary report.
 * 
 * @author Nathaniel_Hershner
 * 
 * @since 2024-01-27
 */

package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class PrintSummaryReport implements ActionListener, MouseListener{
	private JFrame printSummaryReportFrame;
    private JPanel printSummaryReportPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
	public PrintSummaryReport() {
        printSummaryReportFrame = new JFrame("Summary Report");
        ImageIcon frameIcon = new ImageIcon(getClass().getResource("/ChocolateIcon.jpg"));
        printSummaryReportFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Return");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        printSummaryReportPanel = new JPanel();
        printSummaryReportPanel.setLayout(new BoxLayout(printSummaryReportPanel, BoxLayout.Y_AXIS));
        printSummaryReportPanel.setBackground(new Color(0xADD8E6));
        printSummaryReportPanel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Manager.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        

        

        // Load elements from the folder and add them to listModel
        listModel = ListModelLoaders.loadListModelSummaryReport();

        Font listFont = new Font("Rockwell", Font.PLAIN, 30);

        reportList = new JList<>(listModel);
        reportList.setFont(listFont);

        JScrollPane scrollPane = new JScrollPane(reportList);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        scrollPane.setMaximumSize(new Dimension(1000, 300));

        printSummaryReportPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        printSummaryReportPanel.add(imageLabel);
        printSummaryReportPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        printSummaryReportPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printSummaryReportPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printSummaryReportPanel.add(scrollPane);

        printSummaryReportFrame.add(printSummaryReportPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        printSummaryReportFrame.setSize(screenSize);
        printSummaryReportFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
        printSummaryReportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printSummaryReportFrame.setLocationRelativeTo(null);
        printSummaryReportFrame.setVisible(true);

        printSummaryReportPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        printSummaryReportPanel.add(button);
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
        button.addMouseListener(this);
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
        if (clickedButton.getText().equals("Return")) {
            // Dispose of the current frame
            new ManagerTerminal();
            printSummaryReportFrame.dispose();
        }
    }
}

    
    
