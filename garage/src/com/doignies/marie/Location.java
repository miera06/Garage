
package com.doignies.marie;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Location {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private Client client;
	private Voiture voiture;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int kmDepart;

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Location(final Client client, final Voiture voiture) {
		this.client = client;
		this.voiture = voiture;
		this.dateDebut = LocalDate.now();
		this.dateFin = null;
		this.kmDepart = voiture.getNbKm();
	}

	// ///////////////
	// *** Getters ***
	// ///////////////
	public Voiture getVoiture() {
		return voiture;
	}

	public int getKmDepart() {
		return kmDepart;
	}

	public Client getClient() {
		return client;
	}

	// ///////////////
	// *** Setters ***
	// ///////////////

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public boolean estTerminee() {
		// return dateFin != null;

		if (dateFin != null) {
			return true;
		} else {
			return false;
		}
	}

	public Facture terminerLocation(int kmRetour) {
		if (estTerminee()) {
			System.out.println("Location déjà terminée");
			return null;
		}

		// Ajouter 2 jours uniquementpour les tests
		// dateFin = LocalDate.now();
		LocalDate newDate = LocalDate.now();
		LocalDate newDatePlus2 = newDate.plusDays(2);
		dateFin = newDatePlus2;

		int kmParcourus = kmRetour - kmDepart;
		voiture.ajouteKm(kmParcourus);

		long nbJours = ChronoUnit.DAYS.between(this.dateDebut, this.dateFin);
		long prix = voiture.getTarifParJour() * nbJours;

		return new Facture(client, voiture, prix);
	}
}
