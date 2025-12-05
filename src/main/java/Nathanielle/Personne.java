import java.util.ArrayList;

public class Personne {

    // Attributs de base d'une personne
    private String identifiant;
    private String nom;
    private String adresse;
    private String contact;

    // Petite "base" en mémoire pour faire du CRUD
    private static ArrayList<Personne> listePersonnes = new ArrayList<>();

    public Personne(String identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;

        // à chaque création on ajoute la personne dans la liste
        listePersonnes.add(this);
    }

    /**
     * Affiche les infos de la personne (décrit dans l’énoncé).
     */
    public void obtenirInfos() {
        System.out.println(this);
    }

    // ---- CRUD très simple sur la liste statique ----

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
        if (p != null) {
            return listePersonnes.remove(p);
        }
        return false;
    }

    public static ArrayList<Personne> getListePersonnes() {
        return listePersonnes;
    }

    // toString pour avoir un affichage propre
    @Override
    public String toString() {
        return "Personne{" +
                "id='" + identifiant + '\'' +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    // Getters / setters (classiques)

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
