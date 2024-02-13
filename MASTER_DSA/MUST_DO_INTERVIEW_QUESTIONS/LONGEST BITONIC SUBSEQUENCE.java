/**
Longest Bitonic subsequence 
Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first increasing, then decreasing.
 

Example 1:

Input: nums = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.
 */



class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        int[] lis = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer max = null;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (max == null || lis[j] > max) {
                        max = lis[j];
                    }
                }
            }

            if (max != null) {
                lis[i] = max + 1;
            } else {
                lis[i] = 1;
            }
        }

        int[] lds = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            Integer max = null;

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    if (max == null || lds[j] > max) {
                        max = lds[j];
                    }
                }
            }

            if (max != null) {
                lds[i] = max + 1;
            } else {
                lds[i] = 1;
            }
        }

        int omax = lis[0]+lds[0]-1;
        for (int i = 1; i < arr.length; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }
        }
        
        
        return omax;
    } 
}

// Printing Longest Bitonic Subsequence

