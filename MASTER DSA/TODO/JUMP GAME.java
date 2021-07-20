/**
Jump Game |  Medium | Amazon, Apple, Facebook, Google, Microsoft |

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */


class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;

        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i; j <= i + nums[i] && j < dp.length; j++) {
                if (dp[j] == true) {
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }

    public boolean canJump2(int[] nums) {
        int lastPosition = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPosition)
                lastPosition = i;
        }

        return lastPosition == 0;
    }
}


/**
Jump Game II

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
 */


class Solution {
    public int jump(int[] nums) {
       
        int[] dp = new int[nums.length]; 
        dp[0] = 0;
        
        for(int i = 1; i < dp.length; i++){
                dp[i] = Integer.MAX_VALUE;

                for(int j = 0 ; j<i ; j++){
                    if(i <= j + nums[j] && dp[j] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],dp[j]+1);
                        break;
                    }
                }
        }
        
        return dp[dp.length-1];
        
    }
}


        
/**
Jump Game III

Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
 */


class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length){
            return false;
        }
        
        int val = arr[start];
        if(val == 0) return true;
        
        arr[start] += arr.length; // mark as visited
        
        boolean way1 = canReach(arr,start+val);
        boolean way2 = canReach(arr,start-val);
        
        return way1 || way2;
    }
}



// jump game - 4,5,6