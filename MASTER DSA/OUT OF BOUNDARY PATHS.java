/**
Out of Boundary Paths

There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. 
You are allowed to move the ball to one of the four adjacent four cells in the grid (possibly out of the grid 
crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out 
of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
 */

import java.util.*;

class Solution {
    int MOD = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[m][n][N + 1];

        for (int[][] mat : dp)
            for (int[] arr : mat)
                Arrays.fill(arr, -1);

        return findPaths(m, n, N, i, j, dp);
    }

    public int findPaths(int m, int n, int N, int i, int j, int[][][] dp) {
        if (i == m || j == n || i < 0 || j < 0)
            return 1;
        if (N == 0)
            return 0;

        if (dp[i][j][N] >= 0)
            return dp[i][j][N] % MOD;

        int ans = 0;
        ans = (ans + findPaths(m, n, N - 1, i - 1, j, dp)) % MOD;
        ans = (ans + findPaths(m, n, N - 1, i + 1, j, dp)) % MOD;
        ans = (ans + findPaths(m, n, N - 1, i, j - 1, dp)) % MOD;
        ans = (ans + findPaths(m, n, N - 1, i, j + 1, dp)) % MOD;

        dp[i][j][N] = ans % MOD;

        return dp[i][j][N];
    }
}
