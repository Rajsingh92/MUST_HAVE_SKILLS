
// Segregate positive and Negative

class Solution {
    public static void SegregatePosNeg(int[] arr) {
        int pivot = 0;
        int i = 0, j = arr.length - 1;

        while (i <= hi) {
            if (arr[i] < pivot) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}