/**
 
Print all elements in sorted order from row and column wise sorted matrix
Given an n x n matrix, where every row and column is sorted in non-decreasing order. Print all elements of 
matrix in sorted order.
Example:

Input: mat[][]  =  { {10, 20, 30, 40},
                     {15, 25, 35, 45},
                     {27, 29, 37, 48},
                     {32, 33, 39, 50},
                   };

Output: 10 15 20 25 27 29 30 32 33 35 37 39 40 45 48 50
 */

public class Solution {

	private static void sortmatrix(int[][] arr) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int row = 0; row < arr.length; row++) {
			pq.add(new Pair(arr[row][0], row, 0));
		}

		while (!pq.isEmpty()) {
			Pair pair = pq.remove();
			System.out.print(pair.value+" ");
			if (pair.col+1 != arr[0].length)
				pq.add(new Pair(arr[pair.row][pair.col+1], pair.row, pair.col+1));
		}
	}

	static class Pair implements Comparable<Pair> {
		int value;
		int row;
		int col;

		public Pair(int value, int row, int col) {
			this.value = value;
			this.row = row;
			this.col = col;
		}

		public int compareTo(Pair o) {
			return this.value - o.value;
		}
	}

}