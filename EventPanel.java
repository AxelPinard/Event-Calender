import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
    private Event event;
    JButton completeButton = new JButton("Complete");
    private int PreferredX = 670;
    private int PreferredY = 50;
    private int r = 150;
    private int g = 150;
    private int b = 50;

    public EventPanel(Event event) {
        setPreferredSize(new Dimension(PreferredX, PreferredY));
        this.event = event;
        setBackground(new Color(r,g,b));

        JLabel eventLabel = new JLabel(event.getName());
        eventLabel.setFont(new Font("Serif", Font.BOLD, 30));
        add(eventLabel);
    }
}
