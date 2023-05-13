/**
K-partitions

1. You are given two integers n and k, where n represents number of elements and k represents number of subsets.
2. You have to partition n elements in k subsets and print all such configurations.

3
2

1. [1, 2] [3] 
2. [1, 3] [2] 
3. [1] [2, 3] 
 */

import java.io.*;
import java.util.*;

public class Main {
    static int counter = 1;

    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        if (i > n) {
            if (rssf == k) {
                System.out.print(counter + ". ");
                counter++;
                for (ArrayList<Integer> a : ans) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {

            if (ans.get(j).size() > 0) {
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                ans.get(j).add(i);
                solution(i + 1, n, k, rssf + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }

        }

    }

    public static int noOfWays(int n, int k, int[][] dp) {
        if (n == 0 || k == 0 || k > n)
            return 0;

        if (k == 1 || k == n)
            return 1;

        if (dp[n][k] != 0)
            return dp[n][k];

        int uniqueGroup = noOfWays(n - 1, k - 1, dp);
        int partOfExisGroup = noOfWays(n - 1, k, dp) * k;

        return dp[n][k] = uniqueGroup + partOfExisGroup;
    }

    static int noOfWays_DP(int n, int k) { //  -- TODO
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= k; j++){
                if(i == 0 || j == 0 || j > i){
                    dp[i][j] = 0;
                }else if(i == 1 || j == 1 || i == j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }   

        return dp[n][k];

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1, n, k, 0, ans);

    }
}


