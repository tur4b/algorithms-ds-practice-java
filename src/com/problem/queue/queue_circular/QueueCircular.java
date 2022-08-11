package com.problem.queue.queue_circular;

import java.lang.reflect.Array;

public class QueueCircular<T> {

    private int head;
    private int tail;
    private int size;
    private int currentSize;
    private T[] items;

    public QueueCircular(int size,Class<T> t) {
        this.size = size;
        this.head = -1;
        this.tail = -1;
        this.currentSize = 0;
        this.items = (T[]) Array.newInstance(t, size);
    }

    public boolean isEmpty(){
        return currentSize == 0?true:false;
    }

    public boolean isFull(){
        return currentSize == size?true:false;
    }

    //enqueue- add data to the queue
    public void enqueue(T data){
        if(isFull()){
            System.out.println("Queue is full!"); return;
        }
        if(isEmpty()){
            items[++tail] = data;
            head = 0;
            currentSize++;
            return;
        }
        if(tail == (size-1)){
            tail = 0;
            items[tail] = data;
            currentSize++;
            return;
        }
        //otherwise
        items[++tail] = data;
        currentSize++;
    }

    //dequeue - remove an item
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty!");return;
        }
        if(head == tail){
            tail = -1;
            head = -1;
            currentSize--;
            return;
        }

        if(head == (size-1)){
            head = 0;
            currentSize--;
            return;
        }

        //otherwise
        head++;
        currentSize--;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Queue is empty"); return;
        }
        if(tail >= head){
            for(int i = head;i <= tail;i++){
                System.out.print(items[i] + "->");
            }
        }
        else if(tail < head){
            for(int i = head;i <= size-1;i++){
                System.out.print(items[i] + "->");
            }
            for(int i = 0;i <= tail; i++){
                System.out.print(items[i] + "->");
            }
        }
    }
}
