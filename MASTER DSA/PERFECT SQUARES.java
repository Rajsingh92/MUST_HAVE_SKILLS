/**
Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of 
some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
 */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {
        if (n <= 3) {
            return n;
        }

        if (dp[n - 1] != -1)
            return dp[n - 1];
        int min = n;

        for (int i = 1; i * i <= n; i++) {
            min = Math.min(1 + helper(n - i * i, dp), min);
        }

        dp[n - 1] = min;

        return dp[n - 1];
    }

    public int numSquares_DP(int n) {
        int[] dp = new int[n + 1]; 
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++) {
                if (dp[i - j * j] < min) {
                    min = dp[i - j * j];
                }
            }

            dp[i] = min + 1;

        }

        return dp[n];
    }

}