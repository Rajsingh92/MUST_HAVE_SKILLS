import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr, int idx, int m, int k, int[] presum, int[][] dp) {
        if (m == 0 || idx >= arr.length) {
            return 0;
        }

        if (dp[idx][m] != 0) {
            return dp[idx][m];
        }
        int exclude = 0 + solution(arr, idx + 1, m, k, presum, dp);
        int include = presum[idx] + solution(arr, idx + k, m - 1, k, presum, dp);

        dp[idx][m] = Math.max(exclude, include);
        return dp[idx][m];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int k = scn.nextInt();

        int[] presum = new int[n];

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        presum[0] = sum;
        for (int i = k, j = 0; i < n; i++, j++) {
            sum += arr[i] - arr[j];
            presum[i - k + 1] = sum;
        }

        System.out.println(solution(arr, 0, m, k, presum, new int[arr.length][m + 1]));
    }

}