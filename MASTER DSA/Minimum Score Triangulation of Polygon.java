import java.io.*;
import java.util.*;

public class Main {

    public static int minScoreTriangulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; ++d) {
            for (int i = 0; i + d < n; ++i) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[j] * arr[k]);
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
    }
}



public class Q1039 {

    // 1039
    public int minScoreTriangulation(int[] arr, int si, int ei, int[][] dp) {
        if (ei - si <= 1) {
            return dp[si][ei] = 0;
        }

        if (dp[si][ei] != -1)
            return dp[si][ei];

        int minAns = (int) 1e9;
        for (int cut = si + 1; cut < ei; cut++) {
            int lans = minScoreTriangulation(arr, si, cut, dp);
            int rans = minScoreTriangulation(arr, cut, ei, dp);

            minAns = Math.min(minAns, lans + arr[si] * arr[cut] * arr[ei] + rans);
        }

        return dp[si][ei] = minAns;

    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return minScoreTriangulation(values, 0, n - 1, dp);
    }
}
