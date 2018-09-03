package com.sjani.java.Queue;


import java.util.NoSuchElementException;

// Array implementation of Queue with auto-resize

public class QueueArray<T> {

    T[] arr;
    int front, rear;
    int sizeOfQueue;

    public QueueArray() {
        arr = (T[]) new Object[2];
    }

    private void resize(int newCapacity) {
        T[] tmp = (T[]) new Object[newCapacity];
        for (int i = 0; i < sizeOfQueue; i++) {
            tmp[i] = arr[(front + i) % arr.length];
        }
        arr = tmp;
        front = 0;
        rear = sizeOfQueue;
    }

    public boolean isEmpty() {
        if (sizeOfQueue == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void offer(T t) {
        if (sizeOfQueue == arr.length) resize(arr.length * 2);
        arr[rear++] = t;
        if (rear == arr.length) rear = 0;
        sizeOfQueue++;
    }

    public T poll() {
        if (sizeOfQueue == 0) throw new NoSuchElementException();
        T t = arr[front];
        if (++front == arr.length) front = 0;
        if (--sizeOfQueue > 0 && sizeOfQueue == arr.length / 4) resize(arr.length / 2);
        return t;
    }

    public void printQueue() {
        System.out.println(java.util.Arrays.toString(arr));
    }

}
