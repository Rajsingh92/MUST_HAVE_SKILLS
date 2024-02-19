/**
Rotation 
Given an ascending sorted rotated array Arr of distinct integers of size N. The array is right rotated K times. Find the value 
of K.

Example 1:

Input:
N = 5
Arr[] = {5, 1, 2, 3, 4}
Output: 1
Explanation: The given array is 5 1 2 3 4. 
The original sorted array is 1 2 3 4 5. 
We can see that the array was rotated 
1 times to the right.
 */
     

class Solution {
    int findKRotation(int arr[], int n) {
        // find the position of smallest element its index will be K
        int low = 0;
        int high = n - 1;

        while (high >= low) {
            if (arr[low] <= arr[high])
                return low; // already sorted array

            int mid = (low + high) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next])
                return mid;
            else if (arr[mid] >= arr[low]) // if first part sorted search in second part
                low = mid + 1;
            else if (arr[high] >= arr[mid]) // if second part sorted search in first part
                high = mid - 1;
        }
        return -1;
    }
}