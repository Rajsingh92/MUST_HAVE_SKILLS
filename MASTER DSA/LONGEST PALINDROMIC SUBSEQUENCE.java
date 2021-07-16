/**
Longest Palindromic Subsequence  | Apple, Microsoft |

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
without changing the order of the remaining elements.


Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
 */

import java.util.*;

class Solution {
    public int longestPalindromeSubseq(String str) {
        int m = str.length();
        int[][] dp = new int[m][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return lps(str, 0, str.length() - 1, dp);
    }

    public static int lps(String str, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        char ch1 = str.charAt(i);
        char ch2 = str.charAt(j);

        if (ch1 == ch2) {
            dp[i][j] = lps(str, i + 1, j - 1, dp) + 2;
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(lps(str, i, j - 1, dp), lps(str, i + 1, j, dp));
            return dp[i][j];
        }
    }

    public static int longestPalindromeSubseq_DP(String str) {
        int n = str.length();
        int dp[][] = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j))
                        dp[i][j] = 2;
                    else
                        dp[i][j] = 1;
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] != 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    // Minimum Deletions To Make Palindromic Sequence
    public static int minimumDeletionsToPalindrome(String str) {
        int lps = longestPalindromeSubseq_DP(str);
        return str.length() - lps;
    }
}


// Print Longest Palindromic Subsequence
// Longest Palindromic Subsequence II	

