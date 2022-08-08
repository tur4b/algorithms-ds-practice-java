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

    // TODO: implemented just for data which implements Comparable interface
    ////it is more optimal than insertion sort - O(n*n)
    //insert the nodes with ascending order - like: 1->2->3->7->15->.....
    public Node<T> insertInSortedOrderAsc(T data){
        //let's create new node with given "data" [data|next] ->
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            return insertFirst(data); 
        }

        Node<T> current = head;
        Node<T> previous = null;
        //for comparision we need to cast it to long - we can also use some techniques for other data types
        while(current != null && ((Comparable) current.getData()).compareTo(data) <= 0){
            previous = current;
            current = current.getNext();
        }

        //if new node's data less than head's data
        if(previous == null){
            return insertFirst(data);
        }

        //add new node
        previous.setNext(node);
        node.setNext(current);
        size++;
        return node;
    }

    // TODO: implemented just for data which implements Comparable interface
    //insert new nodes in descending order - it is more optimal than insertion sort - O(n*n)
    public Node<T> insertInSortedOrderDesc(T data){
        if(!(data instanceof Comparable)) {
            throw new IllegalArgumentException("requires Comparable obj to compare inserted values");
        }
        //let's create new node with given "data" [data|next] ->
        Node<T> node = new Node<T>(data);

        if(isEmpty()){
            return insertFirst(data);
        }

        Node<T> current = head;
        Node<T> previous = null;
        //for comparision we need to cast it to long - we can also use some techniques for other data types
        while(current != null && ((Comparable) current.getData()).compareTo(data) >= 0){
            previous = current;
            current = current.getNext();
        }

        //if new node's data less than head's data
        if(previous == null){
            return insertFirst(data);
        }

        //add new node
        previous.setNext(node);
        node.setNext(current);
        size++;
        return node;
    }

    //correct
    public Node<T> insertFirst(T data){
        Node<T> node = new Node<>(data);
        if(isEmpty()){
            head = node;
            size++; 
        }
        else {
            node.setNext(head);
            head = node;
            size++;
        } 
        return node;
    }

    //correct
    public Node<T> deleteFirst(){
        if(isEmpty()) {
            return null;
        }
        Node<T> current = head;
        head = head.getNext();
        size--;
        return current;
    }

    //correct
    public Node<T> deleteTarget(T data){
        if(isEmpty()){
            return null;
        }
        //if target is first element
        if(head.getData() == data) {
            deleteFirst();
            return head;
        }

        return deleteTarget_(data);
    }

    private Node<T> deleteTarget_(T data) {
        Node<T> current = head;
        Node<T> previous = head;

        while(current != null){
            previous = current;
            current = current.getNext();
            if(current.getData() == data) {
                break;
            }
        }
        previous.setNext(current.getNext());
        size--;
        return current;
    }

    //correct
    public Node<T> insertAfter(T target, T data){
        boolean found = false;
        if(isEmpty()){
            System.out.println(data + " not found for insertion!");
            return null;
        }
        return insertAfter_(target, data, found);
    }

    private Node<T> insertAfter_(T target, T data, boolean found) {
        Node<T> node = new Node<>(data);
        Node<T> current = head;

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
        return node;
    }

    //correct
    public Node<T> insertLast(T data){
        Node<T> node = new Node<>(data);
        if(isEmpty()){
            return insertFirst(data);
        }
        Node<T> current = head;
        while(current.getNext()!= null){
            current = current.getNext();
        }
        current.setNext(node);
        size++;
        return node;
    }

    //correct
    public Node<T> deleteLast(){
        Node<T> current = head;
        Node<T> previous = head;
        if(isEmpty()) {
            return null;
        }

        return deleteLast_(current, previous);
    }

    private Node<T> deleteLast_(Node<T> current, Node<T> previous) {
        if(size == 1){
            return deleteFirst();
        }
        while(current.getNext() != null){
            previous = current;
            current = current.getNext();
        }
        previous.setNext(null);
        size--;
        return current;
    }

    //correct
    public boolean search(T data){
        if(isEmpty()) return false;
        Node<T> current = head;
        while(current != null){
            if(current.getData() == data) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private void displayNode(Node<T> node){
        String printedText = node.getData().toString();
        if(node.getNext() != null) {
            printedText += "->";
        }
        System.out.print(printedText);
    }

    //correct
    public void show(){
        if(isEmpty()) {
            return;
        }
        Node<T> current = head;
        while(current != null){
            displayNode(current);
            current = current.getNext();
        }
    }

    //reverse the list
    public void reverse(){
        if(isEmpty()){
            System.out.println("List is Empty!"); 
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;

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
