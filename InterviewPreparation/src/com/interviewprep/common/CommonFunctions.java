package com.interviewprep.common;

public class CommonFunctions {
    public static void printArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void printSquareMatrix(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printSquareMatrix(boolean[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplySquareMatrix(int[][] M1, int[][] M2) {
        int[][] M3 = new int[M1.length][M1.length];
        for (int i = 0; i < M1.length; i++) {
            for (int j = 0; j < M1.length; j++) {
                M3[i][j] = 0;
                for (int k = 0; k < M1.length; k++) {
                    M3[i][j] = M3[i][j] + M1[i][k] * M2[k][j];
                }
            }
        }
        return M3;
    }

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length(); i > 0; i--) {
            reversed.append(input.charAt(i - 1)).append(" ");
        }
        return reversed.toString();
    }
}
