/**
Knight On Chess Board   ||  Goldman Sachs Amazon

Given any source point, (C, D) and destination point, (E, F) on a chess board, we need to find whether Knight can 
move to the destination or not.

Knight's movements on a chess board

The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point.
If knight can not move from the source point to the destination point, then return -1.
 */

public class Solution {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int[] dx = { -1, -2, -1, -2, 1, 2, 1, 2 };
        int[] dy = { -2, -1, 2, 1, -2, -1, 2, 1 };
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(x1, y1));
        visited[x1][y1] = true;
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair rem = queue.remove();
                if (rem.x == x2 && rem.y == y2) {
                    return ans;
                }

                for (int i = 0; i < 8; i++) {
                    int nr = rem.x + dx[i];
                    int nc = rem.y + dy[i];

                    if (nr > 0 && nc > 0 && nr <= N && nc <= M && visited[nr][nc] == false) {
                        queue.add(new Pair(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}
