/*
Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if 
every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
*/


public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            if(set.contains(val)) return true;
            set.add(val);
        }
        return false;
    }
}

/**
Contains Duplicate II
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array 
such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (map.containsKey(val)) {
                if (i - map.get(val) <= k)
                    return true;
            }

            map.put(val, i);
        }
        return false;

    }
}