import java.io.*;
import java.util.*;

public class Main {

    public static int shortestSeq(char[] S, char[] T, int m, int n) {

        if (m == 0)
            return 1000;

        if (n <= 0)
            return 1;

        int k;
        for (k = 0; k < n; k++)
            if (T[k] == S[0])
                break;

        // char not found in T
        if (k == n)
            return 1;

        return Math.min(shortestSeq(Arrays.copyOfRange(S, 1, S.length), T, m - 1, n),
                        1 + shortestSeq(Arrays.copyOfRange(S, 1, S.length), Arrays.copyOfRange(T, k + 1, T.length), m - 1,n - k - 1));
    }

    public static int solution(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 1000;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char chins1 = s1.charAt(i - 1);
                int k;

                for (k = j - 1; k >= 0; k--) {
                    if (s2.charAt(k) == chins1) {
                        break;
                    }
                }

                if (k == -1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][k] + 1);
                }
            }
        }

        int ans = dp[dp.length - 1][dp[0].length - 1];
        if (ans >= 1000) {
            ans = -1;
        }
        return ans;
    }

}
