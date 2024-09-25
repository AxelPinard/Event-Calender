//Parent class for Deadline and Meeting

import java.time.LocalDateTime;
import java.util.Arrays;

abstract class Event implements Comparable<Event> {

    //variable init
    private String name;
    private LocalDateTime dateTime;
    private Reminder[] reminders = new Reminder[0];

    //Constructor
    public Event(String name, LocalDateTime dateTime){}
    public Event(){}

    //Reminder adder and getter
    public void addReminder(int daysBefore, int hoursBefore, int minutesBefore){
        Reminder newReminder = new Reminder(daysBefore,hoursBefore,minutesBefore, this);
        reminders = Arrays.copyOf(reminders, reminders.length + 1);
        reminders[reminders.length-1] = newReminder;
    }
    public Reminder[] getReminders(){return reminders;}

    //compareTo takes an Event and compares that events date to another Event date
    //then returns a -1 for before, 0 for same day, and 1 for after
    //EX. 9-22-24.compare(9-13-24) gives a 1 for after
    public int compareTo(Event e){
        return this.dateTime.compareTo(e.dateTime);
    }

    //Following 4 methods are simple setters and getters
    void setName(String name){
        this.name = name;
    }
    void setDateTime(LocalDateTime date){
        this.dateTime = date;
    }
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public String getName(){
        return name;
    }
}
