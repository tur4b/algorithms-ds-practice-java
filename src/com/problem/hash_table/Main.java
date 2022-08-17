package com.problem.hash_table;

import com.problem.hash_table._2.HashTable;

public class Main {
    
    public static void main(String[] args) {
        
        practice_2();

    }

    public static void practice_2() {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("ab", 12);
        table.put("ba", 21);
        table.put("cd", 6);
        table.put("dc", 9);
        table.put("a", 11);
        table.put("kjl", 190);

        System.out.println("----------------------------------------------");

        // table.showEntries();

        System.out.println("----------------------------------------------");

        table.remove("a");

        table.showEntries();

        System.out.println("----------------------------------------------");



    }
}
