import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class EventListPanel extends JPanel {

    //GUI Objects
    ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox<String> eventComboBox;
    final String[] SORT_OPTIONS = {"DUE FIRST", "DUE LAST", "NAME", "REVERSE NAME"};
    JButton addEventButton;
    Map<String, Predicate<Event>> filters;
    ArrayList<JCheckBox> filterBoxes;
    CalenderEventFilters eventfilter = new CalenderEventFilters();
    private final int FrameSizeX = 750;
    private final int FrameSizeY = 1000;
    private final int ControlPanelX = 700;
    private final int ControlPanelY = 300;
    private final int size = 30;


    public EventListPanel() {
        setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));
        setBackground(Color.black);
        events = new ArrayList<>();

        //Control Panel
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(ControlPanelX,ControlPanelY));

        //Display Panel
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(FrameSizeX, FrameSizeY));

        //Add Event Button
        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Serif", Font.BOLD, size));
        addEventButton.addActionListener(e -> {
            new AddEventModal(this);
        });
        controlPanel.add(addEventButton);

        //add Sorting
        eventComboBox = new JComboBox(SORT_OPTIONS);
        eventComboBox.setFont(new Font("Arial", Font.BOLD, size));
        eventComboBox.addActionListener(e -> {
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[0]))
                events.sort((a1,a2) -> a1.getDateTime().compareTo(a2.getDateTime()));
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[1]))
                events.sort((a1, a2) -> a2.getDateTime().compareTo(a1.getDateTime()));
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[2]))
                events.sort((a1, a2) -> a1.getName().compareTo(a2.getName()));
            if (eventComboBox.getSelectedItem().equals(SORT_OPTIONS[3]))
                events.sort((a1, a2) -> a2.getName().compareTo(a1.getName()));
            updateDisplay();
        });
        controlPanel.add(eventComboBox);

        //add Filtering
        filters = new HashMap<>();
        filters.putAll(eventfilter.getEventFilters());
        filterBoxes = new ArrayList<>();

        for ( String filter : filters.keySet()){
            JCheckBox box = new JCheckBox(filter);
            box.setFont(new Font("Arial", Font.BOLD, 30));
            box.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    updateDisplay();
                }
            });
            filterBoxes.add(box);
        }

        for (JCheckBox filter : filterBoxes)
            controlPanel.add(filter);

        add(controlPanel);
        add(displayPanel);

        //Default Events
        EventPlanner.addDefaultEvents(this);


    }

    public void addEvent(Event event) {
        events.add(event);
        updateDisplay();
    }

    public boolean isFiltered(Event event)  {
        boolean result = false;
        for (JCheckBox filter : filterBoxes)
            if (filter.isSelected()) {
                Predicate<Event> pred = filters.get(filter.getText());
                if (pred.test(event))
                    result = true;
            }
        return result;
    }

    public void updateDisplay(){
        displayPanel.removeAll();
        for (Event event : events) {
            if(!isFiltered(event))
                displayPanel.add(new EventPanel(event,this));
        }
        revalidate();
        repaint();
    }
}
