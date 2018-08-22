package com.sjani.java.Stack;

import com.sjani.java.LinkedList.LinkedList;
import com.sjani.java.LinkedList.Node;

public class StackLinkedList extends LinkedList {

    Node top = null;

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(2);
        stack.push(8);
        stack.push(10);
        stack.printList(stack.top);
        stack.pop();
        stack.printList(stack.top);
        stack.push(15);
        stack.printList(stack.top);
    }

    public void push(int x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
    }

    public void pop() {
        if (top == null) return;
        top = top.next;
    }

}
