/**
Remove Duplicates from Sorted Array |  Easy | Amazon, Apple, Facebook, Google, Microsoft |

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        if(n == 0 || n==1){
            return n;
        }
        
        int k = 0;
        for(int i = 0;i<n-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[k] = nums[i];
                k++;
            }
        }
        
        nums[k] = nums[nums.length-1];
        k++;
        
        return k;
    }
}


/*
Remove Duplicates from Sorted Array II |  Medium | Google |

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3]
Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 
0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        if(n <=2){
            return n;
        }
        
        int k = 0;
        for(int i=0;i<n-2;i++){
            if(nums[i]!=nums[i+2]){
                nums[k] = nums[i];
                k++;
            }
        }
        
        nums[k] = nums[n-2];
        k++;
        nums[k] = nums[n-1];
        k++;
        
        return k;
    }
}