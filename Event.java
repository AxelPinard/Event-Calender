import java.util.Calendar;

public class Event {
    private String name;
    private Calendar dateTime;

    //compareTo takes an Event and compares that events date to another Event date
    //then returns a -1 for before, 0 for same day, and 1 for after
    //EX. 9-13-24.compare(9-22-24) gives a 1 for after
    public int compareTo(Event e){
        return e.dateTime.compareTo(this.dateTime);
    }

    //Following 4 methods are simple setters and getters
    public void setName(String name){
        this.name = name;
    }

    public void setDateTime(Calendar dateTime){
        this.dateTime = dateTime;
    }

    public Calendar getDateTime(){
        return dateTime;
    }

    public String getName(){
        return name;
    }
}
