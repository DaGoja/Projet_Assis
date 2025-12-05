import java.util.ArrayList;

public class PersonnelCabine extends Employe {

    private String qualification;
    private ArrayList<Vol> volsAffectes = new ArrayList<>();

    public PersonnelCabine(String identifiant, String nom, String adresse, String contact,
                           String numeroEmploye, String dateEmbauche,
                           String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    @Override
    public String obtenirRole() {
        return "Personnel cabine";
    }

    public void affecterVol(Vol vol) {
        if (!volsAffectes.contains(vol)) {
            volsAffectes.add(vol);
        }
    }

    public ArrayList<Vol> obtenirVol() {
        return volsAffectes;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
