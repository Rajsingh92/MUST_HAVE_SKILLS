/**
Find common elements in three sorted arrays
Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
Examples:

Input:
ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80
 */

public class Solution{
    public static void findCommon(int[] arr1 , int[] arr2 , int[] arr3){
        int i = 0, j = 0, k = 0;
        while(i< arr1.length && j<arr2.length && k< arr3.length){
            if(arr1[i] == arr2[j] && arr2[j] == arr2[k]){
                System.out.print(arr1[i]);
                i++;
                j++;
                k++;
            }else if(arr2[j]>arr1[i]){
                i++;
            }else if(arr3[k]>arr2[j]){
                j++;
            }else{
                k++;
            }
        }
    }
}
