package com.pharmatie;

public class Pharmacie {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Client[] clients = new Client[2];
        Medicament[] medicaments = new Medicament[2];
        clients[0] = new Client("Malfichu", 0.0);
        clients[1] = new Client("Palichon", 0.0);
        medicaments[0] = new Medicament("Aspiron", 20.40, 5);
        medicaments[1] = new Medicament("Rhinoplexil", 19.15, 5);
        int choix = 0;
        while (choix < 4) {
            choix = menu();
            switch (choix) {
                case 1:
                    achat(clients, medicaments);
                    break;
                case 2:
                    approvisionnement(medicaments);
                    break;
                case 3:
                    affichage(clients, medicaments);
                    break;
                case 4:
                    quitter();
                    break;
                default:
                    // On reste dans la boucle.
                    // C'est redondant avec le test dans la méthode menu()
                    // mais c'est un bon réflexe de gérer tous les cas dans un
                    // switch-case.
                    choix = 0;
            }
        }
    }

    // Les méthodes utilitaires
    static int menu() {
        int choix = 0;
        System.out.println();
        System.out.println();
        System.out.println("1 : Achat de medicament");
        System.out.println("2 : Approvisionnement en medicaments");
        System.out.println("3 : Etats des stocks et des credits");
        System.out.println("4 : Quitter");
        while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
            choix = scanner.nextInt();
        }
        return choix;
    }

    // Méthodes auxiliaires à compléter
}

    // Autres classes à compléter
    static void achat(Client[] clients, Medicament[] medicaments) {
        Client client = lireClient(clients);
        Medicament medicament = lireMedicament(medicaments);
        double paiement = lirePaiement();
        int quantite = lireQuantite();

        if (quantite <= medicament.getStock()) {
            medicament.diminuerStock(quantite);
            client.augmenterCredit((medicament.getPrix() * quantite) - paiement);
        } else
            System.out.println("Achat Impossible. Quantite insuffisante");
    }

    static void approvisionnement(Medicament[] medicaments) {
        Medicament medicament = lireMedicament(medicaments);
        System.out.println("Donner la Quantite : ");
        int quantite = scanner.nextInt();
        // se débarasser du \n
        scanner.nextLine();
        medicament.augmenterStock(quantite);
    }

    /**
     * @param clients     affiche les clients
     * @param medicaments affiche les médicaments
     */
    static void affichage(Client[] clients, Medicament[] medicaments) {
        System.out.println("Affichage des stocks");

        for (int i = 0; i < medicaments.length; i++) {
            System.out.println("Stock du medicament " + medicaments[i].getNom()
                    + " :" + medicaments[i].getStock());
        }
        System.out.println("Affichage des credits");

        for (int i = 0; i < clients.length; i++) {
            System.out.println("Credit du client " + clients[i].getNom()
                    + " :" + clients[i].getCredit());
        }
    }

    static Client lireClient(Client[] clients) {
        String nom = null;
        boolean find = false;
        Client c = null;
        System.out.println("Nom du client?:");
        while (!find) {
            nom = scanner.nextLine();
            for (int i = 0; (!find && i < clients.length); i++) {
                if ((clients[i].getNom()).equals(nom)) {
                    find = true;
                    c = clients[i];
                }
            }
            if (!find) {
                System.out.println("Ce client est inconnu, veuillez reprendre ");
            }
        }
        return c;
    }

    static Medicament lireMedicament(Medicament[] medicaments) {
        String nom = null;
        boolean find = false;
        Medicament m = null;
        System.out.println("Nom du medicament?:");
        while (!find) {
            nom = scanner.nextLine();
            for (int i = 0; (!find && i < medicaments.length); i++) {
                if ((medicaments[i].getNom()).equals(nom)) {
                    find = true;
                    m = medicaments[i];
                }
            }
            if (!find) {
            System.out.println("Ce medicament n'est pas en stock veuilliez recommencer");
            }
        }
        return m;
    }

    static double lirePaiement() {
        double paiement = 0.0;
        System.out.println("quel est le montant du paiement?");
        paiement = scanner.nextDouble();
        scanner.nextLine();

        return paiement;
    }

    static int lireQuantite() {
        int quantite;
        System.out.println("quelle est la quantite achetee?");
        quantite = scanner.nextInt();
        scanner.nextLine();

        return quantite;
        
    }

    static void quitter() {
        System.out.println("Programme termine!");
    }
}
       
