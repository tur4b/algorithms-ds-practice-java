package com.problem.linked_list.linked_list_double_ended;
import com.problem.linked_list.model.Node;

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
    public Node<T> insertFirst(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            head = node;
            last = node;
        }
        else {
            node.setNext(head);
            head = node;
        }
        return node;
    }

    //insertLast - O(1)
    public Node<T> insertLast(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            return insertFirst(data);
        }
        previous = last;
        last.setNext(node);
        last = node;
        return node;
    }

    //deleteFirst - O(1)
    public Node<T> deleteFirst(){
        if(isEmpty()){
            System.out.println("List is Empty!"); 
            return null;
        }
        Node<T> removedNode = head;
        head = head.getNext();
        // removedNode.setNext(null);
        return removedNode;
    }

    //deleteLast - O(1) time if we save previous
    //otherwise we need to traverse to get the node that is previous of last
    public Node<T> deleteLast(){
        if(isEmpty()){
            System.out.println("List is Empty!"); 
            return null;
        }
        Node<T> removedNode = last;
        previous.setNext(null);
        last = previous;
        return removedNode;
    }
    
    //show node data
    private String showNodeData(Node<T> node){
        String printedText = node.getData().toString();
        if(node.getNext() != null) {
            printedText += "->";
        }
        return printedText;
    }

    //show list nodes
    public void show(){
        if(isEmpty()){
            System.out.println("List is Empty!"); 
            return;
        }
        Node<T> current = head;
        while(current != null){
            System.out.print(showNodeData(current));
            current = current.getNext();
        }
    }

}
