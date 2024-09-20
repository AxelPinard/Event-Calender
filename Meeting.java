import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Meeting extends Event implements Completable{
    //Variable Init
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete = false;
    public Reminder[] reminders = new Reminder[0];

    //Constructor
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location){
        setName(name);
        setDateTime(start);
        endDateTime = end;
        this.location = location;
    }

    //Setting up Reminders for our Meeting
    public void addReminder(int daysBefore, int hoursBefore, int minutesBefore){
        Reminder newReminder = new Reminder(daysBefore,hoursBefore,minutesBefore, this);
        reminders = Arrays.copyOf(reminders, reminders.length + 1);
        reminders[reminders.length-1] = newReminder;
    }

    //Fulfill the Completable interface contract
    public void complete(){complete = true;}
    public boolean isComplete(){return complete;}

    //Setters and getters
    public LocalDateTime getEndDateTime(){return endDateTime;}
    public String getLocation(){return location;}
    public Duration getDuration(){return Duration.between(getDateTime(),endDateTime);}
    public void setEndDateTime(LocalDateTime end){this.endDateTime = end;}
    public void setLocation(String location){this.location = location;}

}
