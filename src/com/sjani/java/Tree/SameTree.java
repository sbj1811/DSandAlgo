package com.sjani.java.Tree;

public class SameTree {

    public boolean findSameTree(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return root1.data == root2.data && findSameTree(root1.left,root2.left) && findSameTree(root1.right,root2.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root1 = null;
        root1 = bt.addNode(10, root1);
        root1 = bt.addNode(2, root1);
        root1 = bt.addNode(6, root1);
        root1 = bt.addNode(5, root1);
        root1 = bt.addNode(3, root1);

        Node root2 = null;
        root2 = bt.addNode(10, root2);
        root2 = bt.addNode(2, root2);
        root2 = bt.addNode(6, root2);
        root2 = bt.addNode(5, root2);
        root2 = bt.addNode(3, root2);

        SameTree sameTree = new SameTree();
        if(sameTree.findSameTree(root1,root2)) {
            System.out.println("Trees are same");
        } else {
            System.out.println("Tress are different");
        }
    }

}
