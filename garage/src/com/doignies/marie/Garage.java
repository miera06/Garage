
package com.doignies.marie;

import com.doignies.marie.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private final String garageName;
	private final List<Voiture> voitures = new ArrayList<Voiture>();       // Liste vide obligatoire et non pas null (n'existe pas) car sinon la fonction addVoiture() ne peut pas fonctionner. On ne peut pas ajouter dans une liste qui n'existe pas
	private final List<Client> clients = new ArrayList<Client>();          // Liste vide obligatoire et non pas null (n'existe pas) car sinon la fonction addClient() ne peut pas fonctionner. On ne peut pas ajouter dans une liste qui n'existe pas
	private final List<Location> locations = new ArrayList<Location>();    // Liste vide obligatoire et non pas null (n'existe pas) car sinon la fonction locationVoiture() ne peut pas fonctionner. On ne peut pas ajouter dans une liste qui n'existe pas

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Garage(final String newName) {
		this.garageName = newName;

		// On ne met pas newVoitures / newClients / newLocations
		// dans la liste des parametres car lors de la Création d'un garage
		// ils ont deja une valeur par defaut
	}

	// /////////////////
	// *** Fonctions ***
	// /////////////////

	// *** PUBLIC ***

	public void afficheToi() {
		Console.info("*****");

		Console.info("Garage : " + this.garageName);

		Console.info("*****");

		Console.info("Voitures : ");
		for (Voiture maVoiture : this.voitures) {
			maVoiture.afficheToi();

			if (this.estCeQueLaVoitureestLouee(maVoiture)) {
				Console.info("\t\tEn location");
			} else {
				Console.info("\t\tLibre");
			}
		}

		Console.info("*****");

		Console.info("Clients : ");
		for (Client monClient : clients) {
			monClient.afficheToi();
		}
	}

	public void afficheFacturesDuGarage() {
		Console.info("Factures du Garage : " + this.garageName);
		for (Client monClient : this.clients) {
			if (!monClient.getFactures().isEmpty()) { // if (monClient.getFactures().size() > 0) {
				Console.info("\t\t*");

				for (Facture maFacture : monClient.getFactures()) {
					maFacture.afficheToi();
				}
			}
		}
	}

	public void addVoiture(final Voiture uneVoiture) {
		// Ajouter une voiture (uneVoiture)
		// dans la liste des voitures (voitures) du Garage
		this.voitures.add(uneVoiture);
	}

	public void addVoitures(final Voiture... desVoitures) {
		// Ajouter plusieurs voitures
		// dans la liste des voitures (voitures) du Garage
		for (Voiture uneVoiture : desVoitures) {
			this.voitures.add(uneVoiture);
		}

		// Collections.addAll(this.voitures, desVoitures);
	}

	public void addClient(final Client unClient) {
		// Ajouter un client (unClient)
		// dans la liste des clients (clients) du Garage
		this.clients.add(unClient);
	}

	public void addClients(final Client... desClients) {
		// Ajouter plusieurs clients
		// dans la liste des clients (clients) du Garage
		for (Client unClient : desClients) {
			this.clients.add(unClient);
		}

		// Collections.addAll(this.clients, desClients);
	}

	public void locationVoiture(final Client clientLoueur, final Voiture voitureLouee) {
		if (this.locationPossible(clientLoueur, voitureLouee)) {
			Location maLocation = new Location(clientLoueur, voitureLouee);  // Etape 1 je créée ma location
			this.locations.add(maLocation);                                  // ajouter nouvelle location à la liste des locations
			// locations.add(new Location(clientLoueur, voitureLouee));
			clientLoueur.addNbEmprunt();
		}
	}

	public void retourVoiture(int kmDeLaVoitureAuRetour, Client clientLoueur) {
		if (clientLoueur == null) {
			Console.error("clientLoueur ne peut pas etre null");
		} else {
			if (kmDeLaVoitureAuRetour <= 0) {
				Console.error("kmDeLaVoitureAuRetour ne peut pas etre 0 ou negatif");
			} else {
				boolean jaiTrouverLaLocation = false;

				for (Location maLocation : locations) {
					if (clientLoueur.equals(maLocation.getClient()) && !maLocation.estTerminee()) {
						jaiTrouverLaLocation = true;

						if (kmDeLaVoitureAuRetour > maLocation.getKmDepart()) { //si km au retour > km au depart
							Facture nouvelleFacture = maLocation.terminerLocation(kmDeLaVoitureAuRetour);
							clientLoueur.addFacture(nouvelleFacture);
						} else {
							Console.error("km retour < km arrivé");
						}
					}
				}

				if (!jaiTrouverLaLocation) {
					Console.error("client sans location ou toutes ses locations sont deja finies");
				}
			}
		}
	}

	public int compteNbVoiture() {
		return this.voitures.size(); // Appel de la fonction size() qui existe deja dans la class liste
	}

	/**
	 * Renvoie le nombre de voitures de la couleur en parametre
	 * Renvoie 0 si la couleur est null
	 */
	public int compteNbVoitureDeLaCouleur(final String couleurATester) {

		int compteurDeVoiture = 0;

		if (couleurATester == null) {
			// TODO : Faire une Exception
			Console.error("La couleur n'existe pas");
		} else {
			for (Voiture maVoiture : this.voitures) {
				// if (maVoiture.getColor(). == couleurATester) { // Mauvaise maniere de comparer deux CLASSES car String est une classe
				if (couleurATester.equals(maVoiture.getColor())) { // On est sure et certain que couleurATester n'est pas null
					compteurDeVoiture++; // compteurDeVoiture = compteurDeVoiture + 1    OU   compteurDeVoiture += 1
				}
			}
		}

		return compteurDeVoiture;
	}

	public Voiture renvoiLaVoitureQuiALePlusDeKm() {
		// PARCOURS ma liste de voitures
		// 1-sauvegarder le nb de km ET 2-comparer le nb de km avec la précédente
		// 3-sauvegarder la voiture
		// 4-renvoi la  voiture

		Voiture maVoitureKmMax = null;

		for (Voiture maVoiture : this.voitures) {
			// if (maVoitureKmMax == null || maVoiture.getNbKm() > maVoitureKmMax.getNbKm()) {     => prend la premiere voiture avec le plus de km
			if (maVoitureKmMax == null || maVoiture.getNbKm() >= maVoitureKmMax.getNbKm()) {     // => prend la derniere voiture avec le plus de km
				maVoitureKmMax = maVoiture;
			}
		}

		return maVoitureKmMax;
	}

	// *** PRIVATE ***

	private boolean estCeQueLaVoitureestLouee(final Voiture laVoiture) {
		for (Location location : this.locations) { // pour toutes mes locations
			if (laVoiture.equals(location.getVoiture()) && !location.estTerminee()) {
				return true;
			}
		}

		return false;
	}

	private boolean locationPossible(final Client clientLoueur, final Voiture voitureLouee) {
		if (!this.clients.contains(clientLoueur)) { // si clientLoueur n'est pas dans le garage alors erreur et return false
			Console.error("le client n'est pas dans le garage");
			return false;
		}

		if (!this.voitures.contains(voitureLouee)) {// si voitureLouee n'est pas dans le garage alors erreur et return false
			Console.error("la voiture n'est pas dans le garage");
			return false;
		}

		if (!clientLoueur.peutEmpunter()) {
			Console.error(clientLoueur.getName() + " ne peut pas emprunter");
			return false;
		}

		if (this.estCeQueLaVoitureestLouee(voitureLouee)) {
			Console.error("voiture déjà louée");
			return false;
		}

		return true;
	}

	// ///////////////
	// *** Getters ***
	// ///////////////

	// ///////////////
	// *** Setters ***
	// ///////////////
}