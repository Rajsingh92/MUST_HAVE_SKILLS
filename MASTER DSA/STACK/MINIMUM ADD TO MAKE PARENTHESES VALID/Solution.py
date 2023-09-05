class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        stack = []


        for i in s:
            if i=="(" :
                stack.append(i)
            else:
                if(len(stack) <= 0):
                    stack.append(i)
                else:
                    if i == ")" and stack[-1] == "(" :
                        stack.pop()
                    else:
                        stack.append(i)


        return len(stack)

    def minAddToMakeValid2(self, s: str) -> int:
        left = 0
        right = 0


        for char in s :
            if char == "(":
                right+=1
            elif right > 0:
                right-=1
            else:
                left+=1
        
        return left+right
