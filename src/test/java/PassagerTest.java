import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassagerTest {

    @Test
    void testReserverVol() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "");
        Aeroport fco = new Aeroport("FCO", "Rome", "");
        Vol vol = new Vol("TO350", cdg, fco,
                "25/12/2024 10:15", "", "PLANIFIE");

        Passager p = new Passager("ID1", "Durand", "Adresse", "0601020304", "AA123456");

        Reservation r = p.reserverVol(vol, "RES001", "20/12/2024");

        assertEquals("RES001", r.getNumeroReservation());
        assertEquals(vol, r.getVol());
        assertTrue(p.obtenirReservations().contains(r));
        assertTrue(vol.getListeReservations().contains(r));
        assertEquals("EN_ATTENTE", r.getStatut());
    }

    @Test
    void testAnnulerReservation() {
        Aeroport cdg = new Aeroport("CDG", "Paris", "");
        Aeroport fco = new Aeroport("FCO", "Rome", "");
        Vol vol = new Vol("TO350", cdg, fco,
                "25/12/2024 10:15", "", "PLANIFIE");

        Passager p = new Passager("ID2", "Martin", "Adresse", "0600000000", "BB987654");

        Reservation r = p.reserverVol(vol, "RES002", "21/12/2024");
        boolean ok = p.annulerReservation("RES002");

        assertTrue(ok);
        assertEquals("ANNULEE", r.getStatut());
    }
}
