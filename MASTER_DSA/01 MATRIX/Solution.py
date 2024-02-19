from collections import deque

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        queue = deque()
        
        for i in range(0,len(mat)):
            for j in range(0,len(mat[i])):
                if mat[i][j] == 0:
                    queue.append((i,j)) 
                else:
                    mat[i][j] = float('inf')
                    
        
        while queue:
            r,c = queue.popleft()
            
            dirs = [(1,0), (-1,0), (0,1), (0,-1)]
            for dir in dirs:
                nr = r + dir[0]
                nc = c + dir[1]
                
                if(nr >= 0 and nc >= 0 and nr < len(mat) and nc < len(mat[0]) and mat[nr][nc] > mat[r][c] +1):
                    mat[nr][nc] = mat[r][c] + 1
                    queue.append((nr,nc))
                    
        
        return mat
        
        
