/**
Find floor and ceil in an sorted array
Given an sorted array arr[] and an element x, find floor and ceiling of x in arr[0..n-1].
Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is 
smaller than smallest element of arr[].
Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greates element of arr[].

arr = {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array
 */


class Solution {
    public void floorAndCeil(int[] arr, int data) {
        int left = 0;
        int right = arr.length - 1;
        int ceil = 0;
        int floor = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data > arr[mid]) {
                left = mid + 1;
                floor = arr[mid];
            } else if (data < arr[mid]) {
                right = mid - 1;
                ceil = arr[mid];
            } else {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }
        }

        System.out.println(ceil);
        System.out.println(floor);
    }
}


/* 
Smallest alphabet greater than a given character

find the smallest element in the list that is larger than K. 

Examples:  

Input : Letters = ["D", "J", "K"]
        K = "B"
Output: 'D'
*/

class Solution2{
    public static char nextGreatestAlphabet2(char[] alphabets,char k){
        int low = 0;
        int high = alphabets.length-1;
        int floor = -1;

        while(low<=high){
            int mid = (low+high)/2;

            if(alphabets[mid] > k){
                high = mid-1;
                floor = mid;
            }else{
                low = mid+1;
            }
        }

        return alphabets[floor];
    }
}
