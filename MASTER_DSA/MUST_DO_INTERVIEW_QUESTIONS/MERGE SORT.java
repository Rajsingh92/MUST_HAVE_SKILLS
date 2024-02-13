/**
Merge Sorted Array |  Easy | Adobe, Amazon, Facebook, Microsoft |

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a 
size equal to m + n such that it has enough space to hold additional elements from nums2.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
 */





class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}



/**
Merge two sorted arrays with O(1) extra space

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}
 */

class Solution {
    public void merge(int arr1[], int arr2[], int m, int n) {
        for (int i = n - 1; i >= 0; i--) {

            int last = arr1[m - 1];
            int j;

            for (j = m - 2; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    arr1[j + 1] = arr1[j];
                }
            }

            if (j != m - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}






