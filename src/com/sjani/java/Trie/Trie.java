package com.sjani.java.Trie;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.children.get(ch);
            if (node == null) {
                node = new Node();
                node.children.put(ch, node);
            }
            current = node;
        }
        current.isAWord = true;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isAWord;
    }

    public void delete(String word) {
        deleteUtil(root, word, 0);
    }

    private boolean deleteUtil(Node current, String word, int index) {
        if (index == word.length()) {
            if (!current.isAWord) {
                return false;
            }
            current.isAWord = false;
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        Node node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = deleteUtil(node, word, index + 1);
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }
}
