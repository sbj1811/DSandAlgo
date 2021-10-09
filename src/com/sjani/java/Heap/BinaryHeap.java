package com.sjani.java.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private boolean isMin;
    private ArrayList<Node> items;
    private Map<T,Integer> nodePosition = new HashMap<>();
    private int capacity = DEFAULT_CAPACITY;

    public BinaryHeap(boolean isMin) {
        items = new ArrayList<>();
        this.isMin = isMin;
    }

    public void decrease(T data, int newWeight){
        Integer position = nodePosition.get(data);
        items.get(position).weight = newWeight;
        int parent = (position -1 )/2;
        while(parent >= 0){
            if(items.get(parent).weight > items.get(position).weight){
                swap(items.get(parent), items.get(position));
                updatePositionMap((T)items.get(parent).item,(T)items.get(position).item,parent,position);
                position = parent;
                parent = (parent-1)/2;
            }else{
                break;
            }
        }
    }

    public Integer getWeight(T key) {
        Integer position = nodePosition.get(key);
        if( position == null ) {
            return null;
        } else {
            return items.get(position).weight;
        }
    }

    private void updatePositionMap(T data1, T data2, int pos1, int pos2){
        nodePosition.remove(data1);
        nodePosition.remove(data2);
        nodePosition.put(data1, pos1);
        nodePosition.put(data2, pos2);
    }

    public boolean contains(T key){
        return nodePosition.containsKey(key);
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> minHeap = new BinaryHeap<Integer>(true);
        minHeap.add(03);
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
        System.out.println("MAX HEAP: " + maxHeap.toString());

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

    private Node leftChild(int index) {
        return items.get(getLeftChildIndex(index));
    }

    private Node rightChild(int index) {
        return items.get(getRightChildIndex(index));
    }

    private Node parent(int index) {
        return items.get(getParentIndex(index));
    }

    private void swap(Node node1,Node node2){
        int weight = node1.weight;
        T data = (T)node1.item;

        node1.item = node2.item;
        node1.weight = node2.weight;

        node2.item = data;
        node2.weight = weight;
    }


    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException();
        return (T)items.get(0).getItem();
    }

    public Node poll() {
        if (isEmpty()) throw new IllegalStateException();
        Node temp = items.get(0);
        items.set(0,items.get(size - 1));
        nodePosition.remove(temp.item);
        nodePosition.remove(items.get(0));
        nodePosition.put((T)items.get(0).item, 0);
        size--;
        bubbleDown();
        return temp;
    }

    public void add(int item){
        Node node = new Node<T>();
        node.item = item;
        node.weight = item;
        items.add(node);
        nodePosition.put((T)node.item, items.size() -1);
        size++;
        bubbleUp();
    }

    public void add(int weight, T item) {
        Node node = new Node<T>();
        node.item = item;
        node.weight = weight;
        items.add(node);
        nodePosition.put((T)node.item, items.size() -1);
        size++;
        bubbleUp();
    }

    private void bubbleDown() {
        int index = 0;
        if (isMin) {
            while (hasLeftChild(index)) {
                int smallChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index).weight < leftChild(index).weight) {
                    smallChildIndex = getRightChildIndex(index);
                }
                if (items.get(index).weight > items.get(smallChildIndex).weight) {
                    swap(items.get(index), items.get(smallChildIndex));
                } else break;
                index = smallChildIndex;
            }
        } else {
            while (hasLeftChild(index)) {
                int greaterChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index).weight > leftChild(index).weight) {
                    greaterChildIndex = getRightChildIndex(index);
                }
                if (items.get(index).weight < items.get(greaterChildIndex).weight) {
                    swap(items.get(index), items.get(greaterChildIndex));
                } else break;
                index = greaterChildIndex;
            }
        }

    }

    private void bubbleUp() {
        int index = size - 1;
        if (isMin) {
            while (hasParent(index) && parent(index).weight > items.get(index).weight) {
                swap(items.get(getParentIndex(index)), items.get(index));
                index = getParentIndex(index);
            }
        } else {
            while (hasParent(index) && parent(index).weight < items.get(index).weight) {
                swap(items.get(index), items.get(getParentIndex(index)));
                index = getParentIndex(index);
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Node each : items) {
            if (each != null) s += each.item + " : ";
        }
        return s + "\n";

    }
}
