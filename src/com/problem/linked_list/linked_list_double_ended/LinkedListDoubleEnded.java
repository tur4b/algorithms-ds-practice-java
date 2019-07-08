package com.problem.linked_list.linked_list_double_ended;

//double-ended linked list completed
public class LinkedListDoubleEnded<T> {

    private Node<T> head;
    private Node<T> last;
    private Node<T> previous; //use this we can delete last node in O(1) time

    public LinkedListDoubleEnded() {
        this.head = null;
        this.last = null;
        this.previous = null;
    }

    //check if isEmpty
    private boolean isEmpty(){
        return head == null ? true: false;
    }

    //insert first - O(1)
    public void insertFirst(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            head = node;
            last = node;
            return;
        }
        node.setNext(head);
        head = node;
    }

    //insertLast - O(1)
    public void insertLast(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            insertFirst(data); return;
        }
        previous = last;
        last.setNext(node);
        last = node;
    }

    //deleteFirst - O(1)
    public void deleteFirst(){
        if(isEmpty()){
            System.out.println("List is Empty!"); return;
        }
        head = head.getNext();
    }

    //deleteLast - O(1) time if we save previous
    //otherwise we need to traverse to get the node that is previous of last
    public void deleteLast(){
        if(isEmpty()){
            System.out.println("List is Empty!"); return;
        }
        previous.setNext(null);
        last = previous;
    }
    
    //show node data
    private T showNodeData(Node<T> node){
        return node.getData();
    }

    //show list nodes
    public void show(){
        if(isEmpty()){
            System.out.println("List is Empty!"); return;
        }
        Node<T> current = head;
        while(current != null){
            System.out.print(showNodeData(current) + "->");
            current = current.getNext();
        }
        System.out.println();
    }

}
