/**
Maximum repeating number 
Given an array Arr of size N, the array contains numbers in range from 0 to K-1 where K is a positive 
integer and K <= N. Find the maximum repeating number in this array. If there are two or more maximum 
repeating numbers return the element having least value.

Example 1:

Input:
N = 4, K = 3
Arr[] = {2, 2, 1, 2}
Output: 2
Explanation: 2 is the most frequent element.
 */


class Solution {
    int maxRepeating(int[] arr, int n, int k) {
        
        for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % k] += k;
		}
		
		int max=Integer.MIN_VALUE;
		int pos=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
				pos=i;
			}
		}
        
        return pos;
    }
}