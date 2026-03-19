
package com.doignies.marie;

import java.time.LocalDate;
//TODO 3: recuperer les variables de ligne 0 à 14.
// decommenter la classe location pour chaque foncion et l'expliquer puis modif code pour utiliser classe locationet plus ce qu'on utilisait avant.
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
	/*public Location(final Client client, final Voiture voiture) {
		this.client = client;
		this.voiture = voiture;
		this.dateDebut = LocalDate.now();
		this.dateFin = null;
		this.kmDepart = voiture.getNbKm();
	}*/

	// ///////////////
	// *** Getters ***
	// ///////////////
	/*Necessaire ?? public Client getClient() {
		return client;
	}

	public Voiture getVoiture() {
		return voiture;
	}*/

	// ///////////////
	// *** Setters ***
	// ///////////////

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	/*public boolean estActive() {
		return dateFin == null;
	}

	public Facture terminerLocation(int kmRetour, int nbJours) {
		if (!estActive()) {
			System.out.println("Location déjà terminée");
			return null;
		}

		int kmParcourus = kmRetour - kmDepart;
		voiture.ajouteKm(kmParcourus);

		int prix = voiture.getTarifParJour() * nbJours;

		dateFin = LocalDate.now();

		return new Facture(client, voiture, prix);
	}*/
}