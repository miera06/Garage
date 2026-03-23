package com.doignies.marie;

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
	public Facture(final Client newClient, final Voiture newVoiture, final long newPrixLocation, LocalDate newDate) {
		// On ne met pas newDate
		// dans la liste des parametres car lors de la Création d'une facture
		// 1. On met la date du jour à l'instant T
		this.client = newClient;
		this.voiture = newVoiture;
		this.date = newDate;
		this.prixLocation = newPrixLocation;
	}

	// ///////////////
	// *** Getters ***
	// ///////////////

	// ///////////////
	// *** Setters ***
	// ///////////////

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public void afficheToi(){
		System.out.println ("\t\t\t Client : " + this.client.getName());
		System.out.println ("\t\t\t Voiture : " + this.voiture.getMarque());
		System.out.println ("\t\t\t Date : " + this.date);
		System.out.println ("\t\t\t Prix: " + this.prixLocation);
	}
}