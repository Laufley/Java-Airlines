import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrewMemberTest {

    CrewMember crewMember1;
    @Before
    public void setUp(){
        crewMember1 = new CrewMember("Oscar Prieto", RankType.CAPTAIN);
    }

    @Test
    public void canGetRank(){
        assertEquals(RankType.CAPTAIN, crewMember1.getRank());
    }

    @Test
    public void canRelayMessagesToPassengers(){
        String Stringify = crewMember1.getRank().toString();
        assertEquals("Welcome to Java Airlines, I'm" + " "+ crewMember1.getName() + "," + "your" + " " + Stringify, crewMember1.RelayMessage());
    }
}

