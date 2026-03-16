
package com.doignies.marie;

public class Voiture {
    //*variables
    private String marque;
    private String model;
    private String color;
    private int tarifParJour;
    private String etat;
    private int nbKm;
    private Client loueur;

    //*constructeur
    public Voiture (String newMarque,
                    String newModel,
                    String newColor,
                    int newtarifParJour) {
        this.marque = newMarque;
        this.model= newModel;
        this.color = newColor;
        this.tarifParJour = newtarifParJour;
        this.etat = "neuf";
        this.nbKm = 0;
       this.loueur=null;
    }

    public Voiture () {
    }



    //* getters et setters

    public String getColor() { return this.color;}
    public int getNbKm() { return this.nbKm;}

    // * fonctions

    public void afficheToi() {
        System.out.println ("\t" + "- model : " + this.model + " / marque : " + this.marque);
        if (this.loueur != null) {
            System.out.println("\t" + "- loué par: " + this.loueur.getName());
        }
        else {
            System.out.println ("\t" + "- n'est pas louée " );
            }

    }

    public void locationVoiture (Client clientLoueur) {
        if(this.estLoue()==false){
            this.loueur=clientLoueur;
            this.etat="utilisé";
            clientLoueur.setaDejaEmprunte(true);
        }
        else{
            System.out.println("erreur, voiture déjà louée");
        }

    }

    public void retourVoiture (int combienJaiRoule, int nbJourLoc) {
        if(this.estLoue()==true && combienJaiRoule >= 0 && nbJourLoc >=0) {
            this.nbKm=nbKm+combienJaiRoule;
            this.loueur=null;
            System.out.println ("le prix :" + this.tarifParJour*nbJourLoc);

        }
        else {
            System.out.println("erreur, voiture n'est pas louée OU tu es un couillon");
        }

    }

    public void peindreVoiture (String newColor) {
        // il faut changer la couleur
        this.color=newColor;


    }

    private boolean estLoue (){
        if (this.loueur != null){
            return true;
        }
        else{
            return false;
        }
    }


}