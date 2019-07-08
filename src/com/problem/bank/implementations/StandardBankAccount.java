package com.problem.bank.implementations;

import com.problem.bank.BankAccount;
import com.problem.bank.models.Person;
import com.problem.bank.specification.BankSpecification;

import java.util.Date;

public class StandardBankAccount  implements BankAccount {

    private Person owner;
    private Card card;
    private double balance;
    private double creditBalance;
    private BankSpecification bankSpecification;

    public StandardBankAccount() {}

    public StandardBankAccount(Person owner, Card card) {
        this.owner = owner;
        this.balance = 0.00;
        this.creditBalance = 0.00;
        this.card = card;
    }

    public double getBalance() {
        return balance;
    }

    public short getAccountCode() {
        return card.getAccountCode();
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }


    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    @Override
    public Person getOwner() {
        return owner;
    }

    @Override
    public void deposit(double amount) {
        if(Authentication.checkAccount(owner, card, bankSpecification)){
            balance += amount; // amount successfully added
        }
        else{
            System.out.println("Information about account is false!");
        }
    }

    @Override
    public void withdraw(double amount) {
        if(Authentication.checkAccount(owner, card, bankSpecification) && checkBalance(amount)){
            balance -= amount; // amount successfully withdrawed
            System.out.println(amount + " was withdrawed from balance at: " + new Date() +
                    " in " + this);
        }
        else{
            System.out.println("Information about account is false or balance is not enough for withdraw");
        }
    }

    //TODO: not completed it requires some classes
    @Override
    public void takeCredit(double amount) {
        if(Authentication.checkAccount(owner, card, bankSpecification)){

        }
        else{
            System.out.println("Information about account is false!");
        }
    }

    public void setBankSpecification(BankSpecification bankSpecification) {
        this.bankSpecification = bankSpecification;
    }

    @Override
    public double displayBalance() {
        return balance; // show balance
    }

    //TODO: not completed it requires some classes
    @Override
    public void payCreditMonthly(double amount) {

    }

    @Override
    public void transferMoney(double amount, BankAccount bankAccount) {
        boolean check = false;
        boolean auth = false;
        if(Authentication.checkAccount(owner, card, bankSpecification) && checkBalance(amount)){
            // sender successfully verified
            auth = true;
            StandardBankAccount standardBankAccount = (StandardBankAccount) bankAccount;
            if(Authentication.checkAccount(standardBankAccount.getOwner(),standardBankAccount.getCard(),
                    bankSpecification)){
                //receiver successfully verified
                balance -= amount; //amount deleted from sender's account
                bankAccount.deposit(amount); check = true;
            }
        }

        if(!check && auth) System.out.println("Not enough money for transfer");
        if(!auth) System.out.println("Wrong information about account!");
    }

    @Override
    public BankSpecification getBankSpecification() {
        return bankSpecification;
    }

    @Override
    public void closeAccount(short accountCode) {
        if(Authentication.checkAccount(owner, card, bankSpecification) && card.getAccountCode() == accountCode){
            // verified user
            bankSpecification.getAccounts().remove(this);
            System.out.println("Account was removed from Bank: " + this);
            // delete account for this account
        }
    }

    private boolean checkBalance(double amount){
        if(balance>=0){
            if(balance >= amount){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "StandardBankAccount{" +
                "owner=" + owner +
                ", card=" + card +
                ", balance=" + balance +
                ", creditBalance=" + creditBalance +
                '}';
    }
}
