/**
Contiguous Array / longest subarray with equal number of 0s and 1s
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.


Example:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 */

class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();  // sum to index
        map.put(0,-1);
        int sum = 0;
        int ans = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                sum+=1;
            }else if(nums[i] == 0){
                sum+=-1;
            }
            
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }else{
                int idx = map.get(sum);
                ans = Math.max(ans,i-idx);
            }
        }
        
        return ans;
    }
}

/**
count subarray with equal 0 and 1
 */

class Solution {
    public int solve(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();  // sum to freq
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                sum+=1;
            }else if(nums[i] == 0){
                sum+=-1;
            }
            
            if(map.containsKey(sum) == false){
                map.put(sum,i);
            }else{
                int freq = map.get(sum);
                ans += freq;
                map.put(sum,freq+1);
            }
        }
        
        return ans;
    }
}