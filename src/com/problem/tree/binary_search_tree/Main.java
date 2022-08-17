package com.problem.tree.binary_search_tree;

import java.math.BigDecimal;

import com.problem.tree.model.Room;
import com.problem.tree.model.VisitOrder;

public class Main {

    public static void main(String[] args) {
        
        Room room1 = new Room(10, BigDecimal.valueOf(4.5), BigDecimal.valueOf(4.8), (byte) 1);
        Room room2 = new Room(5, BigDecimal.valueOf(2.34), BigDecimal.valueOf(3.82), room1, (byte) 2); // 5b
        Room room3 = new Room(15, BigDecimal.valueOf(1.56), BigDecimal.valueOf(2.8), room2, (byte) 1);
        Room room4 = new Room(3, BigDecimal.valueOf(4.5), BigDecimal.valueOf(4.4), room3, (byte) 2);
        Room room5 = new Room(7, BigDecimal.valueOf(4.56), BigDecimal.valueOf(5.0), room4, (byte) 1);
        Room room6 = new Room(4, BigDecimal.valueOf(3.95), BigDecimal.valueOf(4.14), room5, (byte) 1);
        Room room7 = new Room(12, BigDecimal.valueOf(6.9), BigDecimal.valueOf(7.25), room6, (byte) 3);
        Room room8 = new Room(5, BigDecimal.valueOf(3.9), BigDecimal.valueOf(3.9), room6, (byte) 1); // 5b

        BinarySearchTree<Room> tree = new BinarySearchTree<>();
        tree.insert(room1);
        tree.insert(room2);
        tree.insert(room3);
        tree.insert(room4);
        tree.insert(room5);
        tree.insert(room6);
        tree.insert(room7);
        tree.insert(room8);

        BinarySearchTree<String> t2 = new BinarySearchTree<>();
        t2.insert("+");

        // tree.visitTree(VisitOrder.INORDER)
        //     .forEach(node -> System.out.println(node.getData()));

        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        t.insert(-10);
        t.insert(-3);
        t.insert(0);
        t.insert(5);
        t.insert(2);
        t.insert(3);
        t.insert(9);
        t.insert(-4);

        TreeNode<Integer> foundedNode = t.findByData(5)
            .orElseThrow(() -> new RuntimeException("node not found by data: "));

        System.out.println("foundedNode: " + foundedNode);

    }
    
}
