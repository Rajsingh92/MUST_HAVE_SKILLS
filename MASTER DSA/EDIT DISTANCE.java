/**
Edit Distance |  Hard | Facebook, Adobe, Amazon, Apple, Google, Microsoft |

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        Integer[][] dp = new Integer[m + 1][n + 1];
        return minDistance_DP(word1, m, word2, n);
    }

    public int minDistance(String word1, int m, String word2, int n, Integer[][] dp) {
        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        if (dp[m][n] != null) {
            return dp[m][n];
        }

        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return dp[m][n] = minDistance(word1, m - 1, word2, n - 1, dp);
        } else {
            int insert = minDistance(word1, m, word2, n - 1, dp);
            int delete = minDistance(word1, m - 1, word2, n, dp);
            int replace = minDistance(word1, m - 1, word2, n - 1, dp);

            return dp[m][n] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    public int minDistance_DP(String word1, int m, String word2, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                } else if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }
}