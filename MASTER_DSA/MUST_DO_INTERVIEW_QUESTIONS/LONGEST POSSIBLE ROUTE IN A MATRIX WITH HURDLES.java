
class Solution {

    public static class pair {
        int longestPathLength = 0;
        String longestPath = "";

        public pair(int longestPathLength, String longestPath) {
            this.longestPathLength = longestPathLength;
            this.longestPath = longestPath;
        }
    }

    public static pair longestPathRecu(int sr, int sc, int dr, int dc, boolean[][] vis, int[][] dir, String[] dirS) {
        if (sr == dr && sc == dc) {
            return new pair(0, "");
        }

        pair myAns = new pair(-1, "");
        vis[sr][sc] = true;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= dr && c <= dc && !vis[r][c]) {
                pair recAns = longestPathRecu(r, c, dr, dc, vis, dir, dirS);
                if (recAns.longestPathLength + 1 > myAns.longestPathLength) {
                    myAns.longestPathLength = recAns.longestPathLength + 1;
                    myAns.longestPath = dirS[d] + recAns.longestPath;
                }
            }
        }

        vis[sr][sc] = false;

        return myAns;
    }
}