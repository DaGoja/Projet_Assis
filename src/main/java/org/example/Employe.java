package org.example;

public class Employe extends Personne {
    private int NumeroEmploye;
    private String DateEmbauche;

    public Employe(String identifiant, String nom, String adresse, String contact){
        super(identifiant, nom, adresse, contact);
        this.NumeroEmploye = NumeroEmploye;
        this.DateEmbauche = DateEmbauche;
    }
    public int getNumeroEmploye(){
        return NumeroEmploye;
    }

    public String getDateEmbauche(){
        return DateEmbauche;
    }

    @Override
    public String ObtenirRole(){
        return "C'est un (role) ";
    }
}
