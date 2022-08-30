package com.interviewprep.arrays;

public class TestArraysPractice {
    public static void main(String[] args) {
        int[] inputRotateArrayUsingTempArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] rotatedArrayUsingTempArray = ArraysPractice.rotateArrayUsingTempArray(inputRotateArrayUsingTempArray, 3);
        ArrayUtils.printArray(rotatedArrayUsingTempArray);

        int[] inputRotateOneByOne = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] rotatedArrayOneByOne = ArraysPractice.rotateOneByOne(inputRotateOneByOne, 3);
        ArrayUtils.printArray(rotatedArrayOneByOne);

        int[] inputForJuggling = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] rotateArrayJuggling = ArraysPractice.rotateUsingJuggling(inputForJuggling, 7);
        ArrayUtils.printArray(rotateArrayJuggling);

        int[] inputForReverse = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reversedArray = ArraysPractice.rotateUsingReverseAlgorithm(inputForReverse, 3);
        ArrayUtils.printArray(reversedArray);

        int[] inputForExhangeArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] reversedArrayAfterExchange = ArraysPractice.rotateUsingExchange(inputForExhangeArray, 3);
        ArrayUtils.printArray(reversedArrayAfterExchange);

        int[] rotatedArray = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        int index = ArraysPractice.searchInSortedAndRotated(rotatedArray, 8);
        System.out.println("Index is " + index);


    }
}
