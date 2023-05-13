class Solution {
    static int mod = (int) 1e9 + 7;
    static int counter = 1;

    public static void friendsPairingProblem_backtracking(int i, int n, boolean[] used, String asf) {
        if (i > n) {
            System.out.println(counter + "." + asf);
            counter++;
            return;
        }

        if (used[i]) {
            friendsPairingProblem_backtracking(i + 1, n, used, asf);
        } else {
            used[i] = true;
            friendsPairingProblem_backtracking(i + 1, n, used, asf + "(" + i + ") ");

            for (int j = i + 1; j <= n; j++) {
                if (used[j] == false) {
                    used[j] = true;
                    friendsPairingProblem_backtracking(i + 1, n, used, asf + "(" + i + "," + j + ") ");
                    used[j] = false;
                }
            }

            used[i] = false;
        }
    }

    public static long friendsPairingProblem_memo(int n, long[] dp) {
        if (n <= 1)
            return dp[n] = 1;
        if (dp[n] != 0)
            return dp[n];

        long single = friendsPairingProblem_memo(n - 1, dp) % mod;
        long pairUp = friendsPairingProblem_memo(n - 2, dp) % mod * (n - 1) % mod;

        return dp[n] = (single + pairUp) % mod;
    }

    public static long friendsPairingProblem_DP(int n, long[] dp) {
        int N = n;
        for (n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            long single = dp[n - 1] % mod;
            long pairUp = dp[n - 2] % mod * (n - 1) % mod;

            dp[n] = single + pairUp;
        }

        return dp[N] % mod;
    }

    public static int friendsPairingProblem_Opti(int n) {
        int single = 1;
        int pairUp = 1;

        for (int i = 2; i <= n; i++) {
            int ans = single + pairUp * (i - 1);
            single = pairUp;
            pairUp = ans;
        }

        return pairUp;
    }

    public static void friendsPairingProblem(int n) {
        boolean[] used = new boolean[n + 1];
        long[] dp = new long[n + 1];
        long ans = friendsPairingProblem_memo(n, dp);
        friendsPairingProblem_backtracking(1, n, used, "");
        System.out.println(ans);
    }

}