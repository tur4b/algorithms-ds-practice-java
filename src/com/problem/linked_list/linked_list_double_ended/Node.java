package com.problem.linked_list.linked_list_double_ended;

public class Node<T> {
    private T data;
    private Node next;
    private Node previous;

    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

}
