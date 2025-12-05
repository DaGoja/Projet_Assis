import java.util.ArrayList;

public class Avion {

    private String immatriculation;
    private String modele;
    private int capacite;

    private ArrayList<Vol> listeVols = new ArrayList<>();
    private static ArrayList<Avion> flotte = new ArrayList<>();

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        flotte.add(this);
    }

    public void affecterVol(Vol vol) {
        if (!listeVols.contains(vol)) {
            listeVols.add(vol);
            vol.setAvion(this);
        }
    }

    /**
     * Version très simple : on retourne toujours true.
     * Plus tard tu pourras vérifier les dates de vol.
     */
    public boolean verifierDisponibilite() {
        return true;
    }

    // CRUD basique sur la flotte
    public static Avion chercherParImmatriculation(String immat) {
        for (Avion a : flotte) {
            if (a.immatriculation.equals(immat)) return a;
        }
        return null;
    }

    public static boolean supprimerParImmatriculation(String immat) {
        Avion a = chercherParImmatriculation(immat);
        if (a != null) return flotte.remove(a);
        return false;
    }

    // Getters / setters

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public ArrayList<Vol> getListeVols() {
        return listeVols;
    }

    public static ArrayList<Avion> getFlotte() {
        return flotte;
    }
}
