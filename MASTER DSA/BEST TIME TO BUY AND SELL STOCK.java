/** 
Best Time to Buy and Sell Stock |  Easy | Facebook | -- One transaction
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to 
sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int profitToday = 0;
        int overallProfit = 0;
        
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<lsf){
                lsf = prices[i];
            }
            
            profitToday = prices[i] - lsf;
            if(profitToday>overallProfit)
                overallProfit = profitToday;
        }
        
        return overallProfit;
    }
}

/**
Best Time to Buy and Sell Stock II |  Easy | Alibaba | -- Infinite transaction
Say you have an array prices for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell 
one share of the stock multiple times).
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */

class Solution {
    public int maxProfit(int[] prices) {
        int buyDate  = 0;
        int sellDate = 0;
        int profit = 0;
        
        for(int i =1;i<prices.length;i++){
            if(prices[i]>=prices[i-1]){
                sellDate++;
            }else{
                profit += prices[sellDate] - prices[buyDate];
                sellDate = buyDate = i;
            }
        }
        profit += prices[sellDate] - prices[buyDate];  //last upstroke
        
        return profit;
    }
}




/**
Best Time to Buy and Sell Stock III |  Hard | Amazon, Microsoft |

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */


class Solution {
    public int maxProfit(int[] arr) {
        int misf = arr[0];
        int[] ps = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < misf) {
                misf = arr[i];
            }

            if (arr[i] - misf > ps[i - 1]) {
                ps[i] = arr[i] - misf;
            } else {
                ps[i] = ps[i - 1];
            }
        }

        int masf = arr[arr.length - 1];
        int[] pb = new int[arr.length];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > masf) {
                masf = arr[i];
            }

            if (masf - arr[i] > pb[i + 1]) {
                pb[i] = masf - arr[i];
            } else {
                pb[i] = pb[i + 1];
            }
        }

        int mp = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (ps[i] + pb[i] > mp) {
                mp = ps[i] + pb[i];
            }
        }

        return mp;
    }
}





/**
Best Time to Buy and Sell Stock IV |  Hard | Amazon, Google |

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 */



class Solution {
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) {
            int fadd = Integer.MIN_VALUE;

            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j - 1] - arr[j - 1] > fadd) {
                    fadd = dp[i - 1][j - 1] - arr[j - 1];
                }

                if (fadd + arr[j] > dp[i][j - 1]) {
                    dp[i][j] = fadd + arr[j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[k][n - 1];
    }
}




/**
Best Time to Buy and Sell Stock with Cooldown

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
 

class Solution {
    public int maxProfit(int[] arr) {
        int bstp = -arr[0];
        int sstp = 0;
        int cstp = 0;
        for (int i = 1; i < arr.length; i++) {
            int nbstp = 0;
            int nsstp = 0;
            int ncstp = 0;

            if (cstp - arr[i] > bstp) {
                nbstp = cstp - arr[i];
            } else {
                nbstp = bstp;
            }

            if (bstp + arr[i] > sstp) {
                nsstp = bstp + arr[i];
            } else {
                nsstp = sstp;
            }

            if (sstp > cstp) {
                ncstp = sstp;
            } else {
                ncstp = cstp;
            }

            bstp = nbstp;
            sstp = nsstp;
            cstp = ncstp;
        }

        return Math.max(sstp, cstp);
    }
}




/**
Best Time to Buy and Sell Stock with Transaction Fee |  Medium | Facebook |

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */

class Solution {
    public int maxProfit(int[] arr, int fee) {
        int bstp = -arr[0];
        int sstp = 0;
        for (int i = 1; i < arr.length; i++) {
            int nsstp = 0;
            int nbstp = 0;

            if (sstp - arr[i] > bstp) {
                nbstp = sstp - arr[i];
            } else {
                nbstp = bstp;
            }

            if (bstp + arr[i] - fee > sstp) {
                nsstp = bstp + arr[i] - fee;
            } else {
                nsstp = sstp;
            }

            bstp = nbstp;
            sstp = nsstp;
        }

        return sstp;
    }
}



