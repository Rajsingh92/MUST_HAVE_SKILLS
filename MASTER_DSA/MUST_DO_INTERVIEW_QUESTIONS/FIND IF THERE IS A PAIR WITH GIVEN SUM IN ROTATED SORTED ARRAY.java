
class Solution {
    public boolean pairInSortedRotated(int arr[], int n, int x) {

        // binary search can be used here
        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;

        int l = (i + 1) % n;
        int r = i;

        while (l != r) {
            if (arr[l] + arr[r] == x) {
                return true;
            } else if (arr[l] + arr[r] < x) {
                l = (l + 1) % n;
            } else {
                r = (n + r - 1) % n;
            }

        }
        return false;
    }
}
