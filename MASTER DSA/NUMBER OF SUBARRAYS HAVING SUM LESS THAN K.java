/**
Number of subarrays having sum less than K
Given an array of non-negative numbers and a non-negative number k, find the number of subarrays 
having sum less than k. We may assume that there is no overflow.

Examples :

Input : arr[] = {1, 11, 2, 3, 15}
        K = 10
Output : 4
{1}, {2}, {3} and {2, 3}
 */


class Solution {
    public int numOfSubarraysSumLessK(int[] arr, int k) {
        int si = 0, ei = 0;
        int n = arr.length;

        int count = 0;
        int sum = 0;
        while (ei < n) {
            sum += arr[ei++];
            while (sum > k && si < ei) {
                sum -= arr[si++];
            }

            count += (ei - si);
        }

        return count;
    }
}
