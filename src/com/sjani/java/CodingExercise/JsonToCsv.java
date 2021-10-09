package com.sjani.java.CodingExercise;



/**
 * JsonToCsv : JSON to CSV converter
 */
public class JsonToCsv {
    public static void main(String[] args) {

        String[] cards = {"371449635398431","6011111111111117","5555555555554444","4111111111111111"};
        for (String s: cards
             ) {
            System.out.println(CardTypeDetector.detect(s)+" : "+CardTypeDetector.Check(s));
        }

    }

}
