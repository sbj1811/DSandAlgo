package com.sjani.java.Queue;

// LinkedL List implementation of Queue

import com.sjani.java.Stack.Node;

import java.util.NoSuchElementException;

public class QueueLinkedList<T> {

    Node front, rear;
    int sizeOfQueue;

    public void offer(T t) {
        Node node = new Node(t);
        if (sizeOfQueue++ == 0) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    public T poll() {
        if (sizeOfQueue == 0) {
            throw new NoSuchElementException();
        }
        T t = (T) front.data;
        front = front.next;
        if (--sizeOfQueue == 0) rear = null;
        return t;
    }

    public boolean isEmpty() {
        if (front == null && rear == null) {
            return true;
        } else {
            return false;
        }
    }
}
