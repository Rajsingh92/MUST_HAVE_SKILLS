class Solution {
    public int binarySearch(int arr[], int low, int high, int diff) {
        if (high <= low)
            return Integer.MAX_VALUE;

        int mid = low + (high - low) / 2;

        // found
        if (arr[mid + 1] - arr[mid] != diff)
            return (arr[mid] + diff);
        if (mid > 0 && arr[mid] - arr[mid - 1] != diff)
            return (arr[mid - 1] + diff);

        // did not found
        if (arr[mid] == arr[0] + mid * diff)
            return binarySearch(arr, mid + 1, high, diff);
        else
            return binarySearch(arr, low, mid - 1, diff);
    }

    public int findMissing(int arr[], int n) {
        int diff = (arr[n - 1] - arr[0]) / n;
        return binarySearch(arr, 0, n - 1, diff);
    }
}
