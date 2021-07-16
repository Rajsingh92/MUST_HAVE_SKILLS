/**
Majority Element |  Easy | Adobe, Amazon, Apple, Google, Microsoft |
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority 
element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */



class Solution {
    // Moore’s Voting Algorithm
    public int majorityElement2(int[] nums) {
        //find candidate
        int candidate = nums[0];
        int counter = 1;
        
        for(int i =1;i<nums.length;i++){
        
            if(nums[i] == candidate){
                counter++;
            }else{
                counter--;
            }
            
            if(counter==0){
                candidate = nums[i];
                counter = 1;
            }
            
        }
        
        return candidate;

    }
}


/**
| 229 | Majority Element II |  Medium | Amazon |
Majority element general
Find all elements that appear more than N/K times
 */