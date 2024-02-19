/**
Longest Repeating Subsequence 

Given a string str, find length of the longest repeating subseequence such that the two subsequence don’t have same 
string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in 
the original string.
 

Exampel 1:

Input: str = "axxxy"
Output: 2
Explanation: The longest repeating subsequenece
is "xx".
 */

public class Main {

    public static int LRS(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][n];
    }

    public static String printLRS(String str) {

        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        String res = "";
        int i = n, j = n;

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                res = res + str.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        String reverse = "";
        for (int k = res.length() - 1; k >= 0; k--) {
            reverse = reverse + res.charAt(k);
        }

        return reverse;
    }

}
