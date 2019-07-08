package com.problem.bank.models;

public class Person {
    private String name;
    private String surname;
    private Contact contact;

    public Person(String name, String surname, Contact contact) {
        System.out.println("Person constructor is called");
        this.name = name;
        this.surname = surname;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", contact=" + contact +
                '}';
    }
}
