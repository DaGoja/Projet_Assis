import java.util.ArrayList;

public class Vol {

    private String numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat;

    private Avion avion;
    private Pilote pilote;
    private ArrayList<PersonnelCabine> equipageCabine = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    private static ArrayList<Vol> listeVols = new ArrayList<>();

    public Vol(String numeroVol, Aeroport origine, Aeroport destination,
               String dateHeureDepart, String dateHeureArrivee, String etat) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = etat;
        listeVols.add(this);
        if (origine != null) origine.affecterVol(this);
        if (destination != null) destination.affecterVol(this);
    }

    public void planifierVol() {
        this.etat = "PLANIFIE";
    }

    public void annulerVol() {
        this.etat = "ANNULE";
    }

    public void modifierVol(String nouvelleDepart, String nouvelleArrivee) {
        this.dateHeureDepart = nouvelleDepart;
        this.dateHeureArrivee = nouvelleArrivee;
    }

    public ArrayList<Passager> listingPassager() {
        ArrayList<Passager> liste = new ArrayList<>();
        for (Reservation r : reservations) {
            if (!r.getStatut().equals("ANNULEE")) liste.add(r.getPassager());
        }
        return liste;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
        if (pilote != null) pilote.affecterVol(this);
    }

    public void ajouterMembreCabine(PersonnelCabine p) {
        if (!equipageCabine.contains(p)) {
            equipageCabine.add(p);
            p.affecterVol(this);
        }
    }

    public void ajouterReservation(Reservation r) {
        if (!reservations.contains(r)) reservations.add(r);
    }

    public static Vol chercherParNumero(String numero) {
        for (Vol v : listeVols) {
            if (v.numeroVol.equals(numero)) return v;
        }
        return null;
    }

    public static Vol obtenirVol(String numeroVol) {
        return chercherParNumero(numeroVol);
    }

    public static boolean supprimerParNumero(String numero) {
        Vol v = chercherParNumero(numero);
        if (v != null) return listeVols.remove(v);
        return false;
    }
}
