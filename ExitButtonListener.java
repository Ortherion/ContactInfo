
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This program was written for 
 * University of Phoenix
 * An action listener class for the exit button to exit the application
 * @author Victor M. Beas
 */
public class ExitButtonListener implements ActionListener {

    /**
     * actionPerformed method
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
