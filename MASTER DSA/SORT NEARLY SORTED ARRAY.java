/**
Sort a nearly sorted (or K sorted) array
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that 
sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at 
indexes 5, 6, 7, 8, 9 in the given array.

Examples:
Input : arr[] = {6, 5, 3, 2, 8, 10, 9} k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
 */

import java.util.*;
class GFG {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();

		for (int t = 0; t < T; t++) {
			int N = scn.nextInt();
			int K = scn.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scn.nextInt();
			}

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < arr.length; i++) {
				pq.add(arr[i]);
				if (pq.size() > K) {
					int temp = pq.remove();
					System.out.print(temp + " ");
				}
			}

			while (pq.size() > 0) {
				int temp = pq.remove();
				System.out.print(temp + " ");
			}
			System.out.println();
		}

	}

}