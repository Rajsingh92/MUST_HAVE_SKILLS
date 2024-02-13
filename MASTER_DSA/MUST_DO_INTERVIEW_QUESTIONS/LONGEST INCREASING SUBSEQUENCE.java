/**
Longest Increasing Subsequence |  Medium | Adobe, Airbnb, Amazon, Apple, Facebook, Google, Microsoft |
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing 
the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

class Solution {
    public static int LIS_Rec(int[] arr, int ei, int[] dp) {
        if (dp[ei] != 0)
            return dp[ei];

        int maxLen = 1;
        for (int i = ei; i >= 0; i--) {

            if (arr[i] < arr[ei]) {
                int len = LIS_Rec(arr, i, dp);
                maxLen = Math.max(maxLen, len + 1);
            }
        }

        return dp[ei] = maxLen;
    }

    public static int LIS_Rec(int[] arr) {
        if (arr.length == 0)
            return 0;

        int n = arr.length;
        int[] dp = new int[n];
        int max_ = 0;
        for (int i = n - 1; i >= 0; i--) {
            max_ = Math.max(LIS_Rec(arr, i, dp), max_);
        }

        return max_;
    }

    
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        
        for(int i = 0;i<nums.length;i++){
            Integer max = null;
            
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(max == null || dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            
            if(max!=null){
                dp[i] = max+1;
            }else{
                dp[i] = 1;
            }
            
            if(dp[i]>ans){
                ans = dp[i];
            }
            
        }
        
        return ans;
    }

    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }

    // print all longest increasing subsequence
    public static void printLIS(int[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }

        System.out.println(omax);

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < dp.length; i++) {
            if (omax == dp[i]) {
                queue.add(new Pair(omax, i, arr[i], arr[i] + ""));
            }
        }

        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();

            if (rem.l == 1) {
                System.out.println(rem.psf);
            }

            for (int j = rem.i - 1; j >= 0; j--) {
                if (dp[j] == rem.l - 1 && arr[j] <= rem.v) {
                    queue.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
    }

}






// Length of Longest Balanced Subsequence : n - (invalidOpenBraces + invalidCloseBraces))