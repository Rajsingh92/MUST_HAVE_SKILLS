/*
import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<int[]> queue = new LinkedList<int[]>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.addLast(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // calculate distance of 1 from 0
        while (queue.size() > 0) {
            int[] rem = queue.removeFirst();
            int r = rem[0];
            int c = rem[1];

            int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

            for (int i = 0; i < dir.length; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] > mat[r][c] + 1) {
                    mat[nr][nc] = mat[r][c] + 1;
                    queue.addLast(new int[] { nr, nc });
                }
            }

        }

        return mat;
    }
}

*/