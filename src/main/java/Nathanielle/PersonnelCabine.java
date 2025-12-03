package Nathanielle;

public class PersonnelCabine extends Employe {

    private String qualification;

    public PersonnelCabine(int identifiant, String nom, String adresse, String contact,
                           int numeroEmploye, String dateEmbauche,
                           String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String obtenirRole() {
        return "Personnel cabine";
    }
}
