/**
Create a matrix with alternating rectangles of O and X
Write a code which inputs two numbers m and n and creates a matrix of size m x n (m rows and n columns) in 
which every elements is either X or 0. The Xs and 0s must be filled alternatively, the matrix should have outermost rectangle of Xs, then a rectangle of 0s, then a rectangle of Xs, and so on.

Examples:

Input: m = 3, n = 3
Output: Following matrix 
X X X
X 0 X
X X X
 */


public class Solution{
    public static void fillmatrix(int m ,int n){
        int row = 0;
        int col = 0;
        char[][] mat = new char[m][n];
        char ch = 'X';

        while(row<m && col<n){
            //  first row
            for(int i = col;i<n;i++){
                mat[row][i] = ch;
            }
            row++;

            // last column
            for(int i = row;i<m;i++){
                mat[i][n-1] = ch;
            }
            n--;

            // last row
            if(row<m){
                for(int i = n-1;i>=col;i--){
                    mat[m-1][i] = ch;
                }
            }
            m--;

            // first col
            if(col<n){
                for(int i = m-1;i>=row;i--){
                    mat[i][col] = ch;
                }
            }
            col++;

            ch = (ch == 'O')?'X':'O';
        }
    }
}