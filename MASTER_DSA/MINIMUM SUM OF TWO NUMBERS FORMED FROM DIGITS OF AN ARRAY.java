/**
Min sum formed by digits 

Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits 
of the array. All digits of given array must be used to form the two numbers.
 

Example 1:

Input:
N = 6
arr[] = {6, 8, 4, 5, 2, 3}
Output:
604
Explanation:
The minimum sum is formed by numbers 
358 and 246
*/	

import java.util.*;

class Solution {

    public static long minSum(int arr[], int n) {
        Arrays.sort(arr);

        long num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + arr[i];
            } else {
                num2 = num2 * 10 + arr[i];
            }
        }

        return (num1 + num2);
    }

    public static long minSum2(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        long num1 = 0, num2 = 0;
        while (!pq.isEmpty()) {
            num1 = num1 * 10 + pq.remove();

            if (!pq.isEmpty()) {
                num2 = num2 * 10 + pq.remove();
            }
        }

        return (num1 + num2);
    }
}
