/**
Minimum Number Of Steps To Reduce N / Form N

1. You are given a number N.
2. You have to find the minimum number of operations needed to reduce it to 1.
3. operations allowed are - 
   -> If n is divisible by 2 then you may reduce n to n/2.
   -> If n is divisible by 3 then you may reduce n to n/3.
   -> Decrement n by 1.
 */
 


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return (dp[n]);
    }
}





