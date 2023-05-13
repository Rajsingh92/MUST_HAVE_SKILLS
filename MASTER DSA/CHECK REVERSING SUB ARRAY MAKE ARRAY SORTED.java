/**
Check if reversing a sub array make the array sorted
Given an array of distinct n integers. The task is to check whether reversing one sub-array make 
the array sorted or not. If the array is already sorted or by reversing a subarray once make it 
sorted, print “Yes”, else print “No”.

Examples:

Input : arr [] = {1, 2, 5, 4, 3}
Output : Yes
By reversing the subarray {5, 4, 3}, 
the array will be sorted.

Input : arr [] = { 1, 2, 4, 5, 3 }
Output : No
 */



class Solution {
    //O(nlogn)
    public static boolean checkReverse(int[] arr, int n) {
        if (n == 1) {
            return true;
        }

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        int firstMisMatch = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                firstMisMatch = i;
                break;
            }
        }

        if (firstMisMatch == n) {
            return true;
        }

        int lastMisMatch = 0;
        for (int i = n - 1; i >= firstMisMatch; i--) {
            if (arr[i] != temp[i]) {
                lastMisMatch = i;
                break;
            }
        }

        // check firstMisMatch to lastMisMatch decreasing or not
        for (int i = lastMisMatch; i > firstMisMatch; i--) {
            if (!(arr[i] < arr[i - 1])) {
                return false;
            }
        }

        return true;
    }

    // O(n)
    public static boolean checkReverse2(int arr[], int n) {
        if (n == 1) {
            return true;
        }

        // Find first increasing part
        int i;
        for (i = 1; arr[i - 1] < arr[i] && i < n; i++)
            ;
        if (i == n) {
            return true;
        }

        // Find reversed part
        int j = i;
        while (j < n && arr[j] < arr[j - 1]) {
            if (i > 1 && arr[j] < arr[i - 2]) {
                return false;
            }
            j++;
        }

        if (j == n) {
            return true;
        }

        // Find last increasing part
        int k = j;

        // To handle cases like {1,2,3,4,20,9,16,17}
        if (arr[k] < arr[i - 1]) {
            return false;
        }

        while (k > 1 && k < n) {
            if (arr[k] < arr[k - 1]) {
                return false;
            }
            k++;
        }
        return true;
    }
}