package com.sjani.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalBT {

    public void levelOrderTraversal(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            root = q.poll();
            System.out.print(root.data+" ");
            if(root.left != null){
                q.add(root.left);
            }
            if (root.right != null){
                q.add(root.right);
            }
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
        LevelOrderTraversalBT lot = new LevelOrderTraversalBT();
        lot.levelOrderTraversal(head);
    }


}
