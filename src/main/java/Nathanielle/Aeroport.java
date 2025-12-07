import java.util.ArrayList;

public class Aeroport {

    private String nom;
    private String ville;
    private String description;

    private ArrayList<Vol> vols = new ArrayList<>();
    private static ArrayList<Aeroport> listeAeroports = new ArrayList<>();

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        listeAeroports.add(this);
    }

    public void affecterVol(Vol vol) {
        if (!vols.contains(vol)) vols.add(vol);
    }

    public static Aeroport chercherParNom(String nom) {
        for (Aeroport a : listeAeroports) {
            if (a.nom.equalsIgnoreCase(nom)) return a;
        }
        return null;
    }

    public static boolean supprimerParNom(String nom) {
        Aeroport a = chercherParNom(nom);
        if (a != null) return listeAeroports.remove(a);
        return false;
    }

    public String getNom() {
        return nom;
    }
}
