import java.util.ArrayList;

public class Employe extends Personne {

    private String numeroEmploye;
    private String dateEmbauche;

    // on garde aussi une liste des employés
    private static ArrayList<Employe> listeEmployes = new ArrayList<>();

    public Employe(String identifiant, String nom, String adresse, String contact,
                   String numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;

        listeEmployes.add(this);
    }

    /**
     * Méthode générique : par défaut "Employé".
     * Sera redéfinie dans Pilote / PersonnelCabine.
     */
    public String obtenirRole() {
        return "Employé";
    }

    /**
     * Version décrite dans l’énoncé :
     * on donne un identifiant et on renvoie le rôle.
     */
    public static String obtenirRole(String identifiant) {
        for (Employe e : listeEmployes) {
            if (e.getIdentifiant().equals(identifiant)) {
                return e.obtenirRole();
            }
        }
        return "Inconnu";
    }

    // ---- CRUD basique ----
    public static Employe chercherParNumero(String numero) {
        for (Employe e : listeEmployes) {
            if (e.numeroEmploye.equals(numero)) return e;
        }
        return null;
    }

    public static boolean supprimerParNumero(String numero) {
        Employe e = chercherParNumero(numero);
        if (e != null) return listeEmployes.remove(e);
        return false;
    }

    // Getters / setters

    public String getNumeroEmploye() {
        return numeroEmploye;
    }

    public void setNumeroEmploye(String numeroEmploye) {
        this.numeroEmploye = numeroEmploye;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public static ArrayList<Employe> getListeEmployes() {
        return listeEmployes;
    }
}
