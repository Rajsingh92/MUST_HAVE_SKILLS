/**
Longest subsequence-1 

Given an array A[] of size N, find the longest subsequence such that difference between adjacent 
elements is one.


Example 1:

Input: N = 7
A[] = {10, 9, 4, 5, 4, 8, 6}
Output: 3
Explaination: The three possible subsequences 
{10, 9, 8} , {4, 5, 4} and {4, 5, 6}.
 */

class Solution {
    public static int longestSubsequence(int n, int[] arr) {
        int result = 1;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[i] - arr[j] == 1) || (arr[i] - arr[j] == -1))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}