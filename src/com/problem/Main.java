package com.problem;

import com.problem.linked_list.linked_list_simple.LinkedList;
import com.problem.linked_list.model.Node;
import com.problem.stack.delimiter_match.DelimiterChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

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
        LinkedList<Integer> list = new LinkedList<>();
        list.insertInSortedOrderAsc(5);
        list.insertInSortedOrderAsc(2);
        list.insertInSortedOrderAsc(1);
        list.insertInSortedOrderAsc(4);
        list.insertInSortedOrderAsc(3);
        list.insertInSortedOrderAsc(7);

        // list.show();

        Iterator<Node<Integer>> iterator = list.iterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next().getData() + "->");
        }

        // for(Node<Integer> node : list) {
        //     System.out.print(node.getData() + "->");
        // }

    }

}
