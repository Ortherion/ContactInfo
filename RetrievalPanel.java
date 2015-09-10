
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * This program was written for 
 * University of Phoenix
 * @author Victor M. Beas
 */

public class RetrievalPanel extends JPanel implements ActionListener {
    private JButton loadContactsButton;
    private JButton exitButton;
    
    private JTextArea contactList;
    
    private JPanel buttonPanel;
    private JPanel displayPanel;
    
    private JScrollPane scrollPane;
    
    private String contactInformationList;
    
    
    /**
     * Initializes private variables
     */
    public RetrievalPanel() {
        // Create Buttons
        loadContactsButton = new JButton("Load Contact List");
        exitButton = new JButton("Exit");
        
        contactList = new JTextArea("\tContact List:\n\n");
        scrollPane = new JScrollPane(contactList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                                     JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        contactList.setEditable(false);
        
        buttonPanel = new JPanel();
        displayPanel = new JPanel();
        
        contactInformationList = "";
    }
    
    public JPanel createRetrievalPanel() {
        setLayout(new BorderLayout());
        
        // Creates button panel, sets layout and adds buttons
        buttonPanel.setLayout(new FlowLayout());
        
        loadContactsButton.setName("loadcontacts");
        loadContactsButton.addActionListener(this);
        buttonPanel.add(loadContactsButton);
        
        exitButton.addActionListener(new ExitButtonListener());
        buttonPanel.add(exitButton);
        
        add(buttonPanel, BorderLayout.NORTH);
        
        // Creates display panel and adds buttons
        contactList.setLineWrap(true);
        JScrollPane myScrollPane = new JScrollPane(contactList);
        
        add(myScrollPane, BorderLayout.CENTER);
        
        
        return (this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handler for clear and save buttons
        String buttonName = "";
        buttonName = ((JButton) e.getSource()).getName();
        
        if (buttonName.equals("loadcontacts")); {
            try {
                Scanner in = new Scanner(new FileReader("contactList.dat"));
                while (in.hasNext()) {
                    contactList.append("\t" + in.nextLine() + "\n");
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "File Not Found!", "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}
