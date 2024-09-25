import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Meeting extends Event implements Completable{
    //Variable Init
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete = false;

    //Constructor
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location){
        setName(name);
        setDateTime(start);
        endDateTime = end;
        this.location = location;
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
