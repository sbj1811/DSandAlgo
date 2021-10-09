package com.sjani.java.CodingExercise;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 array = [“Ann", "Apple", "Boy”, “Dog”] prefix = "Ap"

 */

class FindPrefix {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("A", "Ab", "An", "Anm", "Ann"));
        int res = findPrefixWord(list, "Ann");
        System.out.println(res);

    }


    public static int findPrefixWord(List<String> list, String prefix) {
        int res = -1;
        if (list == null || list.size() < 1) return res;
        int start = 0;
        int end = list.size();
        int pivot = 0;
        while (start <= end) {
            pivot = start + (end - start) / 2;
            String word = list.get(pivot);
            if(word.length() >= prefix.length()){
                int isMatch = word.substring(0,prefix.length()).compareTo(prefix);
                System.out.println(word + ":" + start + ":" + pivot + ":" + end + " : " + isMatch);
                if (isMatch == 0) {
                    res = pivot;
                    break;
                } else if (isMatch > 0) {
                    end = pivot - 1;
                } else {
                    start = pivot + 1;
                }
            } else {
                if(word.compareTo(prefix.substring(0,word.length())) >= 0) {
                    start = pivot + 1;
                } else {
                    end = pivot - 1;
                }
            }

        }
        return res;
    }

}

