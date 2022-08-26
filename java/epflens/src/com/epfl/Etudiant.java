package com.epfl;


	/**
	* Super classe Etudiant  
	*/
public class Etudiant extends EPFLien {
	protected String section;
	protected boolean estRegulier;
	
	/**
	 * @param nom
	 * @param annee
	 * @param section
	 * @param estRegulier vérifie si l'étudiant est régulier
	 */
	public Etudiant(String nom, int annee, String section, boolean estRegulier) {
		super(nom, annee);
		this.section = section;
		this.estRegulier = estRegulier;
	}
	
	/**
	 * Constructeur des objets Etudiants
	 * @param nom de l'étudiant
	 * @param annee d'entrée de l'étudiant
	 * @param section de l'étudiant
	 */
	public Etudiant(String nom, int annee, String section) {
		this(nom, annee, section, false);
	}
	
	@Override
	public void afficher() {
		System.out.print(this);
	}
	
	@Override
	public boolean estEtudiant() {
		return true;
	}
	
	@Override
	public String toString() {
		String str = "Etudiant ";
		str += estRegulier ? "regulier:\n" : "d'echange:\n";
		str += super.toString();
		str += "  Section : " + section + "\n";
		return str;
	}
}