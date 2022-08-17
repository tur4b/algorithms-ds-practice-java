package com.problem.stack.stack_array_impl;

import java.lang.reflect.Array;
import java.util.Arrays;

//stack implementation with array
public class Stack<T> {

    private int size;
    private int top;
    private T[] items;

    public Stack(int size, Class<T> t) {
        this.top = -1;
        this.size = size;
        this.items = (T[]) Array.newInstance(t, size);
    }

    public boolean isEmpty(){
        return top == -1 ? true : false;
    }

    public boolean isFull(){
        return (top == (size+1)) ? true : false;
    }

    public void push(T data){
        if(!isFull()){
            items[++top] = data;
            System.out.println("Pushed data: " + data);
        }
        else System.out.println("Overflows!");
    }

    public T pop(){
        if(!isEmpty()){
            top--;
            System.out.println("Popped data: " + items[top + 1]);
        }
        else System.out.println("Underflow!");
        return items[top + 1];
    }

    public int size(){
        return this.size;
    }

    public void showItemsWithPop(){
        if(isEmpty()) return;
        T data = pop();
        System.out.println("Show With pop: " + data);
        showItemsWithPop();
    }

    public void showItemsWithoutPop(){
        if(isEmpty()){
            System.out.println("Stack is empty!"); return;
        }
        for(int i = top;i >= 0;i--){
            System.out.println("Show Without pop:" + items[i]);
        }
    }

    public T get(int index){
        if(index > top || index < 0) return null;
        return items[top - index];
    }

    public T peek(){
        return items[top];
    }
}
