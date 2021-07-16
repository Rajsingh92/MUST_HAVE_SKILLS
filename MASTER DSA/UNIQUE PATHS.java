/**
Unique Paths |  Medium | Alibaba, Amazon, Apple, Facebook, Google, Microsoft |

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of 
the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
 */



class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return countPaths(0, 0, m, n, dp);
    }

    public int countPaths(int x, int y, int m, int n, int[][] dp) {
        if (x >= m || y >= n) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        int path1 = countPaths(x + 1, y, m, n, dp);
        int path2 = countPaths(x, y + 1, m, n, dp);

        dp[x][y] = path1 + path2;
        return dp[x][y];
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else if (i == m - 1) {
                    dp[i][j] = 1;
                } else if (j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}



/**
Unique Paths II |  Medium | Amazon, Facebook, Microsoft |

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the 
bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return countPaths(obstacleGrid,0, 0, m, n, dp);
    }
    
    public int countPaths(int[][] obstacleGrid,int x, int y, int m, int n, int[][] dp) {
        if (x >= m || y >= n || obstacleGrid[x][y] == 1 ) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        int path1 = countPaths(obstacleGrid,x + 1, y, m, n, dp);
        int path2 = countPaths(obstacleGrid,x, y + 1, m, n, dp);

        dp[x][y] = path1 + path2;
        return dp[x][y];
    }
}


/**
Unique Paths III

On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 */


class Solution {
    public int uniquePathsIII(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    return helper(grid, i, j, visited, count);
                }
            }
        }

        return 0;
    }

    public int helper(int[][] grid, int i, int j, boolean[][] visited, int count) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || visited[i][j] == true) {
            return 0;
        }

        if (grid[i][j] == 2 && count == -1) {
            return 1;
        }

        visited[i][j] = true;
        int path1 = helper(grid, i + 1, j, visited, count - 1);
        int path2 = helper(grid, i, j + 1, visited, count - 1);
        int path3 = helper(grid, i - 1, j, visited, count - 1);
        int path4 = helper(grid, i, j - 1, visited, count - 1);
        visited[i][j] = false;

        return path1 + path2 + path3 + path4;

    }
}