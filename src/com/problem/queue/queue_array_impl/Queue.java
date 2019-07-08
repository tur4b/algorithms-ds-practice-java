package com.problem.queue.queue_array_impl;

import java.lang.reflect.Array;

//this queue is simple queue - not circular, so it requires more capacity after
// dequeue operations enqueue operations can not be used more as before
//check circular queue
public class Queue<T> {

    private int size;
    private int currentSize;
    private int head;
    private int tail;
    private T[] items;

    public Queue(int size, Class<T> t){
        this.size = size;
        this.head = -1;
        this.tail = -1;
        this.items = (T[]) Array.newInstance(t, size);
        this.currentSize = 0;
    }

    public boolean isEmpty(){
        return currentSize == 0?true:false;
    }

    public boolean isFull(){
        return currentSize == size?true:false;
    }

    public void enqueue(T data){
        if(isEmpty()){
            items[++tail] = data;
            head = 0;
            currentSize++;
            return;
        }
        if(isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        items[++tail] = data;
        currentSize++;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            head = -1;
            return;
        }
        head++;
        currentSize--;
        if(currentSize == 0) {
            System.out.println("Queue is empty now!");
            head = -1;
            tail = -1;
        }
    }

    public void show(){
        if(isEmpty()) return;
        System.out.println(head);
        System.out.println(tail);
        for(int i = head; i <= tail; i++){
            System.out.print(items[i] + "->");
        }
    }

    public void currentSize(){
        System.out.println("Current Size: " + currentSize);
    }
}
