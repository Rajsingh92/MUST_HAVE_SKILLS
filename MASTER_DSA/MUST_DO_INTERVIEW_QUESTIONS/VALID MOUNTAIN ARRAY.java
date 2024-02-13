/**
Valid Mountain Array |  Easy | Google |

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
 */

class Solution {
    public boolean validMountainArray(int[] arr) {

        int index = 0;
        while (index + 1 < arr.length && arr[index] < arr[index + 1]) {
            index++;
        }

        if (index == 0 || index == arr.length - 1) {
            return false;
        }

        while (index + 1 < arr.length && arr[index] > arr[index + 1]) {
            index++;
        }

        return index == arr.length - 1;
    }
}