/**
Maximum sum increasing subsequence 
Given an array arr of N positive integers, the task is to find the maximum sum increasing subsequence of the 
given array.
 

Example 1:

Input: N = 5, arr[] = {1, 101, 2, 3, 100} 
Output: 106
Explanation:The maximum sum of a
increasing sequence is obtained from
{1, 2, 3, 100}
 */


class Solution
{
	public int maxSumIS(int nums[], int n)  
	{  
	    int ans = 0;
        int[] dp = new int[n];
        
        for(int i = 0;i<n;i++){
            Integer max = null;
            
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(max == null || dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            
            if(max!=null){
                dp[i] = max+nums[i];
            }else{
                dp[i] = nums[i];
            }
            
            if(dp[i]>ans){
                ans = dp[i];
            }
            
        }
        
        return ans;
	}  
}


//  Printing Maximum Sum Increasing Subsequence