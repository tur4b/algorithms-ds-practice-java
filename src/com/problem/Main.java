package com.problem;

import com.problem.stack.delimiter_match.DelimiterChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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

    public void stackDelimiterFunction(){
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
                    if(!(str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y"))){
                        answer = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }while(answer);
    }

    public static void main(String[] args) {

    }

}
