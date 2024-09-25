import javax.swing.*;

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

    //public static void addDefaultEvents(EventPanel events){
        //Add default events, 1 Meeting and 1 Deadline
    //}

}
