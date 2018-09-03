package com.sjani.java.Heap;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private boolean isMin;
    private T[] items;
    private int capacity = DEFAULT_CAPACITY;

    public BinaryHeap(boolean isMin) {
        items = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.isMin = isMin;
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> minHeap = new BinaryHeap<Integer>(true);
        minHeap.add(3);
        minHeap.add(15);
        minHeap.add(7);
        minHeap.add(1);
        minHeap.add(99);
        minHeap.add(200);
        minHeap.add(4);
        minHeap.add(25);
        minHeap.add(999);
        minHeap.add(0);
        minHeap.add(29);
        System.out.println("MIN HEAP: " + minHeap.toString());
        BinaryHeap<Integer> maxHeap = new BinaryHeap<Integer>(false);
        maxHeap.add(3);
        maxHeap.add(15);
        maxHeap.add(7);
        maxHeap.add(1);
        maxHeap.add(99);
        maxHeap.add(200);
        maxHeap.add(4);
        maxHeap.add(25);
        maxHeap.add(999);
        maxHeap.add(0);
        maxHeap.add(29);
        System.out.println("MXN HEAP: " + maxHeap.toString());

    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private T leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private T rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private T parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int index1, int index2) {
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void resize() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException();
        return items[0];
    }

    public T poll() {
        if (isEmpty()) throw new IllegalStateException();
        T temp = items[0];
        items[0] = items[size - 1];
        size--;
        bubbleDown();
        return temp;
    }

    public void add(T item) {
        resize();
        items[size] = item;
        size++;
        bubbleUp();
    }

    private void bubbleDown() {
        int index = 0;
        if (isMin) {
            while (hasLeftChild(index)) {
                int smallChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                    smallChildIndex = getRightChildIndex(index);
                }
                if (items[index].compareTo(items[smallChildIndex]) > 0) {
                    swap(index, smallChildIndex);
                } else break;
                index = smallChildIndex;
            }
        } else {
            while (hasLeftChild(index)) {
                int greaterChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) > 0) {
                    greaterChildIndex = getRightChildIndex(index);
                }
                if (items[index].compareTo(items[greaterChildIndex]) < 0) {
                    swap(index, greaterChildIndex);
                } else break;
                index = greaterChildIndex;
            }
        }

    }

    private void bubbleUp() {
        int index = size - 1;
        if (isMin) {
            while (hasParent(index) && parent(index).compareTo(items[index]) > 0) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        } else {
            while (hasParent(index) && parent(index).compareTo(items[index]) < 0) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (T each : items) {
            if (each != null) s += each + " : ";
        }
        return s + "\n";

    }
}
