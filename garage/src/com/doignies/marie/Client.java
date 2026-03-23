
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
	private List<Facture> factures;
	private int nbEmprunt;

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
		this.factures= new ArrayList<Facture>();
		this.nbEmprunt=0;
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

	public int getAge() {return age;}

	public List<Facture> getFactures() {
		return factures;
	}

	public int getNbEmprunt() {return nbEmprunt;}

	// ///////////////
	// *** Setters ***
	// ///////////////

	// /////////////////
	// *** Fonctions ***
	// /////////////////
	public void afficheToi() {
		System.out.println ("\tClient : " + this.name + " " + this.surname);

		// if(factures.size() > 0) { // Protection pour ne pas afficher si il n'y a pas de factures
		if (!factures.isEmpty()) {
			System.out.println("\tFactures : ");
			for (Facture maFacture : factures) {
				maFacture.afficheToi();
			}
		}
	}

	public void addFacture(Facture nouvelleFacture) {
		factures.add(nouvelleFacture);
	}

	public boolean peutEmpunter (){
		if(this.age>=18){
			return true;
		}else {
			return false;
			//System.out.println ("erreur, le client est mineur");
		}
	}

	public void addNbEmprunt (){
		this.nbEmprunt ++;
		// this.nbEmprunt += 1;
		// this.nbEmprunt = this.nbEmprunt + 1;
	}
}