/**

Number of Islands |  Medium | Adobe, Affirm, Alibaba, Amazon, appdynamics, Facebook, Google, Microsoft |
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may 
assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

 
class Solution {
    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfs(grid, visited, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[] { x, y });

        while (queue.size() > 0) {
            int[] rem = queue.removeLast();
            int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

            for (int i = 0; i < dir.length; i++) {
                int nr = rem[0] + dir[i][0];
                int nc = rem[1] + dir[i][1];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && visited[nr][nc] == false
                        && grid[nr][nc] == '1') {
                    visited[nr][nc] = true;
                    queue.addLast(new int[] { nr, nc });
                }
            }
        }
    }
}

// Q305
