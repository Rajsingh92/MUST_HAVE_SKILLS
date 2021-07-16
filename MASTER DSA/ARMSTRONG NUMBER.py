'''
Armstrong Numbers 
For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of three digits is an integer 
such that the sum of the cubes of its digits is equal to the number itself. Return "Yes" if it is a armstrong number else 
return "No".

Example 1:

Input: N = 153
Output: "Yes"
Explanation: 153 is an Armstrong number
since 13 + 53 + 33 = 153.
Hence answer is "Yes".

'''
class Solution:
    def armstrongNumber (self, n):
        # code here 
        cubeSum = 0
        storeToCompare = n
        while n>0:
            lastNumber=n%10
            cubeSum = cubeSum+(lastNumber**3)
            n = n//10
        
        if cubeSum==storeToCompare:
            return ("Yes")
        else:
            return ("No")



