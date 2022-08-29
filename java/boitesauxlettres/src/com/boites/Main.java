package com.boites;

abstract class Courrier {
    protected double poids;
    protected boolean estExpress;
    protected String adresseDestination;

    public Courrier(double poids, boolean estExpress, String adresseDestination) {
        this.poids = poids;
        this.estExpress = estExpress;
        this.adresseDestination = adresseDestination;
    }

    public abstract void afficher();

    public abstract double affranchirNormal();

    public double affranchir() {
        double prix = .0;
        if (!estInvalide()) {
            prix = affranchirNormal();
            if (estExpress) {
                prix *= 2;
            }
        }
        return prix;
    }


    public boolean estInvalide() {
        return adresseDestination.isEmpty();
    }

    @Override
    public String toString() {
        String expressStr = estExpress ? "oui" : "non";
        String str = estInvalide() ? "(Courrier invalide)\n" : "";
        str += "  Poids : " + poids + " grammes\n";
        str += "  Express : " + expressStr + "\n";
        str += "  Destination : " + adresseDestination + "\n";
        str += "  Prix : " + affranchir() + " CHF\n";
        return str;
    }
}


class Lettre extends Courrier {
    private Format format;

    public Lettre(double poids, boolean estExpress, String adresseDestination, Format format) {
        super(poids, estExpress, adresseDestination);
        this.format = format;
    }

    @Override
    public double affranchirNormal() {
        double tarifDeBase = format == Format.A4 ? 2.50 : 3.50;
        return tarifDeBase + 1.0 * poids / 1000.;
    }

    @Override
    public void afficher() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String str = "Lettre\n";
        str += super.toString();
        str += "  Format : " + format + "\n";
        return str;
    }
}

/**
 * On liste ici les formats de lettre possible
 */
enum Format {
    A3, A4;
}

class Colis extends Courrier {
    private double volume;

    public Colis(double poids, boolean estExpress, String adresseDestination, double volume) {
        super(poids, estExpress, adresseDestination);
        this.volume = volume;
    }

    @Override
    public double affranchir() {
        double prix = .0;
        if (!estInvalide()) {
            prix = .25 * volume + 1.0 * poids / 1000.;
            if (estExpress) {
                prix *= 2;
            }
        }
        return prix;
    }

    @Override
    public double affranchirNormal() {
        return .25 * volume + 1.0 * poids;
    }

    @Override
    public void afficher() {
        System.out.println(this);
    }

    @Override
    public boolean estInvalide() {
        return super.estInvalide() || volume > 50.0;
    }

    @Override
    public String toString() {
        String str = "Colis\n";
        str += super.toString();
        str += "  Volume : " + volume + " litres\n";
        return str;
    }
}

class Publicite extends Courrier {
    public Publicite(double poids, boolean estExpress, String adresseDestination) {
        super(poids, estExpress, adresseDestination);
    }


    @Override
    public double affranchirNormal() {
        return 5.0 * poids / 1000.;
    }

    @Override
    public void afficher() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String str = "Publicite\n";
        str += super.toString();
        return str;
    }
}

class Boite {
    private Courrier[] courriers;
    private int index;

    public Boite(int taille) {
        courriers = new Courrier[taille];
        this.index = 0;
    }

    public void ajouterCourrier(Courrier courrier) {
        if (index < courriers.length) {
            courriers[index] = courrier;
            ++index;
        } else {
            System.out.println("La boite est pleine !");
        }
    }

    public double affranchir() {
        double total = .0;
        for(int i = 0; i < index; i++) {
            total += courriers[i].affranchir();
        }
        return total;
    }

    public int courriersInvalides() {
        int nbreInvalide = 0;
        for(int i = 0; i < index; i++) {
            if (courriers[i].estInvalide()) {
                nbreInvalide += 1;
            }
        }
        return nbreInvalide;
    }

    public void afficher() {
        for(int i = 0; i < index; i++) {
            courriers[i].afficher();
        }
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        // 30  est la capacit'e maximale de la
        // boite aux lettres
        // (pas necessaire si vous dêcidez d'utiliser
        // un ArrayList).
        Boite boite = new Boite(30);

        //Creation de divers courriers/colis..
        Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", Format.A3);
        Lettre lettre2 = new Lettre(800, false, "", Format.A4); // invalide

        Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
        Publicite pub2 = new Publicite(3000, false, ""); // invalide

        Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
        Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !

        boite.ajouterCourrier(lettre1);
        boite.ajouterCourrier(lettre2);
        boite.ajouterCourrier(pub1);
        boite.ajouterCourrier(pub2);
        boite.ajouterCourrier(colis1);
        boite.ajouterCourrier(colis2);


        System.out.println("Le montant total d'affranchissement est de " +
                boite.affranchir());
        boite.afficher();

        System.out.println("La boite contient " + boite.courriersInvalides()
                + " courriers invalides");
    }
}
