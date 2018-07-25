package com.bcnalgorithmclub.warmup;

public class SumOfDiagonals {

    /*

    WarmUp

        Given a square matrix, calculate the absolute difference between the sums of its diagonals
        Print the absolute difference between the sums of the matrix's two diagonals as a single integer.

        Sample Input

        11 2   4
        4  5   6
        10 8 -12

        Sample Output
        15

        Sum across the secondary diagonal: 4 + 5 + 10 = 19
        Difference: |4 - 19| = 15

     */

    int solve(int[][] matrix) {
        int sumA = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sumA += matrix[i][i];
        }
        int sumB = 0;
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            sumB += matrix[matrix[0].length - i - 1][i];
        }
        return Math.abs(sumA - sumB);
    }
}
