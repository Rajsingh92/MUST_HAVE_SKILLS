class Solution:
    def armstrongNumber(self, n):

        cubeSum = 0
        storeToCompare = n

        while n > 0:
            lastNumber = n % 10
            cubeSum = cubeSum + (lastNumber**3)
            n = n // 10

        if cubeSum == storeToCompare:
            return ("Yes")
        else:
            return ("No")

