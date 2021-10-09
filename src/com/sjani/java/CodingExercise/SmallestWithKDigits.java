package com.sjani.java.CodingExercise;

public class SmallestWithKDigits {

    public static void main(String[] args) {
        System.out.println(smallestDigitNumber(1890676));
    }

    public static int smallestDigitNumber(int N){
        double digit = 1;
        while (N/10>0){
            N=N/10;
            digit++;
        }
        if(digit<=1){
            return 0;
        } else {
            return (int) Math.pow(10.0,digit-1);
        }
    }

}
