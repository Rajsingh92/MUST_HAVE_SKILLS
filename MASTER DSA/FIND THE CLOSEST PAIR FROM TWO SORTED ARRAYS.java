/**
Find the closest pair from two sorted arrays

Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] 
such that absolute value of (ar1[i] + ar2[j] – x) is minimum.

Example:

Input:  ar1[] = {1, 4, 5, 7};
        ar2[] = {10, 20, 30, 40};
        x = 32      
Output:  1 and 30
 */

class Solution {

    public void printClosest(int ar1[], int ar2[], int m, int n, int x) {

        int diff = Integer.MAX_VALUE;
        int res_l = 0, res_r = 0; // to store indices


        int l = 0, r = n - 1;
        while (l < m && r >= 0) {

            if (Math.abs(ar1[l] + ar2[r] - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(ar1[l] + ar2[r] - x);
            }

            if (ar1[l] + ar2[r] > x)
                r--;
            else 
                l++;
        }

        System.out.print("The closest pair is [" + ar1[res_l] + ", " + ar2[res_r] + "]");
    }


}