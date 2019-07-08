package com.problem;

import com.problem.bank.implementations.Card;
import com.problem.bank.implementations.StandardBankAccount;
import com.problem.bank.models.*;
import com.problem.bank.specification.BankSpecification;
import com.problem.linked_list.linked_list_simple.LinkedList;
import com.problem.stack.delimiter_match.DelimiterChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public void doSomeBankWork(){
        Scanner sc = new Scanner(System.in);

        //person information
        Set<PhoneNumber> phoneNumberSetP1 = new HashSet<PhoneNumber>();
        phoneNumberSetP1.add(new PhoneNumber("mobile", "+994501234567"));
        phoneNumberSetP1.add(new PhoneNumber("home", "0121234567"));

        Set<PhoneNumber> phoneNumberSetP2 = new HashSet<PhoneNumber>();
        phoneNumberSetP1.add(new PhoneNumber("mobile", "+994501234567"));
        phoneNumberSetP1.add(new PhoneNumber("work", "0121234567"));

        Contact contactP1 = new Contact("XXXX XXXXX Street home XX", phoneNumberSetP1,
                "XXXXXX@gmail.com");

        Contact contactP2 = new Contact("XXXX XXXX Street home XX", phoneNumberSetP2,
                "XXXX@gmail.com");

        Person person1 = new Person("XXX", "XXXX", contactP1);
        Person person2 = new Person("XXXXX", "XXXX", contactP2);

        //bank information
        Set<PhoneNumber> phoneNumberSetB1 = new HashSet<PhoneNumber>();
        phoneNumberSetB1.add(new PhoneNumber("mobile", "+994501234567"));
        phoneNumberSetB1.add(new PhoneNumber("work", "0121234567"));

        Director directorB1 = new Director("KapitalDirector", "KapitalDirectorov", "CEO");

        Licensed licenseB1 = new Licensed("bank", "ABCKapitalABC", new Date());

        Contact contactB1 = new Contact("Xirdalan", phoneNumberSetP1,
                "contact@kapitalbank.az");
        About aboutB1 = new About("Kapital Bank", new Date(), directorB1, contactB1, licenseB1);
        BankSpecification bankSpecification = new BankSpecification(aboutB1);

        Card card1 = new Card(person1, 12341234, (short)1234, bankSpecification);
        Card card2 = new Card(person2, 43214321, (short)4321, bankSpecification);
        //first bank account
        StandardBankAccount standardBankAccount = new StandardBankAccount(person1, card1);
        standardBankAccount.setBankSpecification(bankSpecification);
        bankSpecification.addBankAccount(standardBankAccount);

        //second bank account
        StandardBankAccount standardBankAccountSecond = new StandardBankAccount(person2, card2);
        standardBankAccountSecond.setBankSpecification(bankSpecification);
        bankSpecification.addBankAccount(standardBankAccountSecond);


        // let's do some work
        boolean exit = true;
        do {
            System.out.println("Choose one of the actions!");
            System.out.println("1.Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Transfer");
            System.out.println("5.Exit");
            short number = sc.nextShort();
            switch(number){
                case 1: System.out.println("Balance: " + standardBankAccount.getBalance() +
                        " in account: "+standardBankAccount); break;

                case 2: System.out.println("How much money do you want to add?");
                    double depAmount = sc.nextDouble();
                    standardBankAccount.deposit(depAmount);
                    System.out.println(depAmount + " added to balance in "+ standardBankAccount); break;

                case 3: System.out.println("How much money do you want to withdraw?");
                    double withdrawAmount = sc.nextDouble();
                    standardBankAccount.withdraw(withdrawAmount);break;

                //TODO: not complete
                case 4: System.out.println("How much money do you want to transfer?");
                    double transferAmount = sc.nextDouble();
                    standardBankAccount.transferMoney(transferAmount, standardBankAccountSecond);
                    System.out.println("Balance of second user: " + standardBankAccountSecond.getBalance() +
                            " in account " + standardBankAccountSecond);

                case 5: System.out.println("BYE"); exit = false; break;
            }

        }while(exit);

    }

    public static void stackDelimiterCheck() throws IOException {
        System.out.println("Please add string for checking...");
        String str = getString();
        DelimiterChecker delimiterChecker = new DelimiterChecker(str.toCharArray());
        System.out.println("Input string: " + str);
        System.out.println("Checked answer: " + delimiterChecker.checkIfMatch());
    }

    private static String getString() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        return str;
    }

    public void stacckDelimiterFunction(){
        boolean answer = true;
        do {
            try {
                stackDelimiterCheck();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Do you want to continue?(Yes/No)or(yes/no)or(Y/N)or(y/n)");
                String str = null;
                try {
                    str = getString();
                    if(!(str.equals("Yes") || str.equals("yes") || str.equals("Y") || str.equals("y"))){
                        answer = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }while(answer);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertInSortedOrderDesc(15);
        ll.insertInSortedOrderDesc(21);
        ll.insertInSortedOrderDesc(5);
        ll.insertInSortedOrderDesc(2);
        ll.insertInSortedOrderDesc(10);
        ll.insertInSortedOrderDesc(60);
        ll.insertInSortedOrderDesc(12);
        ll.show();
        ll.reverse();
        ll.show();
    }

}