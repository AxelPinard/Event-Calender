import java.time.Duration;
import java.time.LocalDateTime;

public class Reminder extends Event{
    private Duration timeBefore;
    private Event event;

    //Constructor
    public Reminder(int daysBefore, int hoursBefore, int minutesBefore, Event e){
        timeBefore = Duration.ofDays(daysBefore);
        timeBefore = timeBefore.plusHours(hoursBefore);
        timeBefore = timeBefore.plusMinutes(minutesBefore);
        event = e;
    }

    //getters
    public Duration getTimeBefore(){return timeBefore;}
    public LocalDateTime getDateTime(Event e){return e.getDateTime().minus(timeBefore);}
    public String getReminder(){return ("Reminder that " + event.getName() + " starts on " + event.getDateTime());}
}
