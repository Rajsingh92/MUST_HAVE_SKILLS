class Solution {

    public static int MCM(int[] arr, int i, int j, int[][] dp) {
        if (i + 1 == j) {
            return dp[i][j] = 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int lc = MCM(arr, i, k, dp);
            int rc = MCM(arr, k + 1, j, dp);
            int mc = arr[i] * arr[k + 1] * arr[j];
            
            int total = lc + mc + rc;

            min = Math.min(min, total);
        }

        return dp[i][j] = min;
    }

    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N - 1][N - 1];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else {
                    int min = Integer.MAX_VALUE;

                    for (int k = i; k < j; k++) {
                        int lc = dp[i][k];
                        int rc = dp[k + 1][j];
                        int mc = arr[i] * arr[k + 1] * arr[j + 1];

                        int total = lc + rc + mc;

                        min = Math.min(min, total);
                    }

                    dp[i][j] = min;
                }
            }
        }

        return dp[0][dp.length - 1];
    }
}


// Printing brackets in Matrix Chain Multiplication Problem

