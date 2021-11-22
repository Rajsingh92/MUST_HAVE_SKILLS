/**
Surrounded Regions |  Medium | Amazon, Google |

Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */


class Solution {
    public void solve(char[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        //replace 'O' with '-'
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(mat[i][j] == 'O'){
                    mat[i][j] = '-';
                }
            }
        }

        //call flood fill for all '-' lying on edges
        //left side
        for(int i = 0;i<M;i++){
            if(mat[i][0] == '-'){
                floodfill(mat, i, 0, '-', 'O');
            }
        }

        //right side
        for(int i = 0;i<M;i++){
            if(mat[i][N-1] == '-'){
                floodfill(mat, i, N-1, '-', 'O');
            }
        }

        //top side
        for(int i = 0;i<N;i++){
            if(mat[0][i] == '-'){
                floodfill(mat, 0, i, '-', 'O');
            }
        }

        //bottom side
        for(int i = 0;i<N;i++){
            if(mat[M-1][i] == '-'){
                floodfill(mat, M-1, i, '-', 'O');
            }
        }


        //replace '-' with 'X'
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(mat[i][j] == '-'){
                    mat[i][j] = 'X';
                }
            }
        }
    }
    
    public void floodfill(char[][] mat,int x,int y,char prevV,char newV){
        if(x<0 || y<0 || x>=mat.length || y>=mat[0].length || mat[x][y] != prevV){
            return;
        }
        mat[x][y] = newV;

        floodfill(mat, x+1, y, prevV, newV);
        floodfill(mat, x-1, y, prevV, newV);
        floodfill(mat, x, y+1, prevV, newV);
        floodfill(mat, x, y-1, prevV, newV);
    }
}