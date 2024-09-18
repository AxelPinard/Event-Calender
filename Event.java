import java.time.LocalDate;

abstract class Event implements Comparable<Event> {
    private String name;
    private  LocalDate date;

    //compareTo takes an Event and compares that events date to another Event date
    //then returns a -1 for before, 0 for same day, and 1 for after
    //EX. 9-13-24.compare(9-22-24) gives a 1 for after
    public int compareTo(Event e){
        return e.date.compareTo(this.date);
    }

    //Following 4 methods are simple setters and getters
    void setName(String name){
        this.name = name;
    }

    void setDateTime(LocalDate date){
        this.date = date;
    }

    LocalDate getDateTime(){
        return date;
    }

    String getName(){
        return name;
    }
}
