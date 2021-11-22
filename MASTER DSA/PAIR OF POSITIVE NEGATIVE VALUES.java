/**
Pairs with Positive Negative values 
Given an array of distinct integers, print all the pairs having positive value and negative value of a number that 
exists in the array.

NOTE: If there is no such pair in the array , return empty array.
 

Example 1:

Input:
N = 6
A[] = {1, -3, 2, 3, 6, -1}
Output:
-1 1 -3 3 

source : https://practice.geeksforgeeks.org/problems/pairs-with-positive-negative-values3719/1#
 */


class Compute {

    public long[] PosNegPair(long arr[], long n) {
        ArrayList<Long> list = new ArrayList<>();
        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[j] == -arr[i]) {
                list.add(Math.abs(arr[j]));
                i++;
                j--;
            } else if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                i++;
            } else {
                j--;
            }
        }

        Collections.sort(list);
        long[] ans = new long[2 * list.size()];
        int k = 0;
        for (long val : list) {
            ans[k++] = -val;
            ans[k++] = val;
        }

        return ans;
    }
}


