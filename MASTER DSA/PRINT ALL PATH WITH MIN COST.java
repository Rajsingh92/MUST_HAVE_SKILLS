/**
Minimum Path Sum |  Medium | Adobe, Amazon, Google, Microsoft |
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of 
all numbers along its path.

Note: You can only move either down or right at any point in time.


Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

 */



class Solution {
    public int[][] minPathSum(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        
        //System.out.println(dp[0][0]);
        return dp;
    }

    private class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }


    public  void printPath(int[][] arr){
        int[][] dp = minPathSum(arr);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("", 0, 0));
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();

            if (rem.i == dp.length - 1 && rem.j == dp[0].length - 1) {
                System.out.println(rem.psf);
            } else if (rem.i == dp.length - 1) {
                queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
            } else if (rem.j == dp[0].length - 1) {
                queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
            } else {
                if (dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j]) {
                    queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                } else if (dp[rem.i][rem.j + 1] > dp[rem.i + 1][rem.j]) {
                    queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                } else {
                    queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                    queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                }
            }
        }
    }

  
}

