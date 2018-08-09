package com.sjani.java.Tree;

public class BinaryTree {

    public Node addNode(int data, Node root) {
        Node temp = root;
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return root;
        }
        Node previous = null;

        while (root != null) {
            previous = root;
            if (root.data < data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (previous.data < data) {
            previous.right = newNode;
        } else {
            previous.left = newNode;
        }
        return temp;
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

//    public List<List<String>> printTree(Node root) {
//        int height = height(root);
//        String[][] res = new String[height][(1 << height) - 1];
//        for(String[] arr:res)
//            Arrays.fill(arr,"");
//        List<List<String>> ans = new ArrayList<>();
//        fill(res, root, 0, 0, res[0].length);
//        for(String[] arr:res)
//            ans.add(Arrays.asList(arr));
//        return ans;
//    }
//    public void fill(String[][] res, Node root, int i, int l, int r) {
//        if (root == null)
//            return;
//        res[i][(l + r) / 2] = "" + root.data;
//        fill(res, root.left, i + 1, l, (l + r) / 2);
//        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
//    }
}
