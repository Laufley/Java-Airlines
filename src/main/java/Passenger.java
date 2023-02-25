public class Passenger extends Human{

    private int numberOfBags;


    public Passenger (String name, int numberOfBags){
        super(name);
        this.numberOfBags = numberOfBags;
    }

    public int getNumberOfBags(){
        return this.numberOfBags;
    }


}