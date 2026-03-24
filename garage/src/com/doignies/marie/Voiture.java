
package com.doignies.marie;

import com.doignies.marie.utils.Console;

public class Voiture {
	// /////////////////
	// *** Variables ***
	// /////////////////
	// TODO : ETAPE 5
	// TODO : Ajouter une private String plaqueImmatriculation
	private final String marque;
	private final String model;
	private String color;
	private final int tarifParJour;
	private int nbKm = 0;         // valeur lors de la creation

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

		// On ne met pas newNbKm
		// dans la liste des parametres car lors de la Création d'une Voiture
		// il a deja une valeur par defaut
	}

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public void afficheToi() {
		Console.info("\tVoiture : " + this.model + " " + this.marque + " (" + this.tarifParJour + " €/j) (" + this.nbKm + " km)");
	}

	public void ajouteKm (final int combienJaiRoule){
		this.nbKm += combienJaiRoule;
	}

	public void peindreVoiture (final String newColor) {
		this.color = newColor;
	}

	// ///////////////
	// *** Getters ***
	// ///////////////
	public String getMarque() {
		return this.marque;
	}

	public String getColor() {
		return this.color;
	}

	public int getTarifParJour() {
		return this.tarifParJour;
	}

	public int getNbKm() {
		return this.nbKm;
	}

	// ///////////////
	// *** Setters ***
	// ///////////////
}