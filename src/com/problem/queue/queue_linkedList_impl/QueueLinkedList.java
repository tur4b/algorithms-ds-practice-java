package com.problem.queue.queue_linkedList_impl;

public class QueueLinkedList<T> {

    private Node<T> head;
    private Node<T> last;

    public QueueLinkedList() {
        this.head = null;
        this.last = null;
    }

    //check if isEmpty
    private boolean isEmpty(){
        return head == null ? true: false;
    }

    //enqueue - O(1) time
    public void enqueue(T data){
        //we added to last
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            head = node;
            last = node;
            return;
        }
        last.setNext(node);
        last = node;
    }

    //dequeue - O(1)
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!");return;
        }
        //we delete first
        head = head.getNext();
    }

    //show data
    private T showData(Node<T> node){
        return node.getData();
    }

    //show queue elements
    public void show(){
        if (isEmpty()){
            System.out.println("Queue is Empty!"); return;
        }
        Node current = head;
        while(current != null){
            System.out.print(showData(current) + ",");
            current = current.getNext();
        }
        System.out.println();
    }
}
