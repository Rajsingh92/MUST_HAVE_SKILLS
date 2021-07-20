
/**
Minimum Size Subarray Sum |  Medium | Google, Microsoft |
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.


Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int curr_sum = nums[i];
            
            if(curr_sum>=target){
                return 1;
            }
            
            for(int j=i+1;j<nums.length;j++){
                curr_sum+=nums[j];
                
                if(curr_sum>=target && min> j-i+1){
                    min = j-i+1;
                }
            }
        }
        
        return min == Integer.MAX_VALUE?0:min;
    }
}
