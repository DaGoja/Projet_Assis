import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class VolTest {

    @Test
    void testListingPassagerIgnoreReservationsAnnulees() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "");
        Aeroport fco = new Aeroport("FCO", "Rome", "");
        Vol vol = new Vol("TO350", cdg, fco,
                "25/12/2024 10:15", "", "PLANIFIE");

        Passager p1 = new Passager("P1", "Durand", "Adresse", "0600000000", "AA1");
        Passager p2 = new Passager("P2", "Martin", "Adresse", "0600000001", "BB2");

        // Deux réservations
        Reservation r1 = p1.reserverVol(vol, "R1", "20/12/2024");
        Reservation r2 = p2.reserverVol(vol, "R2", "20/12/2024");

        // On annule la seconde réservation
        r2.annulerReservation();

        // On récupère la liste des passagers actifs
        List<Passager> actifs = vol.listingPassager();

        assertEquals(1, actifs.size());
        assertEquals("Durand", actifs.get(0).getNom());
    }
}
