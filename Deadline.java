public class Deadline implements Completable{

    private Boolean complete = false;

    public void complete(){this.complete = true;}
    public boolean isComplete(){return this.complete;}


}
