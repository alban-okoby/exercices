package com.epfl;

public class Personnel extends EPFLien {
	protected String laboratoire;
	protected double salaire;
	

	/**
	 * Constructeur de la class Personnel 
	 * Sachant qu'un personnel est soit de type ( Enseignant ou Secretaire )
	 * @param nom le nom du personnel
	 * @param annee l'année de début de service 
	 * @param laboratoire le laboratoire ou il exerce 
	 * @param salaire le salaire du personnel
	 */
	public Personnel(String nom, int annee, String laboratoire, double salaire) {
		super(nom, annee);
		this.laboratoire = laboratoire;
		this.salaire = salaire;
	}
	
	@Override
	public void afficher() {
		System.out.print(this);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "  Laboratoire : " + laboratoire + "\n";
		str += "  Salaire : " + salaire + "\n";
		return str;
	}
}