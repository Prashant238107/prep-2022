package com.interviewprep.arrays;

public class ArrayUtils {
    public static void printArray(int[] input) {
        System.out.println("Printing Now");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ---> ");
        }
        System.out.println();
    }

    public static int[] reverseArray(int[] input, int startIndex, int endIndex) {
        int length = endIndex - startIndex + 1;
        for (int i = startIndex; i < length / 2; i++) {
            int temp = input[i];
            input[i] = input[length - 1 - i];
            input[length - 1 - i] = temp;
        }
        return input;
    }
}
