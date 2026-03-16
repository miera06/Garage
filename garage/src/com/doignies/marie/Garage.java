package com.doignies.marie;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    //*variables
    private String garageName;
    private List<Voiture> voitures;
    private List<Client> clients;


    //*constructeur
    public Garage(String name) {
        this.garageName = name;
        this.voitures = new ArrayList<Voiture>();
        this.clients = new ArrayList<Client>();
    }

    //*getters et  setters


    //*fonctions
    public void afficheToi() {
        System.out.println("Garage : " + this.garageName);
        System.out.println("Liste de voitures : ");
        for (Voiture maVoiture : voitures) {
            maVoiture.afficheToi();
        }

        System.out.println("Liste de clients : ");
        for (Client monClient : clients) {
            monClient.afficheToi();
        }

//        - pour chaque element de ma liste qui s'appelle voitureSSS
//                et qui est une voiture
//            afficher la  voiture
//
//        for (Voiture maVoiture : voitures) {
//            maVoiture.display();
//        }
//        - pour element0 puis element 1 puis element 2 etc ... jusqua dernier elelemnt  de ma liste qui sappelle voitureSSS
//            recuperer lelement de la liste TADAM cest une voitures
//                afficher la  voiture
//
//        for (int i = 0; i < voitures.size(); i++) {
//            Voiture voitureEnCours = this.voitures.get(i);
//            voitureEnCours.display();
//        }
    }

    public void addVoiture(Voiture uneVoiture) {
        this.voitures.add(uneVoiture);
    }

    public void addClient(Client unClient) {
        this.clients.add(unClient);
    }


    public int compteNbVoiture() {
        return this.voitures.size();
    }

    public int compteNbVoitureDeLaCouleur(String couleurATester) {
        int compteurDeVoiture = 0;
        for (Voiture maVoiture : voitures) {
            if (maVoiture.getColor() == couleurATester) {
                compteurDeVoiture = compteurDeVoiture + 1;
            }
        }
        return compteurDeVoiture;
    }

    public Voiture renvoiLaVoitureQuiALePlusDeKm() {
        //PARCOURS ma liste de voitures
        //1-sauvagarder le nm de km ET 2-comparer le nb de km avec la précédente
        // 3-sauvegarder la voiture
        //4-renvoi la  voiture
        int nbMaxKm = 0;

        Voiture maVoitureKmMax = new Voiture();

        for (Voiture maVoiture : voitures) {
            if (maVoiture.getNbKm() >= nbMaxKm) { //est ce que ma voiture.blabla est plus grand que nbMaxKm?
                maVoitureKmMax = maVoiture;
                nbMaxKm = maVoiture.getNbKm();
            }
        }
        return maVoitureKmMax;
    }


    //TODO fonction qui affiche toutes les factures du garages (afficheFacture)
    //tips : reprendre la fonction affiche toi et retirer tout ce qui ne concerne pas les factures

    public void afficheFactures() {
        for (Client monClient : clients) {
            if (monClient.getFactures().size() > 0) {
                System.out.println("\t La liste des factures:");
                for (Facture maFacture : monClient.getFactures()) {
                    maFacture.afficheToi();
                }
            }

        }

    }
}