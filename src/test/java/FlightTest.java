import org.junit.Before;
import org.junit.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FlightTest {

    Flight flight1;
    Flight flight2;
    Flight flight3;
    Flight flight4;
    Pilot pilot1;
    Pilot pilot2;

    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void setUp() {
        pilot1 = new Pilot("Gareth V.", RankType.CAPTAIN, "YZP-1146");
        pilot2 = new Pilot("Sean", RankType.CAPTAIN, "YZP-1222");

        passenger1 = new Passenger("Desmond", 1);
        passenger2 = new Passenger("Alexa", 2);
        flight1 = new Flight(pilot1, new String[]{"vegan", "vegetarian", "meat", "gluten free"}, "FR756", DepartureType.EDI, DestinationType.BCN, "06:30", 41000, 182);
        flight2 = new Flight(pilot2, new String[]{"vegan", "vegetarian", "meat", "gluten free"}, "FR126", DepartureType.BCN, DestinationType.EDI, "13:40", 41000, 182);


        ArrayList<String> cabinCrew1 = new ArrayList<>();
        flight1.addCabinCrewMember("Nur");
        flight1.addCabinCrewMember("Ane");
        flight1.addCabinCrewMember("Ramon");

        HashMap<Passenger, String> passengersHash = new HashMap<>();

        flight1.addPassenger(passenger1, "12C");
        flight1.addPassenger(passenger2, "12B");
    }


    @Test
    public void canGetPilot() {
        assertEquals(pilot1, flight1.getPilot());
    }

    @Test
    public void canReassignPilot() {
        flight1.setPilot(pilot2);
        assertEquals(pilot2, flight1.getPilot());
    }

    @Test
    public void canGetMenuOptions() {
        String[] expectedMenuOptions = {"vegan", "vegetarian", "meat", "gluten free"};
        assertArrayEquals(expectedMenuOptions, flight1.getMenu());
    }

    @Test
    public void canGetCabinCrewMembers() {
        ArrayList<String> expectedCabinCrew = new ArrayList<>();
        expectedCabinCrew.add("Nur");
        expectedCabinCrew.add("Ane");
        expectedCabinCrew.add("Ramon");

        assertEquals(expectedCabinCrew, flight1.getCabinCrew());
    }

    @Test
    public void canGetFlightNumber() {
        assertEquals("FR756", flight1.getFlightNumber());
    }

    @Test
    public void canSetFlightNumber() {
        flight1.setFlightNumber("RY265");
        assertEquals("RY265", flight1.getFlightNumber());
    }

    @Test
    public void canGetDepartureType() {
        assertEquals(DepartureType.EDI, flight1.getDeparture());
    }

    @Test
    public void canSetDeparture() {
        flight1.setDeparture(DepartureType.GLA);
        assertEquals(DepartureType.GLA, flight1.getDeparture());
    }

    @Test
    public void canGetDestinationType() {
        assertEquals(DestinationType.BCN, flight1.getDestination());
    }

    @Test
    public void canSetDestination() {
        flight1.setDestination(DestinationType.EDI);
        assertEquals(DestinationType.EDI, flight1.getDestination());

    }

    @Test
    public void canGetDepartureTime() {
        assertEquals("06:30", flight1.getDepartureTime());
    }

    @Test
    public void canSetDepartureTime() {
        flight1.setDepartureTime("08:40");
        assertEquals("08:40", flight1.getDepartureTime());
    }

    @Test
    public void canGetTotalWeightAllowed() {
        assertEquals(41000, flight1.getTotalWeight());
    }

    @Test
    public void canSetTotalWeightAllowed() {
        flight1.setNewMaxWeight(50000);
        assertEquals(50000, flight1.getTotalWeight());
    }

    @Test
    public void canAddPassengerToFlight() {
        Passenger passenger = new Passenger("Floppity Flop", 3);
        String seatNumber = "16F";

        flight1.addPassenger(passenger, seatNumber);

        HashMap<Passenger, String> passengersDict = flight1.getPassengersdict();

        assertEquals(seatNumber, passengersDict.get(passenger)); // because passenger is the key and will evaluate its value which is the seat
        assertEquals(flight1, passenger.getCurrentFlight());
    }

    @Test
    public void canGetPassengersHashMap() {
        HashMap<Passenger, String> expectedPassengers = new HashMap<>();
        expectedPassengers.put(passenger1, "12C");
        expectedPassengers.put(passenger2, "12B");
        assertEquals(expectedPassengers, flight1.getPassengersdict());
    }

    @Test
    public void canGetSinglePassengerInfo() {
        HashMap<Passenger, String> expectedPassengerInfo = new HashMap<>();
        expectedPassengerInfo.put(passenger1, "12C");
        assertEquals(expectedPassengerInfo, flight1.getSinglePassengerInfo(passenger1));
    }

    @Test
    public void canSetPassengerSeat() {
        HashMap<Passenger, String> expectedPassengerInfo = new HashMap<>();
        expectedPassengerInfo.put(passenger1, "12C");
        passenger1.setPassengerInfo("8B");
        assertEquals(expectedPassengerInfo, flight1.getSinglePassengerInfo(passenger1));
    }

    @Test
    public void canGetTotalSeats() {
        assertEquals( 182,flight2.getTotalSeats());
    }

    @Test
    public void canSetTotalSeats(){
        flight1.setTotalSeats(200);
        assertEquals(200, flight1.getTotalSeats());
    }

    @Test
    public void canGetTotalSeatsAvailable() {  // Also tests that can book if there are available seats
        flight4 = new Flight(pilot2, new String[]{"vegan", "vegetarian", "meat", "gluten free"}, "XR465", DepartureType.BCN, DestinationType.EDI, "13:40", 41000, 182);
        assertEquals(182, flight4.getTotalSeats());
        assertEquals(182, flight4.getAvailableSeats());
        flight4.addPassenger(passenger1, "30A");
        flight4.addPassenger(passenger2, "32F");
        assertEquals(182, flight4.getTotalSeats());
        assertEquals(180, flight4.getAvailableSeats());
        flight4.removePassenger(passenger1);
        flight4.removePassenger(passenger2);
        assertEquals(182, flight4.getTotalSeats());
        assertEquals(182, flight4.getAvailableSeats());
    }


    @Test
    public void cannotBookIfNotAvailableSeats(){
        flight3 = new Flight(pilot2, new String[]{"vegan", "vegetarian", "meat", "gluten free"}, "FR111", DepartureType.GLA, DestinationType.EDI, "12:30", 41000, 1);
        flight3.addPassenger(passenger1, "12A");
        assertEquals("sorry, there are not available seats for flight FR111", flight3.addPassenger(passenger2, "28C"));
    }


}






