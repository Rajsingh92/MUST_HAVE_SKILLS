/**
Maximum Subarray |  Easy | Adobe, Alibaba, Amazon, Apple, Facebook, Microsoft |
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum = nums[0];
        int currSum = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(currSum>0){
                currSum+=nums[i];
            }else{
                currSum = nums[i];
            }
            
            bestSum = Math.max(bestSum,currSum);
            
        }
        
        return bestSum;
    }
}


/**
Smallest sum contiguous subarray

Input : arr[] = {3, -4, 2, -3, -1, 7, -5}
Output : -6
Subarray is {-4, 2, -3, -1} = -6
 */


class Solution {
    public int minSubArray(int[] nums) {
        int worstSum = nums[0];
        int currSum = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(currSum<0){
                currSum+=nums[i];
            }else{
                currSum = nums[i];
            }
            
            worstSum = Math.min(worstSum,currSum);
            
        }
        
        return worstSum;
    }
}

// Print continuous subarray with maximum sum

