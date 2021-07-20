/**
 * 
Searching in an array where adjacent differ by at most k
A step array is an array of integer where each element has a difference of at most k with its neighbor. 
Given a key x, we need to find the index value of x if multiple element exist return the first occurrence 
of the key.

Examples:

Input : arr[] = {4, 5, 6, 7, 6}
           k = 1
           x = 6
Output : 2
 */

public class Solution {
    public static int search(int[] arr,int ElementToBeSearched,int k){

        int i = 0;
        while(i< arr.length){
            if(arr[i] == ElementToBeSearched){
                return i;
            }
            i = i + Math.max(1, Math.abs(arr[i] - ElementToBeSearched) / k);
        }

        return -1;
    }
}
