/**
Longest Palindromic Substring |  | Alibaba |

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 */


import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean[][] dp = new boolean[str.length()][str.length()];
        int ans = 0;

        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? true : false;
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    ans = gap + 1;
                }
            }
        }

        System.out.println(ans);
    }

    public String longestPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int si = 0, ei = 0, length = 0; 

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {

                if (gap == 0)
                    dp[i][j] = 1;
                else if (gap == 1 && str.charAt(i) == str.charAt(j))
                    dp[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] > 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;

                if (dp[i][j] > length) {
                    length = dp[i][j];
                    si = i;
                    ei = j;
                }
            }
        }

        return str.substring(si, ei + 1);
    }
}
