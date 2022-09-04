package com.pharmatie;

import java.util.Scanner;

public class Pharmacie {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Client[] clients = new Client[2];
        Medicament[] medicaments = new Medicament[2];
        clients[0] = new Client("client1", 0.0);
        clients[1] = new Client("client2", 0.0);
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
        System.out.println("Saisissez la Quantite : ");
        int quantite = scanner.nextInt();
        scanner.nextLine();
        medicament.augmenterStock(quantite);
    }

    /**
     * @param clients affiche les clients
     * @param medicaments affiche les médicaments
     */
    static void affichage(Client[] clients, Medicament[] medicaments) {
        System.out.println("Affichage des stocks");

        for (int i = 0; i < medicaments.length; i++) {
            System.out.println("Stock du medicament " + medicaments[i].getNom()
                    + " " + medicaments[i].getStock());
        }
        System.out.println("Affichage des credits");

        for (int i = 0; i < clients.length; i++) {
            System.out.println("Credit du client " + clients[i].getNom()
                    + " :" + clients[i].getCredit());
        }
    }

    /**
     * @param clients
     * @return retourne un client s'il existe
     */
    static Client lireClient(Client[] clients) {
        String nom = null;
        boolean find = false;
        Client client = null;
        System.out.println("Le nom du client ?:");
        while (!find) {
            nom = scanner.nextLine();
            for (int i = 0; (!find && i < clients.length); i++) {
                if ((clients[i].getNom()).equals(nom)) {
                    find = true;
                    client = clients[i];
                }
            }
            if (!find) {
                System.out.println("Ce client est inconnu, veuillez reprendre ");
            }
        }
        return client;
    }

    /**
     * Méthode chargée de la vérification d'un médicament 
     * @param medicaments
     * @return retourne le nom du medicament s'il existe 
     */
    static Medicament lireMedicament(Medicament[] medicaments) {
        String nom = null;
        boolean find = false;
        Medicament medicament = null;
        System.out.println("Nom du medicament ?:");
        while (!find) {
            nom = scanner.nextLine();
            for (int i = 0; (!find && i < medicaments.length); i++) {
                if ((medicaments[i].getNom()).equals(nom)) {
                    find = true;
                    medicament = medicaments[i];
                }
            }
            if (!find) {
                System.out.println("Ce medicament n'est pas en stock veuilliez recommencer");
            }
        }
        return medicament;
    }

    /**
     * @return le montant du paiement du client
     */
    static double lirePaiement() {
        double montantPaiement = 0.0;
        System.out.println("quel est le montant du paiement?");
        montantPaiement = scanner.nextDouble();
        scanner.nextLine();

        return montantPaiement;
    }

    /**
     * Reccupérer la quantité achetée
     * @return la quantité achetée
     */
    static int lireQuantite() {
        int quantiteAchetee;
        System.out.println("quelle est la quantite achetee ?");
        quantiteAchetee = scanner.nextInt();
        scanner.nextLine();

        return quantiteAchetee;

    }

    /**
     * Quitter le programme
     */
    static void quitter() {
        System.out.println("Programme termine !");
    }
}

// Créations de nos classe objets
class Client {

    private double credit = 0.0;
    private String nom = "";

    public Client(String nom, double credit) {
        this.credit = credit;
        this.nom = nom;
    }

    public void augmenterCredit(double montant) {
        credit = credit + montant;
    }

    public void diminuerCredit(double montant) {
        credit = credit - montant;
    }

    public double getCredit() {
        return credit;
    }

    public String getNom() {
        return nom;
    }
}

class Medicament {
    private String nom;
    private double prix;
    private int stock;

    public Medicament(String nom, double prix, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    public void augmenterStock(int quantite) {
        stock = stock + quantite;
    }

    public void diminuerStock(int quantite) {
        stock = stock - quantite;
    }

    public int getStock() {
        return stock;
    }

    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }
}
