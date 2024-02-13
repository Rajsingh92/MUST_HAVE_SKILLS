import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] mat = new int[r][c];

        ArrayList<String> res = new ArrayList<>();
        getPaths(mat, 0, 0, "", res);

        for (String val : res) {
            System.out.print(val + " ");
        }

        System.out.print("\n");
        System.out.print(res.size());

    }

    public static void getPaths(int[][] mat, int x, int y, String curr, ArrayList<String> res) {
        if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length) {
            return;
        }

        if (x == mat.length - 1 && y == mat[0].length - 1) {
            res.add(curr);
            return;
        }

        getPaths(mat, x + 1, y, curr + "V", res);
        getPaths(mat, x, y + 1, curr + "H", res);
        getPaths(mat, x + 1, y + 1, curr + "D", res);

    }

    public static int printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}

		int count = 0;
		if (sc + 1 <= dc)
			count += printMazePaths(sr, sc + 1, dr, dc, psf + "h");
		if (sr + 1 <= dr && sc + 1 <= dc)
			count += printMazePaths(sr + 1, sc + 1, dr, dc, psf + "d");
		if (sr + 1 <= dr)
			count += printMazePaths(sr + 1, sc, dr, dc, psf + "v");

		return count;
	}

	public static int printMazePathsMultiJumps(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return 1;
		}

		int count = 0;
		for (int j = 1; sc + j <= dc; j++)
			count += printMazePathsMultiJumps(sr, sc + j, dr, dc, psf + "h" + j);
		for (int j = 1; sr + j <= dr && sc + j <= dc; j++)
			count += printMazePathsMultiJumps(sr + j, sc + j, dr, dc, psf + "d" + j);
		for (int j = 1; sr + j <= dr; j++)
			count += printMazePathsMultiJumps(sr + j, sc, dr, dc, psf + "v" + j);

		return count;
	}
}


