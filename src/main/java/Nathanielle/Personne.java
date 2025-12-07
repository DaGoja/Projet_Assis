import java.util.ArrayList;

public class Personne {

    private String identifiant;
    private String nom;
    private String adresse;
    private String contact;

    private static ArrayList<Personne> listePersonnes = new ArrayList<>();

    public Personne(String identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
        listePersonnes.add(this);
    }

    public String obtenirInfos() {
        return identifiant + " | " + nom + " | " + adresse + " | " + contact;
    }

    public static Personne chercherParIdentifiant(String id) {
        for (Personne p : listePersonnes) {
            if (p.identifiant.equals(id)) {
                return p;
            }
        }
        return null;
    }

    public static boolean supprimerParIdentifiant(String id) {
        Personne p = chercherParIdentifiant(id);
        if (p != null) return listePersonnes.remove(p);
        return false;
    }

    public static ArrayList<Personne> getListePersonnes() {
        return listePersonnes;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
