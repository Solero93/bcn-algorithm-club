package com.bcnalgorithmclub.dynamicprogramming;

public class CommonSubquence {


    void longestCommonSub(String s1, String s2) {

        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty())
            return;


        int[][] subresults = new int[s1.length() + 1][s2.length() + 1];

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    subresults[i][j] = 0;
                else if (cs1[i - 1] == cs2[j - 1])
                    subresults[i][j] = subresults[i - 1][j - 1] + 1;
                else
                    subresults[i][j] = max(subresults[i - 1][j], subresults[i][j - 1]);

            }
        }

    }

    private int max(int i, int i1) {
        return i > i1 ? i : i1;
    }
}
