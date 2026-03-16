
package com.doignies.marie;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private String garageName;
	private List<Voiture> voitures;
	private List<Client> clients;

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Garage(final String name) {
		// On ne met pas newVoitures
		// On ne met pas newClients
		// dans la liste des parametres car lors de la Création d'un garage
		// 1. il n'a pas encore de voiture
		// 2. Il n'a pas encore de client
		this.garageName = name;
		this.voitures = new ArrayList<Voiture>();
		// Liste vide obligatoire et non pas null (n'existe pas)
		// car sinon la fonction addVoiture ne peut pas fonctionner
		// On ne peut pas ajouter dans une liste qui n'existe pas
		this.clients = new ArrayList<Client>();
		// Liste vide obligatoire et non pas null (n'existe pas)
		// car sinon la fonction addClient ne peut pas fonctionner
		// On ne peut pas ajouter dans une liste qui n'existe pas
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
	public void afficheToi() {
		System.out.println("Garage : " + this.garageName);

		System.out.println("Voitures : ");
		for (Voiture maVoiture : voitures) {
			maVoiture.afficheToi();
		}

		System.out.println("Clients : ");
		for (Client monClient : clients) {
			monClient.afficheToi();
		}
	}

	// Ajouter une voiture (uneVoiture) dans la liste de voitures (voitures) du Garage
	public void addVoiture(Voiture uneVoiture) {
		this.voitures.add(uneVoiture);
	}

	// Ajouter plusieurs voitures dans la liste de voitures (voitures) du Garage
	public void addVoiture(Voiture... desVoitures) {
		// xavier.addVoiture(maVoiture2, maVoiture3);
		// -> peut-on l'écrire en une seule ligne ?
		// oui c'est possible il faut changer la signature de la fonction addVoiture
		for (Voiture uneVoiture : desVoitures) {
			this.voitures.add(uneVoiture);
		}
	}

	public void addClient(Client unClient) {
		this.clients.add(unClient);
	}

	public void addClient(Client... desClients) {
		for (Client unClient : desClients) {
			this.clients.add(unClient);
		}
	}

	public int compteNbVoiture() {
		return this.voitures.size();
		// Appel de la fonction size() qui existe deja dans la class liste
	}

	public int compteNbVoitureDeLaCouleur(String couleurATester) {
		// TODO 4
		// TODO : Ajouter une protection si pas de couleur en parametre

		int compteurDeVoiture = 0;

		for (Voiture maVoiture : voitures) {
			if (maVoiture.getColor() == couleurATester) {
				// TODO : Correction à faire
				// TODO : if (couleurATester.equals(maVoiture.getColor())) {
				// TODO : if (maVoiture.getColor().equals(couleurATester)) { => NullPointerException possible


				// compteurDeVoiture = compteurDeVoiture + 1;
				compteurDeVoiture ++;
			}
		}
		return compteurDeVoiture;
	}

	public Voiture renvoiLaVoitureQuiALePlusDeKm() {
		// PARCOURS ma liste de voitures
		// 1-sauvegarder le nb de km ET 2-comparer le nb de km avec la précédente
		// 3-sauvegarder la voiture
		// 4-renvoi la  voiture
		int nbMaxKm = 0;

		Voiture maVoitureKmMax = new Voiture();
		// TODO : Voiture maVoitureKmMax = null;
		// TODO : A VOIR ENSEMBLE

		for (Voiture maVoiture : voitures) {
			// TODO : if (maVoitureKmMax == null || maVoiture.getNbKm() > maVoitureKmMax.getNbKm()) {
			// TODO : A VOIR ENSEMBLE
			if (maVoiture.getNbKm() >= nbMaxKm) {
				maVoitureKmMax = maVoiture;
				nbMaxKm = maVoiture.getNbKm();
			}
		}
		return maVoitureKmMax;
	}

	public void afficheFactures() {
		for (Client monClient : clients) {
			// if (monClient.getFactures().size() > 0) {
			if (!monClient.getFactures().isEmpty()) {
				System.out.println("\tFactures:");

				for (Facture maFacture : monClient.getFactures()) {
					maFacture.afficheToi();
				}
			}
		}
	}

	/* VERSION AVEC LOCATION

	private String garageName;

	private List<Voiture> voitures;
	private List<Client> clients;
	private List<Location> locations;

	public Garage(String garageName) {

		this.garageName = garageName;

		voitures = new ArrayList<>();
		clients = new ArrayList<>();
		locations = new ArrayList<>();
	}

	public void addVoiture(Voiture... desVoitures) {

		for (Voiture v : desVoitures) {
			voitures.add(v);
		}
	}

	public void addClient(Client... desClients) {

		for (Client c : desClients) {
			clients.add(c);
		}
	}

	public Location louerVoiture(Client client, Voiture voiture) {

		if (estLouee(voiture)) {
			System.out.println("Voiture déjà louée");
			return null;
		}

		Location location = new Location(client, voiture);

		locations.add(location);

		return location;
	}

	public boolean estLouee(Voiture voiture) {

		for (Location location : locations) {

			if (location.getVoiture() == voiture && location.estActive()) {
				return true;
			}
		}

		return false;
	}

	public void retourVoiture(Location location, int kmRetour, int nbJours) {

		Facture facture = location.terminerLocation(kmRetour, nbJours);

		if (facture != null) {
			location.getClient().addFacture(facture);
		}
	}

	public void afficheToi() {

		System.out.println("Garage : " + garageName);

		System.out.println("Voitures :");

		for (Voiture v : voitures) {
			v.afficheToi();

			if (estLouee(v)) {
				System.out.println("\t\tActuellement louée");
			}
		}

		System.out.println("Clients :");

		for (Client c : clients) {
			c.afficheToi();
		}
	}*/
}