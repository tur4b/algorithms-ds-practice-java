package com.problem.bank.implementations;

import com.problem.bank.BankAccount;
import com.problem.bank.models.Person;
import com.problem.bank.specification.BankSpecification;

import java.util.List;

public class Authentication {
    private Person owner;
    private Card card;

    public Authentication(Person owner, Card card) {
        this.owner = owner;
        this.card = card;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    // get all accounts for specified Bank
    private static List<BankAccount> getAllBankAccounts(BankSpecification bankSpecification){
        return bankSpecification.getAccounts();
    }

    // checking account information(true/false)
    public  static boolean checkAccount(Person owner, Card card, BankSpecification bankSpecification){
        for(BankAccount account : getAllBankAccounts(bankSpecification)){
            StandardBankAccount bAccount = (StandardBankAccount)account;
            if(bAccount.getOwner().equals(owner) && bAccount.getCard().equals(card)){
                //verified account
                return true;
            }
        }
        //false information on account
        return false;
    }


}
