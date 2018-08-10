package com.sjani.java.Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {

    public boolean printSumPath(Node root, int sum, List<Node> result){
        if(root == null) return false;
        if(root.left == null && root.right==null){
            if (root.data == sum){
                result.add(root);
                return true;
            } else {
                return false;
            }
        }
        if (printSumPath(root.left,sum-root.data,result) || printSumPath(root.right,sum-root.data,result)){
            result.add(root);
            return true;
        }
        return false;
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
        RootToLeafSum rootToLeafSum = new RootToLeafSum();
        List<Node> result = new ArrayList<Node>();
        int findItem = 36;
        boolean pathFound = rootToLeafSum.printSumPath(head, findItem,result);
        if(pathFound) {
            for (Node n : result) {
                System.out.print("Height: ");
            }
        } else {
            System.out.print("No path for "+findItem);
        }

    }



}
