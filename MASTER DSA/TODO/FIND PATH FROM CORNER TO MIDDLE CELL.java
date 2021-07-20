

class Solution {
    public static void findshortestsafepath(int[][] maze, int i, int j, String ans) {

        if (i == maze.length / 2 && j == maze.length / 2) {
            ans += "(" + i + ", " + j + ")";
            System.out.println(ans);
            return;
        }

        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length || maze[i][j] == 0) {
            return;
        }

        int k = maze[i][j];
        maze[i][j] = 0;

        findshortestsafepath(maze, i, j + k, ans + "(" + i + ", " + j + ") -> ");
        findshortestsafepath(maze, i + k, j, ans + "(" + i + ", " + j + ") -> ");
        findshortestsafepath(maze, i, j - k, ans + "(" + i + ", " + j + ") -> ");
        findshortestsafepath(maze, i - k, j, ans + "(" + i + ", " + j + ") -> ");

        maze[i][j] = k;
    }

}
