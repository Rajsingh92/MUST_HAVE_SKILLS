/**
Count the number of possible triangles 

Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different 
array elements as lengths of three sides of triangles. 

Example 1:

Input: 
n = 3
arr[] = {3, 5, 4}
Output: 
1
Explanation: 
A triangle is possible 
with all the elements 5, 3 and 4.
 */

class Solution {
    static int findNumberOfTriangles(int arr[], int n) {
        Arrays.sort(arr);

        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int low = 0;
            int high = i - 1;

            while (low < high) {
                int sum = arr[low] + arr[high];

                if (sum > arr[i]) {
                    ans += high - low;
                    high--;
                } else {
                    low++;
                }
            }
        }

        return ans;
    }
}
