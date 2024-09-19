import java.time.LocalDateTime;

public class Deadline extends Event implements Completable{

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
