package com.problem.bank.models;

public class Director {
    private String name;
    private String surname;
    private String profession;

    public Director(String name, String surname, String profession){
        System.out.println("Director constructor is called");
        this.name = name;
        this.surname = surname;
        this.profession = profession;
    }

    public String getName(){
        return name + " " + surname;
    }

    public void setProfession(String profession){
        this.profession = profession;
    }

    public String getProfession(){
        return profession;
    }

}
