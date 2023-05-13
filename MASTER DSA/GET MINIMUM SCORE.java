/**
Get Minimum Squares 
Given a number N. Find the minimum number of squares of any number that sums to N. For Example: If N = 100 , N can be 
expressed as (10*10) and also as (5*5 + 5*5 + 5*5 + 5*5) but the output will be 1 as minimum number of square is 1 , 
i.e (10*10).
 

Example 1:

Input: N = 100
Output: 1
Explanation: 10 * 10 = 100
 */



class Solution {
    public int MinSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int rem = i - j * j;
                if (dp[rem] < min) {
                    min = dp[rem];
                }
            }

            dp[i] = min + 1;
        }

        return dp[n];
    }
}
