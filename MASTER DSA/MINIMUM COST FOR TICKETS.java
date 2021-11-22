/**
Minimum Cost For Tickets |  Medium | Amazon |

You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
 */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return mincostTickets_DP(days, costs, new int[days.length], 0, 0);
    }

    private int mincostTickets_DP(int[] days, int[] costs, int[] dp, int idx, int currDay) {
        if (days.length == idx)
            return 0;

        if (days[idx] < currDay) {
            return mincostTickets_DP(days, costs, dp, idx + 1, currDay);
        } else {
            if (dp[idx] != 0)
                return dp[idx];

            int oneDay = costs[0] + mincostTickets_DP(days, costs, dp, idx + 1, days[idx] + 1) ;
            int sevenDay = costs[1] + mincostTickets_DP(days, costs, dp, idx + 1, days[idx] + 7) ;
            int thirtyDay = costs[2] + mincostTickets_DP(days, costs, dp, idx + 1, days[idx] + 30) ;

            dp[idx] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
            return dp[idx];
        }
    }
}