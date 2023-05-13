/**
Maximum Sum of Two Non-Overlapping Subarrays

Given an array nums of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays, 
which have lengths firstLen and secondLen.  (For clarification, the firstLen-length subarray could occur before or after the 
secondLen-length subarray.)

Formally, return the largest V for which V = (nums[i] + nums[i+1] + ... + nums[i+firstLen-1]) + (nums[j] + nums[j+1] + ... + nums[j+secondLen-1]) and either:

0 <= i < i + firstLen - 1 < j < j + secondLen - 1 < nums.length, or
0 <= j < j + secondLen - 1 < i < i + firstLen - 1 < nums.length.
 

Example 1:

Input: nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
Output: 20
Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
 */

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int x, int y) {
        int xy = maxSumTwoNoOverlap_DP(nums, x, y);
        int yx = maxSumTwoNoOverlap_DP(nums, y, x);

        return Math.max(xy, yx);
    }

    public int maxSumTwoNoOverlap_DP(int[] nums, int x, int y) {

        int[] dp1 = new int[nums.length]; // max subarray of size x ending at i
        int[] dp2 = new int[nums.length]; // max subarray of size y i to last index

        int sum = 0;
        for (int i = 0; i < dp1.length; i++) {
            if (i < x) {
                sum += nums[i];
                dp1[i] = sum;
            } else {
                sum += nums[i] - nums[i - x];
                dp1[i] = Math.max(sum, dp1[i - 1]);
            }
        }

        sum = 0;
        for (int i = dp2.length - 1; i >= 0; i--) {
            if (i + y >= dp2.length) {
                sum += nums[i];
                dp2[i] = sum;
            } else {
                sum += nums[i] - nums[i + y];
                dp2[i] = Math.max(sum, dp2[i + 1]);
            }
        }

        int ans = 0;
        for (int i = x - 1; i < nums.length - y; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i + 1]);
        }

        return ans;
    }
}
