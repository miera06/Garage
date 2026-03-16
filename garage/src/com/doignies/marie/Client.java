package com.doignies.marie;

public class Client {
    //*Variables
    private String name;
    private String surname;
    private int age;
    private boolean aDejaEmprunte;

    //*constructeurs
    public Client (String newName,
                   String newSurname,
                   int newAge) {
        this.name = newName;
        this.surname= newSurname;
        this.age = newAge;
        this.aDejaEmprunte = false;
    }


    //*getters/setters


    public void setaDejaEmprunte(boolean aDejaEmprunte) {
        this.aDejaEmprunte = aDejaEmprunte;
    }

    public String getName() {
        return name;
    }


    //*Fonctions
    public void afficheToi() {
        System.out.println ("\t" + "- name : " + this.name + " / surname :" + this.surname);
    }
}
