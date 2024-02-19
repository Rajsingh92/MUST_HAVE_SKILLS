/**
Regular Expression Matching |  Hard | Alibaba, Amazon, Google |

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
 */


class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char pc = p.charAt(i - 1);
                    char sc = s.charAt(j - 1);

                    if (pc == '*') {
                        dp[i][j] = dp[i - 2][j];

                        char ch = p.charAt(i - 2);
                        if (ch == '.' || sc == ch) {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                        }
                    } else if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[p.length()][s.length()];

    }
}