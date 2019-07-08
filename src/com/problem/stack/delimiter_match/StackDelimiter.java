package com.problem.stack.delimiter_match;

//perfect it works :)
public class StackDelimiter {

    private int top;
    private char[] items;
    private int size;

    public StackDelimiter(int size) {
        this.top = -1;
        this.size = size;
        this.items = new char[this.size];
    }

    public void push(char ch){
        if(isFull()){
            System.out.println("Stack is full!"); return;
        }
        items[++top] = ch;
    }

    public char pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!"); return '\u0000';
        }
        top--;
        return items[top + 1];
    }

    public boolean isEmpty(){
        return top == -1?true:false;
    }

    public boolean isFull(){
        return top == this.size?true:false;
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Stack is empty!"); return;
        }
        for(int i = top; i>=0; i--) System.out.println("Data: " + items[i]);
    }
}
