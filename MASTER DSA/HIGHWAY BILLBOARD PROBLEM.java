
public class Solution {
    public static int solve(int m, int[] x, int[] rev, int t) {

        int[] dp = new int[x.length];
        dp[0] = rev[0];
        int ans = 0;

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int dist = x[i] - x[j];
                if (dist > t) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = rev[i] + max;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // optimization --  TODO
}


/**
public class Main {
    public static int solution(int m, int[] x, int[] rev, int t) {
        int[] dp = new int[m + 1];
        int j = 0;
        for (int i = 1; i <= m; i++) {
            // System.out.println(i+"  "+j);
            if (j < x.length && x[j] == i) {
                dp[i] = Math.max(dp[i - 1], (i - t - 1 >= 0 ? dp[i - t - 1] : 0) + rev[j]);
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[m];
    }
}
 */