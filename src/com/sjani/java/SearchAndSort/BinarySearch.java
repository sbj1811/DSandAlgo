package com.sjani.java.SearchAndSort;

public class BinarySearch<T extends Comparable<T>> {

    public static void main(String[] args) {
        BinarySearch<Integer> bs = new BinarySearch<Integer>();
        Integer arr[] = {2, 3, 4, 10, 40};
        int len = arr.length;
        int item = 3;
        int result = bs.binarySearchRecursive(arr, 0, len - 1, item);
        if (result == -1)
            System.out.println("Item not found");
        else
            System.out.println("Found " + item + " at index " + result);
        int resultIterative = bs.binarySearchIterative(arr, 0, len - 1, item);
        if (resultIterative == -1)
            System.out.println("Item not found");
        else
            System.out.println("Found " + item + " at index " + resultIterative);
    }

    public int binarySearchRecursive(T arr[], int left, int right, T item) {
        if (arr == null) return -1;
        if (right < left) return -1;
        int mid = (left + right) / 2;
        if (arr[mid] == item) {
            return mid;
        }
        if (arr[mid].compareTo(item) > 0) {
            return binarySearchRecursive(arr, left, mid - 1, item);
        }
        return binarySearchRecursive(arr, mid + 1, right, item);
    }

    public int binarySearchIterative(T arr[], int left, int right, T item) {
        if (arr == null) return -1;
        int mid;
        while (right >= left) {
            mid = (left + right) / 2;
            if (arr[mid] == item) {
                return mid;
            }
            if (arr[mid].compareTo(item) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
