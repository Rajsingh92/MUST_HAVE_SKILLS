/**
Maximal Rectangle |  Hard | Adobe, Amazon, Google, Microsoft |
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's 
and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
 * 
 */

class Solution {
    public int maximalRectangle(char[][] matrix) {
    if( matrix.length == 0 ||  matrix[0].length == 0)  return 0;
     int n = matrix.length;
     int m = matrix[0].length;   

     int[] heights = new int[m];
     int area = 0;
     for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
            heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
         }

         area = Math.max(area, largestRectangleArea(heights));  //ref from above question
     }
     
     return area;
    }
}