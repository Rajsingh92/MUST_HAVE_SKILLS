/***
Walls and Gates | Amazon |

You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume 
that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room 
should remain filled with INF

Example

Input:
[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output:
[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

Explanation:
the 2D grid is:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
the answer is:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
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

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0)
            return;

        LinkedList<Pair> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0)
                    queue.addLast(new Pair(i, j));
            }
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

                    if (nr >= 0 && nc >= 0 && nr < rooms.length && nc < rooms[0].length && rooms[nr][nc] == 2147483647) {
                        rooms[nr][nc] = dist + 1;
                        queue.addLast(new Pair(nr, nc));
                    }
                }

            }
            dist++;
        }
    }
}
