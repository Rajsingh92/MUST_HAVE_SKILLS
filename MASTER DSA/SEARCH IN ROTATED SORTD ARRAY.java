/**
Search in Rotated Sorted Array |  Medium | Alibaba, Amazon, Apple, Facebook, Google, Microsoft |
You are given an integer array nums sorted in ascending order, and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 */
                    
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[low]<=nums[mid]){//first part is sorted
                if(nums[low]<= target && target<nums[mid]){// lie between low and mid
                    high = mid-1;
                }else{
                    low = mid+1;
                }                 
            } else{ //  second part sorted
                if(nums[mid]< target && target<=nums[high]){// lie between mid and high
                    low = mid+1;
                }else{
                    high = mid-1;
                }   
            }  
        }
            
        return nums[low] == target ? low : -1;
    }
    

}                      

/*
Search in Rotated Sorted Array II |  Medium | Google |
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == target){
                return true;
            }
            
            while(low<mid && nums[low] == nums[mid]){
                low++;
            }
             
            if(nums[low]<=nums[mid]){//first part is sorted
                if(nums[low]<= target && target<nums[mid]){// lie between low and mid
                    high = mid-1;
                }else{
                    low = mid+1;
                }                 
            } else{ //  second part sorted
                if(nums[mid]< target && target<=nums[high]){// lie between mid and high
                    low = mid+1;
                }else{
                    high = mid-1;
                }   
            }  
        }
            
        return nums[low] == target ? true : false;
    }
}