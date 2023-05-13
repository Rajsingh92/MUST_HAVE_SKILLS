
public class Solution {

    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        if (idx < 0) {
            return;
        }
        System.out.println(arr[idx]);
        displayArrReverse(arr, idx - 1);

    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == 0) {
            return arr[idx];
        }
        int res = maxOfArray(arr, idx - 1);
        int max = Math.max(arr[idx], res);
        return max;
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == x) {
            return idx;
        } else {
            return firstIndex(arr, idx + 1, x);
        }
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
            return -1;
        }

        int res = lastIndex(arr, idx + 1, x);
        if (res == -1) {
            if (arr[idx] == x) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return res;
        }

    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
            return new int[fsf];
        }

        if (arr[idx] == x) {
            int[] iarr = allIndices(arr, x, idx + 1, fsf + 1);
            iarr[fsf] = idx;
            return iarr;
        } else {
            int[] iarr = allIndices(arr, x, idx + 1, fsf);
            return iarr;
        }
    }

}