package com.supermarche;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

 class Article {

    private String nomArticle;
    private double prixArticle;
    private boolean solde;

    /*
     * Constructeur
     * @param NomArticle est le nom de l'aricle
     * @param PrixArticle est le prix de d'article
     * @param Solde montre si l'article est en solde ou pas
     */
    public Article(String nomArticle, double prixArticle, Boolean solde){
        this.nomArticle = nomArticle;
        this.prixArticle = prixArticle;
        this.solde  =solde;
    }

    public String getNomArticle(){ return nomArticle;}
    public Double getPrixArticle(){ return prixArticle;}
    public Boolean getSolde(){ return solde;}



}
class Achat  {
     /*
     *Constructeur
     * @param qteArticle est la quantité d'article
      */
     private Article article;
     private double qteArticle;


    public Achat(Article article, double qteArticle) {
            this.article=article;
            this.qteArticle=qteArticle;
    }

    public void afficher() {
        String nomArticle=article.getNomArticle();
        double prixArticle=article.getPrixArticle();
        double prixTotal=getPrix();
        String indiceRabais="";
        if (article.getSolde()) {
            indiceRabais="(1/2 prix)";
        }
        System.out.println(nomArticle+":"+prixArticle+" x "+qteArticle+" = "+prixTotal+" Frs"+indiceRabais);
    }
    //classe caisse


    public double getPrix(){
        double rabais=1.0;
        if (article.getSolde()){
            rabais=0.5;
        }
       return qteArticle*rabais*article.getPrixArticle();
    }
}

class Caddie {
    private ArrayList<Achat> listeAchat;

    /*
     *Constructeur
     * @param nombreAchat
     * utilisation du tableau dynamique pour parcourir les achats
     */
//contructeur
    public Caddie() {
        listeAchat = new ArrayList<Achat>();
    }

    public void remplir(Article article, double qteArticle) {
        Achat achat = new Achat(article, qteArticle);
        listeAchat.add(achat);
    }

    public int nombreAchat() {
        return listeAchat.size();
    }

    public Achat getAchat(int index) {
        return listeAchat.get(index);
    }
}

class Caisse {
    private int numCaisse;
    private double total;
    //constructeur
    public Caisse(int numCaisse,double total){
       this.numCaisse=numCaisse;
       this.total=total;
    }

    public int getNumCaisse() { return numCaisse; }

    //Methode
    public void scanner(Caddie caddie){

        System.out.println("=======================================");
        Date dateCourante = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
        System.out.println(formatDate.format(dateCourante));
        System.out.println("caisse numero "+numCaisse);
        System.out.println();

        int nombreachat=caddie.nombreAchat();
        double totalCaddie=0.0;
        for (int i=0; i<nombreachat;i++)
        {
             Achat achat=caddie.getAchat(i);
             achat.afficher();
            totalCaddie += achat.getPrix();
            total += totalCaddie;
        }

        System.out.println();
        System.out.println(" Montant a payer: "+totalCaddie+" frs ");


        System.out.println("=======================================");


        System.out.println("=======================================");
    }
    public void totalCaisse() {
        System.out.println("La caisse numero "+numCaisse+" a encaisse "+total+" frs aujourdhui");
    }

}







public class Main {
    public static void main(String[] args) {
        Date dateCourante = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
        System.out.println(formatDate.format(dateCourante));
        // Les articles vendus dans le supermarché
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false
        );
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);
        // Les caddies du supermarché
        Caddie caddie1 = new Caddie();
        Caddie caddie2 = new Caddie();
        Caddie caddie3 = new Caddie();
        // Les caisses du supermarché
        // le premier argument est le numero de la caisse
        // le second argument est le montant initial de la caisse.
        Caisse caisse1 = new Caisse(1, 0.0);
        Caisse caisse2 = new Caisse(2, 0.0);
        // les clients font leurs achats
        // le second argument de la méthode remplir
        // correspond à une quantité
        // remplissage du 1er caddie
        caddie1.remplir(choufleur, 2);
        caddie1.remplir(cdrom, 1);
        caddie1.remplir(biscuits, 4);
        caddie1.remplir(boisson, 6);
        caddie1.remplir(poisson, 2);
        // remplissage du 2eme caddie
        caddie2.remplir(roman, 1);
        caddie2.remplir(camembert, 1);
        caddie2.remplir(petitspois, 2);
        caddie2.remplir(poires, 2);
        // remplissage du 3eme caddie
        caddie3.remplir(cafe, 2);
        caddie3.remplir(pain, 1);
        caddie3.remplir(camembert, 2);
        // Les clients passent à la caisse
        caisse1.scanner(caddie1);
        caisse1.scanner(caddie2);
        caisse2.scanner(caddie3);

        caisse1.totalCaisse();
        caisse2.totalCaisse();
    }
}
