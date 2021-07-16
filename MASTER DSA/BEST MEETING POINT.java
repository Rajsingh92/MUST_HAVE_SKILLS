/**
Best Meeting Point

A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid 
of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using 
Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example
Example 1:

Input:
[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output:
6

Explanation:
The point `(0,2)` is an ideal meeting point, as the total
 */

import java.util.*;
class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        ArrayList<Integer> hor = new ArrayList<>();
        ArrayList<Integer> ver = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hor.add(i);
                    ver.add(j);
                }
            }
        }

        Collections.sort(hor);
        Collections.sort(ver);
        
        int mid = hor.size() / 2;

        int x = hor.get(mid);
        int y = ver.get(mid);

        int dist = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dist += Math.abs(i - x) + Math.abs(j - y);
                }
            }
        }

        return dist;
    }

    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void BFS(int[][] grid, int[][] dist, int x, int y) {

        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[x][y] = true;
        int time = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Pair rem = queue.removeFirst();
                dist[rem.x][rem.y] += time;
                int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
                for (int i = 0; i < 4; i++) {
                    int nr = rem.x + dir[i][0];
                    int nc = rem.y + dir[i][1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && visited[nr][nc] == false) {
                        visited[nr][nc] = true;
                        queue.addLast(new Pair(nr, nc));
                    }
                }
            }
            time++;
        }
    }

    // TLE
    public int minTotalDistance2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    BFS(grid, dis, i, j);
                }
            }
        }

        int ans = (int) 1e8;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.min(ans, dis[i][j]);
            }
        }

        return ans;
    }

}