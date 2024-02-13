/**
Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence.
A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted 
without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). 
A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.
Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
 */


class Solution {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] lookup = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    lookup[i][j] = -1;
                }
            }

            return LCS_DP(text1, text2, m, n);
        }

        public int LCS_MEMO(String text1, String text2, int m, int n, int[][] lookup) {
            if (m == 0 || n == 0) {
                return 0;
            }

            if (lookup[m - 1][n - 1] != -1) {
                return lookup[m - 1][n - 1];
            }

            if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                lookup[m - 1][n - 1] = 1 + LCS_MEMO(text1, text2, m - 1, n - 1, lookup);
                return lookup[m - 1][n - 1];
            } else {
                lookup[m - 1][n - 1] = Math.max(LCS_MEMO(text1, text2, m - 1, n, lookup),
                        LCS_MEMO(text1, text2, m, n - 1, lookup));
                return lookup[m - 1][n - 1];
            }
        }

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

        public int LCS3_DP(String text1, String text2, String text3, int m, int n, int o) {
            int[][][] dp = new int[m + 1][n + 1][o + 1];

            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    for (int k = 1; k < o + 1; k++) {
                        if (text1.charAt(i - 1) == text2.charAt(j - 1) && text1.charAt(j - 1) == text2.charAt(k - 1)) {
                            dp[i][j] = 1 + dp[i - 1][j - 1][k - 1];
                        } else {
                            dp[i][j] = Math.max(dp[i][j - 1][k], Math.max(dp[i - 1][j][k], dp[i][j][k - 1]));
                        }
                    }
                }
            }

            return dp[m][n][o];
        }

        public static void lcs(String X, String Y, int m, int n) {
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


            int index = dp[m][n];
            int temp = index;
            char[] lcs = new char[index + 1];
            lcs[index] = '\u0000'; // Set the terminating character

            int i = m;
            int j = n;
            while (i > 0 && j > 0) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcs[index - 1] = X.charAt(i - 1);
                    i--;
                    j--;
                    index--;
                }else if (L[i - 1][j] > L[i][j - 1]){
                    i--;
                }else{
                    j--;
                }   
            }

            for (int k = 0; k <= temp; k++)
                System.out.print(lcs[k]);
        }

    }
}

// Print Longest Common Sub Sequences Lexicographical Order
