/**
Minimum Insertion Steps to Make a String Palindrome

Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 */


class Solution {

    public static int minimumInsertionPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 0;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
