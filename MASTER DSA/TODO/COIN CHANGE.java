/**
COIN CHANGE COMBINATION - 1: 

arr : 2 3 5 6 7
target : 12

op : 
2-3-7-.
5-7-.
 */



class Main {
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        if(i == coins.length){
            if(amtsf == tamt){
                System.out.println(asf+".");
            }
            return;
        }
        
        
        
        coinChange(i+1,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");  //yes
        coinChange(i+1,coins,amtsf+ 0 ,tamt,asf);  //no
        
    }
}





/**
COIN CHANGE COMBINATION - 2: 

arr : 2 3 5 6 7
target : 12

op : 
2-2-2-2-2-2-.
2-2-2-3-3-.
2-2-2-6-.
2-2-3-5-.
2-3-7-.
2-5-5-.
3-3-3-3-.
3-3-6-.
5-7-.
6-6-.
 */

class Main {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if( i == coins.length ){
            if(amtsf == tamt){
                System.out.println(asf+".");
            }
            return;
        }
        
        
        // yes
        for(int j = tamt / coins[i] ;j>=1;j--){
            String part = "";
            for(int k=0;k<j;k++){
                part+=coins[i]+"-";
            }
            coinChange(i+1,coins,amtsf+coins[i]*j,tamt,asf+part);
        }
        
        // no
        coinChange(i+1,coins,amtsf,tamt,asf);
    }
}

/**
Coin Change 2 |  Medium | Amazon, Facebook, Google, Microsoft | (combination)

You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 */

class Solution {
    public int change(int amount, int[] arr) {
        if (amount == 0) {
            return 1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        return dp[amount];
    }

} 

/**
Coin Change - Permutations - 1 :

arr : 2 3 5 6 7
target : 12

op : 
2-3-7-.
2-7-3-.
3-2-7-.
3-7-2-.
5-7-.
7-2-3-.
7-3-2-.
7-5-.
 */


class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
        if(amtsf>tamt){
            return;
        }
        
        if(amtsf == tamt){
            System.out.println(asf+".");
            return;
        }
        
        for(int i=0;i<coins.length;i++){
            if(used[i] == false){
                used[i] = true;
                coinChange(coins,amtsf+coins[i],tamt,asf+coins[i]+"-",used);
                used[i] = false;
            }
            
        }
     }
}


/**
Coin Change - Permutations - 2 :

arr : 2 3 5 6 7
target : 12

op : 
2-2-3-.
2-3-2-.
2-5-.
3-2-2-.
5-2-.
 */


class Main {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        if (amtsf > tamt) {
            return;
        } 
        
        if (amtsf == tamt) {
            System.out.println(asf + ".");
            return;
        }

        for (int j = 0; j < coins.length; j++) {
            coinChange(coins, amtsf + coins[j], tamt, asf + coins[j] + "-");
        }
    }
}









// coin change permutation
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int[] dp = new int[amt+1];
        dp[0] = 1;
        
        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(i>=arr[j]){
                    dp[i]+=dp[i-arr[j]];
                }
            }
        }
        
        System.out.println(dp[amt]);
    }
}

/**
| 322 | Coin Change |  Medium | Adobe, Airbnb, Amazon, Apple, Facebook, Microsoft |
*/

/**
public class coinchange {
    public static int coinChangePermutation_memo(int[] arr, int tar, int[] dp) {
        if (tar == 0) {
            return dp[tar] = 1;
        }

        if (dp[tar] != -1)
            return dp[tar];

        int count = 0;
        for (int ele : arr) {
            if (tar - ele >= 0) {
                count += coinChangePermutation_memo(arr, tar - ele, dp);
            }
        }

        return dp[tar] = count;
    }

    public static int coinChangePermutation_DP(int[] arr, int Tar, int[] dp) {
        dp[0] = 1;
        for (int tar = 0; tar <= Tar; tar++) {
            for (int ele : arr) {
                if (tar - ele >= 0) {
                    dp[tar] += dp[tar - ele];
                }
            }
        }

        return dp[Tar];
    }

    public static int coinChangeCombination_memo(int[] arr, int tar, int li, int[][] dp) {
        if (tar == 0) {
            return dp[li][tar] = 1;
        }
        int count = 0;
        for (int i = li; i >= 0; i--)
            if (tar - arr[i] >= 0) {
                count += coinChangeCombination_memo(arr, tar - arr[i], i, dp);
            }

        return dp[li][tar] = count;
    }

    public static int coinChangeCombination_2DP(int[] arr, int Tar, int LI, int[][] dp) {

        for (int li = 0; li <= LI; li++) {
            for (int tar = 0; tar <= Tar; tar++) {
                if (tar == 0) {
                    dp[li][tar] = 1;
                    continue;
                }

                for (int i = li; i >= 0; i--)
                    if (tar - arr[i] >= 0) {
                        dp[li][tar] += dp[i][tar - arr[i]];
                    }
            }
        }

        return dp[LI][Tar];
    }

    public static int coinChangeCombination_1DP(int[] arr, int Tar, int[] dp) {
        dp[0] = 1;
        for (int ele : arr) {
            for (int tar = ele; tar <= Tar; tar++) {
                if (tar - ele >= 0) {
                    dp[tar] += dp[tar - ele];
                }
            }
        }

        return dp[Tar];

    }

    public static void coinChnage() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;

        int[][] dp = new int[arr.length][tar + 1];
        System.out.println(coinChangeCombination_2DP(arr, tar, arr.length - 1, dp));

        print2D(dp);
    }

    // 518
    public int change(int Tar, int[] arr) {
        int[] dp = new int[Tar + 1];
        dp[0] = 1;
        for (int ele : arr) {
            for (int tar = ele; tar <= Tar; tar++) {
                if (tar - ele >= 0) {
                    dp[tar] += dp[tar - ele];
                }
            }
        }

        return dp[Tar];

    }

    // 322
    public int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != (int) 1e9)
            return dp[amount];

        int minCoins = (int) 1e8;
        for (int ele : coins) {
            if (amount - ele >= 0) {
                minCoins = Math.min(minCoins, coinChange(coins, amount - ele, dp) + 1);

            }
        }

        return dp[amount] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int) 1e9);

        int ans = coinChange(coins, amount, dp);

        return ans != (int) 1e8 ? ans : -1;
    }
}

 */