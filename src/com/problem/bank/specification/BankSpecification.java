package com.problem.bank.specification;

import com.problem.bank.BankAccount;
import com.problem.bank.models.About;

import java.util.ArrayList;
import java.util.List;

public  class BankSpecification {
    private About about;
    private List<BankAccount> accounts;

    public BankSpecification(About about) {
        accounts = new ArrayList<>();
        this.about = about;
    }

    public void setAbout(About about){
        this.about = about;
    }

    public About getAbout(){
        return about;
    }

    public void addBankAccount(BankAccount bankAccount){
        System.out.println("New Account added to specified bank");
        accounts.add(bankAccount);
    }

    public List<BankAccount> getAccounts(){
        return accounts;
    }

    @Override
    public String toString() {
        return "BankSpecification{" +
                "about=" + about +
                ", accounts=" + accounts +
                '}';
    }
}
