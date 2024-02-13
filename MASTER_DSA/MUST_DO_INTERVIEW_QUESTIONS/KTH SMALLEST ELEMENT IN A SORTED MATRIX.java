/**
Kth Smallest Element in a Sorted Matrix |  Medium | Apple |

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
 */

public class Solution{
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            
            for(int i = 0;i<matrix.length;i++){
                for(int j = 0;j<matrix[0].length;j++){
                    pq.add(matrix[i][j]);
                    if(pq.size()>k){
                        pq.remove();
                    }
                }
            }
            
            return pq.remove();
        }

        public int kthSmallest2(int[][] matrix, int k) {
            if(matrix.length == 0 || matrix[0].length == 0){
                return 0;
            }
            
            int n = matrix.length;
            int m = matrix[0].length;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return matrix[a/m][a%m]-matrix[b/m][b%m];
            });
            
            for(int i = 0;i<n;i++){
                pq.add(i*m+0);
            }
            
            while(--k>0){
                int idx  = pq.remove();
                int r = idx/m;
                int c = idx%m;
                
                c++;
                if(c<m){
                    pq.add(r*m+c);
                }
            }
            
            
            int idx = pq.remove();
            int r = idx/m;
            int c = idx%m;
            
            return matrix[r][c];
            
            
        }
    }

}