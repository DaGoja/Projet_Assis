package org.example;

import java.util.Date;

public class Employe extends Personne {
    private int NumeroEmploye;
    private String DateEmbauche;

    public Employe(int NumeroEmploye, String DateEmbauche){
        super(NumeroEmploye, DateEmbauche);
    }
    public int getNumeroEmploye(){
        return NumeroEmploye;
    }

    public String getDateEmbauche(){
        return DateEmbauche;
    }

    @Override
    public String ObtenirRole(identifiant identifiant){
        return "C'est un (role) ";
    }
}
