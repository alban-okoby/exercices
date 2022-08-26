package com.epfl;

public class Enseignant extends Personnel {
	protected String section;
	
	public Enseignant(String nom, int annee, String laboratoire, double salaire, String section) {
		super(nom, annee, laboratoire, salaire);
		this.section = section;
	}
	
	@Override
	public void afficher() {
		System.out.print(this);
	}
	
	@Override
	public String toString() {
		String str = "Enseignant:\n";
		str += super.toString();
		str += "  Section d'enseignement : " + section + "\n";
		return str;
	}
}
