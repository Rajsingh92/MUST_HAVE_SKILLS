/**
Input : 10010
Output : 10100
Here n = (18)10 = (10010)2
next greater = (20)10 = (10100)2
Binary representation of 20 contains same number of 1's and 0's as in 18.

Input : 111000011100111110
Output :  111000011101001111
 */

class Solution {

    public static String solve(char[] arr) {
        int i = 0;
        for (i = arr.length - 2; i >= 1; i--) {
            if (arr[i] == '0' && arr[i + 1] == '1') {
                char ch = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = ch;
                break;
            }
        }

        // shift all 1's to end
        int low = i + 2;
        int high = arr.length - 1;

        while (low <= high) {
            if (arr[low] == '1' && arr[high] == '0') {
                char ch = arr[low];
                arr[low] = arr[high];
                arr[high] = ch;
                low++;
            }
            high--;
        }

        return String.valueOf(arr);
    }
}
