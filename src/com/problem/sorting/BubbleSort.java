package com.problem.sorting;

//completed - time complexity O(n^2)
public class BubbleSort {

    private int size;
    private int[] items;

    public BubbleSort(int size, int[] items) {
        this.size = size;
        this.items = items;
    }

    public int[] showArr(){
        return this.items;
    }

    private void swap( int i, int j){
        if(i == j) return;
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //bubble sort in ascending order
    public void bubbleSortAsc(){

        for(int i = size - 1;i >0;i--){

            for(int j = 0;j < i;j++){
                if(items[j] > items[j+1]){
                    swap(j, j+1);
                }
            }
        }
    }

    //bubble sort in descending order
    public void bubbleSortDesc(){
        for(int i = size - 1; i > 0;i--){
            for(int j = 0; j < i;j++){
                if(items[j] < items[j+1]){ swap(j, j+1); }
            }
        }
    }

}
