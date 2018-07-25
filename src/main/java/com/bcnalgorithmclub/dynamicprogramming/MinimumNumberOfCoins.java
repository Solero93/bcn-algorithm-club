package com.bcnalgorithmclub.dynamicprogramming;

public class MinimumNumberOfCoins {

    /*

        Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm}
        valued coins, what is the minimum number of coins to make the change?


        Input: coins[] = {25, 10, 5}, V = 30
        Output: Minimum 2 coins required
        We can use one coin of 25 cents and one of 5 cents

        Input: coins[] = {9, 6}, V = 11
        Output: Minimum 2 coins required
        We can use one coin of 6 cents and 1 coin of 5 cents
     */

    public static void main(String[] args) {
        int n = 11;
        int[] coins = new int[]{9, 6, 5, 1};
        int minNumberCoins = minimumNumberOfCoins(coins, n);

    }

    private static int minimumNumberOfCoins(int[] coins, int n) {
        int[] numberOfCoins = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            numberOfCoins[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    int leftover = i - coins[j];
                    int currentSolution = 1 + numberOfCoins[leftover];
                    if (currentSolution < numberOfCoins[i]) {
                        numberOfCoins[i] = currentSolution;
                    }
                }
            }
        }

        return numberOfCoins[n];
    }
}
