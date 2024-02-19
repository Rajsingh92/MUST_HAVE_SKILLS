/**
Dungeon Game | Hard | Amazon |

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists 
of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must 
fight his way through dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops 
to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering 
these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health 
(represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in 
each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right 
room where the princess is imprisoned.

 

Example 1:


Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: 
RIGHT-> RIGHT -> DOWN -> DOWN.
 */


class Solution {

    public int calculateMinimumHP(int sr, int sc, int n, int m, int[][] dungeon, int[][] dp) {
        if (sr == n - 1 && sc == m - 1) {
            return dp[sr][sc] = Math.max(1, 1 - dungeon[sr][sc]);
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int min = (int) 1e8;
        if (sr + 1 < n)
            min = Math.min(min, calculateMinimumHP(sr + 1, sc, n, m, dungeon, dp));

        if (sc + 1 < m)
            min = Math.min(min, calculateMinimumHP(sr, sc + 1, n, m, dungeon, dp));

        min -= dungeon[sr][sc];
        return dp[sr][sc] = Math.max(min, 1);

    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        int ans = calculateMinimumHP(0, 0, n, m, dungeon, dp);
        return ans;
    }
}