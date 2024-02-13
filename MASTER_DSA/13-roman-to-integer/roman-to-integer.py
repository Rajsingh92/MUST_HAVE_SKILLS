class Solution:
    def romanToInt(self, s: str) -> int:
        # arr=[1000,900,500,400,100,90,50,40,10,9,5,4,1]
        symbol_mapping = {
            'I': 1, 
            'IV': 4, 
            'V': 5, 
            'IX': 9, 
            'X': 10, 
            'XL': 40, 
            'L': 50, 
            'XC': 90, 
            'C': 100, 
            'CD': 400, 
            'D': 500, 
            'CM': 900, 
            'M': 1000
        }

        res = 0
        
        for i in reversed(range(len(s))):
            char = s[i]
            num = symbol_mapping[char]

            if i+1 < len(s) and num < symbol_mapping[s[i+1]]:
                res-=num
            else:
                res += num

        return res


