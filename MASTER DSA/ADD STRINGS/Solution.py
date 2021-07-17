class Solution:
    def addStrings(self, num1: str, num2: str) -> str:

        i = len(num1) - 1
        j = len(num2) - 1
        carry = 0
        res = []

        while i >= 0 or j >= 0:
            totalSum = carry + (ord(num1[i]) - ord('0') if i >= 0 else
                                0) + (ord(num2[j]) - ord('0') if j >= 0 else 0)

            num = totalSum // 10
            rem = totalSum % 10

            res.append(rem)
            carry = num

            if i >= 0:
                i -= 1
            if j >= 0:
                j -= 1

        if carry > 0: 
            res.append(carry)

        return ''.join(str(x) for x in res[::-1])

    def addBinary(self, num1: str, num2: str) -> str:

        i = len(num1) - 1
        j = len(num2) - 1
        carry = 0
        res = []

        while i >= 0 or j >= 0:
            totalSum = carry + (ord(num1[i]) - ord('0') if i >= 0 else
                                0) + (ord(num2[j]) - ord('0') if j >= 0 else 0)

            num = totalSum // 2
            rem = totalSum % 2

            res.append(rem)
            carry = num

            if i >= 0:
                i -= 1
            if j >= 0:
                j -= 1

        if carry > 0:
            res.append(carry)

        return ''.join(str(x) for x in res[::-1])

        