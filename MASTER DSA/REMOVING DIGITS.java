// https://cses.fi/problemset/task/1637

import java.util.*;
import java.io.*;

class Main {

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
    static int posInf = Integer.MAX_VALUE;
    static int negInf = Integer.MIN_VALUE;

    public static int solve(int n, int[] dp) {

        // dp[i] = minimum number steps to convert i to 0

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int num = i;
            while (num > 0) {
                int last = num % 10;
                if (last != 0) {
                    dp[i] = Math.min(dp[i], dp[i - last] + 1);
                }

                num = num / 10;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int n = scan.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, posInf);
        System.out.println(solve(n, dp));
    }
}
