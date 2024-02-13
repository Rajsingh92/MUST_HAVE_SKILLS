/**
Burst Balloons |  Hard | Amazon, Google | 

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 */


class Solution {
    public int maxCoins(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                int max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : nums[i - 1]) * nums[k] * (j == nums.length - 1 ? 1 : nums[j + 1]);

                    int total = left + right + val;

                    if (total > max) {
                        max = total;
                    }
                }

                dp[i][j] = max;
            }
        }

        return dp[0][dp.length - 1];
    }
}