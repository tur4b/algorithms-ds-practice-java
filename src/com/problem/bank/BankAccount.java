package com.problem.bank;

import com.problem.bank.models.Person;
import com.problem.bank.specification.BankSpecification;

public interface BankAccount {

    public Person getOwner();
    public void deposit(double amount);
    public void withdraw(double amount);
    public void takeCredit(double amount);
    public double displayBalance();
    public void payCreditMonthly(double amount);
    public void transferMoney(double amount, BankAccount bankAccount);
    public BankSpecification getBankSpecification();
    public void closeAccount(short accountCode); // requires account code to close your account


}
