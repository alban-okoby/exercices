package com.epfl;

import java.util.ArrayList;
import java.util.Collection;

public class Personnel {
    
    /**
     * Classe Personnel permet de gérer la collection de type Employé
    */

    public Collection<TypeSalaire> employees;

    /**
    * Constructeur par défaut de la classe Personnel 
    */
    public Personnel() {

        this.employees = new ArrayList<>();
    }

    /**
     * Méthode permettant d'ajouter un employé
     * @param employe
     */
    public void ajouterEmploye(TypeSalaire employe) {
        this.employees.add(employe);
    }
    
    
    /**
    * Méthode permettant d'afficher le nom d'un employé
    * @return String 
    * @param employe
    */
    
    public void afficherSalaires() {

        /*
         * Utilisation de la string pour afficher le salaire d'un employé
         * Utilisation de la méthode append() pour les type primitif 
         * Transformer le salaire double en String 
         * 
         */

         StringBuffer infos = new StringBuffer(); 

        // Utilisation de append avec un objet de type String 
        infos.append("Liste des salaires des employés \n" ); 

        for(TypeSalaire employe : this.employees ) {

            infos.append("Le ");
            infos.append(employe.getName());
            infos.append(" gagne ");
            infos.append(employe.calculerSalaire());
            infos.append(" francs. \n");
        }
        // La toSTring méthode permet d'instancier une seule fois et non à chaque fois qu'il y a une concaténation en occurence ici avec la append() méthode
        // return infos.toString();

    }

}


