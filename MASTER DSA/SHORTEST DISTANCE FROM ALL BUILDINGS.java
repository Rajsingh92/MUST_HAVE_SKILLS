/**
Shortest Distance from All Buildings |  Hard | Amazon |

You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

 [[1,1,1,1,1,0],
  [0,0,0,0,0,1],
  [0,1,1,0,0,1],
  [1,0,0,1,0,1],
  [1,0,1,0,0,1],
  [1,0,0,0,0,1],
  [0,1,1,1,1,0]]

  ans : 88
 */

import java.util.*;
public class Solution {

    public class Pair {
        int x;
        int y;
        int dist;

        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE, look = 0;
        int[][] sums = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    result = Integer.MAX_VALUE;
                    LinkedList<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j, 0));

                    while (queue.size() > 0) {
                        Pair rem = queue.removeFirst();

                        int[][] dirs = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
                        for (int k = 0; k < dirs.length; k++) {
                            int nX = rem.x + dirs[k][0];
                            int nY = rem.y + dirs[k][1];
                            if (nX >= 0 && nX < grid.length && nY >= 0 && nY < grid[0].length && grid[nX][nY] == look) {
                                grid[nX][nY]--;
                                sums[nX][nY] += rem.dist + 1;
                                queue.addLast(new Pair(nX, nY, rem.dist + 1));
                                result = Math.min(result, sums[nX][nY]);
                            }
                        }
                    }
                    look--;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}