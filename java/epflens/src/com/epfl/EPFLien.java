package com.epfl;

/**
	 * Classe abstraite regoupant les attributs
	 * et les méthodes communes aux différentes classes
 */
public abstract class EPFLien {

    // Les propriétés communes aux différentes classes.
	protected String nom;
	protected int annee;
	
	/**
	 * Constructeur par défaut de la classe EPPLien 
	 * @param nom le nom du personnel ou de l'étudiant
	 * @param annee l'année du personnel ou de l'étudiant
	 */
	public EPFLien(String nom, int annee) {
		this.nom = nom;
		this.annee = annee;
	}
	
	/**
	 * Méthode d'affichage d'un personnel ou d'un étudiant
	 */
	public void afficher() {
		System.out.print(this);
	}
	
	/**
	 * @return Méthode de vérification si c'es un étudiant
     * Sinon retourne false
	 */
	public boolean estEtudiant() {
		return false;
	}

	/**
	 * @return Rédéfinition de la méthode toString() pour
     * retourner le nom et l'annnée d'un Personnel ou d'un Etudiant
	 */
    
	@Override
	public String toString() {
		String str = "";
		str += "  Nom : " + nom + "\n";
		str += "  Annee : " + annee + "\n";
		return str;
	}

	/**
	 * @return renvoie l'année
	 */
	public int getAnnee() {
		return annee;
	}
}