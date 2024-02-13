/**
Max Consecutive Ones III
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */

class Solution {
    public int longestOnes(int[] A, int K) {
        int count = 0 ;
        int ans  = 0;
        int j = -1;
        
        for(int i = 0;i<A.length;i++){

            //acquire
            if(A[i] ==0){
                count++;
            }
            
            // release
            while(count>K){
                j++;
                if(A[j] == 0){
                    count--;
                }
            }

            int len = i-j;
            ans = Math.max(ans,len);
        }
        
        return ans;
    }
}


/**
Max Consecutive Ones II |  Medium | Google |
Maximum Consecutive Ones - 1 Easy
Maximum Consecutive Ones - 2 Easy
 */