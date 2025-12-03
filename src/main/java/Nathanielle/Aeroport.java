package Nathanielle;

public class Aeroport {

    private String nom;
    private String ville;
    private String description;

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public String getDescription() {
        return description;
    }

    public void affecterVol(Vol vol) {
        // ajouter vol à la liste des vols
    }
}
