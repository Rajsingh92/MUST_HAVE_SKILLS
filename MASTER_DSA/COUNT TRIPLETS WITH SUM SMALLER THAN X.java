/**
Count triplets with sum smaller than X 
Given an array arr[] of distinct integers of size N and a sum value X, the task is to find count of triplets with 
the sum smaller than the given sum value X.

 

Example 1:

Input: N = 6, X = 2
arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with 
sum less than 2 (-2, 0, 1) and (-2, 0, 3). 
 */


class Solution {

    public static int countTriplets(int[] arr, int sum) {

        Arrays.sort(arr);
        int ans = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;
                else {
                    ans += (k - j);
                    j++;
                }
            }
        }

        return ans;
    }

}