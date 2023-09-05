class Solution:
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




