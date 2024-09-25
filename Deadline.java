import java.time.LocalDateTime;
import java.util.Arrays;

public class Deadline extends Event implements Completable{

    //Variable Init
    private Boolean complete = false;

    //Constructor
    public Deadline(String name, LocalDateTime deadline){
        setName(name);
        setDateTime(deadline);
    }

    //Fulfill the completable interface contract
    public void complete(){this.complete = true;}
    public boolean isComplete(){return this.complete;}
}
