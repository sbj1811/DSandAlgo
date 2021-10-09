package com.sjani.java.Tree;

public class SizeBT {


    public int getSizeOfBT(Node root) {
        if(root == null) return 0;
        int leftSize = getSizeOfBT(root.left);
        int rightSize = getSizeOfBT(root.right);
        return leftSize +rightSize + 1;

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
        SizeBT sizeBT = new SizeBT();
        System.out.println("Size of Tree: "+sizeBT.getSizeOfBT(head));
    }

}
