package com.problem.sorting;

//time complexity - O(c*n)
public class SelectionSort {

    private int size;
    private int[] items;

    public SelectionSort(int size, int[] items) {
        this.size = size;
        this.items = items;
    }

    public int[] showArr(){
        return items;
    }

    public void selectionSortAsc(){

        for(int i = 0;i < items.length; i++){

            int min = Integer.MAX_VALUE;
            int minInd = 0;
            for(int j = i;j < items.length;j++){
                if(items[j] < min) {
                    min = items[j];
                    minInd = j;
                }
            }
            int k = items[i];
            items[i] = min;
            items[minInd] = k;
        }
    }

    public void selectionSortDesc(){

        for(int i = 0;i < items.length; i++){
            int max = Integer.MIN_VALUE;
            int maxInd = 0;
            for(int j = i; j< items.length; j++){
                if(items[j] > max){
                    max = items[j];
                    maxInd = j;
                }
            }
            int k = items[i];
            items[i] = max;
            items[maxInd] = k;
        }
    }

}
