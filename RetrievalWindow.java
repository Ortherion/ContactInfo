
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This program was written for 
 * University of Phoenix
 * The RetrievalWindow class creates the frame used by the program
 * and implements the main panel where functionality will take place.
 * @author Victor M. Beas
 */
class RetrievalWindow extends JFrame {
    private RetrievalPanel panel;
    private JPanel panelBuilder;
    
    public RetrievalWindow() {
        super("Contact Information Retrieval Tool");
        
        panel = new RetrievalPanel();
        
        this.buildRetrievalWindow();
    }

    private void buildRetrievalWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelBuilder = panel.createRetrievalPanel();
        add(panelBuilder);
        
        setSize(650, 250);
        setVisible(true);
    }
}
