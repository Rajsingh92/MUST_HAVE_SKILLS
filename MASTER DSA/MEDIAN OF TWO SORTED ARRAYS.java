/**
Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */


class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int low = 0;
        int high = a.length;
        int total = a.length + b.length;

        while (low <= high) {
            int aleft = (low + high) / 2;
            int bleft = (total + 1) / 2 - aleft;

            int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft];
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1];
            int bl = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1];

            if (alm1 <= bl && blm1 <= al) {
                double median = 0.0;

                if (total % 2 == 0) {
                    int leftMax = Math.max(alm1, blm1);
                    int rightMin = Math.min(al, bl);
                    median = (leftMax + rightMin) / 2.0;
                } else {
                    int leftMax = Math.max(alm1, blm1);
                    median = leftMax;
                }

                return median;
            } else if (alm1 > bl) {
                high = aleft - 1;
            } else if (blm1 > al) {
                low = aleft + 1;
            }
        }

        return 0;
    }
}
