/**
Sum of Absolute Differences in a Sorted Array

You are given an integer array nums sorted in non-decreasing order.

Build and return an integer array result with the same length as nums such that result[i] is equal to the summation 
of absolute differences between nums[i] and all the other elements in the array.

In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
 */


class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                temp += Math.abs(nums[i] - nums[j]);
            }
            ans[i] = temp;
        }

        return ans;
    }

    // optimization
    public int[] getSumAbsoluteDifferences2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int rsum = 0, lsum = 0;

        for (int num : nums)
            rsum += num;

        for (int i = 0; i < n; i++) {
            rsum -= nums[i];
            lsum += nums[i];
            ans[i] = (rsum - (n - i - 1) * nums[i]) + ((i + 1) * nums[i] - lsum);
        }

        return ans;
    }
}








/**
Minimum sum of absolute difference of pairs of two arrays
Input :  n = 4
         a[] = {4, 1, 8, 7}
         b[] = {2, 3, 6, 5}
Output : 6
 */


class Solution{
    public static int  findMinSum(int[] arr1,int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int diff = 0;
        for(int i=0;i<arr1.length;i++){
            diff+=Math.abs(arr1[i]-arr2[i]);
        }

        return diff;
    }
}












/**
Permutations in array 
Given two arrays of equal size N and an integer K. The task is to check if after permuting both arrays, we get 
sum of their corresponding element greater than or equal to k i.e Ai + Bi >= K for all i (from 0 to N-1). 
Return true if possible, else false.
 

Example 1:

Input : 
a[] = {2, 1, 3}, 
b[] = { 7, 8, 9 }, 
k = 10. 
Output : 
True

Explanation:
Permutation  a[] = { 1, 2, 3 } 
and b[] = { 9, 8, 7 } 
satisfied the condition a[i] + b[i] >= K.
 */




class Compute {
    public boolean isPossible(long a[], long b[], long n, long k) {

        Arrays.sort(a);
        Arrays.sort(b);

        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            if (a[low] + b[high] < k) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}




