
package com.doignies.marie;

import com.doignies.marie.utils.Console;

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
		Console.info("\t\t\t Client : " + this.client.getName());
		Console.info("\t\t\t Voiture : " + this.voiture.getMarque());
		Console.info("\t\t\t Date : " + this.date);
		Console.info("\t\t\t Prix: " + this.prixLocation);
	}

	// ///////////////
	// *** Getters ***
	// ///////////////

	// ///////////////
	// *** Setters ***
	// ///////////////
}