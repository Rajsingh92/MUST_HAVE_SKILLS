/**
Subarray Sum Equals K |  Medium | Facebook, Microsoft |
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(sum,1);   // sum to freq
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            if(map.containsKey(sum-k)){
                int freq = map.get(sum-k);
                ans+=freq;
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
        
        
    }
}