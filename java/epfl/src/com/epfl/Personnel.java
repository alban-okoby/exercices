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
        public void adjoutEmploye(TypeSalaire employe) {
            this.employees.add(employe);
        }
        
    
    /**
    * Méthode permettant d'afficher le nom d'un employé
    * @return String 
    * @param employe
    */
    
    public String afficheSalaire() {

        /*
         * Utilisation de la string pour afficher le salaire d'un employé
         */
    }


}
