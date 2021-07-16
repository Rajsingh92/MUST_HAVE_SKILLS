/**
Value equal to index value 
Given an array Arr of N positive integers. Your task is to find the elements whose value is equal to that of its index 
value.

Example 1:

Input: 
N = 5
Arr[] = {15, 2, 45, 12, 7}
Output: 2
Explanation: Only Arr[2] = 2 exists here.
 */

class Solution {
    static int binarySearch(int arr[], int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;

            if (mid == arr[mid])
                return mid;
            if (mid > arr[mid])
                return binarySearch(arr, (mid + 1), high);
            else
                return binarySearch(arr, low, (mid - 1));
        }
        return -1;
    }

}
