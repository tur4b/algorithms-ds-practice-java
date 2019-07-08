package com.problem.max_subarray_sum;

public class MaxSubArraySum {

    private int size;
    private int[] items;

    public MaxSubArraySum(int size, int[] items) {
        this.size = size;
        this.items = items;
    }

    public int[] showArr(){
        return this.items;
    }

    //4,-2,3,-5
    //brute-force - O(n^2) time complexity
    public String max_subarray_sum_brute_force(){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < items.length - 1; i++){

            int sum = items[i];
            for(int j = i + 1; j < items.length; j++){
                sum += items[j];
                if(sum > max) max = sum;
            }
        }
        return "Max: " + max;
    }

    //TODO: apply divide and conquer methodology - with O(n*lgn) time complexity
    public String max_subarray_sum_divide_conquer(){
        return "";
    }

    //Kadane's algorithm - O(n) time complexity
    public String max_subarray_sum_kadane(){
        int c_max = 0;
        int g_max = 0;
        for(int i = 0;i < items.length; i++){
            c_max += items[i];
            if(c_max < 0) c_max = 0;
            else if(c_max > g_max) g_max = c_max;
        }
        return "Max: " + g_max;
    }
}
