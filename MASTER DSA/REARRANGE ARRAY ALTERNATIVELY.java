/**
Rearrange Array Alternately 
Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e 
first element should be max value, second should be min value, third should be second max, fourth should be 
second min and so on.

Example 1:

Input:
N = 6
arr[] = {1,2,3,4,5,6}
Output: 6 1 5 2 4 3
Explanation: Max element = 6, min = 1, 
second max = 5, second min = 2, and 
so on... Modified array is : 6 1 5 2 4 3.
 */

class Solution {

    public static void rearrange(int arr[], int n) {

        int min_idx = 0;
        int max_idx = n - 1;

        int max_val = arr[max_idx] + 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[max_idx] % max_val) * max_val;
                max_idx--;
            } else {
                arr[i] = arr[i] + (arr[min_idx] % max_val) * max_val;
                min_idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max_val;
        }
    }

}