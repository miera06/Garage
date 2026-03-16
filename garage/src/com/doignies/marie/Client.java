package com.doignies.marie;

import java.util.ArrayList;
import java.util.List;

public class Client {
    //*Variables
    private String name;
    private String surname;
    private int age;
    private boolean aDejaEmprunte;
    private List<Facture> factures;

    //*constructeurs
    public Client (String newName,
                   String newSurname,
                   int newAge) {
        this.name = newName;
        this.surname= newSurname;
        this.age = newAge;
        this.aDejaEmprunte = false;
        this.factures= new ArrayList<Facture>();
    }


    //*getters/setters
    public void setaDejaEmprunte(boolean aDejaEmprunte) {
        this.aDejaEmprunte = aDejaEmprunte;
    }
    public String getName() {
        return name;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    //*Fonctions
    public void afficheToi() {
        System.out.println ("\t" + "- name : " + this.name + " / surname :" + this.surname);
        if(factures.size ()>0) {
            System.out.println("\t La liste des factures:");
            for (Facture maFacture : factures) {
                maFacture.afficheToi();
            }
        }
    }
    public void addFacture (Facture nouvelleFacture){
        factures.add(nouvelleFacture);
    }
}
