
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
	// TODO : ETAPE 2
	// TODO : remplacer par : private int nbEmprunt.
	// TODO : adapter le code
	// TODO : 0 lors de la création. Puis +1 à chaque fois que le client emprunte
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


	// ///////////////
	// *** Setters ***
	// ///////////////
	public void setNbEmprunt(int nbEmprunt) {this.nbEmprunt = nbEmprunt;}

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

	// Etape 1
	public void peutEmpunter (){
		if(this.age>=18){
			// ne rien mettre?
			// ou mettre dans le sens inverse et ne pas mettre de else? if (this.age<18){syste....("erreur...");}
		}else {
			System.out.println ("erreur, le client est mineur");
		}
	}
	//public int compteLeNbEmprunt(){
	//	if(this.age<18){
	//		System.out.println ("erreur, le client est mineur");
	//	}
	//	else {
	//		}
	//	}
	//}


}

