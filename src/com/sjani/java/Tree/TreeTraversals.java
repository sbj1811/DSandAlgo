package com.sjani.java.Tree;

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
        System.out.print("Pre-order: ");
        tt.preOrder(head);
        System.out.println();
        System.out.print("Post-order: ");
        tt.postOrder(head);
        System.out.println();
        System.out.print("In-order: ");
        tt.inOrder(head);
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }
}
