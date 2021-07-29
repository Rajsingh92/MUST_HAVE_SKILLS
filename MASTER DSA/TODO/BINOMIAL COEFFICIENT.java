class Solution {
    static long nCr(int n, int r) {
        return nCr_DP(n, r);
    }

    public static int nCr_rec(int n, int r) {
        if (r > n) {
            return 0;
        }

        if (n == r || r == 0) {
            return 1;
        }

        return nCr_rec(n - 1, r - 1) + nCr_rec(n - 1, r);
    }

    public static int nCr_DP(int n, int r) {
        int[][] dp = new int[n + 1][r + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < r + 1; j++) {
                if (i == j || j == 0) {
                    dp[i][j] = 1;
                } else if (j > i) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][r];
    }
}
