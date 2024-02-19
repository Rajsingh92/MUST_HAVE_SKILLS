/**
Wildcard Matching |  Hard | Adobe, Amazon, Facebook, Google, Microsoft |

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
 */

class Solution {
    // -1 -> default, 0 -> false, 1 -> true
    public int isMatch(String s, String p, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            if (n == 0 && m == 0)
                return dp[n][m] = 1;
            else if (m == 1 && p.charAt(m - 1) == '*')
                return dp[n][m] = 1;
            else
                return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(m - 1);

        if (ch1 == ch2 || ch2 == '?')
            return dp[n][m] = isMatch(s, p, n - 1, m - 1, dp);
        else if (ch2 == '*') {
            boolean res = false;
            res = res || (isMatch(s, p, n - 1, m, dp) == 1); // map to character
            res = res || (isMatch(s, p, n, m - 1, dp) == 1); // map to empty String

            return dp[n][m] = res ? 1 : 0;
        } else
            return dp[n][m] = 0;
    }

    public String removeStars(String s) {
        if (s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        int i = 1;
        while (i < s.length()) {
            while (i < s.length() && sb.charAt(sb.length() - 1) == '*' && s.charAt(i) == '*')
                i++;
            if (i < s.length())
                sb.append(s.charAt(i));
            i++;
        }

        return sb.toString();
    }

    public boolean isMatch(String s, String p) {
        p = removeStars(p);
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return isMatch(s, p, n, m, dp) == 1;
    }

    public boolean isMatch2(String s, String p) {

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if (i == dp.length - 1) {
                    dp[i][j] = false;
                } else if (j == dp[0].length - 1) {
                    if (p.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (p.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else if (p.charAt(i) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        if (p.charAt(i) == s.charAt(j)) {
                            dp[i][j] = dp[i + 1][j + 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }

        return dp[0][0];
    }
}
