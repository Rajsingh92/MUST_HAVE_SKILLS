/**
# 0 – 1 Knapsack problem
def knapSack(val,wt,W,n):
    if n==0 or W==0:
        return 0

    if wt[n-1]>W:
        return knapSack(val,wt,W,n-1)
    else:
        return max(val[n-1]+knapSack(val,wt,W-wt[n-1],n-1), knapSack(val,wt,W,n-1))


def knapSack_MEMO(val,wt,W,n,lookup): #fill lookup with -1
    if n==0 or W==0:
        return 0
    if lookup[n][W]!=-1:
        return lookup[n][W]

    if wt[n-1]>W:
        lookup[n][W] =  knapSack(val,wt,W,n-1,lookup)
        return lookup[n][W]
    else:
        lookup[n][W] =  max( val[n-1]+knapSack_MEMO(val,wt,W-wt[n-1],n-1,lookup), knapSack_MEMO(val,wt,W,n-1,lookup) )
        return lookup[n][W]

    

def knapSack_DP(val,wt,W,n):
    dp = [[0 for j in range(W+1)] for i in range(n+1)]

    for i in range(n+1):
        for j in range(W+1):
            if i==0 or j==0:
                dp[i][j]=0
            if wt[i-1]>j:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max( val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j] )

    print(dp[n][W])

 */



public class Main {

    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void printResult(int cap, int[] wts, int[] values, int n) {
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int val = values[i - 1];
                int wt = wts[i - 1];

                if (j >= wt) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt] + val);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][cap]);
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, cap, ""));

        while (q.size() > 0) {
            Pair rp = q.remove();
            if (rp.i == 0 || rp.j == 0) {
                System.out.println(rp.psf);
            } else {
                int exc = dp[rp.i - 1][rp.j];
                int inc = rp.j - wts[rp.i - 1] >= 0 ? (dp[rp.i - 1][rp.j - wts[rp.i - 1]] + values[rp.i - 1])
                        : Integer.MIN_VALUE;

                if (dp[rp.i][rp.j] == inc) {
                    q.add(new Pair(rp.i - 1, rp.j - wts[rp.i - 1], (rp.i - 1) + " " + rp.psf));
                }
                if (dp[rp.i][rp.j] == exc) {
                    q.add(new Pair(rp.i - 1, rp.j, rp.psf));
                }
            }
        }
    }
}


/**
// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
    public static int knapsack(int[] weight, int[] value, int n, int bagWeight, int[][] dp) {
        if (n == 0 || bagWeight == 0) {
            return dp[n][bagWeight] = 0;
        }

        if (dp[n][bagWeight] != 0)
            return dp[n][bagWeight];

        int maxCost = 0;
        if (bagWeight - weight[n - 1] >= 0)
            maxCost = knapsack(weight, value, n - 1, bagWeight - weight[n - 1], dp) + value[n - 1];
        maxCost = Math.max(maxCost, knapsack(weight, value, n - 1, bagWeight, dp));

        return dp[n][bagWeight] = maxCost;
    }

    public static int knapsack_DP(int[] weight, int[] value, int BagWeight) {
        int N = weight.length;
        int[][] dp = new int[N + 1][BagWeight + 1];

        for (int n = 0; n <= N; n++) {
            for (int bagWeight = 0; bagWeight <= BagWeight; bagWeight++) {
                if (n == 0 || bagWeight == 0) {
                    dp[n][bagWeight] = 0;
                    continue;
                }

                if (bagWeight - weight[n - 1] >= 0)
                    dp[n][bagWeight] = dp[n - 1][bagWeight - weight[n - 1]] + value[n - 1];
                dp[n][bagWeight] = Math.max(dp[n][bagWeight], dp[n - 1][bagWeight]);
            }
        }

        return dp[N][BagWeight];
    }

    public static int knapsack_unbounded(int[] weight, int[] value, int BagWeight) {
        // combination
        int n = weight.length;
        int[] dp = new int[BagWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int bagWeight = weight[i]; bagWeight <= BagWeight; bagWeight++) {
                dp[bagWeight] = Math.max(dp[bagWeight], dp[bagWeight - weight[i]] + value[i]);
            }
        }

        return dp[BagWeight];
    }
 */