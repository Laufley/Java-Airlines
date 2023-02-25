import java.util.ArrayList;
import java.util.HashMap;

public class Flight {

    private Pilot pilot;

    private String[] menuOptions;
    private ArrayList<String> cabinCrewMembers;
    private HashMap<Passenger, String> passengers;  // String would be seat number like A12
    private String flightNumber;
    private DepartureType departure;
    private DestinationType destination;
    private String departureTime;
    private Integer totalWeightAllowance;


    public Flight(Pilot pilot, String[] menuOptions, String flightNumber, DepartureType departure, DestinationType destination, String departureTime, Integer totalWeightAllowance) {
        this.pilot = pilot;
        this.menuOptions = menuOptions;
        this.cabinCrewMembers = new ArrayList<>();
        this.passengers = new HashMap<>();
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalWeightAllowance = totalWeightAllowance;
    }

    public void addPassenger(Passenger passenger, String seatNumber) {
        passengers.put(passenger, seatNumber); // add the passenger to the HashMap with the seat number
        passenger.setCurrentFlight(this); // assign the current flight I'm operating on to the passenger
    }

    public HashMap<Passenger, String> getPassengersdict(){
        return this.passengers;
    }

    public HashMap<Passenger, String> getSinglePassengerInfo(Passenger passenger){
        HashMap<Passenger, String> passengerInfo = new HashMap<>();
        String seatNumber = passengers.get(passenger);
        passengerInfo.put(passenger, seatNumber);
        return passengerInfo;
    }



    public Pilot getPilot() {
        return this.pilot;
    }

    public void setPilot(Pilot instanceOfPilot) {
        this.pilot = instanceOfPilot;
    }

    public String[] getMenu() {
        return this.menuOptions;
    }

    public ArrayList<String> getCabinCrew() {
        return this.cabinCrewMembers;
    }

    public void addCabinCrewMember(String name) {
        this.cabinCrewMembers.add(name);
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String numberUpdate){
        this.flightNumber = numberUpdate;
    }

    public DepartureType getDeparture(){
        return this.departure;
    }

    public void setDeparture(DepartureType newDeparture){
        this.departure = newDeparture;
    }

    public DestinationType getDestination(){
        return this.destination;
    }

    public void setDestination(DestinationType newDestination){
        this.destination = newDestination;
    }


    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String newTime) {
        this.departureTime = newTime;
    }

    public int getTotalWeight() {
        return this.totalWeightAllowance;
    }

    public void setNewMaxWeight(int newWeight) {
        this.totalWeightAllowance = newWeight;
    }
}
//Note to self:
//In Java, this is a reference to the current object that is being operated on. It is often used to differentiate between instance variables and method parameters that have the same name.
//
//In the case of passenger.setFlight(this), this refers to the current instance of the Flight object that is being operated on by the method. By passing this as an argument to setFlight(), we are telling the Passenger object that it belongs to the current Flight object.
//
//In other words, this is used to refer to the current object and can be used to pass the reference of the current object to other methods or constructors.