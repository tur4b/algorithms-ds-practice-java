package com.problem.sorting;

public class MergeSort {

    private int[] items;
    private int size;

    public MergeSort(int[] items, int size) {
        this.items = items;
        this.size = size;
    }

    public void mergeSort(int start, int end){
        if(end - start < 2) return;

        int mid = (start + end)/2;
        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start, mid, end);
    }

    public void merge(int start, int mid, int end){
        if(items[mid - 1] <= items[mid]) return;

        int i = start;
        int j = end;
        int tempInd = 0;

        int[] temp = new int[end - start];
        while(i < mid && j<end){
            temp[tempInd++] = items[i] <= items[j] ? items[i++] : items[j++];
        }
        System.arraycopy(items, i, items, start + tempInd, mid - i);
        System.arraycopy(temp, 0, items, start, tempInd);
    }

    public void showItems(){
        for(int i: items){
            System.out.print(i + ",");
        }
    }
}
