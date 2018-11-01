package com.sjani.java.SearchAndSort;

public class QuickSort<T extends Comparable<T>> {


    public void quickSort(T[] arr, int low, int high){
        if(arr == null || arr.length == 0){
            return;
        }
        if(low >= high) return;
        int mid = low + (high-low)/2;
        T pivot = arr[mid];
        int i = low, j = high;
        while(i<=j){
            while(arr[i].compareTo(pivot) < 0) i++;
            while(arr[j].compareTo(pivot) > 0) j--;
            if(i <= j){
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if(low < j) quickSort(arr,low,j);
        if(high > i) quickSort(arr,i,high);
    }

    public static void main(String[] args) {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        qs.quickSort(arr,0,arr.length-1);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
    }

}
