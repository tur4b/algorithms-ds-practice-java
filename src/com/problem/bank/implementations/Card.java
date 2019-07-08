package com.problem.bank.implementations;

import com.problem.bank.models.Person;
import com.problem.bank.specification.BankSpecification;

public class Card {
    private Person owner;
    private int creditCardNumber;
    private short accountCode;
    private BankSpecification bankSpecification;

    public Card(Person owner, int creditCardNumber, short accountCode, BankSpecification bankSpecification) {
        System.out.println("Card constructor is called");
        this.owner = owner;
        this.creditCardNumber = creditCardNumber;
        this.accountCode = accountCode;
        this.bankSpecification = bankSpecification;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public short getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(short accountCode) {
        this.accountCode = accountCode;
    }

    public BankSpecification getBankSpecification() {
        return bankSpecification;
    }

    public void setBankSpecification(BankSpecification bankSpecification) {
        this.bankSpecification = bankSpecification;
    }

    @Override
    public String toString() {
        return "Card{" +
                "owner=" + owner +
                ", creditCardNumber=" + creditCardNumber +
                ", accountCode=" + accountCode +
                '}';
    }
}
