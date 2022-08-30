package com.interviewprep.arrays;

import static com.interviewprep.arrays.ArrayUtils.reverseArray;
import static com.interviewprep.arrays.MathUtil.findHCF;

public class ArraysPractice {
    public static int[] rotateArrayUsingTempArray(int[] input, int rotateBy) {
        rotateBy = rotateBy % input.length;
        int[] tempArray = new int[rotateBy];
        for (int i = 0; i < rotateBy; i++) {
            tempArray[i] = input[i];
        }
        for (int i = 0; i < input.length - rotateBy; i++) {
            input[i] = input[i + rotateBy];
        }
        for (int i = 0; i < rotateBy; i++) {
            input[input.length - rotateBy + i] = tempArray[i];
        }
        return input;
    }

    public static int[] rotateOneByOne(int[] input, int rotateBy) {
        for (int i = 0; i < rotateBy; i++) {
            int temp = input[0];
            for (int j = 0; j < input.length - 1; j++) {
                input[j] = input[j + 1];
            }
            input[input.length - 1] = temp;
        }
        return input;
    }

    public static int[] rotateUsingJuggling(int[] input, int rotateBy) {
        int hcf = findHCF(input.length, rotateBy);
        for (int i = 0; i < hcf; i++) {
            int temp = input[i];
            int j = i;
            while (true) {
                int k = j + rotateBy;
                if (k >= input.length) {
                    k = k - input.length;
                }
                if (i == k) {
                    break;
                }
                input[j] = input[k];
                j = k;
            }
            input[j] = temp;
        }
        return input;
    }

    public static int[] rotateUsingReverseAlgorithm(int[] input, int rotateBy) {
        reverseArray(input, 0, rotateBy);
        reverseArray(input, rotateBy + 1, input.length - 1);
        reverseArray(input, 0, input.length - 1);
        return input;
    }

    public static int[] rotateUsingExchange(int[] input, int rotateBy) {
        int i = 0;
        int j = 0;
        return input;
    }

    public static int searchInSortedAndRotated(int[] input, int number) {
        int mid = 0;
        for (int i = 0; i < input.length - 1; i++) {

        }
        return mid;
    }
}
