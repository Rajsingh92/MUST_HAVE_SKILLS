/**
Swim in Rising Water |  Hard | Amazon |

You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

 

Example 1:


Input: grid = [[0,2],[1,3]]
Output: 3
 */

import java.util.*;
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int ans = Math.max(grid[0][0], grid[n - 1][n - 1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // r,c,h
            return a[2] - b[2];
        });

        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        pq.add(new int[] { 0, 0, grid[0][0] });

        while (pq.size() != 0) {
            int[] vtx = pq.poll();
            ans = Math.max(ans, vtx[2]);

            for (int d = 0; d < 4; d++) {
                int x = vtx[0] + dir[d][0];
                int y = vtx[1] + dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < n && !vis[x][y]) {
                    if (x == n - 1 && y == n - 1)
                        return ans;
                    pq.add(new int[] { x, y, grid[x][y] });
                    vis[x][y] = true;
                }
            }
        }

        return -1;
    }
}
