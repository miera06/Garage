
package com.doignies.marie;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Garage {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private String garageName;
	private List<Voiture> voitures;
	private List<Client> clients;
	private List<Location> locations;

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
		this.locations = new ArrayList<Location>();
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

	/**
	 * Renvoie le nombre de voitures de la couleur en parametre
	 * Renvoie 0 si la couleur est null
	 */
	public int compteNbVoitureDeLaCouleur(String couleurATester) {

		int compteurDeVoiture = 0;

		if (couleurATester == null) {
			// TODO : Faire une Exception
			System.out.print("La couleur n'existe pas");
		} else {
			for (Voiture maVoiture : voitures) {
				// if (maVoiture.getColor(). == couleurATester) { // Mauvaise maniere de comparer deux CLASSES car String est une classe

				if (couleurATester.equals(maVoiture.getColor())) { // On est sure et certain que couleurATester n'est pas null
					// compteurDeVoiture = compteurDeVoiture + 1;
					compteurDeVoiture++;
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

		for (Voiture maVoiture : voitures) {
			// if (maVoitureKmMax == null || maVoiture.getNbKm() > maVoitureKmMax.getNbKm()) {     => prend la premiere voiture avec le plus de km
			if (maVoitureKmMax == null || maVoiture.getNbKm() >= maVoitureKmMax.getNbKm()) {	// => prend la derniere voiture avec le plus de km
				maVoitureKmMax = maVoiture;
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

	private boolean locationPossible (Client clientLoueur, Voiture voitureLouee){
		if (!clients.contains(clientLoueur)) {// si client loueur n'est as ds le farage erreur et  retourne false
			System.out.println ("erreur, le client n'est pas dans le garage");
			return false;
		}
		if (!voitures.contains(voitureLouee)) {// si voiture louée n'est as ds le farage erreur et  retourne false
			System.out.println("erreur, la voiture n'est pas dans le garage");
			return false;
		}
		if (!clientLoueur.peutEmpunter()) {
			System.out.println ("erreur, le client " + clientLoueur.getName() + " ne peut pas emprunter");
			return false;
		}

		for (Location maLocation : locations) { // pour toutes mes locations
			if (voitureLouee.equals(maLocation.getVoiture()) && !maLocation.estTerminee()) {
				System.out.println("erreur, voiture déjà louée");
				return false;
			}
		}

		return true;
	}

	public void locationVoiture(Client clientLoueur, Voiture voitureLouee) {
		if (this.locationPossible(clientLoueur, voitureLouee)) {
			Location maLocation = new Location(clientLoueur, voitureLouee); // Etape 1 je créée ma location
			locations.add(maLocation);//ajouter nouvelle location à la liste des locations
			clientLoueur.addNbEmprunt();
		}

	}

	public void retourVoiture (int kmDeLaVoitureAuRetour, Client clientLoueur) {
		if(kmDeLaVoitureAuRetour >= 0)  {

			boolean jaiTrouverLaLocation = false;

			for (Location maLocation : locations){
				if(clientLoueur.equals(maLocation.getClient()) && !maLocation.estTerminee()){
					if(kmDeLaVoitureAuRetour > maLocation.getKmDepart()){ //si km au retour > km au depart

					jaiTrouverLaLocation = true;

					Facture nouvelleFacture = maLocation.terminerLocation(kmDeLaVoitureAuRetour);
					clientLoueur.addFacture(nouvelleFacture);
					}else {
						System.out.println ("erreur km retour < km arrivé");
					}

					// J'ajoute un facture au client aui a loué la voiture


				}
			}

			if (!jaiTrouverLaLocation) {
				System.out.println("message erreur : client sans location ou toutes ses locations sont deja finies");
			}
		} else {
			System.out.println("erreur, kmDeLaVoitureAuRetour");
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