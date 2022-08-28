package com.salaire;

import java.util.ArrayList;

abstract class Employe{

    private String nom;
    private String prenom;
    private int age;
    private String date;

    /*
     * Constructeur
    * @param nom est le nom de l'employé
    * @param prenom est le prenom de l'employé
     */
    public Employe(String nom, String prenom, int age, String date) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String afficherTitre() {
        return getNom() + " " + getPrenom();
    }

    public abstract double calculerSalaire();

}

class Technicien extends Employe {

    private double nombreUnite;
    private final static double COEFFICIENT = 5.0;


    public Technicien(String nom, String prenom, int age, String date, double nombreUnite) {
        super(nom, prenom, age, date);
        this.nombreUnite = nombreUnite;
    }

    @Override
    public double calculerSalaire() {
        return nombreUnite * COEFFICIENT;
    }

    @Override
    public String afficherTitre() {
        return "Le technicien "+ super.afficherTitre();
    }
}

class Commercial extends Employe {

    private  double chiffreAffaire;

    public Commercial(String nom, String prenom, int age, String date, double chiffreAffaire) {
        super(nom, prenom, age, date);
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    @Override
    public double calculerSalaire() {
        return 0;
    }
}

class Representant extends Commercial {

    public final static double POURCENTAGE_REPRESENTANT = 0.2;
    public final static double BONUS_REPRESENTANT = 800.0;

    public Representant(String nom, String prenom, int age, String date, double chiffreAffaire) {
        super(nom, prenom, age, date, chiffreAffaire);
    }

    @Override
    public double calculerSalaire() {
        return (getChiffreAffaire()* POURCENTAGE_REPRESENTANT) + BONUS_REPRESENTANT;
    }

    @Override
    public String afficherTitre() {
        return "Le représentant "+super.afficherTitre();
    }
}


class Vendeur extends Commercial {

    public final static double POURCENTAGE_VENDEUR = 0.2;
    public final static double BONUS_VENDEUR = 400.0;

    public Vendeur(String nom, String prenom, int age, String date, double chiffreAffaire) {
        super(nom, prenom, age, date, chiffreAffaire);
    }

    @Override
    public double calculerSalaire() {
        return (getChiffreAffaire()* POURCENTAGE_VENDEUR) + BONUS_VENDEUR;
    }

    @Override
    public String afficherTitre() {
        return "Le Vendeur " + super.afficherTitre();
    }
}

class Manutentionnaire extends Employe {

    private double heureDeTravail;
    public final static double SALAIRE_HORAIRE = 65.0;

    public Manutentionnaire(String nom, String prenom, int age, String date, double heureDeTravail) {
        super(nom, prenom, age, date);
        this.heureDeTravail = heureDeTravail;
    }

    public double getHeureDeTravail() {
        return heureDeTravail;
    }

    @Override
    public String afficherTitre() {
        return "Le Manutennionnaire " + super.afficherTitre();
    }

    @Override
    public double calculerSalaire() {
        return (heureDeTravail * SALAIRE_HORAIRE);
    }
}

interface PrimeDeRisque {
    double PRIME = 200;
}

class ManuARisque extends Manutentionnaire implements PrimeDeRisque{


    public ManuARisque(String nom, String prenom, int age, String date, double heureDeTravai) {
        super(nom, prenom, age, date, heureDeTravai);
    }

    @Override
    public double calculerSalaire() {
        return (super.calculerSalaire() + PRIME);
    }
}

class TechARisque extends Technicien implements PrimeDeRisque {

    public TechARisque(String nom, String prenom, int age, String date, double heureDetravail) {
        super(nom, prenom, age, date, heureDetravail);
    }

    @Override
    public double calculerSalaire() {
        return (super.calculerSalaire() + PRIME);
    }
}

class Personnel {

    final int MAX_EMPLOYE = 200;
    private static int nombreEmploye;
    private ArrayList<Employe> employes;

    public Personnel() {
        employes = new ArrayList<Employe>();
        nombreEmploye = 0;
    }

    public void ajouterEmploye(Employe employe) {
        if(employes.size() < MAX_EMPLOYE) {
            employes.add(employe);
            nombreEmploye++;
        }
        else {
            System.out.println("Désolé, la limite d'ajout des employés est atteinte");
        }

    }

    public void afficherSalaires() {

        for(Employe emp: employes) {
            System.out.println(emp.afficherTitre() + " gagne " + emp.calculerSalaire() + " francs comme salaire.");
        }
    }

    public double salaireMoyen() {
        double sommeSalaire = 0;
        for(Employe emp: employes) {
            sommeSalaire += emp.calculerSalaire();
        }
        return  (employes.size()> 0) ? sommeSalaire / employes.size() : 0.0;
    }

}
public class Main {

    public static void main(String[] args) {

        Personnel p = new Personnel();

        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, " 1998", 45));
        p.ajouterEmploye(new TechARisque("Jean", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManuARisque("Al", "Abordage", 30, "2001", 45));
        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");
    }
}

