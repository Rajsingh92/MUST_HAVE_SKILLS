// minimum no of deletion to make array in sorted order in increasing order.

public class Solution {

    public static int minimum_No_of_deletion(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int maxLen = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return n - maxLen;
    }
}
