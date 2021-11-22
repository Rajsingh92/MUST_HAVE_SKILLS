/**
Shortest Bridge

In a given 2D binary array grid, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 */


class Solution {

    public int shortestBridge(int[][] grid) {

        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue); // mark first island and fill queue
                    return bfs(grid, queue); 
                }
            }
        }

        return 0;
    }

    public int bfs(int[][] grid, LinkedList<int[]> queue) {
        int dist = 0;
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                int[] rem = queue.removeFirst();

                for (int i = 0; i < dir.length; i++) {
                    int nr = rem[0] + dir[i][0];
                    int nc = rem[1] + dir[i][1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 0) {
                        grid[nr][nc] = 2;
                        queue.addLast(new int[] { nr, nc });
                    }

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length) {
                        if (grid[nr][nc] == 1) {
                            return dist;
                        }
                    }
                }
            }
            dist++;
        }

        return dist;
    }

    public void dfs(int[][] grid, int i, int j, LinkedList<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        queue.offer(new int[] { i, j });

        dfs(grid, i - 1, j, queue);
        dfs(grid, i + 1, j, queue);
        dfs(grid, i, j - 1, queue);
        dfs(grid, i, j + 1, queue);
    }
}