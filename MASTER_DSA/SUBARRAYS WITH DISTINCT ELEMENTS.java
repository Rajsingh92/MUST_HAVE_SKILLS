/**
Sum of length 
Given an array. Calculate the sum of lengths of contiguous subarrays having all distinct elements.
 
Example 1:
Input:
N=3
arr[] = { 1,2,3 }
Output: 10
Explanation: 
{1, 2, 3} is a subarray of length 3 with 
distinct elements. Total length of length
three = 3. {1, 2}, {2, 3} are 2 subarray 
of length 2 with distinct elements. Total 
length of lengths two = 2 + 2 = 4
{1}, {2}, {3} are 3 subarrays of length 1
with distinct element. Total lengths of 
length one = 1 + 1 + 1 = 3
Sum of lengths = 3 + 4 + 3 = 10
 */


import java.util.*;
class Solution {
	long sumoflength(long arr[], int n) {
		HashSet<Long> set = new HashSet<>();
		int start = 0;
		int end = 0;
		long ans = 0;
		while (start < n) {
			while (end < n && set.contains(arr[end]) == false) {
				set.add(arr[end]);
				end++;
			}

			ans += (end - start) * (end - start + 1) / 2;
			set.remove(arr[start]);
			start++;
		}

		return ans;

	}
}