
package com.doignies.marie;

import com.doignies.marie.utils.Affiche;

import java.util.ArrayList;
import java.util.List;

public class Client {
	// /////////////////
	// *** Variables ***
	// /////////////////
	private String name;
	private String surname;
	private int age;
	private int nbEmprunt = 0;                             // valeur lors de la creation
	private List<Facture> factures = new ArrayList<Facture>();  // Liste vide obligatoire et non pas null (n'existe pas) car sinon la fonction addFacture() ne peut pas fonctionner. On ne peut pas ajouter dans une liste qui n'existe pas

	// /////////////////////
	// *** Constructeurs ***
	// /////////////////////
	public Client (final String newName, final String newSurname, final int newAge) {
		this.name = newName;
		this.surname= newSurname;
		this.age = newAge;

		// On ne met pas newNbEmprunt / newFactures
		// dans la liste des parametres car lors de la Création d'un client
		// ils ont deja une valeur par defaut
	}

	// /////////////////
	// *** Fonctions ***
	// /////////////////

	// *** PUBLIC ***

	public void afficheToi() {
		Affiche.a("\tClient : " + this.name + " " + this.surname + " (" + this.age + " ans)");

		if (!this.factures.isEmpty()) { // if(factures.size() > 0) { // Protection pour ne pas afficher si il n'y a pas de factures
			Affiche.a("\t\tFactures : ");

			for (Facture maFacture : this.factures) {
				Affiche.a("\t\t*");
				maFacture.afficheToi();
			}
		}
	}

	public void addNbEmprunt(){
		this.nbEmprunt ++; // this.nbEmprunt += 1;   OU   this.nbEmprunt = this.nbEmprunt + 1;
	}

	public void addFacture(final Facture nouvelleFacture) {
		this.factures.add(nouvelleFacture);
	}

	public boolean peutEmpunter() {
		if (this.age >= 18) {
			return true;
		} else {
			return false;
		}

		// return this.age >= 18;
	}

	// *** PRIVATE ***

	// ///////////////
	// *** Getters ***
	// ///////////////
	public String getName() {
		return this.name;
	}

	public int getNbEmprunt() {
		return this.nbEmprunt;
	}

	public List<Facture> getFactures() {
		return this.factures;
	}

	// ///////////////
	// *** Setters ***
	// ///////////////
}