

class Solution {
    public static int goldMine_memo(int r, int c, int[][] mat, int[][] dp) {
        if (c == mat[0].length - 1) {
            return dp[r][c] = mat[r][c];
        }

        if (dp[r][c] != -1)
            return dp[r][c];

        int maxGold = 0;
        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

        for (int d = 0; d < 3; d++) {
            int x = r + dir[d][0];
            int y = c + dir[d][1];
            if (x >= 0 && x < mat.length) {
                maxGold = Math.max(maxGold, goldMine_memo(x, y, mat, dp));
            }
        }

        return dp[r][c] = maxGold + mat[r][c];
    }

}
