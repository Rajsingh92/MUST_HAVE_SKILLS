/**
Find number of times a string occurs as a subsequence in given string

Given two strings, find the number of times the second string occurs in the first string, whether continuous 
or discontinuous.

Examples: 

Input:  
string a = "GeeksforGeeks"
string b = "Gks"

Output: 4
 */

class Solution {
    int countWays(String S1, String S2) {

        int[][] dp = new int[S1.length()][S2.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // return countSubSeq(S1, S2, S1.length(), S2.length());
        return countSubSeq_MEMO(S1, S2, S1.length(), S2.length(), dp);
    }

    int countSubSeq(String str1, String str2, int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (n == 0) {
            return 1;
        }

        if (m == 0) {
            return 0;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return countSubSeq(str1, str2, m - 1, n - 1) + countSubSeq(str1, str2, m - 1, n);
        } else {
            return countSubSeq(str1, str2, m - 1, n);
        }
    }

    int countSubSeq_MEMO(String str1, String str2, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (n == 0) {
            return 1;
        }

        if (m == 0) {
            return 0;
        }

        if (dp[m - 1][n - 1] != -1) {
            return dp[m - 1][n - 1];
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            dp[m - 1][n - 1] = countSubSeq_MEMO(str1, str2, m - 1, n - 1, dp)
                    + countSubSeq_MEMO(str1, str2, m - 1, n, dp);
            return dp[m - 1][n - 1];
        } else {
            dp[m - 1][n - 1] = countSubSeq_MEMO(str1, str2, m - 1, n, dp);
            return dp[m - 1][n - 1];
        }
    }
}