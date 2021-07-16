/**
Tiling With 2 * 1 Tiles

1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 */




import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i =3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        System.out.println(dp[n]);
    }
}


/**
Tiling With M * 1 Tiles

1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
2. You've an infinite supply of m * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 */


class Main2 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[] dp = new int[n+1];

        
        for(int i =0;i<n+1;i++){
            if(i<m){
                dp[i] = 1;
            }else if(i == m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1]+dp[i-m];
            }
        }
        
        System.out.println(dp[n]);
    }
}



/**
Domino and Tromino Tiling

We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

XX  <- domino

XX  <- "L" tromino
X
Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.

(In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)

Example:
Input: 3
Output: 5
Explanation: 
The five different ways are listed below, different letters indicates different tiles:
XYZ XXZ XYY XXY XYY
XYZ YYZ XZZ XYY XXY
 */


class Solution {
    public int numTilings(int N) {
        if (N == 1) {
            return 1;
        }  
        if (N == 2) {
            return 2;
        }
        if (N == 3) {
            return 5;
        }
        
        int mod = 1000000007;
        int[] f = new int[N + 1];

        f[1] = 1;
        f[2] = 2;
        f[3] = 5;
        for (int i = 4; i <= N; i++) {
            f[i] = 2 * f[i - 1] % mod + f[i - 3] % mod;
            f[i] %= mod;
        }
        return (f[N]);
    }
}

