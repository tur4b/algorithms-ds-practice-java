package com.problem.linked_list.linked_list_simple;

//simple linked list completed - we can add some additional methods :)
public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    //check if the list is empty or not
    public boolean isEmpty(){
        return head == null?true:false;
    }

    ////it is more optimal than insertion sort - O(n*n)
    //insert the nodes with ascending order - like: 1->2->3->7->15->.....
    public void insertInSortedOrderAsc(T data){
        //let's create new node with given "data" [data|next] ->
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            insertFirst(data); return;
        }

        Node current = head;
        Node previous = null;
        //for comparision we need to cast it to long - we can also use some techniques for other data types
        while(current != null && Long.parseLong(current.getData().toString()) <= Long.parseLong(data.toString())){
            previous = current;
            current = current.getNext();
        }

        //if new node's data less than head's data
        if(previous == null){
            insertFirst(data);return;
        }

        //add new node
        previous.setNext(node);
        node.setNext(current);
        size++;
    }

    //insert new nodes in descending order - it is more optimal than insertion sort - O(n*n)
    public void insertInSortedOrderDesc(T data){
        //let's create new node with given "data" [data|next] ->
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            insertFirst(data); return;
        }

        Node current = head;
        Node previous = null;
        //for comparision we need to cast it to long - we can also use some techniques for other data types
        while(current != null && Long.parseLong(current.getData().toString()) >= Long.parseLong(data.toString())){
            previous = current;
            current = current.getNext();
        }

        //if new node's data less than head's data
        if(previous == null){
            insertFirst(data);return;
        }

        //add new node
        previous.setNext(node);
        node.setNext(current);
        size++;
    }

    //correct
    public void insertFirst(T data){
        Node<T> node = new Node<>(data);
        if(isEmpty()){
            head = node;
            size++; return;
        }
        node.setNext(head);
        head = node;
        size++; return;
    }

    //correct
    public void deleteFirst(){
        if(isEmpty()) return;
        Node current = head;
        head = head.getNext();
        size--;
        System.out.println("Deleted Node: " + current.getData());
    }

    //correct
    public void deleteTarget(T data){
        if(isEmpty()){
            System.out.println("Empty!");return;
        }
        //if target is first element
        if(head.getData() == data) {
            deleteFirst();
            return;
        }

        Node current = head;
        Node previous = head;

        while(current != null){
            previous = current;
            current = current.getNext();
            if(current.getData() == data)  break;
        }
        previous.setNext(current.getNext());
        size--;
        System.out.println("Deleted Node: " + current.getData());
    }

    //correct
    public void insertAfter(T target, T data){
        boolean found = false;
        if(isEmpty()){
            System.out.println(data + " not found for insertion!");
            return;
        }
        Node node = new Node(data);
        Node current = head;
        while(current != null){
            if(current.getData() == target) {
                found = true;
                break;
            }
            current = current.getNext();
        }

        if(found == true) {
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }

    }

    //correct
    public void insertLast(T data){
        Node node = new Node(data);
        if(isEmpty()){
            insertFirst(data);return;
        }
        Node current = head;
        while(current.getNext()!= null){
            current = current.getNext();
        }
        current.setNext(node);
        size++;
    }

    //correct
    public void deleteLast(){
        Node current = head;
        Node previous = head;
        if(isEmpty()) return;

        if(size == 1){
            deleteFirst();
            System.out.println("Empty");
            return;
        }
        while(current.getNext() != null){
            previous = current;
            current = current.getNext();
        }
        previous.setNext(null);
        size--;
        System.out.println("Deleted Node: " + current.getData());
    }

    //correct
    public boolean search(T data){
        if(isEmpty()) return false;
        Node current = head;
        while(current != null){
            if(current.getData() == data) return true;
            current = current.getNext();
        }
        return false;
    }

    private void displayNode(Node node){
        System.out.print(node.getData() + "->");
    }

    //correct
    public void show(){
        if(isEmpty()) return;
        Node current = head;
        while(current != null){
            displayNode(current);
            current = current.getNext();
        }
        System.out.println();
    }

    //reverse the list
    public void reverse(){
        if(isEmpty()){
            System.out.println("List is Empty!"); return;
        }
        Node current = head;
        Node previous = null;

        while(current != null){
            current = current.getNext();
            head.setNext(previous);
            previous = head;
            if(current != null) head = current;
        }
    }

    //size
    public int size(){
        return this.size;
    }
}
