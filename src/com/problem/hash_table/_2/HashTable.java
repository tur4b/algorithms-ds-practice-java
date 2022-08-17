package com.problem.hash_table._2;

import java.util.Arrays;

public class HashTable<K, V> {

    private Node<K, V> [] table;
    private int size;

    private static final int DEFAULT_CAPACITY = 16;
    private final int DEFAULT_RESIZE_FACTOR = 2;

    public HashTable() {
        this.table = (Node<K, V> []) new Node[DEFAULT_CAPACITY];
    }

    public void put(K k, V v) {
        if(size == table.length) {
            // resize table
            table = Arrays.copyOf(table, table.length * DEFAULT_RESIZE_FACTOR);
        }

        int hash = hash(k);
        int i = (table.length - 1) & hash;

        System.out.println(String.format("hash(%s)=%d; i=%d", k, hash, i));

        Node<K, V> newNode = new Node<>(hash, k, v, null);
        Node<K, V> node;

        if((node = table[i]) != null) {
            while(node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
        else {
            table[i] = newNode;
        }
        size++;
    }

    // FIXME: should be implemented
    public void remove(K k) {
        int hash = hash(k);
        int i = (table.length - 1) & hash;
        Node<K, V> node;

        System.out.println(String.format("hash(%s)=%d; i=%d", k, hash, i));

        // wrong implementation requires more attention
        if(i < table.length && (node = table[i]) != null) {
            System.out.println(String.format("hash(%s)=%d; i=%d", k, hash, i));

            if(node != null && node.key.equals(k)) {
                table[i] = null;

                if(size <= (table.length / DEFAULT_RESIZE_FACTOR)) {
                    // resize table
                    table = Arrays.copyOfRange(table, 0, size);
                }
                size--;
            }
            else {
                // Node<K, V> previous = node;
                
                while(node != null) {
                    // previous = node;
                    node = node.next;
                    if(node.key.equals(k)) { // && node.value) {
                        System.out.println("not implemented yet!");
                    }
                }
            }
            
        }
        
    }

    public void showEntries() {
        for(int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];

            while(node != null) {
                System.out.println("(k: " + node.key + "; v: " + node.value + "); i: " + i);
                node = node.getNext();
            }
            
        }
    }

    private int hash(K k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    static class Node<K, V> {
    
        private final int hash;
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public Node<K, V> getNext() {
            return next;
        }
    }

}
