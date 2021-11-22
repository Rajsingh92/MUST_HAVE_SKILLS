/**
Subset Sum Problem / Target Sum Subset

Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is 
the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination: 
The two parts are {1, 5, 5} and {11}.

Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explaination: This array can never be 
partitioned into two such parts.

def subsetsum(arr, sum, n): #knapsack variation
    if n == 0:
        return False
    if sum == 0:
        return True

    if sum < arr[n-1]:
        return subsetsum(arr,sum,n-1)

    return subsetsum(arr, sum-arr[n-1], n-1) or subsetsum(arr, sum, n-1)


def subsetsum_Dp(arr, sum, n):
    dp = [[False for j in range(sum+1)] for i in range(n+1)]

    for j in range(1, sum+1):
        dp[0][j] = False
    for i in range(n+1):
        dp[i][0] = True

    for i in range(n+1):
        for j in range(sum+1):
            if j < arr[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = dp[i-1][j-arr[i-1]]

    print(dp[n][sum])
 */


public class targetsum {

    public static int targetSum(int[] arr, int idx, int tar, int[][] dp) {
        if (tar == 0 || idx == arr.length) {
            return dp[idx][tar] = tar == 0 ? 1 : 0;
        }

        if (dp[idx][tar] != -1)
            return dp[idx][tar];

        int count = 0;
        if (tar - arr[idx] >= 0)
            count += targetSum(arr, idx + 1, tar - arr[idx], dp);
        count += targetSum(arr, idx + 1, tar, dp);

        return dp[idx][tar] = count;
    }

    public static int targetSumDP(int[] arr, int Idx, int Tar, int[][] dp) {
        for (int idx = arr.length; idx >= 0; idx--) {
            for (int tar = 0; tar <= Tar; tar++) {
                if (tar == 0 || idx == arr.length) {
                    dp[idx][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }

                int count = 0;
                if (tar - arr[idx] >= 0)
                    count += dp[idx + 1][tar - arr[idx]];
                count += dp[idx + 1][tar];

                dp[idx][tar] = count;
            }
        }

        return dp[Idx][Tar];
    }

    public static boolean targetSumPath(int[] arr, int n, int tar, int[][] dp, String psf) {
        if (tar == 0 || n == 0) {
            if (tar == 0) {
                System.out.println(psf);
                return true;
            }
            return false;
        }

        boolean res = false;
        if (tar - arr[n - 1] >= 0 && dp[n - 1][tar - arr[n - 1]] > 0)
            res = res || targetSumPath(arr, n - 1, tar - arr[n - 1], dp, psf + arr[n - 1] + ",");
        if (dp[n - 1][tar] > 0)
            res = res || targetSumPath(arr, n - 1, tar, dp, psf);

        return res;
    }

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

    public static void printResult(int n, int[] arr, int tar) {

        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];
                        if (j >= val && dp[i - 1][j - val] == true) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        System.out.println(dp[dp.length - 1][tar]);
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, tar, ""));

        while (q.size() > 0) {
            Pair rp = q.remove();
            if (rp.i == 0 || rp.j == 0) {
                System.out.println(rp.psf);
            } else {
                boolean exc = dp[rp.i - 1][rp.j];
                boolean inc = rp.j - arr[rp.i - 1] >= 0 ? dp[rp.i - 1][rp.j - arr[rp.i - 1]] : false;

                if (inc == true) {
                    q.add(new Pair(rp.i - 1, rp.j - arr[rp.i - 1], (rp.i - 1) + " " + rp.psf));
                }
                if (exc == true) {
                    q.add(new Pair(rp.i - 1, rp.j, rp.psf));
                }
            }
        }
    }

}


/**
Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums 
and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the 
expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
 */


class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
      
        if(n == 0) return 0; 
        
        int sum = 0;
        for(int ele : nums) sum+=ele;
        if(S > sum || S < -sum) return 0;
        int[][] dp = new int[n+1][2 * sum + 1];
        for(int[] d: dp) Arrays.fill(d,-1);
        int ans = findTargetSumWays(nums,(S + sum),n,(0 + sum),dp);

        return ans;
    }
    
    public int findTargetSumWays(int[] nums, int tar,int n,int sum,int[][] dp) {
        if(n == 0){
            return dp[n][sum] = (tar == sum)? 1: 0;
        }

        if(dp[n][sum] != -1) return dp[n][sum];

        int count = 0;
        count += findTargetSumWays(nums,tar,n-1,sum + nums[n-1],dp); // positive number
        count += findTargetSumWays(nums,tar,n-1,sum + (-nums[n-1]),dp); // negative number

        return dp[n][sum] = count;
    }
}




/**
// https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

    public static int targetSum(int[] arr, int n, int tar, int[][] dp) {
        if (n == 0 || tar == 0) {
            return dp[n][tar] = (tar == 0) ? 1 : 0;
        }

        if (dp[n][tar] != -1)
            return dp[n][tar];

        boolean res = false;
        if (tar - arr[n - 1] >= 0)
            res = res || (targetSum(arr, n - 1, tar - arr[n - 1], dp) == 1);

        res = res || (targetSum(arr, n - 1, tar, dp) == 1);

        return dp[n][tar] = res ? 1 : 0;
    }

    public static boolean targetSum_DP(int[] arr, int Tar) {
        int N = arr.length;
        boolean[][] dp = new boolean[N + 1][Tar + 1];

        for (int n = 0; n <= N; n++) {
            for (int tar = 0; tar <= Tar; tar++) {
                if (n == 0 || tar == 0) {
                    dp[n][tar] = (tar == 0);
                    continue;
                }

                if (tar - arr[n - 1] >= 0)
                    dp[n][tar] = dp[n][tar] || dp[n - 1][tar - arr[n - 1]];
                dp[n][tar] = dp[n][tar] || dp[n - 1][tar];
            }
        }

        return dp[N][Tar];
    }

    public static int targetSumTotalWays_DP(int[] arr, int Tar) {
        int N = arr.length;
        int[][] dp = new int[N + 1][Tar + 1];

        for (int n = 0; n <= N; n++) {
            for (int tar = 0; tar <= Tar; tar++) {
                if (n == 0 || tar == 0) {
                    dp[n][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }

                if (tar - arr[n - 1] >= 0)
                    dp[n][tar] += dp[n - 1][tar - arr[n - 1]];
                dp[n][tar] += dp[n - 1][tar];
            }
        }

        return dp[N][Tar];
    }

    public static void targetSum(int[] arr, int tar) {
        int n = arr.length;
        int[][] dp = new int[n + 1][tar + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        boolean res = targetSum(arr, n, tar, dp) == 1;
        System.out.println(res);
        print2D(dp);
    }
 */