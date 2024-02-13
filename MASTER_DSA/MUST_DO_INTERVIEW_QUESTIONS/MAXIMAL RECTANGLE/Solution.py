class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:

        r = len(matrix)
        c = len(matrix[0])

        nums = [0]*c
        ans = 0

        for i in range(r):
            for j in range(c):
                if int(matrix[i][j]) == 0:
                    nums[j] = 0
                else:
                    nums[j] = nums[j]+int(matrix[i][j])

            print(nums)
            ans = max(ans,self.largestRectangleArea(nums))


        return ans
    

    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)

        nsl = [-1]*n
        stack = []

        for i in range(n):
            while stack and heights[stack[-1]] >= heights[i]:
                stack.pop()
            
            if stack:
                nsl[i] = stack[-1]

            stack.append(i)

        nsr = [n]*n
        stack = []

        for i in range(n-1,-1,-1):
            while stack and heights[stack[-1]] >= heights[i]:
                stack.pop()
            
            if stack:
                nsr[i] = stack[-1]

            stack.append(i)

        ans = 0

        for i in range(n):
            width = nsr[i]-nsl[i]-1
            ans = max(ans,heights[i]*width)


        return ans
    