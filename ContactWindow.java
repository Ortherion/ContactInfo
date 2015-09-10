
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This program was written for 
 * University of Phoenix
 * The ContactWindow class creates the frame used by the program
 * and implements the main panel where functionality will take place.
 * @author Victor M. Beas
 */

public class ContactWindow extends JFrame {
    
    private ContactPanel panel;
    private JPanel panelBuilder;
    
    public ContactWindow() {
        super("Contact Information Program");
        
        panel = new ContactPanel();
        
        this.buildContactWindow();
    }

    private void buildContactWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelBuilder = panel.createContactPanel();
        add(panelBuilder);
        
        setSize(650, 150);
        
        setVisible(true);
        
        
    }
}
