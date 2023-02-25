import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrewMemberTest {

    CrewMember crewMember1;
    @Before
    public void setUp(){
        crewMember1 = new CrewMember("Suzanne", RankType.LEAD_ATTENDANT);
    }

    @Test
    public void canGetRank(){
        assertEquals(RankType.LEAD_ATTENDANT, crewMember1.getRank());
    }

    @Test
    public void canRelayMessagesToPassengers(){
        String Stringify = crewMember1.getRank().toString();
        assertEquals("Welcome to Java Airlines, I'm" + " "+ crewMember1.getName() + "," + "your" + " " + Stringify, crewMember1.RelayMessage());
    }
}

