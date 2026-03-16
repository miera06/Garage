package com.doignies.marie;

public class Client {
    //*Variables
    private String name;
    private String surname;
    private int age;
    private boolean aDejaEmrpunté;

    //*constructeurs
    public Client (String newName,
                   String newSurname,
                   int newAge) {
        this.name = newName;
        this.surname= newSurname;
        this.age = newAge;
        this.aDejaEmrpunté = false;
    }


    //*getters/setters

    public String getName() {
        return name;
    }


    //*Fonctions
    public void afficheToi() {
        System.out.println ("\t" + "- name : " + this.name + " / surname :" + this.surname);
    }
}
