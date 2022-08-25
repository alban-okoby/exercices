package com.epfl;

public interface TypeSalaire {
    

    /**
     * Méthode permettant de calculer le salaire d'un employé 
     * Elle est abstraite car n'est pas implémentée dans cette classe (TypeSalaire) 
     * Cependant elle sera implémntée dans les sous-classes qui héritent de Employe  
     * 
     * @param return int montant du salaire mensuel de l'Employé 
     */
    public int calculSalaire(); 

    /**
     * Méthode permettant de reccupérer le nom et prénom de l'employé
     * 
     * @param return int montant du salaire mensuel de l'Employé 
     */
    public String getName();
        
    
}
