package com.doignies.marie;

import java.time.LocalDate;

public class Facture {
    //* Variables
    private Client client;
    private Voiture voiture;
    private LocalDate date;
    private int prixLocation;

    //*constructeur
    public Facture(Client newClient,
                   Voiture newVoiture,
                   int newPrixLocation) {
        this.client = newClient;
        this.voiture = newVoiture;
        this.date = LocalDate.now();
        this.prixLocation = newPrixLocation;
    }
    //*Fonctions
    public void afficheToi(){
        System.out.println ("\t\t\t Client : " + this.client.getName());
        System.out.println ("\t\t\t Voiture : " + this.voiture.getMarque());
        System.out.println ("\t\t\t Date : " + this.date);
        System.out.println ("\t\t\t Prix: " + this.prixLocation);
    }

}