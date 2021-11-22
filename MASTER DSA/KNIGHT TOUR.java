import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[] dirx = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] diry = { 1, 2, 2, 1, -1, -2, -2, -1 };

        int[][] chess = new int[n][n];

        printKnightsTour(chess, r, c, 1, dirx, diry);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move, int[] dirx, int[] diry) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] > 0) {
            return;
        }

        if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = move;
        for (int i = 0; i < 8; i++) {
            int nr = r + dirx[i];
            int nc = c + diry[i];
            printKnightsTour(chess, nr, nc, move + 1, dirx, diry);
        }
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}