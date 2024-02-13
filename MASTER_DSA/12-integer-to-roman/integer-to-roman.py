class Solution:
    def intToRoman(self, num: int) -> str:
        
        res = ''
        arr=[1000,900,500,400,100,90,50,40,10,9,5,4,1]
        symbol_mapping = {
            1:"I",
            4:"IV",
            5:"V",
            9:"IX",
            10:"X",
            40:"XL",
            50:"L",
            90:"XC",
            100:"C",
            400:"CD",
            500:"D",
            900:"CM",
            1000:"M"
        }

        for i in range(len(arr)):
            if num in symbol_mapping:
                res = res+symbol_mapping[num]
                num = 0
                break
            else:
                if num > arr[i] :
                    quotient = num // arr[i]
                    num = num % arr[i]

                    for j in range(quotient):
                        res = res+symbol_mapping[arr[i]]


        return res



  

# Input: num = 1994
# Output: "MCMXCIV"
# Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


