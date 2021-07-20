/**
Valid Sudoku |  Medium | Amazon, Apple, Facebook, Google, Microsoft |

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
 */



class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    boolean valid = isValid(board, i, j, board[i][j]);
                    if (valid == false) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isValid(char[][] board, int r, int c, char num) {

        // check row
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == num && c != i) {
                return false;
            }
        }

        // check col
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num && r != i) {
                return false;
            }
        }

        int x = (r / 3) * 3;
        int y = (c / 3) * 3;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == num && i != r && j != c) {
                    return false;
                }
            }
        }

        return true;

    }
}




/**
Sudoku Solver |  Hard | Amazon |

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],
                ["6",".",".","1","9","5",".",".","."],
                [".","9","8",".",".",".",".","6","."],
                ["8",".",".",".","6",".",".",".","3"],
                ["4",".",".","8",".","3",".",".","1"],
                ["7",".",".",".","2",".",".",".","6"],
                [".","6",".",".",".",".","2","8","."],
                [".",".",".","4","1","9",".",".","5"],
                [".",".",".",".","8",".",".","7","9"]]

Output:         [["5","3","4","6","7","8","9","1","2"],
                 ["6","7","2","1","9","5","3","4","8"],
                 ["1","9","8","3","4","2","5","6","7"],
                 ["8","5","9","7","6","1","4","2","3"],
                 ["4","2","6","8","5","3","7","9","1"],
                 ["7","1","3","9","2","4","8","5","6"],
                 ["9","6","1","5","3","7","2","8","4"],
                 ["2","8","7","4","1","9","6","3","5"],
                 ["3","4","5","2","8","6","1","7","9"]]

 */

class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValid(char[][] board, int r, int c, char num) {

        // check row
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == num && c != i) {
                return false;
            }
        }

        // check col
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num && r != i) {
                return false;
            }
        }

        int x = (r / 3) * 3;
        int y = (c / 3) * 3;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == num && i != r && j != c) {
                    return false;
                }
            }
        }

        return true;

    }
}