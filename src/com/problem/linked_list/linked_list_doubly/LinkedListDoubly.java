package com.problem.linked_list.linked_list_doubly;

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
        return head == null ? true: false;
    }

    //insertFirst - O(1) time
    public void insertFirst(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()) {
            head = node;
            last = node;
            ++size;
            return;
        }
        node.setNext(head);
        head.setPrevious(node);
        head = node;
        ++size;
    }

    //insertLast - O(1)
    public void insertLast(T data){
        Node<T> node = new Node<T>(data);
        if(isEmpty()){
            insertFirst(data); return;
        }
        last.setNext(node);
        node.setPrevious(last);
        last = node;
        ++size;
    }

    //deleteFirst - O(1)
    public void deleteFirst(){
        if(isEmpty()){
            System.out.println("List is Empty!");
            return;
        }
        head = head.getNext();
        head.setPrevious(null);
        size--;
    }

    //deleteLast - O(1)
    public void deleteLast(){
        if(isEmpty()){
            System.out.println("List is Empty!");return;
        }
        last.getPrevious().setNext(null);
        last = last.getPrevious();
        size--;
    }

    //delete target
    public void deleteTarget(T traget){
        if(isEmpty()){
            System.out.println("List is Empty!"); return;
        }
        if(head.getData() == traget){
            deleteFirst(); return;
        }
        if(last.getData() == traget){
            deleteLast(); return;
        }
        Node current = head;
        while(current != null && current.getData() != traget){
            current = current.getNext();
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        size--;
    }

    //insert at index - list's index starts from zero
    public void insertAtIndex(long index, T data){
        Node<T> node = new Node<>(data);
        if(isEmpty() || getSize() < index || index < 0){
            System.out.println("Given index is not present!"); return;
        }
        //if index == 0 insert it to the head
        if(index == 0){
            insertFirst(data); return;
        }
        //if index == size insert it to the tail
        if(index == getSize()){
            insertLast(data); return;
        }
        //otherwise
        Node current = head;
        while(current != null && index-- > 0){
            current = current.getNext();
        }

        node.setNext(current);
        current.getPrevious().setNext(node);
        node.setPrevious(current.getPrevious());
        current.setPrevious(node);
        ++size;
    }

    //delete at index - list's index starts from zero
    public void deleteAtIndex(long index){
        long theSize = getSize();
        if(isEmpty() || theSize <= index || index < 0){
            System.out.println("Given index is not present!"); return;
        }
        //if it is first element
        if(index == 0){
            deleteFirst();return;
        }
        //if it is last element
        if(index == theSize - 1){
            deleteLast(); return;
        }
        Node current = head;
        while(current != null && index-- > 0){
            current = current.getNext();
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        size--;

    }

    //get size
    private long getSize(){
        return this.size;
    }

    //show Node data
    private T showNodeData(Node<T> node){
        return node.getData();
    }

    //show list nodes from head - 1->2->3->
    public void showFromHead(){
        if(isEmpty()){
            System.out.print("List is Empty!\n"); return;
        }
        System.out.println("Show Form Head: ");
        Node current = head;
        while(current != null){
            System.out.print(showNodeData(current) + "->");
            current = current.getNext();
        }
        System.out.println();
    }

    //show list nodes from last - 3->2->1->
    public void showFromLast() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.println("Show Form Last: ");
        Node current = last;
        while(current != null){
            System.out.print(showNodeData(current) + "->");
            current = current.getPrevious();
        }
        System.out.println();
    }

}
