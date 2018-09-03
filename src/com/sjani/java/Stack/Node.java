package com.sjani.java.Stack;

public class Node<T> {

    public T data;
    public Node next;
    public Node previous;

    public Node(T i) {
        this.data = i;
        this.next = null;
        this.previous = null;
    }

}