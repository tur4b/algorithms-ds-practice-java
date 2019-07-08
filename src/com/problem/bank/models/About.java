package com.problem.bank.models;

import java.util.Date;

public class About {
    private String name;
    private Date createdDate;
    private Director director;
    private Contact contact;
    private Licensed licensed;

    public About(String name, Date createdDate, Director director, Contact contact, Licensed licensed) {
        System.out.println("Contact constructor is called");
        this.name = name;
        this.createdDate = createdDate;
        this.director = director;
        this.contact = contact;
        this.licensed = licensed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setLicensed(Licensed licensed) {
        this.licensed = licensed;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Director getDirector() {
        return director;
    }

    public Contact getContact() {
        return contact;
    }

    public Licensed getLicensed() {
        return licensed;
    }

    @Override
    public String toString() {
        return "About{" +
                "name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", director=" + director +
                ", contact=" + contact +
                ", licensed=" + licensed +
                '}';
    }
}
