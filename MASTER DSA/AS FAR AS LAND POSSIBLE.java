/**
As Far from Land as Possible

Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water 
cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water 
exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is 
|x0 - x1| + |y0 - y1|.

 

Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 */



class Solution {
    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {

        LinkedList<Pair> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.addLast(new Pair(i, j));
                }
            }
        }

        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length) {
            return -1;
        }

        int dist = 0;
        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                Pair rem = queue.removeFirst();

                for (int i = 0; i < dir.length; i++) {
                    int nr = rem.x + dir[i][0];
                    int nc = rem.y + dir[i][1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        queue.addLast(new Pair(nr, nc));
                    }
                }

            }
            dist++;
        }

        return dist - 1;
    }
}
