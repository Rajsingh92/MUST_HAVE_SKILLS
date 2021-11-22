/**
Palindrome Partitioning II 

Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
 
Example 1:
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:
Input: s = "a"
Output: 0
 */

class Solution {
    public int minCut(String s) {
        boolean[][] strg = new boolean[s.length()][s.length()];

        for (int g = 0; g < strg.length; g++) {
            for (int i = 0, j = g; j < strg.length; i++, j++) {
                if (g == 0) {
                    strg[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        strg[i][j] = true;
                    } else {
                        strg[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        strg[i][j] = strg[i + 1][j - 1];
                    } else {
                        strg[i][j] = false;
                    }
                }
            }
        }

        int[] dp = new int[s.length()];
        dp[0] = 0;

        for (int j = 1; j < dp.length; j++) {

            if (strg[0][j]) {
                dp[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;

                for (int i = j; i >= 1; i--) {
                    if (strg[i][j]) {
                        if (dp[i - 1] < min) {
                            min = dp[i - 1];
                        }
                    }
                }

                dp[j] = min + 1;
            }

        }

        return dp[s.length() - 1];
    }

    // TLE
    public int minCut2(String s) {
        boolean[][] strg = new boolean[s.length()][s.length()];

        for (int g = 0; g < strg.length; g++) {
            for (int i = 0, j = g; j < strg.length; i++, j++) {
                if (g == 0) {
                    strg[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        strg[i][j] = true;
                    } else {
                        strg[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        strg[i][j] = strg[i + 1][j - 1];
                    } else {
                        strg[i][j] = false;
                    }
                }
            }
        }

        int[][] dp = new int[s.length()][s.length()];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (strg[i][j]) {
                        dp[i][j] = 0;
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            int left = dp[i][k];
                            int right = dp[k + 1][j];
                            int cost = 1 + left + right;

                            if (cost < min) {
                                min = cost;
                            }
                        }

                        dp[i][j] = min;
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}