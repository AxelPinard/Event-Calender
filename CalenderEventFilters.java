import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CalenderEventFilters {

    public Map<String, Predicate<Event>> getEventFilters(){
        Map<String, Predicate<Event>> filters = new HashMap<>();
        filters.put("Remove Deadlines",getDeadlinesFilter());
        filters.put("Remove Meetings", getMeetingsFilter());
        return filters;
    }

    public Predicate<Event> getDeadlinesFilter(){
        return (event) -> {return event instanceof Deadline;};
    }

    public Predicate<Event> getMeetingsFilter(){
        return (event) -> {return event instanceof Meeting;};
    }

}
