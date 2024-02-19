/**
Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        
        for(Integer val: nums){
            map.put(val,true);
        }
        for(Integer val: nums){
            if(map.containsKey(val-1)){
                map.put(val,false);
            }
        }
        for(Integer val: nums){
            map.put(val,true);
        }
        
        int max = 0;
        for(Integer val: nums){
            if(map.get(val)==true){
                int start = val;
                int len = 1;
                
                while(map.containsKey(start+len)){
                    len++;
                }
                
                max = Math.max(len,max);
            }
        }
        
        return max;
        
        
    }
}