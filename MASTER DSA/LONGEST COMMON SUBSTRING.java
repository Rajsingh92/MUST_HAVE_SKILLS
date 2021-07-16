/**
Longest Common Substring 

Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
 */

class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[S1.length() + 1][S2.length() + 1];
        int ans = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    // space optimization
    int longestCommonSubstr2(String S1, String S2, int n, int m) {
        int dp[][] = new int[2][m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                } else
                    dp[i % 2][j] = 0;

                ans = Math.max(ans, dp[i % 2][j]);
            }
        }
        return ans;
    }
}