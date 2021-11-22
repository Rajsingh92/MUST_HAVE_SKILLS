// Radix Sort
class Solution {
    private static void radixsort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int exp = 1;
        while (max / exp > 0) {
            countingsort(arr, exp);
            exp = exp * 10;
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void countSort(int[] arr, int exp) {
        int range = 10;
        int[] farr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            farr[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = farr[(arr[i] / exp) % 10] - 1;
            ans[idx] = arr[i];
            farr[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

}