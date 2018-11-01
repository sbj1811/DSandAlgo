package com.sjani.java.LinkedList;

public class Node<T extends Comparable<T>> {

    public T data;
    public Node next;
    public Node previous;

    public Node(T i) {
        this.data = i;
        this.next = null;
        this.previous = null;
    }

}
