/**
Product of Array Except Self |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to 
the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

 */

 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    // optimization
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }

        int left = 1;
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left = left * nums[i];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right = right * nums[i];

        }

        return res;
    }
}
