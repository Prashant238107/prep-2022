package com.interviewprep.dp;

import com.interviewprep.common.CommonFunctions;
import com.interviewprep.common.Pair;

import java.math.BigInteger;
import java.util.*;

//Tree set is a sorted set
public class DPPractice {

    public static int uglyNumbers(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int currentIndex2 = 0;
        int currentIndex3 = 0;
        int currentIndex5 = 0;
        for (int i = 1; i < n; i++) {
            int nextMultiple2 = uglyNumbers[currentIndex2] * 2;
            int nextMultiple3 = uglyNumbers[currentIndex3] * 3;
            int nextMultiple5 = uglyNumbers[currentIndex5] * 5;
            int nextUglyNumber = Math.min(Math.min(nextMultiple2, nextMultiple3), nextMultiple5);
            if (nextUglyNumber == nextMultiple2) {
                currentIndex2++;
            }
            if (nextUglyNumber == nextMultiple3) {
                currentIndex3++;
            }
            if (nextUglyNumber == nextMultiple5) {
                currentIndex5++;
            }
            uglyNumbers[i] = nextUglyNumber;
        }
        return uglyNumbers[n - 1];
    }

    public static int uglyNumbersUsingTreeSet(int n) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        int count = 1;
        while (count < n) {
            int front = ts.pollFirst();
            ts.add(front * 2);
            ts.add(front * 3);
            ts.add(front * 5);
            count++;
        }

        return ts.first();
    }

    public static int nthSuperUglyNumber(int n, List<Integer> primeFactors) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        int count = 1;
        while (count < n) {
            int front = ts.pollFirst();
            for (int i = 0; i < primeFactors.size(); i++) {
                ts.add(primeFactors.get(i) * front);
            }
            count++;
        }
        return ts.pollFirst();
    }

    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int dpFibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static int dpFibonacciSpaceOptimized(int n) {
        int F0 = 0;
        int F1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = F0;
            F0 = F1;
            F1 = F1 + temp;
        }
        return F1;
    }

    public static int fibonacciPowerMatrix(int n) {
        int[][] powerMatrix = {{1, 1}, {1, 0}};
        if (n == 0) {
            return n;
        }
        int[][] finalMatrix = {{1, 1}, {1, 0}};
        for (int i = 1; i < n - 1; i++) {
            finalMatrix = CommonFunctions.multiplySquareMatrix(finalMatrix, powerMatrix);
        }
        return finalMatrix[0][0];
    }

    public static int fibonacciPowerMatrixOptimzed(int n) {
        int[][] powerMatrix = {{1, 1}, {1, 0}};
        if (n == 0) {
            return n;
        }
        int[][] finalMatrix = {{1, 1}, {1, 0}};
        for (int i = 1; i < (n - 1) / 2; i++) {
            finalMatrix = CommonFunctions.multiplySquareMatrix(finalMatrix, powerMatrix);
        }
        finalMatrix = CommonFunctions.multiplySquareMatrix(finalMatrix, finalMatrix);
        if ((n - 1) % 2 == 1) {
            finalMatrix = CommonFunctions.multiplySquareMatrix(finalMatrix, powerMatrix);
        }
        return finalMatrix[0][0];
    }

    public static BigInteger fibonacciOfBigNumber(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.valueOf(0);
        fib[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        return fib[n];
    }

    public static int nthCatalanNumber(int n) {
        int[] catalanNumber = new int[n + 1];
        catalanNumber[0] = 1;
        catalanNumber[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalanNumber[i] = catalanNumber[i] + catalanNumber[j] * catalanNumber[i - j - 1];
            }
        }
        return catalanNumber[n];
    }

    public static int partitionSet(int n) {
        int[][] setCount = new int[n + 1][n + 1];
        for (int elements = 0; elements <= n; elements++) {
            for (int sets = 0; sets <= n; sets++) {
                if (elements == 0 || sets == 0) {
                    setCount[elements][sets] = 0;
                } else if (sets == elements) {
                    setCount[elements][sets] = 1;
                } else if (sets > elements) {
                    setCount[elements][sets] = 0;
                } else {
                    //Add it as single element i.e. less element and less group
                    //Add is to each group as an individual element with one less element and divided into same number
                    setCount[elements][sets] = setCount[elements - 1][sets - 1] + sets * setCount[elements - 1][sets];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans = ans + setCount[n][i];
        }
        return ans;
    }

    public static int binomialCoefficient(int n, int k) {
        int[][] binomial = new int[n + 1][k + 1];
        if (k > n) {
            return 0;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (i == 0) {
                    binomial[i][j] = 0;
                } else if (j == 0 || i == j) {
                    binomial[i][j] = 1;
                } else {
                    binomial[i][j] = binomial[i - 1][j - 1] + binomial[i - 1][j];
                }
            }
        }
        return binomial[n][k];
    }

    public static int binomialCoefficientSpaceOptimized(int n, int k) {
        int[] binomial = new int[k + 1];
        binomial[0] = 1;
        //Pascal's Triangle
        for (int i = 0; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                binomial[j] = binomial[j - 1] + binomial[j];
            }
        }
        return binomial[k];
    }

    public static int permutationCoefficient(int n, int k) {
        int[][] permutations = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (i == 0 || j == 0) {
                    permutations[i][j] = 1;
                } else {
                    permutations[i][j] = permutations[i - 1][j] + j * permutations[i - 1][j - 1];
                }
            }
        }
        return permutations[n][k];
    }

    public static int fixTheFloor(int n) {
        int[] waysForTiling = new int[n + 1];
        waysForTiling[0] = 0;
        waysForTiling[1] = 1;
        waysForTiling[2] = 2;
        for (int i = 3; i <= n; i++) {
            waysForTiling[i] = waysForTiling[i - 1] + waysForTiling[i - 2];
        }

        return waysForTiling[n];
    }

    public static int goldMined(int[][] mines) {
        int columns = mines.length;
        int rows = mines[0].length;
        int[][] goldCollected = new int[rows][columns];
        for (int col = columns - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                int right = (col == (columns - 1)) ? 0 : goldCollected[row][col + 1];
                int top = (col == (columns - 1) || row == 0) ? 0 : goldCollected[row - 1][col + 1];
                int bottom = (row == (rows - 1) || col == (columns - 1)) ? 0 : goldCollected[row + 1][col + 1];
                goldCollected[row][col] = mines[row][col] + Math.max(Math.max(top, bottom), right);
            }
        }

        int max = goldCollected[0][0];
        for (int i = 1; i < mines[0].length; i++) {
            if (max < goldCollected[i][0]) {
                max = goldCollected[i][0];
            }
        }

        return max;
    }

    public static int changeArrangements(int[] change, int total) {
        int[] arrangements = new int[total + 1];
        Arrays.fill(arrangements, 0);
        arrangements[0] = 1;
        for (int i = 0; i < change.length; i++) {
            for (int j = change[i]; j <= total; j++) {
                arrangements[j] = arrangements[j] + arrangements[j - change[i]];
            }
        }
        return arrangements[total];
    }

    public static int friendPaired(int friends) {
        int[] pairs = new int[friends + 1];
        Arrays.fill(pairs, 0);
        pairs[0] = 1;
        pairs[1] = 1;
        for (int i = 2; i <= friends; i++) {
            pairs[i] = pairs[i - 1] + pairs[i - 2] * (i - 1);
        }
        return pairs[friends];
    }

    public static boolean subsetSum(int[] set, int sum) {
        boolean[][] sets = new boolean[sum + 1][set.length + 1];
        for (int i = 0; i <= sum; i++)
            sets[i][0] = false;
        for (int i = 0; i <= set.length; i++)
            sets[0][i] = true;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= set.length; j++) {
                //If the current element is not included in the sum
                //If the current element is included in the sum
                //Can not be a part of the combination or is bigger than the sum itself
                if (set[j - 1] > i) {//is bigger than the sum itself
                    sets[i][j] = sets[i][j - 1];
                } else {
                    sets[i][j] = sets[i][j - 1] /* current element is not included in the sum */
                            || sets[i - set[j - 1]][j - 1]/*current element is included in the sum*/;
                }
            }
        }
        return sets[sum][set.length];
    }

    public static boolean subsetSumOptimized(int[] set, int num) {
        boolean[] sets = new boolean[num + 1];
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= set.length; j++) {
                if (i == 0) {
                    sets[i] = true;
                } else if (j == 0) {
                    sets[i] = false;
                } else if (set[j - 1] > i) {
                    sets[i] = sets[i - 1];
                } else {
                    sets[i] = sets[i - 1] || sets[i - set[j - 1]];
                }
            }
        }
        return sets[num];
    }

    public static boolean subsetModulo(int[] set, int m) {
        //You can check it by taking a mod of each number with m
        //You will get values between 0 and m-1
        //Some combination will always be there as the number of elements is greater than the value
        if (set.length > m) {
            return true;
        }

        boolean[] sets = new boolean[m];
        Arrays.fill(sets, false);
        for (int i = 0; i < set.length; i++) {
            if (sets[0] == true) {
                return true;
            }
            boolean[] temp = new boolean[m];
            Arrays.fill(temp, false);
            for (int j = 0; j < m; j++) {
                if (sets[j] == true) {
                    if (sets[(j + set[i]) % m] == false) {
                        temp[(j + set[i]) % m] = true;
                    }
                }
            }
            for (int k = 0; k < m; k++) {
                if (temp[k]) {
                    sets[k] = true;
                }
            }
            sets[set[i] % m] = true;
        }
        return sets[0];
    }

    public static int largestDivisiblePairs(int[] input) {
        int[] pairs = new int[input.length];
        pairs[input.length - 1] = 1;
        for (int i = input.length - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] % input[i] == 0 || input[i] % input[j] == 0) {
                    max = Math.max(max, pairs[j]);
                }
            }
            pairs[i] = 1 + max;
        }
        return Arrays.stream(pairs).max().getAsInt();
    }

    public static void perfectSum(int[] set, int sum) {
        if (sum < 0 || set.length == 0) {
            return;
        }
        boolean[][] sumSet = new boolean[sum + 1][set.length + 1];
        for (int i = 0; i <= sum; i++)
            sumSet[i][0] = false;
        for (int i = 0; i <= set.length; i++)
            sumSet[0][i] = true;
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= set.length; j++) {
                //If the current element is not included in the sum
                //If the current element is included in the sum
                //Can not be a part of the combination or is bigger than the sum itself
                if (set[j - 1] > i) {//is bigger than the sum itself
                    sumSet[i][j] = sumSet[i][j - 1];
                } else {
                    sumSet[i][j] = sumSet[i][j - 1] /* current element is not included in the sum */
                            || sumSet[i - set[j - 1]][j - 1]/*current element is included in the sum*/;
                }
            }
        }

        if (!sumSet[sum][set.length]) {
            System.out.println("Sum is not possible");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        //We are starting from the last
        printSumPath(set, set.length, sum, path, sumSet);
    }

    //Need to be understood
    public static void printSumPath(int[] set, int length, int sum, ArrayList<Integer> path, boolean[][] sumSet) {
//        if (length == 0 && sum != 0 && sumSet[0][sum]) {
//            path.add(set[length]);
//            System.out.println("Print subset sum path" + path);
//            path.clear();
//            return;
//        }
//        if (length == 0 && sum == 0) {
//            System.out.println("Print subset sum path" + path);
//            path.clear();
//            return;
//        }
//        if (sumSet[length - 1][sum - 1]) {
//            ArrayList<Integer> pathNew = new ArrayList<>();
//            pathNew.addAll(path);
//            printSumPath(set, length - 1, sum, pathNew, sumSet);
//        }
//        if (sum >= set[length] && sumSet[length - 1][sum - set[length]]) {
//            path.add(set[length]);
//            printSumPath(set, length - 1, sum - set[length], path, sumSet);
//        }
    }

    public static int binomialCoefficientModulo(int n, int k, int p) {
        if (n - k < k) {
            k = n - k;
        }
        int[][] binomial = new int[2][k + 1];
        //Only two rows are required as only previous elements are required
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (i == 0) {
                    binomial[i % 2][j] = 0;
                } else if (j == 0 || i == j) {
                    binomial[i % 2][j] = 1;
                } else {
                    binomial[i % 2][j] = (binomial[(i - 1) % 2][j - 1] + binomial[(i - 1) % 2][j]) % p;
                }
            }
        }
        if (n % 2 == 0) {
            return binomial[0][k];
        }
        return binomial[1][k];
    }

    public static int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static int choiceArea(int startX, int startY, Area x, Area y, Area z, HashMap<Pair, Integer> path, int last) {
        if (startX < 0 || startY < 0) {
            return 0;
        }
        Pair pair = new Pair(startX, startY);
        if (path.containsKey(pair)) {
            return path.get(pair);
        }
        int temp = 0;

        switch (last) {
            case 1:
                temp = 1 + Math.max(
                        choiceArea(startX + y.a, startY + y.b, x, y, z, path, 2),
                        choiceArea(startX + z.a, startY + z.b, x, y, z, path, 3));
                break;
            case 2:
                temp = 1 + Math.max(
                        choiceArea(startX + x.a, startY + x.b, x, y, z, path, 1),
                        choiceArea(startX + z.a, startY + z.b, x, y, z, path, 3));
                break;
            case 3:
                temp = 1 + Math.max(
                        choiceArea(startX + x.a, startY + x.b, x, y, z, path, 1),
                        choiceArea(startX + y.a, startY + y.b, x, y, z, path, 2));
                break;
        }
        path.put(pair, temp);
        return temp;
    }

    public static int cutRod(int length, int[] prices) {
        int[] cost = new int[length + 1];
        cost[0] = 0;
        for (int i = 1; i <= length; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, prices[j] + cost[i - j - 1]);
            }
            cost[i] = max_val;
        }
        return cost[length];
    }

//Need to be understood
//    public static int tilingProblem(int n) {
//        int[] tiling = new int[n + 1];
//        return 0;
//    }

    public static int painting(int n, int k, int mod) {
        int[] colours = new int[n + 1];
        colours[0] = 0;
        colours[1] = k;
        int same = 0;
        int diff = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (colours[i - 1] * (k - 1)) % mod;
            colours[i] = (same + diff) % mod;
        }

        return colours[n];
    }

    public static int assemblyLines(int[][] assembly, int[][] time, int[] entry, int[] exit) {
        int[] T1 = new int[assembly.length];
        int[] T2 = new int[assembly.length];
        int i;
        T1[0] = entry[0] + assembly[0][0];
        T2[0] = entry[1] + assembly[1][0];

        for (i = 1; i < assembly.length; ++i) {
            T1[i] = Math.min(T1[i - 1] + assembly[0][i], T2[i - 1] + time[1][i] + assembly[0][i]);
            T2[i] = Math.min(T2[i - 1] + assembly[1][i], T1[i - 1] + time[0][i] + assembly[1][i]);
        }
        return Math.min(T1[assembly.length - 1] + exit[0], T2[assembly.length - 1] + exit[1]);
    }

    public static int lengthOfSnake(int[][] grid) {
        int[][] snake = new int[grid.length][grid[0].length];
        int maxLength = 0;
        int maxRow = 0;
        int maxColumn = 0;
        LinkedList<Pair> path = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != 0 || j != 0) {
                    if (i > 0 && Math.abs(grid[i - 1][j] - grid[i][j]) == 1) {
                        snake[i][j] = Math.max(snake[i - 1][j] + 1, snake[i][j]);
                    }
                    if (j > 0 && Math.abs(grid[i][j - 1] - grid[i][j]) == 1) {
                        snake[i][j] = Math.max(snake[i][j - 1] + 1, snake[i][j]);
                    }
                    if (maxLength < snake[i][j]) {
                        maxLength = snake[i][j];
                        maxRow = i;
                        maxColumn = j;

                    }
                }
            }
        }

        path.add(new Pair(maxRow, maxColumn));
        while (snake[maxRow][maxColumn] != 0) {
            if (maxRow > 0 && snake[maxRow][maxColumn] - 1 == snake[maxRow - 1][maxColumn]) {
                path.add(new Pair(maxRow - 1, maxColumn));
                maxRow--;
            }
            if (maxColumn > 0 && snake[maxRow][maxColumn] - 1 == snake[maxRow][maxColumn - 1]) {
                path.add(new Pair(maxRow, maxColumn - 1));
                maxColumn--;
            }
        }
        System.out.println("Path of the snake is");
        path.stream().forEach(n -> System.out.println(n.first + "," + n.second + " -> "));
        return maxLength;
    }

//Needs to be understood
//    public static int countDifferentNum(int n, int diff) {
//        int[][] difference = new int[n + 1][n + 2];
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= n; j++) {
//                if (i == 0) {
//                    difference[i][j] = 0;
//                } else if (j > i) {
//                    difference[i][j] = 0;
//                } else if (i == 1 && j == 0) {
//                    difference[i][j] = 2;
//                } else if (i == 1 && diff == 1) {
//                    difference[i][j] = 1;
//                } else {
//                    int res = 2 * difference[i - 1][j + 1] + (2 * difference[i - 1][j]);
//                    difference[i][j] = res;
//                }
//            }
//        }
//        return difference[n][diff];
//    }

    public static int lengthSequences(int length, int max) {
        int[][] sequences = new int[max + 1][length + 1];

        for (int i = 0; i < max + 1; i++) {
            for (int j = 0; j < length + 1; j++) {
                if (i == 0 || j == 0) {
                    sequences[i][j] = 0;
                } else if (i < j) {
                    sequences[i][j] = 0;
                } else if (j == 1) {
                    sequences[i][j] = i;
                } else {
                    sequences[i][j] = sequences[i - 1][j] + sequences[i / 2][j - 1];
                }
            }
        }
        return sequences[max][length];
    }

    public static int lengthOfCommonSubsequence(String input, String dup) {
        char[] inputArray = input.toCharArray();
        char[] dupArray = dup.toCharArray();
        int[][] commonSequence = new int[inputArray.length + 1][dupArray.length + 1];

        for (int i = 0; i <= inputArray.length; i++) {
            for (int j = 0; j <= dupArray.length; j++) {
                if (i == 0 || j == 0) {
                    commonSequence[i][j] = 0;
                } else if (inputArray[i - 1] == dupArray[j - 1]) {
                    commonSequence[i][j] = commonSequence[i - 1][j - 1] + 1;
                } else {
                    commonSequence[i][j] = Math.max(commonSequence[i - 1][j], commonSequence[i][j - 1]);
                }
            }
        }

        return commonSequence[inputArray.length][dupArray.length];
    }

    public static int longestIncreasingSubsequence(int[] input) {
        int[] sequence = new int[input.length];
        Arrays.fill(sequence, 1);
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && sequence[i] < sequence[j] + 1) {
                    sequence[i] = sequence[j] + 1;
                }
            }
        }
        return Arrays.stream(sequence).max().getAsInt();
    }

    public static void longestIncreasingSubsequencePrint(int[] input) {
        int[] sequence = new int[input.length];
        Arrays.fill(sequence, 1);

        Vector<Integer>[] elements = new Vector[input.length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Vector<Integer>();
        }
        elements[0].add(input[0]);
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && sequence[i] < sequence[j] + 1) {
                    sequence[i] = sequence[j] + 1;
                    elements[i] = (Vector<Integer>) elements[j].clone();
                }
            }
            elements[i].add(input[i]);
        }
        Vector<Integer> max = elements[0];
        for (Vector<Integer> x : elements) {
            if (x.size() > max.size()) {
                max = x;
            }
        }
        for (int x : max) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static int longestIncreasingSubsequenceOptimized(int[] v) {
        if (v.length == 0) {
            return 0;
        }
        int[] tail = new int[v.length];
        int length = 1;
        tail[0] = v[0];

        for (int i = 1; i < v.length; i++) {
            if (v[i] > tail[length - 1]) {
                tail[length] = v[i];
                length++;
            } else {
                int idx = Arrays.binarySearch(tail, 0, length - 1, v[i]);
                if (idx < 0) {
                    idx = -1 * idx - 1;
                }
                tail[idx] = v[i];
            }
        }
        return length;
    }

    public static void longestCommonSubsequencePrint(String input, String dup) {
        char[] inputChar = input.toCharArray();
        char[] dupChar = dup.toCharArray();
        int[][] lcs = new int[inputChar.length + 1][dupChar.length + 1];
        for (int i = 0; i <= inputChar.length; i++) {
            for (int j = 0; j <= dupChar.length; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (inputChar[i - 1] == dupChar[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        int lcsLength = lcs[inputChar.length][dupChar.length];
        char[] lcsValues = new char[lcsLength];
        int i = inputChar.length;
        int j = dupChar.length;
        while (i > 0 && j > 0) {
            if (inputChar[i - 1] == dupChar[j - 1]) {
                lcsValues[lcsLength - 1] = dup.charAt(j - 1);
                i--;
                j--;
                lcsLength--;
            } else if (lcs[i - 1][j] > lcs[i][j - 1])
                i--;
            else
                j--;
        }

        System.out.println("LCS of the two strings is " + Arrays.toString(lcsValues));
    }

//Needs to be understood
//    public static int longestCommonSubSequenceOptimized(String input, String dup) {
//        int[][] lcs = new int[2][input.length() + 1];
//        int currentRow = 0;
//        for (int i = 0; i <= input.length(); i++) {
//            currentRow = currentRow % 2;
//            currentRow++;
//            for (int j = 0; j <= dup.length(); j++) {
//                if (i == 0 || j == 0) {
//                    lcs[currentRow - 1][j - 1] = 0;
//                } else if (input.charAt(i - 1) == dup.charAt(j - 1)) {
//                    lcs[currentRow][j] = lcs[currentRow - 1][j - 1] + 1;
//                } else {
//                    lcs[currentRow][j] = Math.max(lcs[currentRow][j - 1], lcs[currentRow - 1][j]);
//                }
//            }
//        }
//        return lcs[currentRow - 1][input.length()];
//    }

    public static int longestRepeatingSequence(String input) {
        char[] inputArray = input.toCharArray();
        int[][] commonSequence = new int[inputArray.length + 1][inputArray.length + 1];

        for (int i = 0; i <= inputArray.length; i++) {
            for (int j = 0; j <= inputArray.length; j++) {
                if (i == 0 || j == 0) {
                    commonSequence[i][j] = 0;
                } else if (inputArray[i - 1] == inputArray[j - 1] && i != j) {
                    commonSequence[i][j] = commonSequence[i - 1][j - 1] + 1;
                } else {
                    commonSequence[i][j] = Math.max(commonSequence[i - 1][j], commonSequence[i][j - 1]);
                }
            }
        }

        return commonSequence[inputArray.length][inputArray.length];
    }

    public static void longestRepeatingSequencePrinting(String input) {
        char[] inputArray = input.toCharArray();
        int[][] commonSequence = new int[inputArray.length + 1][inputArray.length + 1];
        for (int i = 0; i <= inputArray.length; i++) {
            for (int j = 0; j <= inputArray.length; j++) {
                if (i == 0 || j == 0) {
                    commonSequence[i][j] = 0;
                } else if (inputArray[i - 1] == inputArray[j - 1] && i != j) {
                    commonSequence[i][j] = commonSequence[i - 1][j - 1] + 1;
                } else {
                    commonSequence[i][j] = Math.max(commonSequence[i - 1][j], commonSequence[i][j - 1]);
                }
            }
        }

        int length = commonSequence[inputArray.length][inputArray.length];
        char[] commonString = new char[length];
        int index = 0;
        int i = input.length(), j = input.length();
        while (i > 0 && j > 0) {
            if (commonSequence[i][j] == commonSequence[i - 1][j - 1] + 1) {
                commonString[index] = inputArray[i - 1];
                i--;
                j--;
                index++;
            } else if (commonSequence[i][j] == commonSequence[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        String reversedString = Arrays.toString(commonString)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println("Repeating sequence is " + CommonFunctions.reverseString(reversedString));
    }

    public static int maxSumBiotonicArray(int[] biotonic) {
        int[] maxSumLToR = new int[biotonic.length];
        int[] maxSumRToL = new int[biotonic.length];
        for (int i = 0; i < biotonic.length; i++) {
            maxSumRToL[i] = biotonic[i];
            maxSumLToR[i] = biotonic[i];
        }
        for (int i = 1; i < biotonic.length; i++) {
            for (int j = 0; j < i; j++) {
                if (biotonic[i] > biotonic[j] && maxSumRToL[i] < maxSumLToR[j] + biotonic[i]) {
                    maxSumRToL[i] = maxSumRToL[j] + biotonic[i];
                }
            }
        }
        for (int i = biotonic.length - 2; i >= 0; i--) {
            for (int j = biotonic.length - 1; j > i; j--) {
                if (biotonic[i] > biotonic[j] && maxSumLToR[i] < maxSumLToR[j] + biotonic[i]) {
                    maxSumLToR[i] = maxSumLToR[j] + biotonic[i];
                }
            }
        }
        int maxSum = 0;
        for (int i = 0; i < biotonic.length; i++) {
            maxSum = Math.max(maxSum, (maxSumRToL[i] + maxSumLToR[i] - biotonic[i]));
        }
        return maxSum;
    }

    public static int maxLengthBiotonicArray(int[] biotonic) {
        int[] maxLengthLToR = new int[biotonic.length];
        int[] maxLengthRToL = new int[biotonic.length];
        for (int i = 0; i < biotonic.length; i++) {
            maxLengthRToL[i] = 1;
            maxLengthLToR[i] = 1;
        }
        for (int i = 1; i < biotonic.length; i++) {
            for (int j = 0; j < i; j++) {
                if (biotonic[i] > biotonic[j] && maxLengthLToR[i] < maxLengthLToR[j] + 1) {
                    maxLengthLToR[i] = maxLengthLToR[j] + 1;
                }
            }
        }
        for (int i = biotonic.length - 2; i >= 0; i--) {
            for (int j = biotonic.length - 1; j > i; j--) {
                if (biotonic[i] > biotonic[j] && maxLengthRToL[i] < maxLengthRToL[j] + 1) {
                    maxLengthRToL[i] = maxLengthRToL[j] + 1;
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < biotonic.length; i++) {
            maxLength = Math.max(maxLength, (maxLengthRToL[i] + maxLengthLToR[i] - 1));
        }
        return maxLength;
    }

    public static int maxSumIncreasingSubsequence(int[] input) {
        int[] sum = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            sum[i] = input[i];
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && sum[i] < input[i] + sum[j]) {
                    sum[i] = input[i] + sum[j];
                }
            }
        }

        return Arrays.stream(sum).max().getAsInt();
    }

    public static int maxProductIncreasingSubsequence(int[] input) {
        int[] product = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            product[i] = input[i];
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && product[i] < input[i] * product[j]) {
                    product[i] = input[i] * product[j];
                }
            }
        }

        return Arrays.stream(product).max().getAsInt();
    }

    public static int setWithProductLessThanK(int[] input, int k) {
        int[][] setCount = new int[input.length + 1][k + 1];
        for (int i = 0; i <= input.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0) {
                    setCount[i][j] = 0;
                } else {
                    setCount[i][j] = setCount[i - 1][j];
                    if (input[i - 1] <= j && input[i - 1] > 0) {
                        setCount[i][j] = setCount[i][j] + (setCount[i - 1][j / input[i - 1]] + 1);
                    }
                }
            }
        }
        return setCount[input.length][k];
    }

    public static int sumWithNoThreeConsecutive(int[] input) {
        int[] sum = new int[input.length];
        sum[0] = input[0];
        sum[1] = input[1] + input[0];
        sum[2] = Math.max(sum[1], Math.max(input[0] + input[2], input[1] + input[2]));
        for (int i = 3; i < input.length; i++) {
            sum[i] = Math.max(Math.max(sum[i - 1], sum[i - 2] + input[i]), sum[i - 3] + input[i] + input[i - 1]);
        }
        return Arrays.stream(sum).max().getAsInt();
    }

    public static int sumWithNoAdjacentElement(int[] input) {
        int[] sum = new int[input.length];
        sum[0] = input[0];
        sum[1] = Math.max(input[0], input[1]);
        for (int i = 2; i < input.length; i++) {
            sum[i] = Math.max(sum[i - 2] + input[i], input[i - 1]);
        }

        return sum[input.length - 1];
    }

    public static int longestSubsequenceWithAdjacentConsecutive(int[] input) {
        int[] adjacent = new int[input.length];
        Arrays.fill(adjacent, 1);
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(input[i] - input[j]) == 1) {
                    adjacent[i] = Math.max(adjacent[j] + 1, adjacent[i]);
                }
            }
        }

        return Arrays.stream(adjacent).max().getAsInt();
    }

    public static int longestSubsequenceWithAdjacentConsecutiveOptimized(int[] input) {
        if (input.length == 1) {
            return 1;
        }
        int[] sequenceLength = new int[input.length];
        HashMap<Integer, Integer> mapValueAndIndex = new HashMap<>();
        sequenceLength[0] = 1;
        mapValueAndIndex.put(input[0], 0);
        for (int i = 1; i < input.length; i++) {
            if (Math.abs(input[i] - input[i - 1]) == 1) {
                sequenceLength[i] = sequenceLength[i - 1] + 1;
            } else if (mapValueAndIndex.containsKey(input[i] + 1) || mapValueAndIndex.containsKey(input[i] - 1)) {
                sequenceLength[i] = 1 + Math.max(mapValueAndIndex.getOrDefault(input[i] + 1, 0),
                        mapValueAndIndex.getOrDefault(input[i] - 1, 0));
            } else {
                sequenceLength[i] = 1;
            }
            mapValueAndIndex.put(input[i], sequenceLength[i]);
        }
        return Arrays.stream(sequenceLength).max().getAsInt();
    }

    public static int maxSumTillIndexAndIncludeKthElement(int[] input, int endIndex, int elementIncludedIndex) {
        int[] lis = new int[endIndex + 1];
        for (int i = 0; i <= endIndex; i++) {
            lis[i] = input[i] < input[elementIncludedIndex] ? input[i] : 0;
        }
        for (int i = 1; i <= endIndex; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j] && input[i] < input[elementIncludedIndex] && input[j] < input[elementIncludedIndex]) {
                    lis[i] = Math.max(lis[j] + input[i], lis[i]);
                }
            }
        }

        return Arrays.stream(lis).max().getAsInt() + input[elementIncludedIndex];
    }

    public static int maxChainOfPairs(Pair[] pairs) {
        Arrays.sort(pairs);
        int[] lis = new int[pairs.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j].second < pairs[i].first) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }

    public static void maxChainOfPairsPrinting(Pair[] pairs) {
        Arrays.sort(pairs);
        ArrayList<Pair>[] lis = new ArrayList[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            lis[i] = new ArrayList<Pair>();
            lis[i].add(pairs[i]);
        }
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j].second < pairs[i].first) {
                    int sizeWithJ = lis[j].size() + 1;
                    int currentSize = lis[i].size();
                    if (sizeWithJ > currentSize) {
                        lis[i].clear();
                        lis[i] = ((ArrayList<Pair>) lis[j].clone());
                        lis[i].add(pairs[i]);
                    }
                }
            }
        }

        int index = -1;
        int length = 0;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i].size() > length) {
                index = i;
                length = lis[i].size();
            }
        }

        System.out.println("Maximum length pairs are ");
        lis[index].forEach(pair -> {
            System.out.print("(" + pair.first + " , " + pair.second + ") ");
        });
    }

    public static int maxActivitiesAndPrint(Pair[] pairs) {
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return pair1.second > pair2.second ? 0 : -1;
            }
        });
        System.out.println("Maximum chain of activities printing ");
        System.out.print("(" + pairs[0].first + " , " + pairs[0].second + ") ");
        int index = 0;
        int count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i].first > pairs[index].second) {
                System.out.print("(" + pairs[i].first + " , " + pairs[i].second + ") ");
                index = i;
                count++;
            }
        }
        return count;
    }

    public static double maxAverage(int[][] matrix) {
        int[][] cost = new int[matrix.length][matrix.length];
        cost[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    cost[i][j] = cost[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    cost[i][j] = cost[i - 1][j] + matrix[i][j];
                } else {
                    cost[i][j] = Math.max(cost[i - 1][j], cost[i][j - 1]) + matrix[i][j];
                }
            }
        }
        System.out.println(cost[matrix.length - 1][matrix.length - 1]);
        return (double) cost[matrix.length - 1][matrix.length - 1] / (2 * matrix.length - 1);
    }

    public static int maxGames(int n) {
        int[] games = new int[n + 1];
        games[0] = 1;
        games[1] = 2;
        int i = 1;
        while (games[i++] < n) {
            games[i] = games[i - 1] + games[i - 2];
        }
        if (games[i - 1] == n) {
            return (i - 1);
        }
        return (i - 2);
    }

    public static int maxSumPathInTriangleSpaceOptimized(int[][] matrix) {
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i + 1][j + 1]) + matrix[i][j];
            }
        }
        return matrix[0][0];
    }

    public static int minSumPathInTriangleSpaceOptimized(int[][] matrix) {
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]) + matrix[i][j];
            }
        }
        return matrix[0][0];
    }
}