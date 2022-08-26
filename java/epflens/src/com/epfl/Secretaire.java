package com.epfl;

public class Secretaire extends Personnel {
	
	public Secretaire(String nom, int annee, String laboratoire, double salaire) {
		super(nom, annee, laboratoire, salaire);
	}
	
	@Override
	public void afficher() {
		System.out.print(this);
	}
	
	@Override
	public String toString() {
		String str = "Secretaire:\n";
		str += super.toString();
		return str;
	}
}
