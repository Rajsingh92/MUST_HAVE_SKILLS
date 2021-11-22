import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int n = str.length();
        int[][] dp = new int[n][n];
        System.out.println(countOfPalindromicSubsubsequence_Rec(str, 0, n - 1, dp));
    }

    public static int countOfPalindromicSubsubsequence_Rec(String str, int si, int ei, int[][] dp) {
        if (si > ei)
            return 0;
        if (si == ei)
            return dp[si][ei] = 1;

        if (dp[si][ei] != 0)
            return dp[si][ei];

        int middleString = countOfPalindromicSubsubsequence_Rec(str, si + 1, ei - 1, dp);
        int withoutFirstCharString = countOfPalindromicSubsubsequence_Rec(str, si + 1, ei, dp);
        int withoutLastCharString = countOfPalindromicSubsubsequence_Rec(str, si, ei - 1, dp);

        int rAns = withoutFirstCharString + withoutLastCharString;

        return dp[si][ei] = (str.charAt(si) == str.charAt(ei) ? rAns + 1 : rAns - middleString);
    }

    static int countPS(String str) {
        int[][] dp = new int[str.length()][str.length()];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
            }
        }

        return dp[0][str.length() - 1];
    }

}

// Count Different Palindromic Subsequences | Hard | Google |