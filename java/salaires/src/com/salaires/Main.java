package com.epfl;

import java.util.ArrayList;

Public Emloye
{
        private String nom;
        private String prenom;
        private int age;
        private String date;


        public Employe(String nom, String prenoms, int age,String date)
        this.nom=nom;
        this.prenoms= prenoms;
        this.age=age;
        this.date=date;


public String afficherTitre() {
        return "L'employe";
}
public abstract double calculerSalaire()
}
class Technicien extends Employe {
  private double nombreUnites;
  private final static Double COEFFICIENT = 5.0;


  public Technicien(String nom,String prenoms,int age,double nombreUnites)
  {
        super(nom,prenoms,age,date);
         this.nombreUnites=nombreUnites;      
  }
  public double calculerSalaire();
  {
     return nombreUnites * COEFFICIENT;
  }
  public String afficherTitre(){
        return "Le technicien " + super.afficherTitre;
  }
 class commercial extends Employe {
        private double ChiffreAffaire;

        /**
         * 
         */
        public commercial(String nom,Strinf prenoms,int age,double ChiffreAffaire)
        {
                super(nom,prenoms,age,date);
                this.nombreUnites=nombreUnites;   
        }
 }
 class Representant extends commercial  
 {
        public static double POURCENTAGE_REPRESENTANT = 0.2;
        public static double BONUS_REPRESENTANT = 800;

        public double calculerSalaire(){
                return (getChiffreAffaire() * POURCENTAGE_REPRESENTANT + BONUS_REPRESENTANT;
        }
        public String afficherTitre(){
                return "Le commercial" + super.afficherTitre;
        }

 }

 class Vendeur extends commercial  
 {
        public static double POURCENTAGE_VENDEUR = 0.2;
        public static double BONUS_VENDEUR = 400;

        public double calculerSalaire(){
                return (getChiffreAffaire() * POURCENTAGE_VENDEUR + BONUS_VENDEUR;
        }
        public String afficherTitre(){
                return "Le vendeur" + super.afficherTitre;
        }

 }

 
 class Manutentionnaire extends Employe  
 {
        public static double heuretravail;
        public static double salairehoraire = 65;

        public Manutentionnaire(String nom,Strinf prenoms,int age,double ChiffreAffaire)
        {
                super(nom,prenoms,age,date,heuretravail);
                  
        }

        public double getHeureDetravail(){
                return heuretravail;
        }
        public String afficherTitre(){
                return "Le Manutentionnaire" + super.afficherTitre;
        }
        public double calculerSalaire()
        
        

 }
 class ManutARisque extends Manutentionnaire();
 {
        public ManutARisque(String nom,String prenoms,int age,double ChiffreAffaire)
        {
                super(nom,prenoms,age,date,heuretravail);
                  
        }
        public  double calculerSalaire(){
                return (super.calculerSalaire() + PRIME);
        }
 }

 class TechnARisque extends Technicien();
 {
        public TechnARisque(String nom,String prenoms,int age,double ChiffreAffaire)
        {
                super(nom,prenoms,age,date,heuretravail);
                  
        }
        public  double calculerSalaire(){
                return (super.calculerSalaire() + PRIME);
        }
 }

class personnel {
        final int MAX_EMPLOYE = 200;
        private  static int nombreEmploye;
        private ArrayList<Employe> employes;
        
        public Personnel() {
                employes = new ArrayList<Employe>();
                nombreEmploye=0;
        }

        public void  ajouterEmploye(Employe employe){
                if (employe.size < MAX_EMPLOYE) {
                        employe.add(employe);
                        nombreEmploye ++;
                }
                else {
                        System.out.println("La limte  a ete  atteint ");
                }
        }

        public void afficherSalaires()
        {
                for (Employe employe : employes) {
                        System.out.println(employe.afficherTitre()+"gagne"+,employe.calculerSalaire()"francs comme salaire");
                        
                }
        }

        public void salaireMoyen ;

}




}

public class Main {

    public static void main(String[] args) {
	// write your code here

        Personnel p = new Personnel();
        
        new Vendeur("Pierre", "Business", 45, "1995", 3000).ajouterEmploye(p);
        /*
        
                0));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 2
                0000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000
        ));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "
                1998", 45));
                p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 100
                        0));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45)
        );
        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p
                .salaireMoyen() + " francs.");

         */
    }
}


