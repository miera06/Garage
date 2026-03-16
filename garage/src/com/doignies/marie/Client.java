
package com.doignies.marie;

import java.util.ArrayList;
import java.util.List;

public class Client {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private String name;
	private String surname;
	private int age;
	// TODO : ETAPE 1
	// TODO : Un client mineur ne peut pas emprunter
	// TODO : si c'est le cas message d'erreur : "Le client est mineur"
	private boolean aDejaEmprunte;
	// TODO : ETAPE 2
	// TODO : remplacer par : private int nbEmprunt.
	// TODO : adapter le code
	// TODO : 0 lors de la création. Puis +1 à chaque fois que le client emprunte
	private List<Facture> factures;

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Client (final String newName, final String newSurname, final int newAge) {
		// On ne met pas newADejaEmprunte
		// On ne met pas newFactures
		// dans la liste des parametres car lors de la Création d'un client
		// 1. il n'a jamais emprunte
		// 2. Il n'a pas encore de facture
		this.name = newName;
		this.surname= newSurname;
		this.age = newAge;
		this.aDejaEmprunte = false;
		this.factures= new ArrayList<Facture>();
		// Liste vide obligatoire et non pas null (n'existe pas)
		// car sinon la fonction addFacture ne peut pas fonctionner
		// On ne peut pas ajouter dans une liste qui n'existe pas
	}

	// ///////////////
	// *** Getters ***
	// ///////////////
	public String getName() {
		return name;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	// ///////////////
	// *** Setters ***
	// ///////////////
	public void setADejaEmprunte(boolean aDejaEmprunte) {
		this.aDejaEmprunte = aDejaEmprunte;
	}

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public void afficheToi() {
		System.out.println ("\t" + "- name : " + this.name + " / surname :" + this.surname);

		if(factures.size() > 0) { // Protection pour ne pas afficher si il n'y a pas de factures

			System.out.println("\t La liste des factures : ");
			for (Facture maFacture : factures) {
				maFacture.afficheToi();
			}
		}
	}

	public void addFacture(Facture nouvelleFacture) {
		factures.add(nouvelleFacture);
	}
}