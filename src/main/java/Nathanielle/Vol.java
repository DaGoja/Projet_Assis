import java.util.ArrayList;

public class Vol {

    private String numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat; // PLANIFIE / ANNULE / etc.

    private Avion avion;
    private Pilote pilote;
    private ArrayList<PersonnelCabine> equipageCabine = new ArrayList<>();
    private ArrayList<Reservation> listeReservations = new ArrayList<>();

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

    // -------- Méthodes de gestion des vols --------

    public void planifierVol() {
        this.etat = "PLANIFIE";
    }

    public void annulerVol() {
        this.etat = "ANNULE";
    }

    public void modifierVol(String nouvelleDateDepart, String nouvelleDateArrivee) {
        this.dateHeureDepart = nouvelleDateDepart;
        this.dateHeureArrivee = nouvelleDateArrivee;
    }

    public ArrayList<Passager> listingPassager() {
        ArrayList<Passager> passagers = new ArrayList<>();
        for (Reservation r : listeReservations) {
            if (!"ANNULEE".equals(r.getStatut())) {
                passagers.add(r.getPassager());
            }
        }
        return passagers;
    }

    // -------- Associations --------

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
        if (pilote != null) {
            pilote.affecterVol(this);
        }
    }

    public void ajouterMembreCabine(PersonnelCabine membre) {
        if (!equipageCabine.contains(membre)) {
            equipageCabine.add(membre);
            membre.affecterVol(this);
        }
    }

    public void ajouterReservation(Reservation reservation) {
        if (!listeReservations.contains(reservation)) {
            listeReservations.add(reservation);
        }
    }

    // -------- CRUD sur les vols --------

    public static Vol chercherParNumero(String num) {
        for (Vol v : listeVols) {
            if (v.numeroVol.equals(num)) return v;
        }
        return null;
    }

    public static boolean supprimerParNumero(String num) {
        Vol v = chercherParNumero(num);
        if (v != null) return listeVols.remove(v);
        return false;
    }

    // Getters / setters

    public String getNumeroVol() {
        return numeroVol;
    }

    public void setNumeroVol(String numeroVol) {
        this.numeroVol = numeroVol;
    }

    public Aeroport getOrigine() {
        return origine;
    }

    public void setOrigine(Aeroport origine) {
        this.origine = origine;
    }

    public Aeroport getDestination() {
        return destination;
    }

    public void setDestination(Aeroport destination) {
        this.destination = destination;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Avion getAvion() {
        return avion;
    }

    public Pilote getPilote() {
        return pilote;
    }

    public ArrayList<PersonnelCabine> getEquipageCabine() {
        return equipageCabine;
    }

    public ArrayList<Reservation> getListeReservations() {
        return listeReservations;
    }

    public static ArrayList<Vol> getListeVols() {
        return listeVols;
    }
}

