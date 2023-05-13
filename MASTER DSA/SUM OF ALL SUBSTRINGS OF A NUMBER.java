/**
Sum of all substrings of a number 

Given an integer S represented as a string, the task is to get the sum of all possible sub-strings of this string.
As the answer will be large, print it modulo 10^9+7.

Example 1:

Input:
S = 1234
Output: 1670
Explanation: Sum = 1 + 2 + 3 + 4 + 12 +
23 + 34 + 123 + 234 + 1234 = 1670
 */

import java.util.*;

class Solution {
    public static long sumSubstrings(String s) {
        long[] dp = new long[s.length()];
        dp[0] = s.charAt(0) - '0';
        long res = dp[0];
        int mod = 1000000007;

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            dp[i] = ((i + 1) * num + 10 * dp[i - 1]) % mod;
            res = (res + dp[i]) % mod;
        }

        return res;

    }

    public static long sumSubstrings2(String s) {

        long prev = s.charAt(0) - '0';
        long res = prev;
        int mod = 1000000007;

        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            long curr = ((i + 1) * num + 10 * prev) % mod;
            res = (res + curr) % mod;
            prev = curr;
        }

        return res;

    }
}


