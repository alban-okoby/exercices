package com.epfl;

public class Etudiant extends EPFLien {
	protected String section;
	protected boolean estRegulier;
	
	public Etudiant(String nom, int annee, String section, boolean estRegulier) {
		super(nom, annee);
		this.section = section;
		this.estRegulier = estRegulier;
	}
	
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