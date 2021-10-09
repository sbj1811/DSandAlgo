package com.sjani.java.Stack;

// LinkedL List implementation of Stack

public class StackLinkedList<T> {

    Node top = null;

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
        stack.push(2);
        stack.push(8);
        stack.push(10);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.push(15);
        stack.printStack();
    }

    public void push(T x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null) return null;
        Node temp = top;
        top = top.next;
        return (T) temp.data;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    public void printStack() {
        Node tmp = top;
        if (tmp == null) {
            System.out.println("null");
        }
        while (tmp != null) {
            System.out.print(tmp.data + ", ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
