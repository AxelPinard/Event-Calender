import java.time.LocalDateTime;
import java.util.Arrays;

public class Deadline extends Event implements Completable{

    //Variable Init
    private Boolean complete = false;
    private Reminder[] reminders = new Reminder[0];

    //Constructor
    public Deadline(String name, LocalDateTime deadline){
        setName(name);
        setDateTime(deadline);
    }

    //setting up Reminders for our Deadline
    public void addReminder(int daysBefore, int hoursBefore, int minutesBefore){
        Reminder newReminder = new Reminder(daysBefore,hoursBefore,minutesBefore);
        reminders = Arrays.copyOf(reminders, reminders.length + 1);
        reminders[reminders.length-1] = newReminder;
    }

    //Fulfill the completable interface contract
    public void complete(){this.complete = true;}
    public boolean isComplete(){return this.complete;}
}
