package com.epfl;

import java.util.Date;

public class Salaire {

    public abstract class Employe {
        // Les propriétés communes aux différentes classes.
        public String name;
        public String lastName;
        public Date date;
        public int age;

        /*
         * @param name est le nom de l'employé
         * @param lastName est le prénom de l'employé
         * @param date est la date de début de service de l'employé
         */

        public Employe(String name, String lastName, Date date, int age) {
            this.name = name;
            this.lastName = lastName;
            this.Date = date;
            this.age = age;
        }

        /*
        * Méthode qui reccupère le nom et le prénom de l'employé de type chaîne de caractères
         */

        public String getName() {
            return "L'employé ".concat(this.name).concat(" ").concat(this.lastName);
        }

    }


}
