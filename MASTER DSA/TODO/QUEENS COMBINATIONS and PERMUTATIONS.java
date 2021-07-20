/**
Queens Combinations - 2d As 2d 
 
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the  n * n chess-board. 

IP : 2

OP:
qq
--

q-
q-

q-
-q

-q
q-

-q
-q

--
qq
 */

 
import java.io.*;
import java.util.*;

public class Main {

    // method 1 -- box chooses
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {

        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }

        int nr = 0;
        int nc = 0;
        String yasf = "Q";
        String nasf = ".";
        if (col == tq - 1) {
            nr = row + 1;
            nc = 0;
            yasf += "\n";
            nasf += "\n";
        } else {
            nr = row;
            nc = col + 1;
        }

        queensCombinations(qpsf + 1, tq, nr, nc, asf + yasf);
        queensCombinations(qpsf, tq, nr, nc, asf + nasf);

    }

    // method 1 -- queen chooses
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int col = j + 1; col < chess.length; col++) {
            chess[i][col] = true;
            queensCombinations(qpsf + 1, tq, chess, i, col);
            chess[i][col] = false;
        }

        for (int r = i + 1; r < chess.length; r++) {
            for (int c = 0; c < chess[0].length; c++) {
                chess[r][c] = true;
                queensCombinations(qpsf + 1, tq, chess, r, c);
                chess[r][c] = false;
            }
        }
    }

    // 2D as 1D 
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            
            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess, row * chess.length + col);
            chess[row][col] = false;
            
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, 0, 0, "");
        queensCombinations(0, n, chess, 0, -1);
        queensCombinations(0, n, chess, -1);
    }
}




/**
Queens Permutations - 2d As 2d 
  
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
     n * n chess-board. 

IP : 2

OP:
q1	q2	
-	-	

q1	-	
q2	-	

q1	-	
-	q2	

q2	q1	
-	-	

-	q1	
q2	-	

-	q1	
-	q2	

q2	-	
q1	-	

-	q2	
q1	-	

-	-	
q1	q2	

q2	-	
-	q1	

-	q2	
-	q1	

-	-	
q2	q1	
 */


public class Main {

    // mehod 1 -- queen chooses
    public static void queensPermutations(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] != 0 ? "q" + chess[row][col] + "\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int row = 0; row < chess.length; row++) {
            for (int col = 0; col < chess.length; col++) {
                if (chess[row][col] == 0) {
                    chess[row][col] = qpsf + 1;
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[row][col] = 0;
                }
            }
        }
    }

    // method 2 -- box chooses
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }

        int nr = 0;
        int nc = 0;
        String sep = " ";

        if (col == tq - 1) {
            nr = row + 1;
            nc = 0;
            sep = "\n";
        } else {
            nr = row;
            nc = col + 1;
            sep = "\t";
        }

        for (int i = 0; i < queens.length; i++) {
            if (queens[i] == false) {
                queens[i] = true;
                queensPermutations(qpsf + 1, tq, nr, nc, asf + "q" + (i + 1) + sep, queens);
                queens[i] = false;
            }
        }
        queensPermutations(qpsf, tq, nr, nc, asf + "-" + sep, queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        queensPermutations(0, n, chess);
        queensPermutations(0, n, 0, 0, "", queens);
    }
}