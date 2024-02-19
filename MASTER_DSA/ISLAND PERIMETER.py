'''
Island Perimeter |  Easy | Amazon, Apple, Facebook, Google |
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is 
exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square 
with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
'''
class Solution:
    def __init__(self):
        self.permeter = 0
        
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    self.dfs(grid,i,j)
                    break
                    
        return self.permeter
    
    def dfs(self,grid,i,j):
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[0]) or grid[i][j]==0:
            self.permeter+=1
            return
        if grid[i][j]==-1:
            return 
        
        grid[i][j] = -1
        self.dfs(grid,i+1,j)
        self.dfs(grid,i-1,j)
        self.dfs(grid,i,j+1)
        self.dfs(grid,i,j-1)
        