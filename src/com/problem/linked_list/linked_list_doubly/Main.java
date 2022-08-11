package com.problem.linked_list.linked_list_doubly;

import java.util.Iterator;

import com.problem.linked_list.linked_list_doubly.model.IteratorType;
import com.problem.linked_list.model.Node;

public class Main {
    
    public static void main(String[] args) {
        LinkedListDoubly<Integer> list = new LinkedListDoubly<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        Iterator<Node<Integer>> iterator = list.iterator(IteratorType.ITERATE_TAIL);
        while(iterator.hasNext()) {
            System.out.println("data: " + iterator.next().getData());
        }

    }

}
