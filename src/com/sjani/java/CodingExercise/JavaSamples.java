package com.sjani.java.CodingExercise;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaSamples {
    static int num = 1111;
    static {
        num = num-- - --num;
        System.out.println(num);
    }

    {
        num = num++ + ++num;

    }

    public static void main(String[] args) {

        System.out.println(num);

    }
}
