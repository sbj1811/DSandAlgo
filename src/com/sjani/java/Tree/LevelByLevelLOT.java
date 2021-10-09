package com.sjani.java.Tree;

import com.sjani.java.Queue.QueueArray;
import com.sjani.java.Queue.QueueLinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class LevelByLevelLOT {

    public void levelByLevelTraversal2Queue(Node root) {
        if (root == null) return;
        QueueArray<Node> q1 = new QueueArray<Node>();
        QueueArray<Node> q2 = new QueueArray<Node>();
        q1.offer(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                root = q1.poll();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q2.offer(root.left);
                }
                if (root.right != null) {
                    q2.offer(root.right);
                }
            }
            System.out.println();
            while (!q2.isEmpty()) {
                root = q2.poll();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q1.offer(root.left);
                }
                if (root.right != null) {
                    q1.offer(root.right);
                }
            }
            System.out.println();
        }
    }

    public void levelByLevelTraversalQueueDelimiter(Node root) {
        if (root == null) return;
        QueueLinkedList<Node> q1 = new QueueLinkedList<Node>();
        q1.offer(root);
        q1.offer(null);
        while (!q1.isEmpty()) {
            root = q1.poll();
            if (root != null) {
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q1.offer(root.left);
                }
                if (root.right != null) {
                    q1.offer(root.right);
                }
            } else {
                if (!q1.isEmpty()) {
                    System.out.println();
                    q1.offer(null);
                }
            }
        }
    }

    public void levelByLevelTraversalQueueCount(Node root) {
        if (root == null) return;
        QueueArray<Node> q1 = new QueueArray<Node>();
        int levelCount = 1;
        int currentCount = 0;
        q1.offer(root);
        while (!q1.isEmpty()) {
            while (levelCount > 0) {
                root = q1.poll();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q1.offer(root.left);
                    currentCount++;
                }
                if (root.right != null) {
                    q1.offer(root.right);
                    currentCount++;
                }
                levelCount--;
            }
            System.out.println();
            levelCount =  currentCount;
            currentCount = 0;
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
        LevelByLevelLOT lot = new LevelByLevelLOT();
        lot.levelByLevelTraversal2Queue(head);
        lot.levelByLevelTraversalQueueDelimiter(head);
        System.out.println();
        System.out.println();
        lot.levelByLevelTraversalQueueCount(head);
    }


}
