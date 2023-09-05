class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0] * cols for _ in range(rows)]

        ans = 0

        for i in range(rows-1,-1,-1):
            for j in range(cols-1,-1,-1):
                if i == rows-1 or j == cols-1:
                    dp[i][j] = int(matrix[i][j])
                else:
                    if matrix[i][j] == '0':
                        dp[i][j] = 0
                    else:
                        dp[i][j] = min(dp[i+1][j],dp[i+1][j+1],dp[i][j+1])+1
                ans  = max(ans,dp[i][j])

        return ans*ans


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        self.maxsize = 0
        memo = [[-1] * cols for _ in range(rows)]  # Memoization table
        
        self.findLargestSquare(matrix, rows - 1, cols - 1, memo)
        
        return self.maxsize*self.maxsize
    
    def findLargestSquare(self, matrix, rows, cols, memo):
        if rows < 0 or cols < 0:
            return 0
        
        if memo[rows][cols] != -1:
            return memo[rows][cols]
        
        left = self.findLargestSquare(matrix, rows, cols - 1, memo)
        top = self.findLargestSquare(matrix, rows - 1, cols, memo)
        diagonal = self.findLargestSquare(matrix, rows - 1, cols - 1, memo)
        
        size = 1 + min(min(top, left), diagonal) if matrix[rows][cols] == '1' else 0
        
        self.maxsize = max(self.maxsize, size)
        memo[rows][cols] = size  # Memoize the result
        
        return size

 