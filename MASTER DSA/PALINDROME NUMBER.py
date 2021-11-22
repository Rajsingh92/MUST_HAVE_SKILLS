'''
Palindrome Number |  Easy | Adobe, Alibaba, Amazon, Apple, Facebook, Google, Microsoft |
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?

 

Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
'''

class Solution:
    def isPalindrome(self, x: int) -> bool:
        num=x
        result=0
        while x>0:
            lastDigit  = x % 10    
            result  = (result  *10) + lastDigit     
            x = x //10

        return (num==result)
        