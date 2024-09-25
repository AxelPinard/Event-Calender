import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddEventModal extends JFrame {
    private EventListPanel eventListPanel;
    AddEventModal modal;

    record Attribute(String name, JTextField value) {}

    ArrayList<Attribute> attributes;
    JPanel infoCollectorPanel;
    JComboBox<String> eventTypeComboBox;

    public static final String[] eventTypes = {"Deadline", "Meeting"};

    public AddEventModal(EventListPanel eventListPanel) {
        modal = this;
        this.eventListPanel = eventListPanel;

        this.setTitle("Add Event");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(addEventPanel());
        this.pack();
        this.setVisible(true);
    }

    private JPanel addEventPanel(){
        JPanel panel = new JPanel();
        attributes = new ArrayList<>();

        infoCollectorPanel = new JPanel();
        infoCollectorPanel.setPreferredSize(new Dimension(600, 400));
        infoCollectorPanel.setBackground(Color.magenta);

        eventTypeComboBox = new JComboBox<String>(eventTypes);
        eventTypeComboBox.addActionListener(getEventChooser());

        panel.add(eventTypeComboBox);
        panel.add(infoCollectorPanel);

        JButton addEventButton = new JButton("Submit");
        addEventButton.addActionListener(getEventCreator());

        panel.setPreferredSize(new Dimension(500, 500));
        panel.add(addEventButton);

        return panel;
    }

    private ActionListener getEventChooser() {
        return e -> {
            attributes.clear();
            infoCollectorPanel.removeAll();
            switch (eventTypeComboBox.getSelectedIndex()) {
                case 0: {
                    attributes.add(new Attribute("Name", new JTextField(10)));
                    attributes.add(new Attribute("Year", new JTextField(10)));
                    attributes.add(new Attribute("Month", new JTextField(10)));
                    attributes.add(new Attribute("Day", new JTextField(10)));
                    attributes.add(new Attribute("Hour", new JTextField(10)));
                    attributes.add(new Attribute("Minute", new JTextField(10)));
                    break;
                }
                case 1: {
                    attributes.add(new Attribute("Name", new JTextField(10)));
                    attributes.add(new Attribute("Location", new JTextField(10)));
                    attributes.add(new Attribute("Year", new JTextField(10)));
                    attributes.add(new Attribute("Month", new JTextField(10)));
                    attributes.add(new Attribute("Day", new JTextField(10)));
                    attributes.add(new Attribute("Hour", new JTextField(10)));
                    attributes.add(new Attribute("Minute", new JTextField(10)));
                    attributes.add(new Attribute("End Year", new JTextField(10)));
                    attributes.add(new Attribute("End Month", new JTextField(10)));
                    attributes.add(new Attribute("End Day", new JTextField(10)));
                    attributes.add(new Attribute("End Hour", new JTextField(10)));
                    attributes.add(new Attribute("End Minute", new JTextField(10)));

                    break;
                }
            }
            attributes.forEach(attr -> {
                infoCollectorPanel.add(new JLabel(attr.name));
                infoCollectorPanel.add(attr.value);
            });
            infoCollectorPanel.revalidate();
            infoCollectorPanel.repaint();
        };
    }


    private ActionListener getEventCreator() {
        return e -> {
            Event newEvent = new Deadline("Error",LocalDateTime.now());   // need to initialize abstract Animal Variable
            switch (eventTypeComboBox.getSelectedIndex()) {
                case 0: {
                    LocalDateTime newDate = LocalDateTime.of(Integer.parseInt(attributes.get(1).value.getText()),
                            Integer.parseInt(attributes.get(2).value.getText()),
                            Integer.parseInt(attributes.get(3).value.getText()),
                            Integer.parseInt(attributes.get(4).value.getText()),
                            Integer.parseInt(attributes.get(5).value.getText()));

                    newEvent = new Deadline(attributes.get(0).value.getText(), newDate);
                    break;
                }
                case 1: {
                    LocalDateTime newDate = LocalDateTime.of(Integer.parseInt(attributes.get(2).value.getText()),
                            Integer.parseInt(attributes.get(3).value.getText()),
                            Integer.parseInt(attributes.get(4).value.getText()),
                            Integer.parseInt(attributes.get(5).value.getText()),
                            Integer.parseInt(attributes.get(6).value.getText()));

                    LocalDateTime newEndDate = LocalDateTime.of(Integer.parseInt(attributes.get(7).value.getText()),
                            Integer.parseInt(attributes.get(8).value.getText()),
                            Integer.parseInt(attributes.get(9).value.getText()),
                            Integer.parseInt(attributes.get(10).value.getText()),
                            Integer.parseInt(attributes.get(11).value.getText()));

                    newEvent = new Meeting(attributes.get(0).value.getText(),newDate,newEndDate,attributes.get(1).value.getText());
                    break;
                }
            }
            System.out.println("hi before");
            eventListPanel.addEvent(newEvent);
            System.out.println("hi after");
            modal.dispose();
        };
    }
}