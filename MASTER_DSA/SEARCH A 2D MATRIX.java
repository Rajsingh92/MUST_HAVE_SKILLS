/**
Search a 2D Matrix |  Medium | Amazon, Facebook, Google, Microsoft |

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix[0].length-1;
        
        while(low>=0 && low< matrix.length && high>=0 && high<matrix[0].length){
            if(matrix[low][high] == target){
                return true;
            }else if(matrix[low][high] > target){
                high--;
            }else{
                low++;
            }
        }
        
        return false;
    }
}
