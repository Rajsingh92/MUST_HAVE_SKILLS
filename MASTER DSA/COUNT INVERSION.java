public class Solution {

    // not passing all test cases
    static long count = 0;

    static long inversionCount(long arr[], long N) {
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    static long[] mergeTwoSorted(long[] left, long[] right) {
        int i = 0, j = 0, k = 0;

        long[] merged = new long[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                count += left.length - i;
                merged[k] = right[j];
                k++;
                j++;
            } else {
                merged[k] = left[i];
                k++;
                i++;
            }
        }

        while (i < left.length) {
            merged[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            merged[k] = right[j];
            k++;
            j++;
        }

        return merged;
    }

    static long[] mergeSort(long arr[], int low, int high) {
        if (low == high) {
            long[] barr = new long[1];
            barr[0] = arr[low];
            return barr;
        }

        int mid = (low + high) / 2;
        long[] left = mergeSort(arr, low, mid);
        long[] right = mergeSort(arr, mid + 1, high);

        long[] merged = mergeTwoSorted(left, right);

        return merged;

    }
}