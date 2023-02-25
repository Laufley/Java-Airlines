import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight1;
    Pilot pilot1;
    Pilot pilot2;
    @Before
    public void setUp(){
        pilot1 = new Pilot("Gareth V.", RankType.CAPTAIN, "YZP-1146");
        pilot2 = new Pilot("Sean", RankType.CAPTAIN, "YZP-1222");
        flight1 = new Flight(pilot1, new String[] {"vegan", "vegetarian", "meat", "gluten free"},"FR756", DepartureType.EDI, DestinationType.BCN, "06:30", 41000);

    }

    @Test
    public void canGetPilot(){
        assertEquals(pilot1, flight1.getPilot());
    }

    @Test
    public void canReassignPilot(){
        flight1.setPilot(pilot2);
        assertEquals(pilot2, flight1.getPilot());
    }

    @Test
    public void canGetMenuOptions(){
        String[] expectedMenuOptions = {"vegan", "vegetarian", "meat", "gluten free"};
        assertArrayEquals(expectedMenuOptions,flight1.getMenu());
    }
}
