package com.interviewprep.arrays;

public class MathUtil {
    public static int findHCF(int number1, int number2) {
        if (number2 == 0)
            return number1;
        else
            return findHCF(number2, number1 % number2);
    }
}
