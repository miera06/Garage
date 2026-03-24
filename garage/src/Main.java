
import com.doignies.marie.Client;
import com.doignies.marie.Garage;
import com.doignies.marie.Voiture;

public class Main {
	public static void main(String[] args) {
		// TIPS
		// ******************************************
		// 1. Déclaration
		//        On crée la variable (on dit qu’elle existe)
		//        int age;
		//        La variable age existe
		//        Mais elle n’a pas encore de valeur
		// 2. Initialisation
		//        On donne une première valeur à la variable
		//        age = 25;
		//        C’est la première fois qu’on lui donne une valeur
		// 3. Affectation
		//        On change la valeur d’une variable déjà initialisée
		//        age = 30;
		// ******************************************
		// final = valeur fixe (constante). Une fois initialisée : impossible de changer la valeur
		//        final int age = 25;
		//        age = 30; => ERREUR
		//        Pourquoi utiliser final ?
		//        1. Sécurité(éviter les erreurs). Tu empêches les modifications accidentelles:
		//             final double PI = 3.14159; => Personne ne pourra modifier PI par erreur
		//        2. Code plus lisible
		// ******************************************
		// System.out.println(marie.compteNbVoitureDeLaCouleur("bleue"));
		//        ==> Affiche le nombre de voiture bleue dans le garage marie
		// ******************************************
		// xavier.renvoiLaVoitureQuiALePlusDeKm().afficheToi();
		//        ==> Renvoie la voiture qui a le plus de KM.
		//        ==> puis affiche la
		// ******************************************
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
		// ******************************************
		// ET
		// true && true => true
		// true && false => false
		// false && true => false
		// false && false => false
		// ******************************************
		// OU
		// true || true => true
		// true || false => true
		// false || true => true
		// false || false => false
		// ******************************************
		// Affiche un message lors du survol de la fonction avec la souris
		//        xavier.compteNbVoitureDeLaCouleur();
		// ******************************************
		// Comment déclarer une fonction
		// [public private] [static ou non] [void bool/int] [nom] ([param]) {}


		// int i = Math.max(1, 2);
		// System.out.println(i);

		// Quel est le nom de la classe :  Math
		// Le nom de la fonction : max
		//le nb de parametre quel type et leur vlauer : 2 / 1 et 2
		//ecrire la signature de la fonction :  public static int max(int, int) {}


		// ** DEBUT du jeu de test
		// ** J'ai le doit de mettre du texte
		// ** des valeurs en dur

		// Création des Garages
		Garage marie = new Garage("Marie");
		Garage xavier = new Garage("Xavier");

		// Création des Voitures
		Voiture maVoiture1 = new Voiture("maVoiture1", "maVoiture1", "blanche", 100);
		Voiture maVoiture2 = new Voiture("maVoiture2", "maVoiture2", "bleue", 150);
		Voiture maVoiture3 = new Voiture("maVoiture3", "maVoiture3", "rouge", 200);

		// Création des Clients
		Client monClient1 = new Client("monClient1", "monClient1", 55);
		Client monClient2 = new Client("monClient2", "monClient2", 35);
		Client monClient3 = new Client("monClient3", "monClient3", 17);

		// ** FIN du jeu de test

		// Ajout des Clients dans les Garages
		marie.addClient(monClient1);
		xavier.addClients(monClient2, monClient3);

		// Ajout des Voitures dans les Garages
		marie.addVoiture(maVoiture1);
		xavier.addVoitures(maVoiture2, maVoiture3); // Tu as demandé si c'est possible : c'est possible d'ajouté plusieurs voiture d'un coup


		xavier.locationVoiture(monClient1, maVoiture1); // ca ne fonctionne pas : monClient1, maVoiture1 pas dans xavier
		xavier.locationVoiture(monClient1, maVoiture2); // ca ne fonctionne pas : monClient1 pas dans xavier
		xavier.locationVoiture(monClient2, maVoiture1); // ca ne fonctionne pas : maVoiture1 pas dans xavier

		xavier.locationVoiture(monClient2, maVoiture2);
		xavier.retourVoiture(150, monClient2);

		xavier.locationVoiture(monClient2, maVoiture2);
		xavier.retourVoiture(150, monClient2); // ca ne fonctionne pas : kmDeLaVoitureAuRetour trop petit

		xavier.locationVoiture(monClient3, maVoiture3); // ca ne fonctionne pas : client mineur
		xavier.retourVoiture(200, monClient3);  // ca ne fonctionne pas :

		xavier.afficheToi();
		xavier.afficheFacturesDuGarage();
	}
}