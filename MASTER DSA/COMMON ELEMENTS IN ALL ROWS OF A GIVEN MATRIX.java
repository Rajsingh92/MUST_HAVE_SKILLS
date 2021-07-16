/**
Common elements in all rows of a given matrix
Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.

Example:

Input:
mat[4][5] = {{1, 2, 1, 4, 8},
             {3, 7, 8, 5, 1},
             {8, 7, 7, 3, 1},
             {8, 1, 2, 7, 9},
            };

Output: 
1 8 or 8 1
8 and 1 are present in all rows.
                        
 */



public class Solution{
    public static void commonInRow(int[][] mat){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<mat.length;i++){
            map.put(mat[0][i], 1);
        }

        for(int i = 1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(map.containsKey(mat[i][j]) && map.get(mat[i][j]) ==i ){
                    map.put(mat[i][j],i+1);
                }
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        for(int key : keys){
            int res = map.get(key);
            if(res==mat.length){
                System.out.println(res);
            }
        }
    }
}