import java.util.*;

class Main {

    static int mod = 1000000007;
    static int posInf = Integer.MAX_VALUE;
    static int negInf = Integer.MIN_VALUE;

    public static int A(int n, int[] arr) {

        int[] dp = new int[n];
        Arrays.fill(dp, posInf);

        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j <= i + 2; j++) {
                if (j < n)
                    dp[j] = Math.min(dp[j], dp[i] + Math.abs(arr[i] - arr[j]));
            }
        }

        return dp[n - 1];
    }

    public static int B(int n, int k, int[] arr) {

        int[] dp = new int[n];
        Arrays.fill(dp, posInf);

        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (j < n)
                    dp[j] = Math.min(dp[j], dp[i] + Math.abs(arr[i] - arr[j]));
            }
        }

        for (int val : dp) {
            System.out.print(val + " ");
        }

        return dp[n - 1];
    }

    public static int C(int n, int[][] arr) {

        int[][] dp = new int[3][n];

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);
            dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], dp[2][i - 1]);
            dp[2][i] = arr[2][i] + Math.max(dp[0][i - 1], dp[1][i - 1]);
        }

        return Math.max(dp[0][n - 1], Math.max(dp[1][n - 1], dp[2][n - 1]));
    }

    public static int H(int H, int W, char[][] grid) {

        int[][] dp = new int[H][W];

        for (int i = H - 1; i >= 0; i--) {
            for (int j = W - 1; j >= 0; j--) {
                if (grid[i][j] == '.') {
                    if (i == H - 1 && j == W - 1) {
                        dp[i][j] = 1;
                    } else if (i == H - 1) {
                        dp[i][j] = dp[i][j + 1] % mod;
                    } else if (j == W - 1) {
                        dp[i][j] = dp[i + 1][j] % mod;
                    } else {
                        dp[i][j] = (dp[i][j + 1] + dp[i + 1][j]) % mod;
                    }
                }
            }
        }

        return dp[0][0];
    }
}
