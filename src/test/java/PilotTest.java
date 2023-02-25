import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void setUp(){
        pilot = new Pilot("Oscar Prieto", RankType.CAPTAIN, "YZP-2134");
    }

    @Test
    public void canGetLicenseNumber(){
        assertEquals("YZP-2134", pilot.getLicenseNumber());
    }

    @Test
    public void canFlyAirplane(){
        assertEquals("I can fly the airplane", pilot.flyAirplane());
    }
}
