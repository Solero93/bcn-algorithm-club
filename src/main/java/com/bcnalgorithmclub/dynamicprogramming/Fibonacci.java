package com.bcnalgorithmclub.dynamicprogramming;

public class Fibonacci {

    /*
    The Fibonacci numbers are the numbers in the following integer sequence.

     0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,

      Fn = Fn-1 + Fn-2

      F0 = 0 and F1 = 1.

        Input  : n = 2
        Output : 1

        Input  : n = 9
        Output : 34

     */

    public static void main(String[] args) {

        int result = fib(9);
        int result1 = fibDP(9);
        System.out.println(result);
    }

    private static int fibDP(int i) {
        int[] array = new int[i + 1];
        array[0] = 0;
        array[1] = 1;

        for (int j = 2; j <= i; j++) {
            array[j] = array[j - 1] + array[j - 2];
        }

        return array[i];
    }

    private static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

}
