class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        m = len(num1)-1
        n = len(num2)-1

        rem = 0
        ans = ""

        while m>=0 and n>=0:
            number1 = int(num1[m])
            number2 = int(num2[n])

            added = number1+number2+rem
            last_digit = added%10
            rem = added//10

            ans =  str(last_digit)+ans

            m-=1
            n-=1

        while m>=0 :
            added = int(num1[m])+rem
            last_digit = added%10
            rem = added//10
            ans =  str(last_digit) +ans
            m-=1

        while n>=0 :
            added = int(num2[n])+rem
            last_digit = added%10
            rem = added//10
            ans =  str(last_digit) + ans
            n-=1

        if rem!=0:
            ans = str(rem)+ans

        return ans
        