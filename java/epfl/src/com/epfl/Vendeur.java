package com.epfl;


class Vendeur extends Employe {
    
    /**
     * La propriété spécifique aux vendeurs
     */
     int chiffreDeVente;
     final int PRIME_VENDEUR  = 400;

     /**
      * Constructeur
      * @param name est le nom du vendeur
      * @param lastName est le prénom du vendeur
      * @param Date est la date de début de sercive du vendeur 
      * @param age est l'age du vendeur
      * @param chiffreDeVente est le total mensuel de vente du vendeur
      */

    public Vendeur(String name, String lastName, String age, int date, int chiffreDeVente) {
        // Appel au construction de la super classe Employé
        super(name, lastName, age, date);
        this.chiffreDeVente = chiffreDeVente;
    }

    /**
     * @return retourne le salaire du vendeur
     */
    
    public double calculSalaire() {
        return this.pourcentageVente() + PRIME_VENDEUR; 
    }

    /**
     * @return retourne le poucentage du chiffre affaire du vendeur
     */
    protected double pourcentageVente() {
        return this.chiffreDeVente * 0.2; 
    }
}
