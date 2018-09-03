package com.sjani.java.Tree;

import com.sjani.java.Stack.StackLinkedList;

import java.util.Stack;

public class TreeTraversals {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(2, head);
        head = bt.addNode(6, head);
        head = bt.addNode(5, head);
        head = bt.addNode(3, head);
        head = bt.addNode(8, head);
        head = bt.addNode(16, head);
        head = bt.addNode(19, head);
        head = bt.addNode(11, head);
        System.out.print("Height: ");
        System.out.println(bt.height(head));
        TreeTraversals tt = new TreeTraversals();
        System.out.println("Recursive Version:");
        System.out.print("Pre-order: ");
        tt.preOrder(head);
        System.out.println();
        System.out.print("Post-order: ");
        tt.postOrder(head);
        System.out.println();
        System.out.print("In-order: ");
        tt.inOrder(head);
        System.out.println();
        System.out.println("Iterative Version:");
        System.out.print("Pre-order: ");
        tt.iterativePreorder(head);
        System.out.println();
        System.out.print("Post-order: ");
        tt.iterativePostorder(head);
        System.out.println();
        System.out.print("In-order: ");
        tt.iterativeInorder(head);
        System.out.println();
        System.out.println("Min value in tree: "+bt.findMin(head));
        System.out.println("Max value in tree: "+bt.findMax(head));
    }

    // VLR
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // LRV
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // LVR
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void iterativePostorder(Node root){
        if (root == null) {
            return;
        }
        StackLinkedList<Node> s1 = new StackLinkedList<Node>();
        StackLinkedList<Node> s2 = new StackLinkedList<Node>();
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if(root.left != null){
                s1.push(root.left);
            }
            if(root.right != null){
                s1.push(root.right);
            }
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().data+" ");
        }
    }

    public void iterativePreorder(Node root) {
        if (root == null) {
            return;
        }
        StackLinkedList<Node> s1 = new StackLinkedList<Node>();
        s1.push(root);
        while(!s1.isEmpty()){
            root = s1.pop();
            System.out.print(root.data+" ");
            if(root.right != null){
                s1.push(root.right);
            }
            if(root.left != null){
                s1.push(root.left);
            }
        }

    }

    public void iterativeInorder(Node root) {
        if (root == null) {
            return;
        }
        StackLinkedList<Node> s1 = new StackLinkedList<Node>();
        while(true) {
            if (root != null) {
                s1.push(root);
                root = root.left;
            } else {
                if(s1.isEmpty()) {break;}
                root = s1.pop();
                System.out.print(root.data+" ");
                root = root.right;
            }
        }
    }
}
