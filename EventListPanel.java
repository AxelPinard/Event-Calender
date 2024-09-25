import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {

    //GUI Objects
    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox sortDropDown;
    JCheckBox filterDisplay;
    JButton addEventButton;

    //Other Variables
    private final int FrameSizeX = 750;
    private final int FrameSizeY = 1000;
    private final int ControlPanelX = 700;
    private final int ControlPanelY = 300;


    public EventListPanel() {
        setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));
        setBackground(Color.black);
        events = new ArrayList<>();

        //Control Panel
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(ControlPanelX,ControlPanelY));

        //Add Event Button
        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Serif", Font.BOLD, 30));
        addEventButton.addActionListener(e -> {
            new AddEventModal(this);
        });
        controlPanel.add(addEventButton);


        add(controlPanel);
    }

    public void addEvent(Event event) {
        System.out.println("Hi Inside");
        events.add(event);
        System.out.println("Hi Inside2");
        updateDisplay();
        System.out.println("Hi Inside3");
    }

    public void updateDisplay(){
        //displayPanel.removeAll();
        revalidate();
        repaint();

    }

}
