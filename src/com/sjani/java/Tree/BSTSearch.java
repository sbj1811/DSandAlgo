package com.sjani.java.Tree;

public class BSTSearch {

    public Node search (int key, Node root) {
        if (root == null){return null;}
        if (root.data == key){return root;}
        if (root.data < key) {
            return search(key,root.right);
        } else {
            return search(key,root.left);
        }
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
        BSTSearch bstSearch = new BSTSearch();
        Node result = null;
        int item = 9;
        result = bstSearch.search(item,head);
        if(result != null && result.data == item) {
            System.out.println("Found: "+item);
        } else {
            System.out.println(item+" Not Found");
        }
    }


}
