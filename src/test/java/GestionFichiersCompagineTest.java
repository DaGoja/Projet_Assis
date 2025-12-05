import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestionFichiersCompagnieTest {

    @Test
    void testImportFlightsNePlantePas() {
        assertDoesNotThrow(() -> GestionFichiersCompagnie.importFlights());
    }
}
