class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:

        if len(pushed) != len(popped) :
            return False
            
        m = len(pushed)
        ind = 0
        stack = []


        for i in range(m):
            stack.append(pushed[i])

            while stack and popped[ind] == stack[-1]:
                stack.pop()
                ind+=1

        if stack:
            return False
        else:
            return True


