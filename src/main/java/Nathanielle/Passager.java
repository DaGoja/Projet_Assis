import java.util.ArrayList;

public class Passager extends Personne {

    private String passeport;
    private ArrayList<Reservation> listeReservations = new ArrayList<>();

    public Passager(String identifiant, String nom, String adresse, String contact,
                    String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
    }

    public Reservation reserverVol(Vol vol, String numeroReservation, String dateReservation) {
        Reservation r = new Reservation(numeroReservation, dateReservation, "EN_ATTENTE", this, vol);
        listeReservations.add(r);
        vol.ajouterReservation(r);
        return r;
    }

    public boolean annulerReservation(String numero) {
        for (Reservation r : listeReservations) {
            if (r.getNumeroReservation().equals(numero)) {
                r.annulerReservation();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Reservation> obtenirReservations() {
        return listeReservations;
    }

    public String getPasseport() {
        return passeport;
    }

    public void setPasseport(String passeport) {
        this.passeport = passeport;
    }
}
