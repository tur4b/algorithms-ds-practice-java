package com.problem.search.binary;

public class BinarySearch {

    //binary search using normal loop
    public static boolean binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length;

        while(low<=high){
            int mid = (low + high)/2;

            if(arr[mid] == target) return true;
            else if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    //binary search with recursion - you are best! :)
    public static boolean binarySearch_Recursion(int[] arr, int low, int high, int target){
        int mid = (low + high)/2;
        if(low>high) return false;
        if(arr[mid] == target) return true;
        if(arr[mid] < target)
            return binarySearch_Recursion(arr, mid+1,  high, target);
        if(arr[mid] > target)
            return binarySearch_Recursion(arr, low, mid-1, target);

        return false;
    }

}
