/**
Fibonacci Number |  Easy | Adobe, Amazon, Microsoft |
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the 
sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 */

public class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public int fib_MEMO(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fib_MEMO(n - 1, dp) + fib_MEMO(n - 2, dp);
    }

    public int fib_DP(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 0; i < dp.length; i++) {
            dp[i] += dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fib_opti(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int sum = 0;

        for (int i = 2; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }
}



/**
Count Ways To Express N As The Sum Of 1,3,4

Input : N = 5 
Output : 6
Explanation: 1 + 1 + 1 + 1 + 1
             1 + 4
             4 + 1
             1 + 1 + 3
             1 + 3 + 1
             3 + 1 + 1
 */


public class Solution{
    public int countWays(int n){

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for(int i = 4;i <= n;i++){
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }

        return dp[n];
    }
}

