package com.epfl;

public class EtudiantRegulier extends Etudiant {
	private double moyenne;
	
	/**
	 * @param nom est le nom ( et eventuellement le prénom ) de l'étudiant régulier
	 * @param annee est l'année d'entrée à EPFL de l'étudiant régulier
	 * @param section est la section de l'étudiant régulier
	 * @param moyenne est la moyenne de l'étudiant régulier
	 */
	public EtudiantRegulier(String nom, int annee, String section, double moyenne) {
		super(nom, annee, section, true);
		this.moyenne = moyenne;
	}
	
	/* 
	 * Rédéfinition de la méthode qui affiche un étudiant régulier
	 */
	@Override
	public void afficher() {
		System.out.print(this);
	}
	
	/* 
	 * Rédéfinition de la méthode qui convertir en chaîne
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str += "  Moyenne : " + moyenne + "\n";
		return str;
	}
}
