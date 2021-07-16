/**
Count Negative Numbers in a Sorted Matrix
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the 
number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
 */


class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int r = m-1;
        int c = 0;
        
        int ans = 0;
        
        while(r>=0 && c<n){
            if(grid[r][c]<0){
                ans+=n-c;
                r--;
            }else{
                c++;
            }
        }
        
        return ans;
    }
}



/**
Find the row with maximum number of 1s
Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.

Example:

Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2
 */


class Solution{
    public int maxOnesInRow(int[][] mat){
        int m = mat.length;
        int n = ma[0].length;

        int i = 0,j=m-1;
        int index = -1;

        while(i >= 0 && i < m && j >= 0 && j < n){
            if(mat[i][j] == 1){
                j--;
                index = i;
            }else{
                i++;
            }
        }

        if(index != -1) {
            return index+1;;
        }else{
            return index;
        }
    }
}




