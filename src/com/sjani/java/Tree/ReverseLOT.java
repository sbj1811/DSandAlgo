package com.sjani.java.Tree;

import com.sjani.java.Queue.QueueArray;
import com.sjani.java.Queue.QueueLinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLOT {

    public void levelByLevelTraversal(Node root){
        if(root == null) return;
        QueueLinkedList<Node> q = new QueueLinkedList<Node>();
        Stack<Node> s = new Stack<Node>();
        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.right != null) q.offer(root.right);
            if(root.left != null) q.offer(root.left);
            s.push(root);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop().data + " ");
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
        ReverseLOT lot = new ReverseLOT();
        lot.levelByLevelTraversal(head);
    }
}
