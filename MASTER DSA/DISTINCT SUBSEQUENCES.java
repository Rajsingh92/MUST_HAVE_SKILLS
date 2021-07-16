/**
Distinct Subsequences |  Hard | Google |

Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It is guaranteed the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
 */



class Solution {
    public int numDistinct_memo(String s, String t, int n, int m, int[][] dp) {
        if (m == 0) {
            return dp[n][m] = 1;
        }

        if (n < m) {
            return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            dp[n][m] = numDistinct_memo(s, t, n - 1, m - 1, dp) + numDistinct_memo(s, t, n - 1, m, dp);
        } else {
            dp[n][m] = numDistinct_memo(s, t, n - 1, m, dp);
        }

        return dp[n][m];
    }



    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);


        int ans = numDistinct_DP(s, t,n,m, dp);

        return ans;
    }
}


/*
// Distinct Subsequences II |  Hard | Google |
public class Q940 {
   // leetcode 940
   public static int distinctSubseqII(String str) {
       int mod = (int) 1e9 + 7;
       str = '$' + str;
       int n = str.length();
       long[] dp = new long[n];

       int[] loc = new int[26];

       dp[0] = 1;
       for (int i = 1; i < n; i++) {
           dp[i] = (2 * dp[i - 1] % mod) % mod;
           int idx = str.charAt(i) - 'a';

           if (loc[idx] != -1) {
               dp[i] = (dp[i] % mod - dp[loc[idx] - 1] % mod + mod) % mod;
           }

           loc[idx] = i;
       }

       return (int) dp[n - 1] % mod;

   }

}
*/