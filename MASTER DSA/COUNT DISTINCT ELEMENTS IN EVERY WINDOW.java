/**
Count distinct elements in every window 
Given an array of integers and a number K. Find the count of distinct elements in every window of 
size K in the array.

Example 1:

Input:
N = 7, K = 4
A[] = {1,2,1,3,4,2,3}
Output: 3 4 4 3
 */


class Solution {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;

        while (i < k - 1) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            i++;
        }

        i--;
        int j = -1;

        while (i < A.length - 1) {
            // acquire
            i++;
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            res.add(map.size());

            // release
            j++;
            int freq = map.get(A[j]);
            if (freq == 1) {
                map.remove(A[j]);
            } else {
                map.put(A[j], freq - 1);
            }
        }

        return res;
    }
}
    