package com.problem.stack.stack_linkedList_impl;

//stack implementation with linked list - insertion and deletion in O(1) time
public class StackLinkedList<T> {

    private Node<T> head;

    public StackLinkedList(){
        this.head = null;
    }

    //simple push function - insert to the head
    public void push(T data){
        System.out.println("Push: " + data);
        Node<T> node = new Node<>(data);
        node.setNext(head);
        head = node;
    }

    //simple pop function - delete from the head
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return null;}
        Node<T> current = head;
        head = head.getNext();
        System.out.println("Pop: " + current.getData());
        return current.getData();
    }

    public void show(){
        System.out.println("Show Method called...");
        Node<T> current = head;
        while(current != null){
            System.out.println("Data: " + current.getData());
            current = current.getNext();
        }
    }

    public boolean isEmpty(){
        return head == null ? true: false;
    }

}
