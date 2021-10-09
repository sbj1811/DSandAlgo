package com.sjani.java.DynamicProgramming;

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode implements Comparator<HuffmanNode> {
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        return o1.data - o2.data;
    }
}

public class HuffmanCoding {



    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFreq = { 5, 9, 12, 13, 16, 45 };
        int n = charArray.length;
        HuffmanNode root = null;

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new HuffmanNode());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c  = charArray[i];
            hn.data = charFreq[i];
            hn.left = null;
            hn.right =  null;
            q.add(hn);
        }

        while (q.size() > 1){
            HuffmanNode temp1 = q.poll();
            HuffmanNode temp2 = q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = temp1.data + temp2.data;
            f.c = '-';

            f.left =  temp1;
            f.right = temp2;
            root = f;
            q.add(f);
        }

        printCode(root,"");

    }

    private static void printCode(HuffmanNode root, String s) {
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c+" : "+s);
            return;
        }
        printCode(root.left, s+"0");
        printCode(root.right, s+"1");
    }

}
