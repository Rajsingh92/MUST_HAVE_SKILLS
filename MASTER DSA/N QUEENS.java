/**
Nqueens Permutations - 2d As 1d 

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens (distinct) can be placed on the n * n chess-board. 
3. No queen shall be able to kill another.

-	q1	-	-	
-	-	-	q2	
q3	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q2	
q4	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q2	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q4	
q2	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q4	-	-	-	
-	-	q2	-	

-	q1	-	-	
-	-	-	q4	
q3	-	-	-	
-	-	q2	-	

-	-	q1	-	
q2	-	-	-	
-	-	-	q3	
-	q4	-	-	

-	-	q1	-	
q2	-	-	-	
-	-	-	q4	
-	q3	-	-	

-	-	q1	-	
q3	-	-	-	
-	-	-	q2	
-	q4	-	-	

-	-	q1	-	
q4	-	-	-	
-	-	-	q2	
-	q3	-	-	

-	-	q1	-	
q3	-	-	-	
-	-	-	q4	
-	q2	-	-	

-	-	q1	-	
q4	-	-	-	
-	-	-	q3	
-	q2	-	-	

-	-	q2	-	
q1	-	-	-	
-	-	-	q3	
-	q4	-	-	

-	-	q2	-	
q1	-	-	-	
-	-	-	q4	
-	q3	-	-	

-	-	q3	-	
q1	-	-	-	
-	-	-	q2	
-	q4	-	-	

-	-	q4	-	
q1	-	-	-	
-	-	-	q2	
-	q3	-	-	

-	-	q3	-	
q1	-	-	-	
-	-	-	q4	
-	q2	-	-	

-	-	q4	-	
q1	-	-	-	
-	-	-	q3	
-	q2	-	-	

-	q2	-	-	
-	-	-	q1	
q3	-	-	-	
-	-	q4	-	

-	q2	-	-	
-	-	-	q1	
q4	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q1	
q2	-	-	-	
-	-	q4	-	

-	q4	-	-	
-	-	-	q1	
q2	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q1	
q4	-	-	-	
-	-	q2	-	

-	q4	-	-	
-	-	-	q1	
q3	-	-	-	
-	-	q2	-	

-	q2	-	-	
-	-	-	q3	
q1	-	-	-	
-	-	q4	-	

-	q2	-	-	
-	-	-	q4	
q1	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q2	
q1	-	-	-	
-	-	q4	-	

-	q4	-	-	
-	-	-	q2	
q1	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q4	
q1	-	-	-	
-	-	q2	-	

-	q4	-	-	
-	-	-	q3	
q1	-	-	-	
-	-	q2	-	

-	-	q2	-	
q3	-	-	-	
-	-	-	q1	
-	q4	-	-	

-	-	q2	-	
q4	-	-	-	
-	-	-	q1	
-	q3	-	-	

-	-	q3	-	
q2	-	-	-	
-	-	-	q1	
-	q4	-	-	

-	-	q4	-	
q2	-	-	-	
-	-	-	q1	
-	q3	-	-	

-	-	q3	-	
q4	-	-	-	
-	-	-	q1	
-	q2	-	-	

-	-	q4	-	
q3	-	-	-	
-	-	-	q1	
-	q2	-	-	

-	-	q2	-	
q3	-	-	-	
-	-	-	q4	
-	q1	-	-	

-	-	q2	-	
q4	-	-	-	
-	-	-	q3	
-	q1	-	-	

-	-	q3	-	
q2	-	-	-	
-	-	-	q4	
-	q1	-	-	

-	-	q4	-	
q2	-	-	-	
-	-	-	q3	
-	q1	-	-	

-	-	q3	-	
q4	-	-	-	
-	-	-	q2	
-	q1	-	-	

-	-	q4	-	
q3	-	-	-	
-	-	-	q2	
-	q1	-	-	

-	q2	-	-	
-	-	-	q3	
q4	-	-	-	
-	-	q1	-	

-	q2	-	-	
-	-	-	q4	
q3	-	-	-	
-	-	q1	-	

-	q3	-	-	
-	-	-	q2	
q4	-	-	-	
-	-	q1	-	

-	q4	-	-	
-	-	-	q2	
q3	-	-	-	
-	-	q1	-	

-	q3	-	-	
-	-	-	q4	
q2	-	-	-	
-	-	q1	-	

-	q4	-	-	
-	-	-	q3	
q2	-	-	-	
-	-	q1	-	
 */

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // vertical
        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; i < chess.length; i++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        // horizontal
        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; j < chess.length; j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        // diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; i < chess.length && j < chess.length; i++, j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        // anti-diagonal
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = col; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] > 0 ? "q" + chess[row][col] + "\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == 0 && IsQueenSafe(chess, row, col)) {
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}



/**
Nqueens Combinations - 2d As 1d 

1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the n * n chess-board. 
3. No queen shall be able to kill another.

4

-	q	-	-	
-	-	-	q	
q	-	-	-	
-	-	q	-	


-	-	q	-	
q	-	-	-	
-	-	-	q	
-	q	-	-	

 */

public class Main {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // vertical
        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j]) {
                return false;
            }
        }

        // horizontal
        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j]) {
                return false;
            }
        }

        // diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j]) {
                return false;
            }
        }

        // anti-diagonal
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j]) {
                return false;
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
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

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}





/**
N-Queens |  Hard | Alibaba, Amazon, Facebook, Microsoft |

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("Q");
            res.add(bres);
            return res;
        }

        String[][] board = new String[n][n];
        for (String[] arr : board)
            Arrays.fill(arr, ".");

        solve(board, 0, 0, res);
        // res.size() -- for getting number of solutions
        return res;
    }

    public void solve(String[][] board, int row, int qsf, List<List<String>> res) {

        if (row == board.length) {
            if (qsf == board.length) {
                List<String> bres = new ArrayList<>();
                for (String[] arr : board) {
                    String asf = "";
                    for (String val : arr) {
                        asf += val;
                    }
                    bres.add(asf);
                }
                res.add(bres);
            }

            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isQueenSafe(board, row, col)) {
                board[row][col] = "Q";
                solve(board, row + 1, qsf + 1, res);
                board[row][col] = ".";
            }
        }
    }

    public boolean isQueenSafe(String[][] board, int r, int c) {
        // check row
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == "Q") {
                return false;
            }
        }

        // check col
        for (int i = 0; i < board[0].length; i++) {
            if (board[i][c] == "Q") {
                return false;
            }
        }

        // check main diagonal
        // upper part
        int row = r;
        int col = c;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == "Q") {
                return false;
            }

            row--;
            col--;
        }

        // lower part
        row = r;
        col = c;
        while (row > board.length && col > board[0].length) {
            if (board[row][col] == "Q") {
                return false;
            }
            row++;
            col++;
        }

        // check second diagonal
        // upper part
        row = r;
        col = c;
        while (row >= 0 && col < board[0].length) {
            if (board[row][col] == "Q") {
                return false;
            }

            row--;
            col++;
        }

        // lower part
        row = r;
        col = c;
        while (row < board.length && col >= 0) {
            if (board[row][col] == "Q") {
                return false;
            }

            row++;
            col--;

        }

        return true;
    }
}

