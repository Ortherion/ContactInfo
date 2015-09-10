
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This program was written for 
 * University of Phoenix
 * All GUI components are created here
 * @author Victor M. Beas
 */

public class ContactPanel extends JPanel implements ActionListener {
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    
    private JPanel infoPanelTop;
    private JPanel infoPanelBottom;
    private JPanel buttonPanel;
    
    private JButton saveButton;
    private JButton clearButton;
    private JButton exitButton;
    
    private JTextField nameField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField phoneField;
    
    private String contactCard = "";
    private String name = "";
    private String email = "";
    private String phoneNoString = ""; // String can validate length and catch leading 0's
    private String ageString = "";
    private int age = 0;
    
    /**
     * Initializes private variables
     */
    public ContactPanel() {
        
        // Initializes private variables
        nameLabel = new JLabel("Name: ");
        ageLabel = new JLabel("Age: ");
        emailLabel = new JLabel("E-Mail: ");
        phoneLabel = new JLabel("Phone Number: ");
        
        nameField = new JTextField("", 20);
        ageField = new JTextField("", 20);
        emailField = new JTextField("", 20);
        phoneField = new JTextField("", 20);
        
        // Creates panels
        infoPanelTop = new JPanel();
        infoPanelBottom = new JPanel();
        buttonPanel = new JPanel();
        
        // Creates buttons
        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
    }
    
    public JPanel createContactPanel() {
        // Sets BorderLayout manager for the main panel
        setLayout(new BorderLayout());
        
        // Sets layout manager for top label and text fields
        infoPanelTop.setLayout(new FlowLayout());
        
        infoPanelTop.add(nameLabel);
        infoPanelTop.add(nameField);
        infoPanelTop.add(ageLabel);
        infoPanelTop.add(ageField);
        
        add(infoPanelTop, BorderLayout.NORTH);
        
        //Sets layout manager for bottom label and text fields
        infoPanelBottom.add(emailLabel);
        infoPanelBottom.add(emailField);
        infoPanelBottom.add(phoneLabel);
        infoPanelBottom.add(phoneField);
        
        add(infoPanelBottom, BorderLayout.CENTER);
        
        // Sets layout manger for bottom button section
        buttonPanel.setLayout(new FlowLayout());
        
        // Names buttons and adds listeners. Adds buttons to panel
        saveButton.setName("save");
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);
        
        clearButton.setName("clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);
        
        // Adds exit button. No need to setName as ExitButtonListener is its own class
        exitButton.addActionListener(new ExitButtonListener());
        buttonPanel.add(exitButton);
        
        // Adds button panel to main panel
        add(buttonPanel, BorderLayout.SOUTH);
        
        return (this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = "";
        buttonName = ((JButton)e.getSource()).getName();
        
        if (buttonName.equals("save")) {
            // Checks if name and email fields are filled
            this.name = nameField.getText();
            if (this.name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the donor name.", "Donor Name Error", JOptionPane.WARNING_MESSAGE);
            } else {
                this.email = emailField.getText();
                if (this.email.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid E-mail address.", "Donor E-Mail Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                    // Validates numeric input and checks phone number and age 
                    try {
                        this.phoneNoString = phoneField.getText();
                        if (this.phoneNoString.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please enter the donor phone number", "Donor Phone Number Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if (this.phoneNoString.length() != 10) {
                                JOptionPane.showMessageDialog(null, "Please enter a 10 digit phone number", "Donor Phone Number Length Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                this.ageString = ageField.getText();
                                if (this.ageString.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the donor age.", "Donor Age Error", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    this.age = Integer.parseInt(this.ageString);
                                    if (this.age > 120 || this.age < 0) {
                                        JOptionPane.showMessageDialog(null, "Age must be between 0 and 120.", "Donor Age Error", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        contactCard = "Name: " + this.name + "\nAge: " + this.ageString +
                                                "\nE-Mail: " + this.email + "\nPhone Number: " + this.phoneNoString + "\n\n";
                                        InfoSave(contactCard);
                                    }
                                }
                            }
                        }
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(null, "Please enter numeric values.", "Numeric Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else if (buttonName.equals("clear")) {
            this.nameField.setText("");
            this.ageField.setText("");
            this.emailField.setText("");
            this.phoneField.setText("");
        }
    }
    
    // This method is used to save output to a file contactlist.dat
    public void InfoSave(String c) throws FileNotFoundException, IOException {
        File infoFile = new File("contactlist.dat");
        
        FileWriter outputFile = new FileWriter(infoFile,true);
        
        outputFile.write(c);
        
        outputFile.close();
        JOptionPane.showMessageDialog(null, "File successfully saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
