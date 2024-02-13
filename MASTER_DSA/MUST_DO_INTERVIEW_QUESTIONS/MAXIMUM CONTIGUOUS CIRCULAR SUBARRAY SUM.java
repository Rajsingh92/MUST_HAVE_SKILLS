/**
Maximum Sum Circular Subarray

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] 
is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., 
nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 */


class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int x = maxSubArray(nums);
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            y += nums[i];
            nums[i] *= -1;
        }

        int z = maxSubArray(nums);
        if (y + z == 0)
            return x;

        return Math.max(x, y + z);
    }

    public int maxSubArray(int[] nums) {
        int bestSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currSum > 0) {
                currSum += nums[i];
            } else {
                currSum = nums[i];
            }

            bestSum = Math.max(bestSum, currSum);

        }

        return bestSum;
    }
}