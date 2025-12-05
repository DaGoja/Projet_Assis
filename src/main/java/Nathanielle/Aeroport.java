import java.util.ArrayList;

public class Aeroport {

    private String nom;
    private String ville;
    private String description;

    private ArrayList<Vol> volsAssocies = new ArrayList<>();
    private static ArrayList<Aeroport> listeAeroports = new ArrayList<>();

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        listeAeroports.add(this);
    }

    public void affecterVol(Vol vol) {
        if (!volsAssocies.contains(vol)) {
            volsAssocies.add(vol);
        }
    }

    // CRUD
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Vol> getVolsAssocies() {
        return volsAssocies;
    }

    public static ArrayList<Aeroport> getListeAeroports() {
        return listeAeroports;
    }
}
