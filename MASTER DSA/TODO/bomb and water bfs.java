public class bombandwater {
    private static class BAWPair {
        int r;
        int c;
        int time;

        public BAWPair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static int BombAndWaterBFS(int[][] mat) {

        boolean[][] isVisited = new boolean[mat.length][mat[0].length];
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int Time = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (isVisited[i][j] == false && mat[i][j] == 1) {
                    LinkedList<BAWPair> que = new LinkedList<>();
                    que.addLast(new BAWPair(i, j, 0));

                    while (!que.isEmpty()) {

                        BAWPair rpair = que.removeFirst();

                        Time = rpair.time;

                        for (int d = 0; d < dir.length; d++) {
                            int r = dir[d][0] + rpair.r;
                            int c = dir[d][1] + rpair.c;

                            if (r < mat.length && c < mat[0].length && r >= 0 && c >= 0 && mat[r][c] == 1
                                    && !isVisited[r][c]) {
                                isVisited[r][c] = true;
                                que.addLast(new BAWPair(r, c, rpair.time + 1));
                                // isVisited[r][c]=false;
                            }

                        }
                    }
                }

            }

        }
        return Time;

    }
}
