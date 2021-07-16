/**
Longest increasing subarray 
Given an array containing n numbers. The problem is to find the length of the longest contiguous subarray 
such that every element in the subarray is strictly greater than its previous element in the same subarray.

 

Example 1:

Input:
N = 9
A[] = {5, 6, 3, 5, 7, 8, 9, 1, 2}
Output:
5
 */

class Compute {

    public long lenOfLongIncSubArr(long arr[], long n) {
        long max = 1;
        int len = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                if (len > max) {
                    max = len;
                }

                len = 1;
            }
        }

        // last len
        if (len > max) {
            max = len;
        }

        return max;
    }
}