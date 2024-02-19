/**
Max Dot Product of Two Subsequences

Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of 
the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence 
of [1,2,3,4,5] while [1,5,3] is not).

 

Example 1:

Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2. 
Their dot product is (2*3 + (-2)*(-6)) = 18.
 */

public class Solution {
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp)
            Arrays.fill(d, -(int) 1e8);

        return maxDotProduct_memo(nums1, nums2, n, m, dp);
    }
    
    public int maxDotProduct_memo(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = -(int) 1e8;
        }

        if (dp[n][m] != -(int) 1e8)
            return dp[n][m];

        int val = nums1[n - 1] * nums2[m - 1];
        int a = maxDotProduct_memo(nums1, nums2, n - 1, m, dp);
        int b = maxDotProduct_memo(nums1, nums2, n, m - 1, dp);
        int acceptBothNumber = maxDotProduct_memo(nums1, nums2, n - 1, m - 1, dp) + val;

        return dp[n][m] = Math.max(Math.max(acceptBothNumber, val), Math.max(a, b));
    }

    
}
