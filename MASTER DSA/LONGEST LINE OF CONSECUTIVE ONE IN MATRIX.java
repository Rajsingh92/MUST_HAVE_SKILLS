/**
Longest Line of Consecutive One in Matrix

Given a 01 matrix, find the longest line of consecutive 1 in the matrix. The line could be horizontal, vertical, diagonal 
or anti-diagonal.

The number of elements in the given matrix will not exceed 10,000.

Example
Example 1:

Input: 
  [[0,1,1,0],
   [0,1,1,0],
   [0,0,0,1]]
Output: 3
Explanation: (0,1) (1,2) (2,3)
 */

public class Solution {

    public int longestLine(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][][] dp = new int[m + 1][n + 2][4]; // h,d,v,ad
        int ans = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (mat[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j - 1][1] + 1;
                    dp[i][j][2] = dp[i - 1][j][2] + 1;
                    dp[i][j][3] = dp[i - 1][j + 1][3] + 1;

                    ans = Math.max(ans,
                            Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));
                }
            }
        }

        return ans;
    }
}
