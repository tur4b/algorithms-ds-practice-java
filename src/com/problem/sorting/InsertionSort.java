package com.problem.sorting;

//time complexity - O(c*n), it is good for small size array sorting
public class InsertionSort {

    private int size;
    private int[] items;

    public InsertionSort(int size, int[] items){
        this.size = size;
        this.items = items;
    }

    //sorting in ascending order
    public void sortArrOrderAsc(){

        for(int i = 1;i < size;i++){
            int key = items[i];
            int j = i-1;
            for(;j>=0;j--){
                if(items[j] > key){
                    items[j+1] = items[j];
                }
                else break;
            }
            items[j+1] = key;
        }
    }

    //sorting in descending order
    public void sortArrOrderDesc(){
        for(int i = 1;i < size; i++){
            int key = items[i];
            int j = i-1;
            for(;j>=0;j--){
                if(items[j] < key){
                    items[j+1] = items[j];
                }
                else break;
            }
            items[j+1] = key;
        }
    }

    //show array
    public int[] showArr(){
        return this.items;
    }

}
