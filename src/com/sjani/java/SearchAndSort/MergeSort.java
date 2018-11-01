package com.sjani.java.SearchAndSort;

import com.sjani.java.LinkedList.LinkedList;
import com.sjani.java.LinkedList.Node;

public class MergeSort<T extends Comparable<T>> {


    public static void main(String[] args) {
        MergeSort<Integer> ms = new MergeSort<Integer>();
        Integer arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        ms.mergeSort(arr);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(arr));
        LinkedList<Integer> ll = new LinkedList<>();
        Node head = null;
        head = ll.append(head,15);
        head = ll.append(head,10);
        head = ll.append(head,5);
        head = ll.append(head,20);
        head = ll.append(head,3);
        head = ll.append(head,2);
        ll.printList(head);
        ms.mergeSortLinkedList(head);
        ll.printList(head);
    }

    public void mergeSort(T[] arr) {
        int size = arr.length;
        if (size < 2) return;
        int mid = size / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[size - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private void merge(T[] arr, T[] left, T[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public Node mergeSortLinkedList(Node head){
        if(head == null || head.next == null) return head;
        int size = 0;
        Node p  = head;
        while(p != null){
            size++;
            p = p.next;
        }
        int mid = size/2;
        Node left = head, right = null;
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            Node next = current.next;
            if(count == mid){
                current.next = null;
                right =  next;
            }
            current =  next;
        }
        Node h1 = mergeSortLinkedList(left);
        Node h2 =  mergeSortLinkedList(right);
        return merge(h1,h2);
    }


    private Node merge(Node a, Node b){
        Node result = null;
        if(a == null) return b;
        if(b ==  null) return a;
        if(a.data.compareTo(b.data) <= 0){
            result = a;
            result.next = merge(a.next,b);
        } else {
            result = b;
            result.next =  merge(a,b.next);
        }
        return result;
    }

}
