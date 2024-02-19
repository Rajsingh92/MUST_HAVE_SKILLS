/**
Interleaving String |  Hard | Amazon, Apple, Microsoft |

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

Input: s1 = "", s2 = "", s3 = ""
Output: true
 */


class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return isInterleave(s1, s1.length(), s2, s2.length(), s3, s3.length(), dp);
    }

    public boolean isInterleave(String s1, int m, String s2, int n, String s3, int k, int[][] dp) {
        if (k == 0) {
            if (m == 0 && n == 0)
                return true;

            return false;
        }

        if (dp[m][n] >= 0) {
            return dp[m][n] == 1 ? true : false;
        }

        boolean case1 = m >= 1 && s1.charAt(m - 1) == s3.charAt(k - 1) && isInterleave(s1, m - 1, s2, n, s3, k - 1, dp);
        boolean case2 = n >= 1 && s2.charAt(n - 1) == s3.charAt(k - 1) && isInterleave(s1, m, s2, n - 1, s3, k - 1, dp);

        boolean ans = case1 || case2;
        if (ans) {
            dp[m][n] = 1;
        } else {
            dp[m][n] = 0;
        }

        return ans;
    }
}
