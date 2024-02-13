/**
Spiral Matrix |  Medium | Adobe, Amazon, Apple, Facebook, Google, Microsoft |

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 */


public class Solution{
    public static void spiral(int[][] mat,int m ,int n){
        int row = 0;
        int col = 0;

        while(row<m && col<n){
            // print first row
            for(int i = col;i<n;i++){
                System.out.println(mat[row][i]);
            }
            row++;

            //print last column
            for(int i = row;i<m;i++){
                System.out.println(mat[i][n-1]);
            }
            n--;

            //print last row
            if(row<m){
                for(int i = n-1;i>=col;i--){
                    System.out.println(mat[m-1][i]);
                }
            }
            m--;

            //print first col
            if(col<n){
                for(int i = m-1;i>=row;i--){
                    System.out.println(mat[i][col]);
                }
            }
            col++;
        }
    }

    // anticlockwise
    public static void anticlockwiseSpiral(int m, int n, int arr[][]) {
        int i, k = 0, l = 0;

        int cnt = 0;

        int total = m * n;

        while (k < m && l < n) {
            if (cnt == total)
                break;

            for (i = k; i < m; ++i) {
                System.out.print(arr[i][l] + ", ");
                cnt++;
            }
            l++;

            if (cnt == total)
                break;

            for (i = l; i < n; ++i) {
                System.out.print(arr[m - 1][i] + ", ");
                cnt++;
            }
            m--;

            if (cnt == total)
                break;

            if (k < m) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(arr[i][n - 1] + ", ");
                    cnt++;
                }
                n--;
            }

            if (cnt == total)
                break;

            if (l < n) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(arr[k][i] + ", ");
                    cnt++;
                }
                k++;
            }
        }
    }
}

/**
Spiral Matrix II |  Medium | Amazon, Google, Microsoft |

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        spiral(mat,n,n);
        return mat;
    }
    
    public static void spiral(int[][] mat,int m ,int n){
        int row = 0;
        int col = 0;
        int num = 1;
        
        while(row<m && col<n){
            for(int i = col;i<n;i++){
                mat[row][i] = num;
                num++;
            }
            row++;

            for(int i = row;i<m;i++){
                mat[i][n-1] = num;
                num++;
            }
            n--;

            if(row<m){
                for(int i = n-1;i>=col;i--){
                    mat[m-1][i] = num;
                    num++;
                }
            }
            m--;

            if(col<n){
                for(int i = m-1;i>=row;i--){
                    mat[i][col] = num;
                    num++;
                }
            }
            col++;
        }
    }
}



/**

Spiral Matrix III |  Medium | Facebook |
 */

