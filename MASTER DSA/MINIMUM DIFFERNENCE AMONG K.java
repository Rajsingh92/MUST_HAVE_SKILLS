/**
Minimum Difference among K 
Given an array of n integers and a positive number k. We are allowed to take any k integers from the given array. 
The task is to find the minimum possible value of the difference between maximum and minimum of k numbers.

 

Example 1:

Input:
N=7
K=3
arr[] = {10, 100, 300, 200, 1000, 20, 30}
Output:
20
Explanation:
20 is the minimum possible difference 
between any maximum and minimum of any 
k numbers.Given k = 3, we get the result 
20 by selecting integers {10, 20, 30}.
max(10, 20, 30) - max(10, 20, 30) = 30 - 10 
= 20.
 */

class Solution {
    long minDiff(long arr[], int n, int k) {

        Arrays.sort(arr);
        long res = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            long temp = arr[i + k - 1] - arr[i];
            if (res > temp) {
                res = temp;
            }
        }
        return res;
    }
}