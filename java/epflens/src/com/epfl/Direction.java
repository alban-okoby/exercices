package com.epfl;


public class Direction {

    public static void main(String[] args) {
	// write your code here

        // Etudiants
        EtudiantRegulier gaston = new EtudiantRegulier("Gaston Peutimide", 2013, "SSC", 6.0);
        EtudiantRegulier yvan = new EtudiantRegulier("Yvan Rattrapeur", 2011, "SSC", 2.5);
        
        EtudiantEchange bjorn = new EtudiantEchange("Bjorn Borgue", 2012, "Informatique", "KTH");
        
        // Enseignant
        Enseignant math = new Enseignant("Mathieu Matheu", 1998, "LMEP", 10000, "Physique");
        
        // Secretaire
        Secretaire sophie = new Secretaire("Sophie Scribona", 2005, "LMT", 5000);

        EPFL epfl = new EPFL();
        
        epfl.ajouter(gaston)
                .ajouter(yvan)
                .ajouter(bjorn)
                .ajouter(math)
                .ajouter(sophie);
        
        String str = "Parmi les " + epfl.totalEPFLien() + " EPFLiens, ";
        str += epfl.totalEtudiant() + " sont des etudiants.\n";
        str += "Ils sont a l'EPFL depuis en moyenne " + epfl.tempsMoyen() + " ans";
        System.out.println(str);
        epfl.afficher();

    }
}


