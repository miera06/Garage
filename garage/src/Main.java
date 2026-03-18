
import com.doignies.marie.Client;
import com.doignies.marie.Garage;
import com.doignies.marie.Voiture;

public class Main {
	public static void main(String[] args) {
		// TIPS
		// System.out.println(marie.compteNbVoitureDeLaCouleur("bleue"));
		// ==> Affiche le nombre de voiture bleue dans le garage marie

		// xavier.renvoiLaVoitureQuiALePlusDeKm().afficheToi();
		// ==> Renvoie la voiture qui a le plus de KM.
		// ==> puis affiche la

		// Boucle for numero 1
		// pour chaque voiture de ma liste de voiture (ma liste de voiture s'appelle voitures)
		//        on doit afficher la  voiture
		//
		// La premiere voiture de ma liste de voiture (qui s'appelle voitures)
		// s'appelle maVoiture
		// La deuxieme voiture de ma liste de voiture (qui s'appelle voitures)
		// s'appelle maVoiture
		// etc ...
		// for (Voiture maVoiture : voitures) {
		//        maVoiture.display();
		// }

		// Boucle for numero 2
		// on recupere un par un les elements de la liste par leur indice (0 puis 1 puis 2 puis 3 etc ...)
		//        on doit afficher la  voiture
		//
		// for (int i = 0; i < voitures.size(); i++) {
		//        Voiture voitureDeLaListeALaPositionI = this.voitures.get(i);
		//        voitureEnCours.display();
		// }

		// ** DEBUT du jeu de test
		// ** J'ai le doit de mettre du texte
		// ** des valeurs en dur

		// Création des Garages
		Garage marie = new Garage("Marie");
		Garage xavier = new Garage("Xavier");

		// Création des Voitures
		Voiture maVoiture1 = new Voiture("Dacia", "Duster", "blanche", 100);
		Voiture maVoiture2 = new Voiture("Renault", "Clio", "bleue", 150);
		Voiture maVoiture3 = new Voiture("Peugeot", "208", "rouge", 200);

		// Création des Clients
		Client monClient1 = new Client("Toutou", "Bob", 55);
		Client monClient2 = new Client("Dada", "Ollie", 35);
		Client monClient3 = new Client("Baba", "Barbara", 17);

		// ** FIN du jeu de test

		// Ajout des Clients dans les Garages
		marie.addClient(monClient1);
		xavier.addClient(monClient2, monClient3);

		// Ajout des Voitures dans les Garages
		marie.addVoiture(maVoiture1);
		xavier.addVoiture(maVoiture2, maVoiture3); // Tu as demandé si c'est possible : c'est possible d'ajouté plusieurs voiture d'un coup


		maVoiture2.locationVoiture(monClient2);
		maVoiture2.retourVoiture(20, 3);

		maVoiture3.locationVoiture(monClient3);
		maVoiture3.retourVoiture(20, 3);

		xavier.afficheToi();
		xavier.afficheFactures();
	}
}