import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void main(String[] args) {

        //JFrame and JPanel setup
        JFrame frame = new JFrame("Event Calender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EventListPanel eventlistpanel = new EventListPanel();
        frame.getContentPane().add(eventlistpanel);

        frame.pack();
        frame.setVisible(true);

    }

    public static void addDefaultEvents(EventListPanel events){

        //Add default events, 1 Meeting and 1 Deadline
        //Also look man I really dont think this should count as magic numbers
        // I dont want to have to make 5 variables just for these default events
        Deadline defaultDeadline = new Deadline("Default Deadline", LocalDateTime.of(2024,12,31,23,59));
        Meeting defaultMeeting = new Meeting("Default Meeting", LocalDateTime.of(2023,12,31,23,59),
                LocalDateTime.of(2025,12,31,23,59), "UCA");
        events.addEvent(defaultMeeting);
        events.addEvent(defaultDeadline);
    }

}
