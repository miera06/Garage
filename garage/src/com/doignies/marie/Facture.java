
package com.doignies.marie;

import com.doignies.marie.utils.Affiche;

import java.time.LocalDate;

public class Facture {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private Client client;
	private Voiture voiture;
	private LocalDate date;
	private long prixLocation;

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Facture(final Client newClient, final Voiture newVoiture, final long newPrixLocation, final LocalDate newDate) {
		this.client = newClient;
		this.voiture = newVoiture;
		this.date = newDate;
		this.prixLocation = newPrixLocation;
	}

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public void afficheToi(){
		Affiche.a("\t\t\t Client : " + this.client.getName());
		Affiche.a("\t\t\t Voiture : " + this.voiture.getMarque());
		Affiche.a("\t\t\t Date : " + this.date);
		Affiche.a("\t\t\t Prix: " + this.prixLocation);
	}

	// ///////////////
	// *** Getters ***
	// ///////////////

	// ///////////////
	// *** Setters ***
	// ///////////////
}