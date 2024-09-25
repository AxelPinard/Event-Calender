import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CalenderEventFilters {

    //Filter configeration
    public Map<String, Predicate<Event>> getEventFilters(){
        Map<String, Predicate<Event>> filters = new HashMap<>();
        filters.put("Remove Deadlines",getDeadlinesFilter());
        filters.put("Remove Meetings", getMeetingsFilter());
        filters.put("Remove Completed",getCompletedFilter());
        return filters;
    }


    //Filter methods
    public Predicate<Event> getCompletedFilter(){
        return (event) ->{return ((Completable)event).isComplete();};
    }

    public Predicate<Event> getDeadlinesFilter(){
        return (event) -> {return event instanceof Deadline;};
    }

    public Predicate<Event> getMeetingsFilter(){
        return (event) -> {return event instanceof Meeting;};
    }

}
