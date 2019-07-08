package com.problem.stack.stack_linkedList_impl;

public class Node<T> {

    private T data;
    private Node next;

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
