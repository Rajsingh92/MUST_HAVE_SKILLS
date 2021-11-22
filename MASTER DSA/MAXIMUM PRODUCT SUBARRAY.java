/**
Maximum Product Subarray |  Medium | Adobe |

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, 
and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
 */


class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxPre = nums[0];
        int minPre = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(nums[i], Math.max(maxPre * nums[i], minPre * nums[i]));
            int min = Math.min(nums[i], Math.min(maxPre * nums[i], minPre * nums[i]));

            maxPre = max;
            minPre = min;

            if (maxPre > res) {
                res = maxPre;
            }
        }

        return res;
    }
}


/**
Maximum Non Negative Product in a Matrix

You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.

Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.

Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.

Notice that the modulo is performed after getting the maximum product.

 

Example 1:

Input: grid = [[-1,-2,-3],
               [-2,-3,-3],
               [-3,-3,-2]]
Output: -1
Explanation: It's not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
 */



class Solution {
    public int maxProductPath(int[][] grid) {  // same as maximum product subarray
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;

        long[][] maxPre = new long[m][n];
        long[][] minPre = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maxPre[i][j] = grid[i][j];
                    minPre[i][j] = grid[i][j];
                } else if (j == 0) {
                    maxPre[i][j] = grid[i][j] * maxPre[i - 1][j];
                    minPre[i][j] = grid[i][j] * minPre[i - 1][j];
                } else if (i == 0) {
                    maxPre[i][j] = grid[i][j] * maxPre[i][j - 1];
                    minPre[i][j] = grid[i][j] * minPre[i][j - 1];
                } else {
                    if (grid[i][j] < 0) {
                        maxPre[i][j] = grid[i][j] * Math.min(minPre[i][j - 1], minPre[i - 1][j]);
                        minPre[i][j] = grid[i][j] * Math.max(maxPre[i][j - 1], maxPre[i - 1][j]);
                    } else {
                        maxPre[i][j] = grid[i][j] * Math.max(maxPre[i][j - 1], maxPre[i - 1][j]);
                        minPre[i][j] = grid[i][j] * Math.min(minPre[i][j - 1], minPre[i - 1][j]);
                    }
                }

            }
        }

        int ans = (int) (maxPre[m - 1][n - 1] % MOD);

        return ans < 0 ? -1 : ans;

    }
}


