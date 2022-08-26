package com.epfl;

public class EtudiantRegulier extends Etudiant {
	private double moyenne;
	
	public EtudiantRegulier(String nom, int annee, String section, double moyenne) {
		super(nom, annee, section, true);
		this.moyenne = moyenne;
	}
	
	@Override
	public void afficher() {
		System.out.print(this);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += "  Moyenne : " + moyenne + "\n";
		return str;
	}
}
