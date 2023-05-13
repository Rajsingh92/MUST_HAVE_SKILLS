/**
Tic Tac Toe 
A Tic-Tac-Toe board is given after some moves are played. Find out if the given board is valid, i.e., 
is it possible to reach this board position after some moves or not.
Note that every arbitrary filled grid of 9 spaces isn’t valid e.g. a grid filled with 3 X and 6 O isn’t 
valid situation because each player needs to take alternate turns.

Note :  The game starts with X

Example 1:

Input:
board[] = {'X', 'X', 'O', 
           'O', 'O', 'X',
           'X', 'O', 'X'};
Output: Valid
 */


class Solution{
    public static boolean isValid(char board[]){
        int xCount= 0 ,oCount = 0;
        for(int i = 0;i<board.length;i++){
            if(board[i] == 'X'){
                xCount++;
            }
            if(board[i] == 'O'){
                oCount++;
            }
        }

        if(xCount == oCount || xCount == oCount + 1){
            // if O is winner
            if(isCharWin(board, 'O')){
                if(isCharWin(board, 'X')){
                    return false;
                }
                return xCount == oCount;
            }

            // if X is winner
            if(isCharWin(board, 'X') && xCount != oCount + 1){
                return false;
            }

            return true;
        }

        return false;
        

    }

    public static boolean isCharWin(char[] board,char ch){
        int[][] win = { { 0, 1, 2 }, // Check first row.
				        { 3, 4, 5 }, // Check second Row
				        { 6, 7, 8 }, // Check third Row
				        { 0, 3, 6 }, // Check first column
				        { 1, 4, 7 }, // Check second Column
				        { 2, 5, 8 }, // Check third Column
				        { 0, 4, 8 }, // Check first Diagonal
                        { 2, 4, 6 }  // Check second Diagonal
                    };
        
        for(int i = 0;i<8;i++){
            if(board[win[i][0]] == ch && board[win[i][1]] == ch && board[win[i][2]] == ch){
                return true;
            }
            return false;
        }
    }
}