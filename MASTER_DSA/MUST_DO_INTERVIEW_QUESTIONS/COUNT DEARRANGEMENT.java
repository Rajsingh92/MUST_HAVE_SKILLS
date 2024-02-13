public class Solution {

    public int countDer(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        return (n - 1) * (countDer(n - 1) + countDer(n - 2));
    }

    public int countDer_DP(int n) {

        int dp[] = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; ++i)
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);

        return der[n];
    }

    public int countDer_opti(int n) {

        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        int a = 0;
        int b = 1;

        for (int i = 3; i <= n; ++i) {
            int cur = (i - 1) * (a + b);
            a = b;
            b = cur;
        }

        return b;
    }
}
