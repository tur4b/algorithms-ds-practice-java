package com.problem.linked_list.linked_list_doubly;
import com.problem.linked_list.model.Node;

//doubly linked list completed
public class LinkedListDoubly<T> {

    private Node<T> head;
    private Node<T> last;
    private long size;

    public LinkedListDoubly() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    //check if isEmpty
    private boolean isEmpty(){
        return head == null;
    }

    //insertFirst - O(1) time
    public Node<T> insertFirst(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()) {
            last = head = node;
            ++size;
        }
        else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
            ++size;
        }
        return node;
    }

    //insertLast - O(1)
    public Node<T> insertLast(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            return insertFirst(data);
        }
        last.setNext(node);
        node.setPrevious(last);
        last = node;
        ++size;
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
        head.setPrevious(null);
        size--;
        return removedNode;
    }

    //deleteLast - O(1)
    public Node<T> deleteLast(){
        if(isEmpty()){
            System.out.println("List is Empty!");
            return null;
        }
        Node<T> removedNode = last;
        last.getPrevious().setNext(null);
        last = last.getPrevious();
        size--;
        return removedNode;
    }

    //delete target
    public Node<T> deleteTarget(T traget){
        if(isEmpty()){
            System.out.println("List is Empty!"); 
            return null;
        }
        if(head.getData() == traget){
            return deleteFirst();
        }
        if(last.getData() == traget){
            return deleteLast();
        }
        Node<T> current = head;
        while(current != null && current.getData() != traget){
            current = current.getNext();
        }
        Node<T> removeNode = current;
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        size--;
        return removeNode;
    }

    //insert at index - list's index starts from zero
    public Node<T> insertAtIndex(long index, T data){
        Node<T> node = new Node<>(data);
        if(isEmpty() || getSize() < index || index < 0){
            System.out.println("Given index is not present!");
            return null;
        }
        //if index == 0 insert it to the head
        if(index == 0){
            return insertFirst(data);
        }
        //if index == size insert it to the tail
        if(index == getSize()){
            return insertLast(data);
        }
        //otherwise
        Node<T> current = head;
        while(current != null && index-- > 0){
            current = current.getNext();
        }

        node.setNext(current);
        current.getPrevious().setNext(node);
        node.setPrevious(current.getPrevious());
        current.setPrevious(node);
        ++size;
        return node;
    }

    //delete at index - list's index starts from zero
    public Node<T> deleteAtIndex(long index){
        long theSize = getSize();
        if(isEmpty() || theSize <= index || index < 0){
            System.out.println("Given index is not present!");
            return null;
        }
        //if it is first element
        if(index == 0){
            return deleteFirst();
        }
        //if it is last element
        if(index == theSize - 1){
            return deleteLast();
        }
        Node<T> current = head;
        while(current != null && index-- > 0){
            current = current.getNext();
        }
        Node<T> removeNode = current;
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        size--;
        return removeNode;
    }

    //get size
    private long getSize(){
        return this.size;
    }

    //show list nodes from head - 1->2->3->
    public void showFromHead(){
        if(isEmpty()){
            System.out.print("List is Empty!\n"); return;
        }
        System.out.println("Show Form Head: ");
        Node<T> current = head;
        while(current != null){
            System.out.print(showNodeData(current));
            current = current.getNext();
        }
    }

    private String showNodeData(Node<T> node) {
        String printedText = node.getData().toString();
        if(node.getNext() != null) {
            printedText += "<->";
        }
        return printedText;
    }

    //show list nodes from last - 3->2->1->
    public void showFromLast() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.println("Show Form Last: ");
        Node<T> current = last;
        while(current != null){
            System.out.print(showNodeData(current));
            current = current.getPrevious();
        }
    }

}
