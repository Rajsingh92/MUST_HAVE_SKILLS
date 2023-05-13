/**
Find First and Last Position of Element in Sorted |  Medium | Facebook |
Given a sorted array with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element 
x in the given array. 
Examples: 

Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}    
        x = 5
Output : First Occurrence = 2
         Last Occurrence = 5


Number of occurrence 
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:
Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
 */



class Solution {
    public int[] searchRange(int[] arr, int ele) {
        int[] res = new int[2] ;
        
        
        
        res[0] = firstOccurence(arr,ele);
        res[1] = lastOccurence(arr,ele);

        return res;
    }
    
    public int firstOccurence(int[] arr,int ele){
        int si = 0;
        int ei = arr.length - 1;
        int first = -1;
        
        while (si <= ei) {
            int mid = (si + ei) >> 1;

            if (arr[mid] == ele) {
                first = mid;
                ei = mid-1;
            } else if (arr[mid] < ele) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        
        return first;
    }
    
    public int lastOccurence(int[] arr,int ele){
        int si = 0;
        int ei = arr.length - 1;
        int last = -1;
        
        while (si <= ei) {
            int mid = (si + ei) >> 1;

            if (arr[mid] == ele) {
                last = mid;
                si = mid+1;
            } else if (arr[mid] < ele) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        
        return last;
    }

    // Count of an Element in a Sorted Array
    public int numberOfOccurences(int[] arr,int ele){
        if(lastOccurence(arr,ele)==-1 && firstOccurence(arr,ele) == -1){
            return 0;
        }
		
        return lastOccurence(arr,ele)-firstOccurence(arr,ele)+1 ;
    }
}




