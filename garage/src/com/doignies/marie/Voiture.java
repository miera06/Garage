
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
	private int nbKm;

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

	public int getTarifParJour() {return tarifParJour;}

	// ///////////////
	// *** Setters ***
	// ///////////////

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public void afficheToi() {
		System.out.println ("\tVoiture : " + this.model + " " + this.marque);


		// TODO : A ADAPTER
		/*if (this.loueur != null) {
			System.out.println("\t\t" + "- loué par: " + this.loueur.getName());
		} else {
			System.out.println ("\t\t" + "- n'est pas louée " );
		}*/
	}

	public void ajouteKm (int combienJaiRoule){
		this.nbKm += combienJaiRoule;
	}

	public void peindreVoiture (String newColor) {
		this.color = newColor;
	}
}