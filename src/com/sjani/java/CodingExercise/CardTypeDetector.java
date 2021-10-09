package com.sjani.java.CodingExercise;

public class CardTypeDetector {

    public static String detect(String  cardNumber){
        String cardType = "null";
        if(cardNumber.matches("^4[0-9]{12}(?:[0-9]{3})?$")){
            cardType = "visa";
        } else if(cardNumber.matches("^3[47][0-9]{13}$")){
            cardType = "american_express";
        } else if(cardNumber.matches("^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$")){
            cardType = "master_card";
        } else if(cardNumber.matches("^6(?:011|5[0-9]{2})[0-9]{12}$")){
            cardType = "discover";
        }
        return cardType;
    }

    public static boolean Check(String ccNumber)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

}
