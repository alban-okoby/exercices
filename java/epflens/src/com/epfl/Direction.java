package com.epfl;


public class Direction {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Création d'Etudiants ( régulier ou echange)
        EtudiantRegulier cecile = new EtudiantRegulier("Koffi Cecile", 2022, "UVCI", 7.3);
        EtudiantRegulier yvan = new EtudiantRegulier("Yvan Rattrapeur", 2011, "SSC", 2.5);
        EtudiantEchange bjorn = new EtudiantEchange("Bjorn Borgue", 2012, "Informatique", "KTH");
        EtudiantEchange Arnaud = new EtudiantEchange("Yao Arnaud", 2005, " ", "PIGIER");
        EtudiantRegulier gaston = new EtudiantRegulier("Gaston Peutimide", 2013, "SSC", 6.0);
        
        // Création de personnel ( Enseignant ou Secretaire )
        Enseignant math = new Enseignant("Mathieu Matheu", 1998, "LMEP", 10000, "Physique");
        Secretaire sophie = new Secretaire("Sophie Scribona", 2005, "LMT", 5000);

        // Instation d'objet Epfl pour y ajouter le Personnel et/ou les Etudiants crées
        EPFL epfl = new EPFL();
        
        // Ajout des personnes instantées
        epfl.ajouter(cecile)
                .ajouter(gaston)
                .ajouter(yvan)
                .ajouter(bjorn)
                .ajouter(math)
                .ajouter(sophie)
                .ajouter(Arnaud);
        
        String str = "Parmi les " + epfl.totalEPFLien() + " EPFLiens, ";
        str += epfl.totalEtudiant() + " sont des etudiants.\n";
        str += "Ils sont a l'EPFL depuis en moyenne " + epfl.tempsMoyen() + " ans";
        System.out.println(str);
        epfl.afficher();

    }
}


