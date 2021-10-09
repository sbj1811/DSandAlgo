package com.sjani.java.CodingExercise;

import java.util.ArrayList;
import java.util.List;

public class FindAllRectangles {

    static List<List<Integer>> output = new ArrayList<>();
    public static void main(String[] args) {
        int[][] tests = new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}};
        int size = tests.length;
        int index = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < tests[i].length; j++) {
                if (tests[i][j] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    output.add(temp);
                    index = index + 1;
                    findend(i, j, tests, index);
                }
            }
        }
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void findend(int i, int j, int[][] a, int index) {

        int x = a.length;
        int y = a[0].length;
        int flagc = 0;
        int flagr = 0;
        int m = 0;
        int n = 0;
        for (m = i; m < x; m++) {
            if (a[m][j] == 1) {
                flagr = 1;
                break;
            }
            if (a[m][j] == 5) {
                continue;
            }
            for (n = j; n < y; n++) {
                if (a[m][n] == 1) {
                    flagc = 1;
                    break;
                }
                a[m][n] = 5;
            }
        }

        if (flagr == 1) {
            output.get(index).add(m - 1);
        } else {
            output.get(index).add(m);
        }
        if (flagc == 1) {
            output.get(index).add(n - 1);
        } else {
            output.get(index).add(n);
        }
    }

}