//  Searching in a Nearly Sorted Array
class Solution {
    public static int searchElement(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (mid - 1 >= low && arr[mid - 1] == target) {
                return mid - 1;
            } else if (mid + 1 <= high && arr[mid + 1] == target) {
                return mid + 1;
            }

            if (arr[mid] > target) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }

        return -1;
    }
}