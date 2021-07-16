class InsertionSort {
    public static void insertion_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > val) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = val;
        }
    }
}
