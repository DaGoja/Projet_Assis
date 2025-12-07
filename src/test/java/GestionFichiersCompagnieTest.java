import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestionFichiersCompagnieTest {

    @Test
    public void testSauvegarderReservationsNePlantePas() {
        Aeroport a = new Aeroport("CDG", "Paris", "");
        Aeroport b = new Aeroport("FCO", "Rome", "");
        Vol v = new Vol("T3", a, b, "d1", "d2", "PLANIFIE");

        Passager p = new Passager("P1", "Durand", "Lyon", "0600", "AA111");
        Reservation r = p.reserverVol(v, "R1", "20/12/2024");
        r.confirmerReservation();

        assertDoesNotThrow(() -> {
            GestionFichiersCompagnie.sauvegarderReservations("reservations_test.csv");
        });
    }
}
