import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VolTest {

    @Test
    public void testCreationVol() {
        Aeroport a = new Aeroport("CDG", "Paris", "");
        Aeroport b = new Aeroport("FCO", "Rome", "");

        Vol v = new Vol("T1", a, b, "d1", "d2", "PLANIFIE");

        assertEquals("T1", v.getNumeroVol());
    }
}
