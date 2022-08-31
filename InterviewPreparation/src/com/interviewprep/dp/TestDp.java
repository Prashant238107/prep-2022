package com.interviewprep.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDp {
    public static void main(String[] args) {
        System.out.println("Ugly 150th number is " + DPPractice.uglyNumbers(150));

        System.out.println("Ugly 150th number is " + DPPractice.uglyNumbersUsingTreeSet(150));

        List<Integer> primeFactors = new ArrayList<>();
        primeFactors.add(2);
        primeFactors.add(5);
        System.out.println("5th super ugly number is " + DPPractice.nthSuperUglyNumber(5, primeFactors));

        primeFactors.add(3);
        System.out.println("150th super ugly number is " + DPPractice.nthSuperUglyNumber(150, primeFactors));

        System.out.println("9th Fibonacci number is " + DPPractice.recursiveFibonacci(9));

        System.out.println("9th Fibonacci number is " + DPPractice.dpFibonacci(9));

        System.out.println("9th Fibonacci number is " + DPPractice.dpFibonacciSpaceOptimized(9));

        System.out.println("9th Fibonacci number is " + DPPractice.fibonacciPowerMatrix(9));

        System.out.println("9th Fibonacci number is " + DPPractice.fibonacciPowerMatrixOptimzed(9));

        System.out.println("9th Fibonacci number is " + DPPractice.fibonacciOfBigNumber(100));

        for (int i = 4; i < 10; i++) {
            System.out.println(i + "th Catalan number is " + DPPractice.nthCatalanNumber(i));
        }

        System.out.println("Number of ways to split a set of 5 elements " + DPPractice.partitionSet(5));

        System.out.println("5C2 is " + DPPractice.binomialCoefficient(5, 2));

        System.out.println("5C2 is " + DPPractice.binomialCoefficientSpaceOptimized(5, 2));

        System.out.println("10P2 is " + DPPractice.permutationCoefficient(10, 2));

        System.out.println("Ways to tile a floor of 2X4 by 2X1 tiles is " + DPPractice.fixTheFloor(4));
        System.out.println("Ways to tile a floor of 2X3 by 2X1 tiles is " + DPPractice.fixTheFloor(3));

        int[][] gold = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
        System.out.println("Maximum gold mined is " + DPPractice.goldMined(gold));

        int[] change = {1, 2, 3};
        int total = 4;
        System.out.println("Maximum arrangements for a total of " + total + " is " + DPPractice.changeArrangements(change, total));

        System.out.println("No of groups for 4 friends is " + DPPractice.friendPaired(4));

        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 33;
        System.out.println("Subset with sum equal to " + sum +
                (DPPractice.subsetSum(set, sum) == true ? " exists" : " doesn't exist"));
        sum = 9;
        System.out.println("Subset with sum equal to " + sum +
                (DPPractice.subsetSum(set, sum) == true ? " exists" : " doesn't exist"));

        int[] set1 = {3, 34, 4, 12, 5, 2};
        int sum1 = 33;
        System.out.println("Subset with sum equal to " + sum1 +
                (DPPractice.subsetSumOptimized(set1, sum1) == true ? " exists" : " doesn't exist"));
        sum1 = 9;
        System.out.println("Subset with sum equal to " + sum1 +
                (DPPractice.subsetSumOptimized(set1, sum1) == true ? " exists" : " doesn't exist"));

        int[] arr = {1, 7};
        int m = 5;
        System.out.println("Modular sum is possible " + ((DPPractice.subsetModulo(arr, 5) == true) ? "Yes" : "No"));
        System.out.println("Modular sum is possible " + ((DPPractice.subsetModulo(arr, 4) == true) ? "Yes" : "No"));

        int[] largestSubsetPairsDivisible = {1, 3, 6, 13, 17, 18};
        System.out.println("Largest subset pairs divisible is " + DPPractice.largestDivisiblePairs(largestSubsetPairsDivisible));

        //Left
        DPPractice.perfectSum(set1, sum1);

        System.out.println("10C2%13 is equal to " + DPPractice.binomialCoefficientModulo(10, 2, 13));

        DPPractice.Area x = new DPPractice.Area(3, 2);
        DPPractice.Area y = new DPPractice.Area(-5, -10);
        DPPractice.Area z = new DPPractice.Area(-20, 5);
        int a = 20;
        int b = 8;
        HashMap<DPPractice.Pair, Integer> path = new HashMap<>();
        System.out.println("Maximum chances of survival path" +
                DPPractice.maxOfThree(
                        DPPractice.choiceArea(a + x.a, b + x.b, x, y, z, path, 1),
                        DPPractice.choiceArea(a + y.a, b + y.b, x, y, z, path, 2),
                        DPPractice.choiceArea(a + z.a, b + z.b, x, y, z, path, 3)));

        int[] costs = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = costs.length;
        System.out.println("Maximum price of the rod " + DPPractice.cutRod(size, costs));

        System.out.println("Paint 3 posts with 2 colours " + DPPractice.painting(3, 2, 1000000007));

        int[][] assembly = {
                {4, 5, 3, 2},
                {2, 10, 1, 4}};
        int[][] time = {
                {0, 7, 4, 5},
                {0, 9, 2, 8}};
        int[] entry = {10, 12};
        int[] exit = {18, 7};
        System.out.println("Minimum time taken out of two assembly " + DPPractice.assemblyLines(assembly, time, entry, exit));

        int[][] snake = {
                {9, 6, 5, 2},
                {8, 7, 6, 5},
                {7, 3, 1, 6},
                {1, 1, 1, 7}};
        System.out.println("Maximum length of the snake is " + DPPractice.lengthOfSnake(snake));

        //System.out.println("Count of sequences is " + DPPractice.countDifferentNum(2, 0));

        System.out.println("Maximum sequences for maximum value of 10 and length of sequence equal to 4 is " + DPPractice.lengthSequences(4, 10));

        System.out.println("Length of common subsequence is " + DPPractice.lengthOfCommonSubsequence("GEEKS", "FREAKS"));

        int[] longestIncreasingSubsequence = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Maximum length of longest increasing subsequence is " + DPPractice.longestIncreasingSubsequence(longestIncreasingSubsequence));

        System.out.println("Printing longest increasing subsequence ");
        DPPractice.longestIncreasingSubsequencePrint(longestIncreasingSubsequence);

        System.out.println("Maximum length of longest increasing subsequence is " + DPPractice.longestIncreasingSubsequenceOptimized(longestIncreasingSubsequence));

        DPPractice.longestCommonSubsequencePrint("GEEKS", "FREAKS");

        //System.out.println("Length of common subsequence is " + DPPractice.longestCommonSubSequenceOptimized("GEEKS", "FREAKS"));

        System.out.println("Length of longest repeating sequence " + DPPractice.longestRepeatingSequence("AABEBCDD"));

        DPPractice.longestRepeatingSequencePrinting("AABEBCDD");

        int[] maxSumBiotonic = {1, 15, 51, 45, 33, 100, 12, 18, 9};
        System.out.println("Maximum Sum of biotonic array is " + DPPractice.maxSumBiotonicArray(maxSumBiotonic));

        int[] maxLengthBiotonic = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println("Maximum Length of biotonic array is " + DPPractice.maxLengthBiotonicArray(maxLengthBiotonic));

        int[] maxSumSubsequence = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("Maximum sum increasing subsequence is " + DPPractice.maxSumIncreasingSubsequence(maxSumSubsequence));

        int[] maxProductSubsequence = {3, 100, 4, 5, 150, 6};
        System.out.println("Maximum product increasing subsequence is " + DPPractice.maxProductIncreasingSubsequence(maxProductSubsequence));

        int[] setWithProductLessThanK = {1, 2, 3, 4};
        int k = 10;
        System.out.println("Number of sets with product less than " + k + " is " + DPPractice.setWithProductLessThanK(setWithProductLessThanK, k));

        int[] sumWithNoThreeConsecutive = {100, 1000, 100, 1000, 1};
        System.out.println("Maximum sum with no three consecutive " + DPPractice.sumWithNoThreeConsecutive(sumWithNoThreeConsecutive));

        int[] maxSumWithNoAdjacent = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println("Maximum sum with no adjacent elements " + DPPractice.sumWithNoAdjacentElement(maxSumWithNoAdjacent));
    }
}
