/**
Minimum Cost To Make Two Strings Identical 

Given two strings X and Y, and two values costX and costY, the task is to find the minimum cost required to make the given two 
strings identical. You can delete characters from both the strings. The cost of deleting a character from string X is costX 
and from Y is costY. The cost of removing all characters from a string is the same.

Example 1:

Input: X = "abcd", Y = "acdb", costX = 10 
       costY = 20.
Output: 30
Explanation: For Making both strings 
identical we have to delete character 
'b' from both the string, hence cost 
will be = 10 + 20 = 30.
 */

class Solution {
    public int LCS_DP(String text1, String text2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public int findMinCost(String X, String Y, int costX, int costY) {
        int m = X.length();
        int n = Y.length();
        int lcs = LCS_DP(X, Y, m, n);
        return costX * (m - lcs) + costY * (n - lcs);
    }
}