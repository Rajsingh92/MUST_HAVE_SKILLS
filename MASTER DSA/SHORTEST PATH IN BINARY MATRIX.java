/**
Shortest Path in Binary Matrix
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 */



class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        
        LinkedList<int []> q = new LinkedList<>();
        q.addLast(new int[]{0,0});
        int level =1;
        grid[0][0]=1;
        
        while(q.size()!=0){
            int size = q.size();
            while(size-->0){
                int[] idx = q.removeFirst();
                if(idx[0]==m-1 && idx[1]==n-1){
                    return level;
                }
                
                for(int i=0;i<8;i++){
                    int x = idx[0]+dir[i][0];
                    int y = idx[1]+dir[i][1];
                    
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==0){
                        grid[x][y]=1;
                        q.addLast(new int[]{x,y});
                    }
                }
            }
            level++;
           
        }
        
        return -1;
    }
}