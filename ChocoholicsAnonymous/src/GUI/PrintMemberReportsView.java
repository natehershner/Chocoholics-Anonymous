/*
 * Displays Member Report.
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
import java.awt.Insets;
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


public class PrintMemberReportsView implements ActionListener, MouseListener{
	private JFrame printMemberReportsViewFrame;
    private JPanel printMemberReportsViewPanel;
    private JList<String> reportList;
    private DefaultListModel<String> listModel;
	public PrintMemberReportsView(String code) {
        printMemberReportsViewFrame = new JFrame("View Members's Reports");
        ImageIcon frameIcon = new ImageIcon("resources/ChocolateIcon.jpg");
        printMemberReportsViewFrame.setIconImage(frameIcon.getImage());

        JButton button = createButton("Available Reports");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(500, 100));
        button.setMaximumSize(new Dimension(450, 100));

        Font buttonFont = new Font("Rockwell", Font.BOLD, 30);
        button.setFont(buttonFont);

        printMemberReportsViewPanel = new JPanel();
        printMemberReportsViewPanel.setLayout(new BoxLayout(printMemberReportsViewPanel, BoxLayout.Y_AXIS));
        printMemberReportsViewPanel.setBackground(new Color(0xADD8E6));
        printMemberReportsViewPanel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        ImageIcon imageIcon = new ImageIcon("resources/Manager.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setBorder(new LineBorder(Color.decode("#0047AB"), 5));

        // Load elements from the folder and add them to listModel
        listModel = ListModelLoaders.loadListModelMemberReports(code);

        Font listFont = new Font("Rockwell", Font.PLAIN, 30);

        reportList = new JList<>(listModel);
        reportList.setFont(listFont);

        JScrollPane scrollPane = new JScrollPane(reportList);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        scrollPane.setMaximumSize(new Dimension(1000, 300));

        printMemberReportsViewPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        printMemberReportsViewPanel.add(imageLabel);
        printMemberReportsViewPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        printMemberReportsViewPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printMemberReportsViewPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        printMemberReportsViewPanel.add(scrollPane);

        printMemberReportsViewFrame.add(printMemberReportsViewPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(printMemberReportsViewFrame.getGraphicsConfiguration());
        int windowWidth = screenSize.width - (insets.left + insets.right);
        int windowHeight = screenSize.height - (insets.top + insets.bottom);
        printMemberReportsViewFrame.setSize(windowWidth, windowHeight);
        printMemberReportsViewFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);        
        printMemberReportsViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printMemberReportsViewFrame.setLocationRelativeTo(null);
        printMemberReportsViewFrame.setVisible(true);

        printMemberReportsViewPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        printMemberReportsViewPanel.add(button);
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
        if (clickedButton.getText().equals("Available Reports")) {
            // Dispose of the current frame
        	new PrintMemberReport();
            printMemberReportsViewFrame.dispose();
            
        }
    }
}

    
    
