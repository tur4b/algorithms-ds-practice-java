package com.problem.bank.models;

import java.util.Set;

public class Contact {
    private String address;
    private Set<PhoneNumber> phoneNums;
    private String emailAddress;

    public Contact(String address, Set<PhoneNumber> phoneNums, String emailAddress) {
        System.out.println("Contact constructor is called");
        this.address = address;
        this.phoneNums = phoneNums;
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", phoneNums=" + phoneNums +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
