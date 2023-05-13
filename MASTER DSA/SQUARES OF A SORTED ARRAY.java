/**
Squares of a Sorted Array |  Easy | Adobe |

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted 
in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */

 
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int i = nums.length - 1;
        int low = 0;
        int high = nums.length - 1;

        while (i >= 0) {
            if (Math.abs(nums[low]) > nums[high]) {
                res[i] = nums[low] * nums[low];
                low++;
            } else {
                res[i] = nums[high] * nums[high];
                high--;
            }
            i--;
        }

        return res;
    }
}
