import java.util.ArrayList;

public class Pilote extends Employe {

    private String licence;
    private int heuresDeVol;

    // les vols sur lesquels ce pilote est affecté
    private ArrayList<Vol> volsAffectes = new ArrayList<>();

    public Pilote(String identifiant, String nom, String adresse, String contact,
                  String numeroEmploye, String dateEmbauche,
                  String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    public void affecterVol(Vol vol) {
        if (!volsAffectes.contains(vol)) {
            volsAffectes.add(vol);
        }
    }

    public ArrayList<Vol> obtenirVol() {
        return volsAffectes;
    }

    // Getters / setters
    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public int getHeuresDeVol() {
        return heuresDeVol;
    }

    public void setHeuresDeVol(int heuresDeVol) {
        this.heuresDeVol = heuresDeVol;
    }
}
