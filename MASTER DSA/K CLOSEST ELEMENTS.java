/**
K closest elements 

Given a sorted array, arr[] of N integers, and a value X. Find the K closest elements to X in arr[].
Keep the following points in mind:

If X is present in the array, then it need not be considered.
If there are two elements with the same difference with X, the greater element is given priority.
If sufficient elements are not present on the right side then take elements from left and vice versa.
 
Example 1:

Input:
N = 13
arr[] = {12, 16, 22, 30, 35, 39, 42, 
         45, 48, 50, 53, 55, 56}
K = 4, X = 35
Output: 30 39 42 45
Explanation: 
First closest element to 35 is 30.
Second closest element to 35 is 39.
Third closest element to 35 is 42.
And fourth closest element to 35 is 45.
 */

import java.util.*;
class Solution {
    public class Pair implements Comparable<Pair> {
        int val;
        int dist;

        Pair(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }

        public int compareTo(Pair o) {
            if (this.dist == o.dist) {
                return o.val - this.val;
            } else {
                return this.dist - o.dist;
            }
        }
    }

    int[] printKClosest(int[] arr, int n, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int val : arr) {
            if (x - val != 0) {
                pq.add(new Pair(val, Math.abs(x - val)));
            }
        }

        int[] ans = new int[k];
        int i = 0;

        while (k-- > 0) {
            Pair rem = pq.remove();
            ans[i++] = rem.val;
        }

        return ans;
    }
}