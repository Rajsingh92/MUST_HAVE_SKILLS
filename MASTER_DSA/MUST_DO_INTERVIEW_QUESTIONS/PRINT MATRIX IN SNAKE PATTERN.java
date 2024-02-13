/**
 * 
Print matrix in snake pattern
Given an n x n matrix .In the given matrix, you have to print the elements of the matrix in the snake pattern.

Examples :

Input :mat[][] = { {10, 20, 30, 40},
                   {15, 25, 35, 45},
                   {27, 29, 37, 48},
                   {32, 33, 39, 50}};
              
Output : 10 20 30 40 45 35 25 15 27 29 37 48 50 39 33 32 
 */

class Solution {
    public static void snake(int[][] mat, int m, int n) {
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.println(mat[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.println(mat[i][j]);
                }
            }
        }
    }
}