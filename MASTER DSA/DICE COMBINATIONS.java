// https://cses.fi/problemset/task/1633

import java.util.*;
import java.io.*;


public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int mod = 1000000007;

    public static int solve(int n,int[] dp){

        // dp[i] = number of ways to make sum x using numbers from 1 to 6
        // dp[x] = dp[x-1] + dp[x-2] + dp[x-3] + dp[x-4] + dp[x-5] + dp[x-6]
        
        dp[0] = 1;
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<=6 && i-j>=0;j++){
                dp[i] += dp[i-j] % mod;
                dp[i] = dp[i] % mod;
            }
        }

        return dp[n];
    }

    
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int n = scan.nextInt();
        
        System.out.println(solve(n,new int[n+1]));
    }
}
