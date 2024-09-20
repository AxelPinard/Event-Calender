import java.time.Duration;
import java.time.LocalDateTime;

public enum Urgency {
    VERYFAR(100,"Relax its nothing to worry about now"),
    DISTANT(10,"Event is Distant but upcoming"),
    IMMINENT(3, "Event is Imminent and almost upon you"),
    OVERDUE(0, "You have failed to head the warnings and now you get what you deserve");

    //Variable init
    final Duration ThresholdOfImminence;
    final String Alert;

    //Constructor
    Urgency(int days, String message) {
        ThresholdOfImminence = Duration.ofDays(days);
        Alert = message;
    }

    //Getters
    public Duration getThresholdOfImminence(){return ThresholdOfImminence;}
    public String getAlert(){return Alert;}

    //Cycles through the Urgency days and ultimately returns the one most relevent one
    //ex. 70 days out returns VeryFar, 5 days out returns Distant, 1 day our returns Imminent, any time after date returns overdue
    public Urgency getUrgency(Urgency oldUrgency,LocalDateTime time){
        LocalDateTime now = LocalDateTime.now();
        if (time.minusDays(ThresholdOfImminence.toDays()).isBefore(now)){
            return this;
        }
        return oldUrgency;
    }
}
