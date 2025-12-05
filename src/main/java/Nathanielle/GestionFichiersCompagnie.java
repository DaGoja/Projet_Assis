import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe utilitaire qui s'occupe de la lecture / écriture
 * de fichiers CSV pour les vols et les passagers.
 *
 * Les formats utilisés :
 *
 *  - vols.csv :
 *      Code;Dep;Arriv;Date;Heure
 *      TO350;Paris;Rome;25-12-2024;10:15
 *
 *  - passagers.csv :
 *      CodeVol;Passeport;Nom
 *      TO350;AA123456;Durand
 */
public class GestionFichiersCompagnie {

    // Noms de fichiers par défaut (dans le dossier du projet)
    private static final String FICHIER_VOLS = "vols.csv";
    private static final String FICHIER_PASSAGERS = "passagers.csv";

    // ===================== IMPORT DES VOLS =====================

    /**
     * Fonction équivalente à "Function importFlights()" dans le sujet.
     *
     * Elle lit le fichier vols.csv et crée les objets Vol / Aéroport
     * correspondants dans le programme.
     */
    public static void importFlights() {
        File fichier = new File(FICHIER_VOLS);

        if (!fichier.exists()) {
            System.out.println("Fichier " + FICHIER_VOLS + " introuvable, import ignoré.");
            return;
        }

        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {

            String ligne = lecteur.readLine(); // on saute l'entête "Code;Dep;Arriv;Date;Heure"
            // si le fichier ne contient que l'entête => rien à importer

            while ((ligne = lecteur.readLine()) != null) {
                // on ignore les lignes vides
                if (ligne.trim().isEmpty()) {
                    continue;
                }

                // On découpe la ligne CSV
                String[] morceaux = ligne.split(";");
                if (morceaux.length < 5) {
                    // format inattendu, on affiche juste un message et on passe à la suite
                    System.out.println("Ligne mal formée (ignorée) : " + ligne);
                    continue;
                }

                String codeVol = morceaux[0];
                String villeDepart = morceaux[1];
                String villeArrivee = morceaux[2];
                String date = morceaux[3];
                String heure = morceaux[4];

                // On récupère ou on crée les aéroports correspondants
                Aeroport depart = Aeroport.chercherParNom(villeDepart);
                if (depart == null) {
                    depart = new Aeroport(villeDepart, villeDepart, "");
                }

                Aeroport arrivee = Aeroport.chercherParNom(villeArrivee);
                if (arrivee == null) {
                    arrivee = new Aeroport(villeArrivee, villeArrivee, "");
                }

                // On crée le vol (heure d'arrivée vide pour le moment)
                new Vol(codeVol, depart, arrivee, date + " " + heure, "", "PLANIFIE");
            }

            System.out.println("Import des vols terminé.");

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier vols : " + e.getMessage());
        }
    }

    // ===================== EXPORT DES VOLS =====================

    /**
     * Fonction équivalente à "Function exportFlights()" dans le sujet.
     *
     * Elle parcourt la liste des vols en mémoire et ré-écrit complètement
     * le fichier vols.csv.
     */
    public static void exportFlights() {

        List<Vol> vols = Vol.getListeVols();

        try (BufferedWriter ecrivain = new BufferedWriter(new FileWriter(FICHIER_VOLS, false))) {

            // On ré-écrit l'entête à chaque fois
            ecrivain.write("Code;Dep;Arriv;Date;Heure");
            ecrivain.newLine();

            for (Vol v : vols) {

                // On essaie de séparer "date" et "heure" à partir de dateHeureDepart
                String dateHeure = v.getDateHeureDepart();
                String date = "";
                String heure = "";

                if (dateHeure != null) {
                    String[] morceaux = dateHeure.split(" ");
                    if (morceaux.length >= 1) {
                        date = morceaux[0];
                    }
                    if (morceaux.length >= 2) {
                        heure = morceaux[1];
                    }
                }

                String ligne = v.getNumeroVol() + ";" +
                        v.getOrigine().getNom() + ";" +
                        v.getDestination().getNom() + ";" +
                        date + ";" +
                        heure;

                ecrivain.write(ligne);
                ecrivain.newLine();
            }

            System.out.println("Export des vols terminé dans " + FICHIER_VOLS);

        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier vols : " + e.getMessage());
        }
    }

    // ===================== SAUVEGARDE DES PASSAGERS =====================

    /**
     * Fonction équivalente à "Function saveListPassengers()" dans le sujet.
     *
     * Elle enregistre, pour un vol donné, la liste des passagers (réservations
     * non annulées) dans passagers.csv.
     *
     * On APPEND (ajout à la fin) pour pouvoir appeler cette méthode
     * plusieurs fois avec des vols différents.
     */
    public static void saveListPassengers(Vol vol) {

        // On récupère la liste des passagers à partir des réservations
        List<Passager> passagers = vol.listingPassager();

        boolean fichierExisteDeja = new File(FICHIER_PASSAGERS).exists();

        try (BufferedWriter ecrivain = new BufferedWriter(new FileWriter(FICHIER_PASSAGERS, true))) {

            // Si le fichier n'existait pas, on écrit une entête
            if (!fichierExisteDeja) {
                ecrivain.write("CodeVol;Passeport;Nom");
                ecrivain.newLine();
            }

            for (Passager p : passagers) {
                String ligne = vol.getNumeroVol() + ";" +
                        p.getPasseport() + ";" +
                        p.getNom();
                ecrivain.write(ligne);
                ecrivain.newLine();
            }

            System.out.println("Liste des passagers du vol " +
                    vol.getNumeroVol() + " sauvegardée dans " + FICHIER_PASSAGERS);

        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier passagers : " + e.getMessage());
        }
    }
}
