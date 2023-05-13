/**
Longest Increasing Path in a Matrix

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally 
or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
 */

 
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int ans = longestIncreasingPath_MEMO(matrix, i, j, new int[matrix.length][matrix[0].length]);

                if (ans > max) {
                    max = ans;
                }
            }
        }

        return max;
    }

    public int longestIncreasingPath_MEMO(int[][] matrix, int r, int c, int[][] dp) {

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int max = 1;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int i = 0; i < 4; i++) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];

            if (nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]) {

                int ans = 1 + longestIncreasingPath_MEMO(matrix, nr, nc, dp);
                if (ans > max) {
                    max = ans;
                }
            }
        }

        dp[r][c] = max;
        return max;

    }
}
