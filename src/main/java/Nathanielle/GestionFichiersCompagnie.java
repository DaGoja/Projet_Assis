import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionFichiersCompagnie {

    public static void importVols(String fichier) {

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {

            String l;

            while ((l = br.readLine()) != null) {

                String tab[] = l.split(";");

                if (tab.length < 5) {
                    continue;
                }

                String num = tab[0];
                String dep = tab[1];
                String arr = tab[2];
                String date = tab[3];
                String heure = tab[4];

                Aeroport aDep = new Aeroport(dep, dep, dep);
                Aeroport aArr = new Aeroport(arr, arr, arr);

                new Vol(num, aDep, aArr, date + " " + heure, "", "PLANIFIE");
            }

        } catch (IOException e) {
            System.out.println("erreur import vols : " + e.getMessage());
        }
    }


    public static void sauvegarderReservations(String fichier) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true))) {

            for (Vol v : Vol.getListeVols()) {

                for (Reservation r : v.getReservations()) {

                    bw.write(
                        r.getPassager().getPasseport() + ";" +
                        r.getPassager().getNom() + ";" +
                        v.getNumeroVol() + ";" +
                        r.getStatut()
                    );

                    bw.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("erreur sauvegarde : " + e.getMessage());
        }
    }
}
