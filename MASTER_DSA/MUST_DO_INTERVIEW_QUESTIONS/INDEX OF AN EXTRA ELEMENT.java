/**
Index Of an Extra Element 

Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. First array has one 
element extra added in between. Find the index of the extra element.

Example 1:

Input:
N = 7
A[] = {2,4,6,8,9,10,12}
B[] = {2,4,6,8,10,12}
Output: 4
Explanation: In the second array, 9 is
missing and it's index in the first array
is 4.
 */

class Solution {
    public int findExtra(int a[], int b[], int n) {

        int low = 0;
        int high = n - 1;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (b[mid] == a[mid]) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }
}