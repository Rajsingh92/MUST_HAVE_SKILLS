
/**
QUICK SORT
 */
public class Main {

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return;
        }

        int pi = partition(arr, lo, hi);
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (j - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}


/**
QUICK SELECT : find the k-th smallest element in the given array
 */



public class Main {

    // passed k as k-1
    public static int quickSelect(int[] arr, int lo, int hi, int k) {

        int pi = partition(arr, lo, hi);
        if (k > pi) {
            return quickSelect(arr, pi + 1, hi, k);
        } else if (k < pi) {
            return quickSelect(arr, lo, pi - 1, k);
        } else {
            return arr[pi];
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }

        return (j - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}







// 3 Way Quicksort Dutch National Flag
public class Solution {
    private static void quicksort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int[] two = threewayPartition(arr, lo, hi);
        quicksort(arr, lo, two[0]);
        quicksort(arr, two[1], hi);

    }

    private static int[] threewayPartition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];

        int i = lo;
        int j = hi;
        int itr = lo;
        while (itr <= j) {
            if (arr[itr] < pivot) {
                swap(arr, itr, i);
                i++;
                itr++;
            } else if (arr[itr] == pivot) {
                itr++;
            } else {
                swap(arr, itr, j);
                j--;
            }
        }

        int[] two = new int[2];
        two[0] = i - 1;
        two[1] = itr;
        return two;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}





/**
iterative quick sort
 */