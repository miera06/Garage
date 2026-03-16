import com.doignies.marie.Client;
import com.doignies.marie.Garage;
import com.doignies.marie.Voiture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ** DEBUT
        // ** Création du jeu de test
        // ** J'ai le doit de mettre du texte
        // des valeurs en dut

        Garage marie = new Garage("Marie");
        Garage xavier = new Garage ("Xavier");

        Voiture maVoiture1 = new Voiture ("Dacia", "Duster", "blanche", 100);
        Voiture maVoiture2 = new Voiture ("Renault", "Clio", "bleue", 150);
        Voiture maVoiture3 = new Voiture ("Peugeot", "208", "rouge", 200);

        Client monClient1 = new Client ("Toutou","Bob",55);
        Client monClient2 = new Client ("Dada","Ollie",35);
        Client monClient3 = new Client ("Baba","Barbara",26);

        // ** FIN

        marie.addClient(monClient1);

        xavier.addClient(monClient2);
        xavier.addClient(monClient3);

        marie.addVoiture(maVoiture1);

        //xavier.addVoiture(maVoiture2, maVoiture3); -> peut-on l'écrire en une seule ligne? oui c'est possible il faut changer la signature de la fonction addVoiture
        xavier.addVoiture(maVoiture2);
        xavier.addVoiture(maVoiture3);

        // System.out.println(marie.compteNbVoitureDeLaCouleur("bleue"));
        // xavier.renvoiLaVoitureQuiALePlusDeKm().afficheToi();


        maVoiture2.locationVoiture(monClient2);
        maVoiture2.retourVoiture(20,3);

        maVoiture3.locationVoiture(monClient2);
        maVoiture3.retourVoiture(20,3);


        //xavier.afficheToi();
        xavier.afficheFactures();
    }
}