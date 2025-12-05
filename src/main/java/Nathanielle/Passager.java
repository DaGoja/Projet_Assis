import java.util.ArrayList;

public class Passager extends Personne {

    private String passeport;
    private ArrayList<Reservation> listeReservations = new ArrayList<>();

    public Passager(String identifiant, String nom, String adresse, String contact,
                    String passeport) {
        super(identifiant, nom, adresse, contact);
        this.passeport = passeport;
    }

    /**
     * Le passager réserve un vol.
     * Ici je passe le numéro de réservation et la date en paramètre,
     * mais tu peux adapter plus tard.
     */
    public Reservation reserverVol(Vol vol, String numeroReservation, String dateReservation) {
        Reservation r = new Reservation(numeroReservation, dateReservation,
                "EN_ATTENTE", this, vol);

        listeReservations.add(r);
        vol.ajouterReservation(r);

        return r;
    }

    public boolean annulerReservation(String numeroReservation) {
        for (Reservation r : listeReservations) {
            if (r.getNumeroReservation().equals(numeroReservation)) {
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
