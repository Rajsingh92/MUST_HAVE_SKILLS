import java.io.*;
import java.util.*;

public class Main {

    public static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        //if number of floors == 1 ans number of eggs >= 1, then we need only one attempt
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        //if number of eggs == 1
        for (int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int f = 1; f <= j; f++) {
                    max = 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]);
                    if (max < dp[i][j]) {
                        dp[i][j] = max;
                    }
                }
            }
        }
        return dp[n][k];
    }

    //887
public int superEggDrop(int K, int N,int[][] dp) {
    if(N <= 2) return dp[N][K] = N;
    if(K == 1) return dp[N][K] =N;
    
    if(dp[N][K]!=0) return dp[N][K];
    
    int ans = (int)1e8, lo = 1, hi = N;
    while(lo <= hi){
        
        int mid = (lo + hi) >> 1;
        int EggBreak = superEggDrop(K-1,mid-1,dp);
        int EggNotBreak = superEggDrop(K,N- mid,dp);
        
        if(EggBreak < EggNotBreak) lo = mid + 1;
        else hi = mid - 1;
        
        ans = Math.min(ans, 1 + Math.max(EggBreak,EggNotBreak));
    }
    
    return dp[N][K] = ans;
}

public int superEggDrop(int K, int N) {
    int[][] dp = new int[N+1][K+1];
    
    return superEggDrop(K,N,dp);
}


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //n -> number of eggs and k -> number of floors
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(eggDrop(n, k));
    }



}


//https://www.geeksforgeeks.org/count-possible-ways-to-construct-buildings/


