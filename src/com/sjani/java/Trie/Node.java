package com.sjani.java.Trie;

import java.util.HashMap;
import java.util.Map;

public class Node {

    Map<Character, Node> children;
    boolean isAWord;

    public Node() {
        children = new HashMap<>();
        isAWord = false;
    }
}
