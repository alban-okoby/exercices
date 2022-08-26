package com.epfl;

public class Personnel extends EPFLien {
	protected String laboratoire;
	protected double salaire;
	
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