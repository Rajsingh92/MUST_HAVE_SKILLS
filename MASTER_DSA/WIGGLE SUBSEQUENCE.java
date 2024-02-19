/**
Wiggle Subsequence

A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate between positive and negative.
In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. The first is not because its first two differences are positive, and the second is not because its last difference is zero.
A subsequence is obtained by deleting some elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

Given an integer array nums, return the length of the longest wiggle subsequence of nums.

 

Example 1:

Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
 */

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] dp1 = new int[nums.length]; // end with 
        dp1[0] = 1;

        int[] dp2 = new int[nums.length]; // neg
        dp2[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                dp1[i] = dp2[i - 1] + 1;
                dp2[i] = dp2[i - 1];
            } else if (nums[i] - nums[i - 1] < 0) {
                dp1[i] = dp1[i - 1];
                dp2[i] = dp1[i - 1] + 1;
            } else {
                dp1[i] = dp1[i - 1];
                dp2[i] = dp2[i - 1];
            }
        }

        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int prevPos = 1;
        int prevNeg = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                prevPos = prevNeg + 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                prevNeg = prevPos + 1;
            }
        }

        return Math.max(prevPos, prevNeg);
    }
}
