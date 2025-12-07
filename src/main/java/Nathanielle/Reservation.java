public class Reservation {

    private String numeroReservation;
    private String dateReservation;
    private String statut;

    private Passager passager;
    private Vol vol;

    public Reservation(String numeroReservation, String dateReservation,
                       String statut, Passager passager, Vol vol) {
        this.numeroReservation = numeroReservation;
        this.dateReservation = dateReservation;
        this.statut = statut;
        this.passager = passager;
        this.vol = vol;
    }

    public void confirmerReservation() {
        this.statut = "CONFIRMEE";
    }

    public void annulerReservation() {
        this.statut = "ANNULEE";
    }

    public void modifierReservation(Vol nouveauVol) {
        this.vol = nouveauVol;
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public Passager getPassager() {
        return passager;
    }

    public Vol getVol() {
        return vol;
    }
}
