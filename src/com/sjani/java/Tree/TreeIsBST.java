package com.sjani.java.Tree;

public class TreeIsBST {

    public boolean checkBST(Node root){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.data <= min || root.data > max){
            return false;
        }
        return checkBST(root.left, min,root.data) && checkBST(root.right, root.data, max);
    }

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
        TreeIsBST TreeIsBST = new TreeIsBST();
        if(TreeIsBST.checkBST(head)) {
                System.out.print("Tree is a BST");
        } else {
            System.out.print("Tree is not a BST");
        }
    }
}
