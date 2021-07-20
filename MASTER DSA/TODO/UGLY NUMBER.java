/**
Ugly Number

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

 

Example 1:

Input: n = 6
Output: true
Explanation: 6 = 2 × 3
 */

class Solution {
   public static boolean isUgly(int num) {
       if (num <= 0)
           return false;
           
       while (num % 2 == 0)
           num /= 2;

       while (num % 3 == 0)
           num /= 3;

       while (num % 5 == 0)
           num /= 5;

       return num == 1;
   }
}

/**
Ugly Number II

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 */

class Solution {
   public int nthUglyNumber(int n) {
      if (n == 1) return 1;

      int[] dp = new int[n + 1];
      dp[1] = 1;

      int p2 = 1;
      int p3 = 1;
      int p5 = 1;

      for (int i = 2; i < dp.length; i++) {
         int f2 = 2 * dp[p2];
         int f3 = 3 * dp[p3];
         int f5 = 5 * dp[p5];

         int min = Math.min(f2, Math.min(f3, f5));
         dp[i] = min;

         if (min == f2) p2++;
         if (min == f3) p3++;
         if (min == f5) p5++;
      }

      return dp[n];
   }
}


/**
Super Ugly Number

A super ugly number is a positive integer whose prime factors are in the array primes.

Given an integer n and an array of integers primes, return the nth super ugly number.

The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

 

Example 1:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
 */

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {

                int val = primes[j] * dp[pointers[j]];
                if (min > val) {
                    min = val;
                }

            }

            dp[i] = min;

            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * dp[pointers[j]]) {
                    pointers[j]++;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }

        return dp[n];
    }
}
 

