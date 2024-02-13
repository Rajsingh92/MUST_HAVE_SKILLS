/**
Segregate Even and Odd numbers

Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers 
first, and then odd numbers.

Example:  

Input  = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3}
 */


class Solution {
    void segregateEvenOdd(int arr[], int n) {
        int l = 0;
        int r = n - 1;

        while (l < r) {
            while (l < r && arr[l] % 2 == 0) {
                l++;
            }

            while (l < r && arr[r] % 2 == 1) {
                r--;
            }

            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

    }
}



/**
Sort in specific order 

Given an array A of positive integers. Your task is to sort them in such a way that the first part of the array 
contains odd numbers sorted in descending order, rest portion contains even numbers sorted in ascending order.


Example 1:

Input:
N = 7
Arr = {1, 2, 3, 5, 4, 7, 10}
Output:
7 5 3 1 2 4 10
 */


class Solution {

    public void sortIt(long arr[], long n) {

        for (int i = 0; i < n; i++)
            if ((arr[i] & 1) != 0) 
                arr[i] *= -1;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++)
            if ((arr[i] & 1) != 0)
                arr[i] *= -1;
    }
}
