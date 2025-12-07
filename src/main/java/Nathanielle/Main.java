public class Main {

    public static void main(String[] args) {

        Aeroport cdg = new Aeroport("CDG", "Paris", "Charles de Gaulle");
        Aeroport fco = new Aeroport("FCO", "Rome", "Fiumicino");

        Avion avion1 = new Avion("F-ABCD", "Airbus A320", 180);

        Pilote pilote = new Pilote(
                "EMP001", "Dupont", "Paris", "0600000001",
                "PIL001", "01/01/2020", "LIC-A320", 3500
        );

        PersonnelCabine cabine1 = new PersonnelCabine(
                "EMP002", "Martin", "Paris", "0600000002",
                "CAB001", "10/03/2021", "Chef cabine"
        );

        Vol volParisRome = new Vol(
                "TO350", cdg, fco,
                "25/12/2024 10:15", "25/12/2024 12:45",
                "PLANIFIE"
        );

        avion1.affecterVol(volParisRome);
        volParisRome.setPilote(pilote);
        volParisRome.ajouterMembreCabine(cabine1);

        Passager passager = new Passager(
                "PAS001", "Durand", "Lyon", "0600000003", "AA123456"
        );

        Reservation r = passager.reserverVol(volParisRome, "RES001", "20/12/2024");
        r.confirmerReservation();

        System.out.println("Passagers du vol TO350 :");
        for (Passager p : volParisRome.listingPassager()) {
            System.out.println(p.getNom());
        }
    }
}

