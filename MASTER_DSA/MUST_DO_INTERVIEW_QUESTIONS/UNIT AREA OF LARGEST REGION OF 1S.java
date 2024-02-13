/**
Unit Area of largest region of 1's 

Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally(horizontally, vertically, dioganally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
 */


class Solution {
    static int count;

    public int findMaxArea(int[][] grid) {
        int mres = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 1;
                    dfs(grid, i, j);
                    mres = Math.max(mres, count);
                }
            }
        }

        return mres;
    }

    public void dfs(int[][] grid, int x, int y) {

        int[] rowNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

        grid[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int row = x + rowNbr[i];
            int col = y + colNbr[i];
            if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
                count++;
                dfs(grid, row, col);
            }
        }

    }
}



