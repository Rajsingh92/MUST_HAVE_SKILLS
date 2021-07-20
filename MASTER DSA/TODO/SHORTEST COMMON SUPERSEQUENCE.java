/**
Shortest Common Supersequence
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers
exist, you may return any of them.
(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are 
chosen anywhere from T) results in the string S.)

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.        
 */

class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] lookup = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lookup[i][j] = -1;
            }
        }
        // System.out.println(SCS_DP(str1,str2,m,n));
        // System.out.println(m+n-LCS_DP(str1,str2,m,n));
        return "";
    }

    public int SCS_rec(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return 1 + SCS_rec(str1, str2, m - 1, n - 1);
        } else {
            return Math.min(1 + SCS_rec(str1, str2, m - 1, n), 1 + SCS_rec(str1, str2, m, n - 1));
        }
    }

    public int SCS_MEMO(String text1, String text2, int m, int n, int[][] lookup) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (lookup[m - 1][n - 1] != -1) {
            return lookup[m - 1][n - 1];
        }

        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            lookup[m - 1][n - 1] = 1 + SCS_MEMO(text1, text2, m - 1, n - 1, lookup);
            return lookup[m - 1][n - 1];
        } else {
            lookup[m - 1][n - 1] = Math.min(1 + SCS_MEMO(text1, text2, m - 1, n, lookup),
                    1 + SCS_MEMO(text1, text2, m, n - 1, lookup));
            return lookup[m - 1][n - 1];
        }
    }

    public int SCS_DP(String text1, String text2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
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

    public static String printShortestSuperSeq(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j]);
                }
            }
        }

        int index = dp[m][n];
        String str = "";
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                str += (X.charAt(i - 1));
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str += (Y.charAt(j - 1));
                j--;
                index--;
            } else {
                str += (X.charAt(i - 1));
                i--;
                index--;
            }
        }

        while (i > 0) {
            str += (X.charAt(i - 1));
            i--;
            index--;
        }
        while (j > 0) {
            str += (Y.charAt(j - 1));
            j--;
            index--;
        }

        String reverse = "";
        for (int k = str.length() - 1; k >= 0; k--) {
            reverse = reverse + str.charAt(k);
        }

        return reverse;
    }

}