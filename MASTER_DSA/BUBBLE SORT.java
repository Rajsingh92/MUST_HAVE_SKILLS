class BubbleSort {
    public static void bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i - 1; j++) {
                if (arr[j + 1] > arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

