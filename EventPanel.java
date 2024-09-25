import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {

    //variable inti
    private Event event;
    JButton completeButton = new JButton("Complete");
    private int PreferredX = 670;
    private int PreferredY = 50;
    private int size = 15;
    private int r = 150;
    private int g = 150;
    private int b = 50;

    public EventPanel(Event event, EventListPanel self) {
        //some inital setup
        setPreferredSize(new Dimension(PreferredX, PreferredY));
        this.event = event;
        setBackground(new Color(r,g,b));

        //creates the string and buttons for the label
        String eventLabelString = event.getName() + " starts: " + event.getDateTime();
        if(event instanceof Meeting)
            eventLabelString += " lasts: " + ((Meeting)event).getDuration() + " at: " + ((Meeting) event).getLocation();
        if(event instanceof Completable) {
            eventLabelString += ((Completable) event).isComplete() ? " (complete)" : " (not complete)";

            completeButton.addActionListener(e -> {
                ((Completable) event).complete();
                self.updateDisplay();
            });
        }

        //Putting it together and adding to display
        JLabel eventLabel = new JLabel(eventLabelString);
        eventLabel.setFont(new Font("Serif", Font.BOLD, size));
        add(eventLabel);
        add(completeButton);
    }
}
