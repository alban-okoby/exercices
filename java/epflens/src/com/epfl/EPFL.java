package com.epfl;

import java.util.ArrayList;
import java.util.Calendar;


public class EPFL {
	private ArrayList<EPFLien> epfliens;
	
	public EPFL() {
		epfliens = new ArrayList<>();
	}
	
	/**
	 * @param e
	 * @return Ajouter un EPPLien ( soit un étudiant ou un personnel)
	 */
	public EPFL ajouter(EPFLien e) {
		epfliens.add(e);
		return this;
	}
	
	public EPFLien get(int i) {
		if (i < totalEPFLien()) {
			return epfliens.get(i);
		}
		return null;
	}
	
	/**
	 * @return Méthode qui renvoie le nombres d'EPFL (le nombre d'étudiants et de personnels)
	 */
	public int totalEPFLien() {
		return epfliens.size();
	}
	
	/**
	 * @return Méthode qui renvoie le nombres d'EPFL (soit le nombre d'étudiants)
	 */
	public int totalEtudiant() {
		int nbreEtudiant = 0;
		for (EPFLien ep : epfliens) {
			if (ep.estEtudiant()) {
				++nbreEtudiant;
			}
		}
		return nbreEtudiant;
	}
	
	/**
	 * @return Cette méthode retourne le nombre d'années moyen pendant lesquelles les personnes enregistrées ont fréquenté l'EPFL
	 */
	public double tempsMoyen() {
		double moyenne = 0.;
		// Affichage de l'année courante
		int anneeCourante  = Calendar.getInstance().get(Calendar.YEAR);
		for (EPFLien ep : epfliens) {
			if (ep.estEtudiant()) {
				moyenne = moyenne + (anneeCourante - ep.getAnnee());
			}
		}
		moyenne /= totalEPFLien();
		return moyenne;
	}
	
	/**
	 * affiche la liste de tous les EPPLiens
	 */
	public void afficher() {
		System.out.println("La liste des EPFLiens:");
		for (EPFLien ep : epfliens) {
			ep.afficher();
		}
	}
}