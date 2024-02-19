class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """

        stack = []


        for i in s:
            if i=="(" or i=="{" or i=="[":
                stack.append(i)
            else:
                if(len(stack) <= 0):
                    return False

                last = stack[-1]

                if i == "}" and last == "{" :
                    stack.pop()
                elif i == ")" and last == "(" :
                    stack.pop()
                elif i == "]" and last == "[" :
                    stack.pop()
                else:
                    return False

                

        print(stack)

        if len(stack) == 0 :
            return True
        else:
            return False