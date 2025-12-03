package Nathanielle;

import java.util.ArrayList;
import java.util.List;

public class Vol {

    private String numeroVol;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private String etat; 

    private Avion avion;
  
    private Aeroport aeroportDepart;
  
    private Aeroport aeroportArrivee;

    private List<Passager> listePassagers;

    public Vol(String numeroVol, String dateHeureDepart, String dateHeureArrivee,
               Aeroport aeroportDepart, Aeroport aeroportArrivee, Avion avion) {
        this.numeroVol = numeroVol;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
        this.etat = "Prévu";
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
        this.avion = avion;
        this.listePassagers = new ArrayList<>();
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public String getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public void setDateHeureArrivee(String dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public String getEtat() {
        return etat;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeroport getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public Aeroport getAeroportArrivee() {
        return aeroportArrivee;
    }

    public void setAeroportArrivee(Aeroport aeroportArrivee) {
        this.aeroportArrivee = aeroportArrivee;
    }

    public List<Passager> getListePassagers() {
        return listePassagers;
    }

    public void planifierVol() {
    }

    public void annulerVol() {
        this.etat = "Annulé";
    }

    public void modifierVol(String nouvelleDateDepart, String nouvelleDateArrivee) {
        this.dateHeureDepart = nouvelleDateDepart;
        this.dateHeureArrivee = nouvelleDateArrivee;
    }

    public void ajouterPassager(Passager passager) {
        listePassagers.add(passager);
    }

    public void listingPassagers() {
        for (Passager p : listePassagers) {
            System.out.println(p.obtenirInfos());
        }
    }
}
