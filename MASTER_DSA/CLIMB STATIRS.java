/**
Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */

class Solution {
    public static int countPaths_MEMO(int n, int[] lookup) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (lookup[n] > 0) {
            return lookup[n];
        }

        int a = countPaths_MEMO(n - 1,lookup);
        int b = countPaths_MEMO(n - 2,lookup);
        int c = countPaths_MEMO(n - 3,lookup);
        lookup[n] = a + b + c;
        return lookup[n];
    }

    public static int countPaths_DP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }

    // variable jumps
    public static int countPaths(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        return dp[0];
    }
}


/**
Min Cost Climbing Stairs |  Easy | Amazon |

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the 
cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
 */


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[dp.length - 1] = 0;
        dp[dp.length - 2] = cost[dp.length - 2];

        for (int i = dp.length - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        int sum = 0;

        for (int i = 2; i < cost.length; i++) {
            sum = cost[i] + Math.min(a, b);
            a = b;
            b = sum;
        }

        return Math.min(a, b);
    }
}



// climb stairs with minimum moves
public class Main {

    public static int countPaths(int[] arr, int n) {
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                if (dp[i + j] != null) {
                    min = Math.min(min, dp[i + j]);
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        return dp[0];
    }

    public static class Pair {
        int i;
        int jmps;
        String psf;

        Pair(int i, int jmps, String psf) {
            this.i = i;
            this.jmps = jmps;
            this.psf = psf;
        }
    }

    // print all paths with min jumps -- TODO
    public static void solve(int[] arr) {
        Integer[] dp = new Integer[arr.length];
        dp[arr.length - 1] = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                if (dp[i + j] != null && dp[i + j] < min) {
                    min = dp[i + j];
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }

        System.out.println(dp[0]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, dp[0], ""));

        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();

            if (rem.jmps == 0) {
                System.out.println(rem.psf + " .");
            }

            for (int j = 1; j <= arr[rem.i] && rem.i + j < dp.length; j++) {
                int ci = rem.i + j;
                if (dp[ci] != null && dp[ci] == rem.jmps - 1) {
                    queue.add(new Pair(ci, rem.jmps - 1, rem.psf + " - > " + ci));
                }
            }
        }
    }

}