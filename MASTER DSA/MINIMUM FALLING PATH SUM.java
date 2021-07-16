/**
Minimum Falling Path Sum

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is 
either directly below or diagonally left/right. Specifically, the next element from position (row, col) 
will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum underlined below:
[[2,1,3],      [[2,1,3],
 [6,5,4],       [6,5,4],
 [7,8,9]]       [7,8,9]]
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (i == matrix.length - 1) {
                    dp[i][j] = matrix[i][j];
                } else if (j == matrix[i].length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.min(ans, dp[0][i]);
        }

        return ans;
    }
}