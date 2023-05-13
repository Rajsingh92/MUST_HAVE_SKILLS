/**
Counting Bits

Given an integer num, return an array of the number of 1's in the binary representation of every number in the 
range [0, num].

 

Example 1:

Input: num = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
 */

class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }

        int[] dp = new int[num + 1]; 
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + 1;
            }
        }

        return dp;
    }

}