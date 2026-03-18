
package com.doignies.marie;

public class Voiture {
	// /////////////////
	// *** Variables ***
	// /////////////////
	// TODO : ETAPE 5
	// TODO : Ajouter une private String plaqueImmatriculation
	private String marque;
	private String model;
	private String color;
	private int tarifParJour;
		// TODO : ETAPE 3
	// TODO : Supprimer cette variable "etat"
	// TODO : Je ne sais pas a quoi peut servir cette information
	private int nbKm;
	private Client loueur;

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Voiture(final String newMarque, final String newModel, final String newColor, final int newtarifParJour) {
		// TODO : ETAPE 5
		// TODO : decommente la ligne en dessous
		// TODO : this.plaqueImmatriculation = PlaqueGenerator.genererPlaque();
		this.marque = newMarque;
		this.model = newModel;
		this.color = newColor;
		this.tarifParJour = newtarifParJour;
		this.nbKm = 0;
		this.loueur = null;
	}

	// Le constructeur vide est nécessaire car on en a besoin dans
	// Garage.renvoiLaVoitureQuiALePlusDeKm
	// TODO : A VOIR ENSEMBLE
	public Voiture () {

	}

	// ///////////////
	// *** Getters ***
	// ///////////////
	public String getMarque() {
		return marque;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return this.color;
	}

	public int getNbKm() {
		return this.nbKm;
	}

	// ///////////////
	// *** Setters ***
	// ///////////////

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public void afficheToi() {
		System.out.println ("\tVoiture : " + this.model + " " + this.marque);
		if (this.loueur != null) {
			System.out.println("\t\t" + "- loué par: " + this.loueur.getName());
		} else {
			System.out.println ("\t\t" + "- n'est pas louée " );
		}
	}

	public void locationVoiture(Client clientLoueur) {
		if(clientLoueur.peutEmpunter() == false){
			System.out.println ("erreur, le client est mineur");
		}
		else {
		// if(this.estLoue()==false) {
		if(!this.estLoue()) {
			this.loueur = clientLoueur;
			//clientLoueur.setNbEmprunt(clientLoueur.getNbEmprunt()++);
		} else {
			System.out.println("erreur, voiture déjà louée");
		}
		}
	}

	public void retourVoiture (int combienJaiRoule, int nbJourLoc) {
		// if(this.estLoue() == true && combienJaiRoule >= 0 && nbJourLoc >= 0) {
		if(this.estLoue() && combienJaiRoule >= 0 && nbJourLoc >= 0) {
			// J'augmente le nbKm de la voiture
			// this.nbKm = nbKm + combienJaiRoule;
			this.nbKm += combienJaiRoule;

			// J'ajoute un facture au client aui a loué la voiture
			Facture nouvelleFacture = new Facture(this.loueur, this, this.tarifParJour * nbJourLoc);
			this.loueur.addFacture(nouvelleFacture);

			// J'enleve le loueur de la voiture
			// La voiture n'est plus loué
			this.loueur=null;
		} else {
			System.out.println("erreur, voiture n'est pas louée OU tu es un couillon");
		}
	}

	public void peindreVoiture (String newColor) {
		this.color = newColor;
	}
	private boolean estLoue () {
		/*
		if (this.loueur != null) {
			return true;
		} else {
			return false;
		}
		*/
		// Explication
		// Si (this.loueur != null) vaut TRUE alors Renvoyer TRUE
		// Si (this.loueur != null) vaut FALSE alors Renvoyer FALSE
		// Du coup on peut renvoyer this.loueur != null directement
		return this.loueur != null;
	}

}