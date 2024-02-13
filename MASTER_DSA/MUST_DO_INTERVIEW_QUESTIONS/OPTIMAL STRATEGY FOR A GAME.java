/**
Optimal Strategy For A Game 

You are given an array A of size N. The array contains integers and is of even length. The elements of 
the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.

In each turn, a player selects either the first or last coin from the row, removes it from the row 
permanently, and receives the value of the coin.

You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:

Input:
N = 4
A[] = {5,3,7,10}
Output: 15
Explanation: The user collects maximum
value as 15(10 + 5)
 */



class solve {
    
    static long countMaximum(int nums[], int n) {
        long[][] dp = new long[nums.length][nums.length];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = nums[i];
                } else if (g == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    long val1 = (long) (nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]));
                    long val2 = (long) (nums[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));

                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }

        return dp[0][dp.length - 1];
    }
}