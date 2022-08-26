package com.epfl;

import java.util.ArrayList;
import java.util.Calendar;


public class EPFL {
	private ArrayList<EPFLien> epfliens;
	
	public EPFL() {
		epfliens = new ArrayList<>();
	}
	
	public EPFL ajouter(EPFLien e) {
		epfliens.add(e);
		return this;
	}
	
	public EPFLien get(int index) {
		if (index < totalEPFLien()) {
			return epfliens.get(index);
		}
		return null;
	}
	
	public int totalEPFLien() {
		return epfliens.size();
	}
	
	public int totalEtudiant() {
		int nbreEtudiant = 0;
		for (EPFLien ep : epfliens) {
			if (ep.estEtudiant()) {
				++nbreEtudiant;
			}
		}
		return nbreEtudiant;
	}
	
	public double tempsMoyen() {
		double moyenne = 0.;
		int anneeCourante  = Calendar.getInstance().get(Calendar.YEAR);
		for (EPFLien ep : epfliens) {
			if (ep.estEtudiant()) {
				moyenne = moyenne + (anneeCourante - ep.getAnnee());
			}
		}
		moyenne /= totalEPFLien();
		return moyenne;
	}
	
	public void afficher() {
		System.out.println("Liste des EPFLiens:");
		for (EPFLien ep : epfliens) {
			ep.afficher();
		}
	}
}