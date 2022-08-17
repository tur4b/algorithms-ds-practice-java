package com.problem.hash_table._1;

public class HashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_LOAD_FACTOR = 2;

    private Node<K,V>[] table;
    private long size;

    public V put(K key, V value) {
        int hash = hash(key);
        Node<K, V> node = new Node<>(hash, key, value, null);
        int n = table.length, i = (n-1) & hash;
        Node<K, V> entry;

        if(table == null) {
            Node<K,V>[] newTab = (Node<K,V>[])new Node[DEFAULT_CAPACITY];
            
            n = newTab.length;

            i = (n - 1) & hash;
            newTab[i] = node;
            table = newTab;

            size++;
            return value;
        }
        else {
            if(size == table.length) {
                // resize table
            }
            else {
                if((entry = table[i]) != null && entry.key != null && entry.key.equals(key)) {
                    table[i].value = value;
                }
            }
        }
        
        return null;
    }
    

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
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

    }

}
