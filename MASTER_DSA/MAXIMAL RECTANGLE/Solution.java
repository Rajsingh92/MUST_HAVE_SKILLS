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
