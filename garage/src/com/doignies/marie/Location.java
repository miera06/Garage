
package com.doignies.marie;

import com.doignies.marie.utils.Console;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Location {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private final Client client;
	private final Voiture voiture;
	private final LocalDate dateDebut = LocalDate.now();   // valeur lors de la creation
	private LocalDate dateFin = null;                      // valeur lors de la creation
	private final int kmDepart;

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Location(final Client client, final Voiture voiture) {
		this.client = client;
		this.voiture = voiture;
		this.kmDepart = voiture.getNbKm();

		// On ne met pas newDateDebut / newDateFin
		// dans la liste des parametres car lors de la Création d'un client
		// ils ont deja une valeur par defaut
	}

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public boolean estTerminee() {
		if (this.dateFin != null) {
			return true;
		} else {
			return false;
		}

		// return dateFin != null;
	}

	public Facture terminerLocation(final int kmRetour) {
		if (this.estTerminee()) {
			Console.error("Location déjà terminée");
			return null;
		}

		// Ajouter 2 jours uniquement pour les tests
		// dateFin = LocalDate.now();
		LocalDate datePlus2 = LocalDate.now().plusDays(2);
		this.dateFin = datePlus2;

		int kmParcourus = kmRetour - this.kmDepart;
		this.voiture.ajouteKm(kmParcourus);

		long prix = this.calculPrix();

		return new Facture(this.client, this.voiture, prix, this.dateFin);
	}

	// *** PRIVATE ***

	private long calculPrix() {
		long nbJours = ChronoUnit.DAYS.between(this.dateDebut, this.dateFin);
		long prix = 0;

		if (this.client.getNbEmprunt() != 1) {
			prix = this.voiture.getTarifParJour() * nbJours;
		} else {
			prix = 2 * (this.voiture.getTarifParJour() * nbJours);
		}

		return prix;

		// return this.client.getNbEmprunt() != 1 ? this.voiture.getTarifParJour() * nbJours : 2 * (this.voiture.getTarifParJour() * nbJours);
	}

	// ///////////////
	// *** Getters ***
	// ///////////////
	public Client getClient() {
		return this.client;
	}

	public Voiture getVoiture() {
		return this.voiture;
	}

	public int getKmDepart() {
		return this.kmDepart;
	}

	// ///////////////
	// *** Setters ***
	// ///////////////
}