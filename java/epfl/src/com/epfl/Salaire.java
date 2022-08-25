package com.epfl;

import java.util.Date;

public class Main {

    public abstract class Employe {
        // Les propriétés communes aux différentes classes.
        public String name;
        public String lastName;
        public Date date;
        public int age;

        /**
         * @param name est le nom de l'employé
         * @param lastName est le prénom de l'employé
         * @param date est la date de début de service de l'employé
         */

        public Employe(String name, String lastName, Date date, int age) {
            this.name = name;
            this.lastName = lastName;
            this.date = date;
            this.age = age;
        }

        /*
        * Méthode qui reccupère le nom et le prénom de l'employé de type chaîne de caractères
         */

        public String getName() {
            return "L'employé ".concat(this.name).concat(" ").concat(this.lastName);
        }

    }

    /*
        Personnel p = new Personnel();

        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 3000
                0));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 2
                0000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000
        ));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "
                1998", 45));
                p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 100
                        0));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45)
        );
        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p
                .salaireMoyen() + " francs.");

         */


}
