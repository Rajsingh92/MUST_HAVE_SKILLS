/**
K-th Smallest Prime Fraction

You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.

For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].

Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].

 

Example 1:

Input: arr = [1,2,3,5], k = 3
Output: [2,5]
Explanation: The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
The third fraction is 2/5.
 */


import java.util.*;
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numToIndex.put(arr[i], i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] fraction1, int[] fraction2) {
                return fraction1[0] * fraction2[1] - fraction2[0] * fraction1[1];
            }
        });

        for (int i = 1; i < arr.length; i++) {
            pq.offer(new int[] { arr[0], arr[i] });
        }

        for (int i = 1; i < k; i++) {
            int[] rem = pq.poll();
            int numIndex = numToIndex.get(rem[0]);
            int denIndex = numToIndex.get(rem[1]);

            if (numIndex + 1 < denIndex) {
                numIndex++;
                pq.offer(new int[] { arr[numIndex], arr[denIndex] });
            }
        }

        return pq.peek();
    }
}

