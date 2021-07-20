/**
Count Square Submatrices with All Ones

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
 */

class Solution {
    public int countSquares(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        int ans = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i == arr.length - 1 || j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j] == 1 ? 1 : 0;
                } else {
                    if (arr[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    }
                }
                ans += dp[i][j];
            }
        }

        return ans;
    }
}

