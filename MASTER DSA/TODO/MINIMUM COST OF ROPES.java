/**
Minimum Cost of ropes 

There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to 
connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output: 
29
 */

import java.util.*;
class Solution {
	long minCost(long arr[], int n) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (long val : arr) {
			pq.add(val);
		}

		long cost = 0;
		while (pq.size() != 1) {
			long one = pq.remove();
			long two = pq.remove();
			cost += one + two;
			pq.add(one + two);
		}

		return cost;
	}
}