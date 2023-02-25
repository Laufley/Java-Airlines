public class Passenger extends Human{

    private int numberOfBags;
    private Flight currentFlight;


    public Passenger (String name, int numberOfBags){
        super(name);
        this.numberOfBags = numberOfBags;
    }

    public int getNumberOfBags(){
        return this.numberOfBags;
    }

    public Flight getCurrentFlight() {
        return this.currentFlight;
    }

    public void setCurrentFlight(Flight flight) {
        this.currentFlight = flight;
    }
}