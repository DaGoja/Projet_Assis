public class MainCompagnieAerienne {

    public static void main(String[] args) {

        // ===================== 1. Création des aéroports =====================
        Aeroport cdg = new Aeroport("CDG", "Paris", "Paris Charles de Gaulle");
        Aeroport fco = new Aeroport("FCO", "Rome", "Rome Fiumicino");

        // ===================== 2. Création d'un avion ========================
        Avion avion1 = new Avion("F-ABCD", "Airbus A320", 180);

        // ===================== 3. Création de l'équipage ====================
        Pilote pilote = new Pilote(
                "EMP001",          // identifiant personne
                "Dupont",          // nom
                "10 rue des Lilas",
                "0600000001",
                "PIL001",          // numéro employé
                "01/01/2020",      // date embauche
                "LICENCE-A320",    // licence
                3500               // heures de vol
        );

        PersonnelCabine hotesse = new PersonnelCabine(
                "EMP002",
                "Martin",
                "5 avenue Victor Hugo",
                "0600000002",
                "CAB001",
                "01/06/2021",
                "Chef de cabine"
        );

        // ===================== 4. Création d'un vol ==========================
        Vol volParisRome = new Vol(
                "TO350",               // numéro de vol
                cdg,                   // aéroport d'origine
                fco,                   // aéroport de destination
                "25/12/2024 10:15",    // date/heure départ
                "25/12/2024 12:45",    // date/heure arrivée
                "PLANIFIE"             // état
        );

        // On associe l'avion et l'équipage au vol
        avion1.affecterVol(volParisRome);
        volParisRome.setPilote(pilote);
        volParisRome.ajouterMembreCabine(hotesse);

        // ===================== 5. Création d'un passager =====================
        Passager passager1 = new Passager(
                "PAS001",
                "Durand",
                "20 boulevard de la République",
                "0600000003",
                "AA123456"
        );

        // Affichage des infos de la personne (méthode du sujet)
        System.out.println("=== Informations sur le passager ===");
        passager1.obtenirInfos();

        // ===================== 6. Réservation d'un vol =======================
        System.out.println("\n=== Réservation du vol ===");
        Reservation reservation1 = passager1.reserverVol(
                volParisRome,
                "RES001",          // numéro de réservation
                "20/12/2024"       // date de réservation
        );
        System.out.println("Réservation créée : " + reservation1.getNumeroReservation()
                + " pour le vol " + reservation1.getVol().getNumeroVol());

        // Confirmation de la réservation
        reservation1.confirmerReservation();
        System.out.println("Statut de la réservation : " + reservation1.getStatut());

        // ===================== 7. Listing des passagers du vol ===============
        System.out.println("\n=== Liste des passagers du vol TO350 ===");
        for (Passager p : volParisRome.listingPassager()) {
            System.out.println("- " + p.getNom() + " (passeport : " + p.getPasseport() + ")");
        }

        // ===================== 8. Test de la méthode obtenirRole =============
        System.out.println("\n=== Rôle des employés ===");
        System.out.println("Pilote : " + Employe.obtenirRole("EMP001"));
        System.out.println("Personnel cabine : " + Employe.obtenirRole("EMP002"));

        // ===================== 9. Annulation de la réservation ===============
        System.out.println("\n=== Annulation de la réservation ===");
        passager1.annulerReservation("RES001");
        System.out.println("Nouveau statut : " + reservation1.getStatut());

        // Après annulation, il ne devrait plus apparaître dans la liste active
        System.out.println("\n=== Liste des passagers après annulation ===");
        for (Passager p : volParisRome.listingPassager()) {
            System.out.println("- " + p.getNom());
        }

        // ===================== 10. Exemple de recherche CRUD =================
        System.out.println("\n=== Recherche de vol par numéro ===");
        Vol volTrouve = Vol.chercherParNumero("TO350");
        if (volTrouve != null) {
            System.out.println("Vol trouvé : " + volTrouve.getNumeroVol()
                    + " de " + volTrouve.getOrigine().getNom()
                    + " vers " + volTrouve.getDestination().getNom());
        } else {
            System.out.println("Vol non trouvé.");
        }

        System.out.println("\n=== Fin du test ===");
    }
}
