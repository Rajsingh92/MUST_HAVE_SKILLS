
/**
Rotate Matrix Elements
Given a matrix, clockwise rotate elements in it.

Input:
1    2    3    4    
5    6    7    8
9    10   11   12
13   14   15   16

Output:
5    1    2    3
9    10   6    4
13   11   7    8
14   15   16   12
 */


public class Solution{
    public static void rotate(int[][] mat,int m,int n){
        int row = 0;
        int col = 0;
        int prev,curr;

        while(row<m && col<n){

            if(row+1 == m || col+1 == n){
                break;
            }

            prev = mat[row+1][col];

            //move first row
            for(int i = col;i<n;i++){
                curr = mat[row][i];
                mar[row][i] = prev;
                prev = curr;
            }
            row++;

            //move last column
            for(int i = row;i<m;i++){
                curr = mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }
            n--;

            //move last row
            if(row<m){
                for(int i =n-1;i>=col;i--){
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            //move first column
            if(col<n){
                for(int i = m-1;i>=row;i--){
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;

        }
        
    }
}