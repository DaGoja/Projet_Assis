import java.util.ArrayList;

public class Avion {

    private String immatriculation;
    private String modele;
    private int capacite;

    private ArrayList<Vol> vols = new ArrayList<>();
    private static ArrayList<Avion> flotte = new ArrayList<>();

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
        flotte.add(this);
    }

    public void affecterVol(Vol vol) {
        if (!vols.contains(vol)) {
            vols.add(vol);
            vol.setAvion(this);
        }
    }

    public boolean verifierDisponibilite() {
        return true;
    }

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

    public String getImmatriculation() {
        return immatriculation;
    }
}
