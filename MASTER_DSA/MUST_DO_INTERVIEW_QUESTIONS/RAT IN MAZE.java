class RatInAMaze {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // size of array
        int[][] maze = new int[n][n];

        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                maze[r][c] = scn.nextInt();
            }
        }

        int limit = scn.nextInt();

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        System.out.println(solve(maze, 0, 0, limit, visited));
    }

    private static boolean solve(int[][] maze, int x, int y, int remMoves, boolean[][] visited) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            return true;
        }

        if (InvalidSpot(maze, visited, x, y, remMoves) == true) {
            return false;
        }

        visited[x][y] = true;

        boolean r = solve(maze, x + 1, y, remMoves - 1, visited);
        boolean d = solve(maze, x, y + 1, remMoves - 1, visited);
        boolean l = solve(maze, x - 1, y, remMoves - 1, visited);
        boolean u = solve(maze, x, y - 1, remMoves - 1, visited);

        visited[x][y] = false;

        return r || d || l || u;
    }

    private static boolean InvalidSpot(int[][] maze, boolean[][] visited, int x, int y, int remMoves) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 0 || visited[x][y] == true || remMoves <= 0) {
            return true;
        
        return false;
        
    }

}